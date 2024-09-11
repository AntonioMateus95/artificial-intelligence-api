package com.github.antoniomateus95.artificialintelligence.domain.model;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProviderInfo {

  private String name;
  private String enterpriseName;
  private LocalDate releaseDate;

}
