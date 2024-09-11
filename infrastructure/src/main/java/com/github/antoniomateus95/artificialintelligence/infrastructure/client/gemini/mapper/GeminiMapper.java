package com.github.antoniomateus95.artificialintelligence.infrastructure.client.gemini.mapper;

import com.github.antoniomateus95.artificialintelligence.infrastructure.client.gemini.dto.GeminiContent;
import com.github.antoniomateus95.artificialintelligence.infrastructure.client.gemini.dto.GeminiContentPart;
import com.github.antoniomateus95.artificialintelligence.infrastructure.client.gemini.dto.GeminiRequest;
import java.util.List;
import lombok.NonNull;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants.ComponentModel;
import org.mapstruct.Named;
import org.springframework.ai.chat.messages.Message;
import org.springframework.ai.chat.prompt.Prompt;

@Mapper(componentModel = ComponentModel.SPRING)
public interface GeminiMapper {

  @Mapping(target = "text", source = "content", qualifiedByName = "removeBackQuotes")
  GeminiContentPart toGeminiContentPart(Message message);

  List<GeminiContentPart> toGeminiContentPart(List<Message> messages);

  @Mapping(target = "parts", source = "instructions")
  GeminiContent toGeminiContent(Prompt prompt);

  default GeminiRequest toGeminiRequest(Prompt prompt) {
    return GeminiRequest.builder()
        .content(toGeminiContent(prompt))
        .build();
  }

  @Named("removeBackQuotes")
  default String removeBackQuotes(@NonNull String text) {
    return text.replace("`", "");
  }
}
