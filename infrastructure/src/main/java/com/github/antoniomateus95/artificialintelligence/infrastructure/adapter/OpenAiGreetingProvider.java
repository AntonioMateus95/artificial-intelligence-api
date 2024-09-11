package com.github.antoniomateus95.artificialintelligence.infrastructure.adapter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.antoniomateus95.artificialintelligence.domain.model.ProviderInfo;
import com.github.antoniomateus95.artificialintelligence.domain.model.ProviderType;
import com.github.antoniomateus95.artificialintelligence.domain.provider.GreetingProvider;
import com.github.antoniomateus95.artificialintelligence.infrastructure.client.openai.dto.OpenAiInfo;
import com.github.antoniomateus95.artificialintelligence.infrastructure.mapper.GreetingMapper;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.ChatClient;
import org.springframework.ai.chat.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.parser.BeanOutputParser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OpenAiGreetingProvider implements GreetingProvider {

  private final ChatClient chatClient;
  private final ObjectMapper objectMapper;
  private final GreetingMapper greetingMapper;

  @Value("classpath:prompts/describe_yourself.st")
  private Resource describeYourselfPrompt;

  @Override
  public ProviderInfo hello() {
    BeanOutputParser<OpenAiInfo> parser = new BeanOutputParser<>(OpenAiInfo.class, objectMapper);
    String format = parser.getFormat();

    PromptTemplate promptTemplate = new PromptTemplate(describeYourselfPrompt);
    Prompt prompt = promptTemplate.create(Map.of("format", format));
    ChatResponse response = chatClient.call(prompt);

    return greetingMapper.toDomain(parser.parse(response.getResult().getOutput().getContent()));
  }

  @Override
  public boolean supports(ProviderType providerType) {
    return ProviderType.OPENAI.equals(providerType);
  }
}
