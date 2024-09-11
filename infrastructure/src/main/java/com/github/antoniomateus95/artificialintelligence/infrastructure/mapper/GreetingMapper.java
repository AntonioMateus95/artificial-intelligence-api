package com.github.antoniomateus95.artificialintelligence.infrastructure.mapper;

import com.github.antoniomateus95.artificialintelligence.domain.model.ProviderInfo;
import com.github.antoniomateus95.artificialintelligence.infrastructure.dto.ProviderInfoResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(componentModel = ComponentModel.SPRING)
public interface GreetingMapper {

  ProviderInfo toDomain(ProviderInfoResponse openAiInfo);

}
