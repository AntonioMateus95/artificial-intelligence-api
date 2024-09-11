package com.github.antoniomateus95.artificialintelligence.infrastructure.client.gemini.dto;

import java.util.Collections;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GeminiContent {

  @Builder.Default
  private String role = "user";

  @Builder.Default
  private List<GeminiContentPart> parts = Collections.emptyList();

}
