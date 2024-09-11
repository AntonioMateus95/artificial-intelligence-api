package com.github.antoniomateus95.artificialintelligence.domain.provider;

import com.github.antoniomateus95.artificialintelligence.domain.model.ProviderInfo;
import com.github.antoniomateus95.artificialintelligence.domain.model.ProviderType;
import org.springframework.plugin.core.Plugin;

public interface GreetingProvider extends Plugin<ProviderType> {

  ProviderInfo hello();

}
