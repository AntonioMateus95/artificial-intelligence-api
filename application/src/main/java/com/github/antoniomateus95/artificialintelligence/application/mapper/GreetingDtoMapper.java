package com.github.antoniomateus95.artificialintelligence.application.mapper;

import com.github.antoniomateus95.artificialintelligence.application.dto.ProviderResponse;
import com.github.antoniomateus95.artificialintelligence.domain.model.ProviderInfo;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(componentModel = ComponentModel.SPRING)
public interface GreetingDtoMapper {

  ProviderResponse toResponse(ProviderInfo providerInfo);

}
