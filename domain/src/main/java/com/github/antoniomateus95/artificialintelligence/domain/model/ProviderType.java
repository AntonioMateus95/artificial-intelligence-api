package com.github.antoniomateus95.artificialintelligence.domain.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@Getter
@RequiredArgsConstructor
public enum ProviderType {

  OPENAI("openai"),
  GEMINI("gemini");

  private final String name;

  public static ProviderType from(String name) {
    return Arrays.stream(values())
        .filter(type -> type.getName().equals(name))
        .findFirst()
        .orElse(null);
  }
}
