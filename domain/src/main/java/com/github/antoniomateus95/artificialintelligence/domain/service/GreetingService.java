package com.github.antoniomateus95.artificialintelligence.domain.service;

import com.github.antoniomateus95.artificialintelligence.domain.exception.InvalidProviderTypeException;
import com.github.antoniomateus95.artificialintelligence.domain.model.ProviderType;
import com.github.antoniomateus95.artificialintelligence.domain.provider.GreetingProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.plugin.core.PluginRegistry;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GreetingService {

  private final PluginRegistry<GreetingProvider, ProviderType> providers;

  public String hello(ProviderType providerType) {
    return providers.getPluginFor(providerType)
        .map(GreetingProvider::hello)
        .orElseThrow(InvalidProviderTypeException::new);
  }
}
