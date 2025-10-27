package com.example.jpa_version_update.jpa.mapper;

import com.example.jpa_version_update.core.model.Config;
import com.example.jpa_version_update.core.model.Entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

@Getter
@Component
@RequiredArgsConstructor
public class ConfigJsonMapperHelper {

    /**
     * Used to exclude id and version fields from serialization
     */
    private static class CustomMixin {
        @JsonIgnore
        private Long id;
        @JsonIgnore
        private Integer version;
    }

    private final ObjectMapper objectMapper;

    @PostConstruct
    public void configureObjectMapper() {
        objectMapper.addMixIn(Entity.class, CustomMixin.class);
    }

    @Named("mapConfigToJson")
    public JsonNode mapConfigToJson(Config config) {
        return objectMapper.valueToTree(config);
    }

    @Named("mapJsonToConfig")
    public Config mapJsonToConfig(JsonNode jsonNode) {
        try {
            return objectMapper.treeToValue(jsonNode, Config.class);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error mapping JsonNode to Config", e);
        }
    }
}
