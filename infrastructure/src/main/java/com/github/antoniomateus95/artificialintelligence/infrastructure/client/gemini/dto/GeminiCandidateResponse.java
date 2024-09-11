package com.github.antoniomateus95.artificialintelligence.infrastructure.client.gemini.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GeminiCandidateResponse {

  private GeminiContent content;

}
