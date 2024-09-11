package com.github.antoniomateus95.artificialintelligence.infrastructure.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import java.time.LocalDate;
import lombok.Data;

@Data
public class ProviderInfoResponse {

  @JsonPropertyDescription("My name is")
  private String name;
  @JsonPropertyDescription("I was created by")
  private String enterpriseName;
  @JsonPropertyDescription("My release date was")
  @JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd")
  private LocalDate releaseDate;

}
