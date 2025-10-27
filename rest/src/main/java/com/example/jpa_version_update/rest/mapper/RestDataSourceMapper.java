package com.example.jpa_version_update.rest.mapper;

import com.example.jpa_version_update.core.model.DataSource;
import com.example.jpa_version_update.rest.dto.DataSourceRead;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RestDataSourceMapper {

    DataSourceRead mapOut(DataSource model);
}
