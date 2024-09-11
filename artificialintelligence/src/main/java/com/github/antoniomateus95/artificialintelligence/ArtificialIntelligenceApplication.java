package com.github.antoniomateus95.artificialintelligence;

import com.github.antoniomateus95.artificialintelligence.domain.provider.GreetingProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.plugin.core.config.EnablePluginRegistries;

@SpringBootApplication
@EnablePluginRegistries({GreetingProvider.class})
public class ArtificialIntelligenceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArtificialIntelligenceApplication.class, args);
	}

}
