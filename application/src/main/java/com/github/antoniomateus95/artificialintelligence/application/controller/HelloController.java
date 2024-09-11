package com.github.antoniomateus95.artificialintelligence.application.controller;

import com.github.antoniomateus95.artificialintelligence.application.dto.ProviderResponse;
import com.github.antoniomateus95.artificialintelligence.application.mapper.GreetingDtoMapper;
import com.github.antoniomateus95.artificialintelligence.domain.model.ProviderInfo;
import com.github.antoniomateus95.artificialintelligence.domain.model.ProviderType;
import com.github.antoniomateus95.artificialintelligence.domain.service.GreetingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/hello")
public class HelloController {

  private final GreetingService greetingService;
  private final GreetingDtoMapper greetingDtoMapper;

  @GetMapping
  public ResponseEntity<ProviderResponse> hello(@RequestHeader String provider) {
    ProviderInfo providerData = greetingService.hello(ProviderType.from(provider));
    return ResponseEntity.ok(greetingDtoMapper.toResponse(providerData));
  }
}
