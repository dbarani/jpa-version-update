package com.example.jpa_version_update.jpa.mapper;

import com.example.jpa_version_update.core.model.IConfiguration;
import com.example.jpa_version_update.jpa.entity.UserConfiguration;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ConfigurationMapper {

    private final UserConfigurationMapper userConfigurationMapper;

    public UserConfiguration mapOut(IConfiguration model) {
        if (null == model) {
            return null;
        }
        UserConfiguration moduleConfiguration = null;
        if (model instanceof com.example.jpa_version_update.core.model.UserConfiguration userConfiguration) {
            moduleConfiguration = userConfigurationMapper.mapOut(userConfiguration);
        }
        return moduleConfiguration;
    }

    public IConfiguration mapIn(UserConfiguration entity) {
        if (null == entity) {
            return null;
        }
        return userConfigurationMapper.mapIn(entity);
    }

}
