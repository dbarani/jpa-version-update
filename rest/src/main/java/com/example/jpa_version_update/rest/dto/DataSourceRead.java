package com.example.jpa_version_update.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.OffsetDateTime;

@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class DataSourceRead {
    private String id;
    private Integer version;
    private String name;
    private String url;
    @DateTimeFormat(
        iso = DateTimeFormat.ISO.DATE_TIME
    )
    private OffsetDateTime createdAt;
    @DateTimeFormat(
        iso = DateTimeFormat.ISO.DATE_TIME
    )
    private OffsetDateTime modifiedAt;

    @JsonProperty("id")
    public @NotNull String getId() {
        return this.id;
    }

    @JsonProperty("version")
    public @NotNull Integer getVersion() {
        return this.version;
    }

    @JsonProperty("name")
    public @NotNull String getName() {
        return this.name;
    }

    @JsonProperty("url")
    public @NotNull String getUrl() {
        return this.url;
    }

    @JsonProperty("createdAt")
    public @NotNull @Valid OffsetDateTime getCreatedAt() {
        return this.createdAt;
    }

    @JsonProperty("modifiedAt")
    public @NotNull @Valid OffsetDateTime getModifiedAt() {
        return this.modifiedAt;
    }

}
