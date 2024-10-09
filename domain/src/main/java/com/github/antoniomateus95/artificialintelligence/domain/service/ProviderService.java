package com.github.antoniomateus95.artificialintelligence.domain.service;

import com.github.antoniomateus95.artificialintelligence.domain.model.ProviderType;
import org.springframework.context.ApplicationContext;
import org.springframework.plugin.core.Plugin;
import org.springframework.plugin.core.PluginRegistry;
import org.springframework.stereotype.Service;

@Service
public class ProviderService<T extends Plugin<ProviderType>> {

  private final PluginRegistry<T, ProviderType> providers;

  @SuppressWarnings("unchecked")
  public ProviderService(ApplicationContext context) {
    this.providers = (PluginRegistry<T, ProviderType>) context.getBean(PluginRegistry.class);
  }

  public T getProvider(ProviderType providerType) {
    return providers.getPluginFor(providerType).orElseThrow();
  }
}
