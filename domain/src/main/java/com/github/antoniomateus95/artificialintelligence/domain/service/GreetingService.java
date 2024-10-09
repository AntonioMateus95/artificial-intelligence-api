package com.github.antoniomateus95.artificialintelligence.domain.service;

import com.github.antoniomateus95.artificialintelligence.domain.model.ProviderInfo;
import com.github.antoniomateus95.artificialintelligence.domain.model.ProviderType;
import com.github.antoniomateus95.artificialintelligence.domain.provider.GreetingProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GreetingService {

  private final ProviderService<GreetingProvider> providerService;

  public ProviderInfo hello(ProviderType providerType) {
    return providerService.getProvider(providerType).hello();
  }
}
