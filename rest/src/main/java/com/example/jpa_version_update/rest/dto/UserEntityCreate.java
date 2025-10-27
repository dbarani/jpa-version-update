package com.example.jpa_version_update.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class UserEntityCreate {
    private String id;
    private Integer version;
    private String code;

    @JsonProperty("id")
    public String getId() {
        return this.id;
    }

    @JsonProperty("version")
    public Integer getVersion() {
        return this.version;
    }

    @JsonProperty("code")
    public @NotNull String getCode() {
        return this.code;
    }

}