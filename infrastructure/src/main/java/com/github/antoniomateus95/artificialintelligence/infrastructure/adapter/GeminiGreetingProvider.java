package com.github.antoniomateus95.artificialintelligence.infrastructure.adapter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.antoniomateus95.artificialintelligence.domain.model.ProviderInfo;
import com.github.antoniomateus95.artificialintelligence.domain.model.ProviderType;
import com.github.antoniomateus95.artificialintelligence.domain.provider.GreetingProvider;
import com.github.antoniomateus95.artificialintelligence.infrastructure.client.gemini.GeminiClient;
import com.github.antoniomateus95.artificialintelligence.infrastructure.client.gemini.dto.GeminiCandidateResponse;
import com.github.antoniomateus95.artificialintelligence.infrastructure.client.gemini.dto.GeminiContent;
import com.github.antoniomateus95.artificialintelligence.infrastructure.client.gemini.dto.GeminiContentPart;
import com.github.antoniomateus95.artificialintelligence.infrastructure.client.gemini.dto.GeminiResponse;
import com.github.antoniomateus95.artificialintelligence.infrastructure.client.gemini.mapper.GeminiMapper;
import com.github.antoniomateus95.artificialintelligence.infrastructure.dto.ProviderInfoResponse;
import com.github.antoniomateus95.artificialintelligence.infrastructure.mapper.GreetingMapper;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.parser.BeanOutputParser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GeminiGreetingProvider implements GreetingProvider {

  private final GeminiClient geminiClient;
  private final GeminiMapper geminiMapper;
  private final ObjectMapper objectMapper;
  private final GreetingMapper greetingMapper;

  @Value("classpath:prompts/describe_yourself.st")
  private Resource describeYourselfPrompt;

  @Override
  public ProviderInfo hello() {
    var parser = new BeanOutputParser<>(ProviderInfoResponse.class, objectMapper);
    String format = parser.getFormat();

    PromptTemplate promptTemplate = new PromptTemplate(describeYourselfPrompt);
    Prompt prompt = promptTemplate.create(Map.of("format", format));
    GeminiResponse response = geminiClient.call(geminiMapper.toGeminiRequest(prompt));

    return greetingMapper.toDomain(response.getCandidates()
        .stream()
        .findFirst()
        .map(GeminiCandidateResponse::getContent)
        .map(GeminiContent::getParts)
        .flatMap(parts -> parts.stream().findFirst())
        .map(GeminiContentPart::getText)
        .map(parser::parse)
        .orElse(null));
  }

  @Override
  public boolean supports(ProviderType providerType) {
    return ProviderType.GEMINI.equals(providerType);
  }
}
