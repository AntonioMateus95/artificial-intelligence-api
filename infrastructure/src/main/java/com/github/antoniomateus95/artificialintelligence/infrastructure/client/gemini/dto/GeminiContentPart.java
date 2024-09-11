package com.github.antoniomateus95.artificialintelligence.infrastructure.client.gemini.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GeminiContentPart {

  private String text;

}
