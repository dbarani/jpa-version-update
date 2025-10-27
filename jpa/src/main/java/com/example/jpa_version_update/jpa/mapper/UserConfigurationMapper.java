package com.example.jpa_version_update.jpa.mapper;

import com.example.jpa_version_update.jpa.entity.UserConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        uses = ConfigJsonMapperHelper.class,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserConfigurationMapper {

    @Mapping(target = "configuration", source = "configuration", qualifiedByName = "mapConfigToJson")
    UserConfiguration mapOut(com.example.jpa_version_update.core.model.UserConfiguration model);

    @Mapping(target = "configuration", source = "configuration", qualifiedByName = "mapJsonToConfig")
    com.example.jpa_version_update.core.model.UserConfiguration mapIn(UserConfiguration entity);

}
