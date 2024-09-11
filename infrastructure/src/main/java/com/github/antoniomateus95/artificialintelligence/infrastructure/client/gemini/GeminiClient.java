package com.github.antoniomateus95.artificialintelligence.infrastructure.client.gemini;

import com.github.antoniomateus95.artificialintelligence.infrastructure.client.gemini.dto.GeminiRequest;
import com.github.antoniomateus95.artificialintelligence.infrastructure.client.gemini.dto.GeminiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "gemini", url = "${spring.ai.gemini.base-url}", configuration = GeminiClientConfiguration.class)
public interface GeminiClient {

  @RequestMapping(method = RequestMethod.POST, value = "/gemini-pro:generateContent",
      produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
  GeminiResponse call(@RequestBody GeminiRequest request);

}
