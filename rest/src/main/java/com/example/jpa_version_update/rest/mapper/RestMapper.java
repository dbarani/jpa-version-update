package com.example.jpa_version_update.rest.mapper;

import com.example.jpa_version_update.core.model.Entity;
import com.example.jpa_version_update.rest.dto.UserEntityDto;
import com.example.jpa_version_update.rest.dto.UserEntityCreate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class RestMapper {
    private final RestDataSourceMapper restDataSourceMapper;

    public Entity mapEntityIn(UserEntityCreate userEntityCreate) {
        if (userEntityCreate == null) {
            return null;
        }

        return mapEntityIn(
                userEntityCreate.getId(),
                userEntityCreate.getVersion(),
                userEntityCreate.getCode()
        );
    }

    private Entity mapEntityIn(String configurationId,
                               Integer configurationVersion,
                               String code) {
        final Entity outputEntity = new Entity();
        Optional.ofNullable(configurationId).ifPresent(id -> outputEntity.setId(Long.parseLong(id)));
        Optional.ofNullable(configurationVersion).ifPresent(outputEntity::setVersion);
        outputEntity.setCode(code);
        return outputEntity;
    }

    public UserEntityDto mapEntityOut(Entity entity) {
        if (entity == null) {
            return null;
        }

        var entityDto = new UserEntityDto();
        entityDto.setId(String.valueOf(entity.getId()));
        entityDto.setVersion(entity.getVersion());
        entityDto.setCode(entity.getCode());
        entityDto.setTitle(null);
        entityDto.setDescription(null);
        entityDto.setDatasource(restDataSourceMapper.mapOut(entity.getDatasource()));
        return entityDto;
    }
}
