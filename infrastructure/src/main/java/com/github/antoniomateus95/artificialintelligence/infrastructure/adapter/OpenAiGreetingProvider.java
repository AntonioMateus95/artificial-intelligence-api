package com.github.antoniomateus95.artificialintelligence.infrastructure.adapter;

import com.github.antoniomateus95.artificialintelligence.domain.model.ProviderType;
import com.github.antoniomateus95.artificialintelligence.domain.provider.GreetingProvider;
import org.springframework.stereotype.Component;

@Component
public class OpenAiGreetingProvider implements GreetingProvider {

  @Override
  public String hello() {
    return "Hello World from OpenAi";
  }

  @Override
  public boolean supports(ProviderType providerType) {
    return ProviderType.OPENAI.equals(providerType);
  }
}
