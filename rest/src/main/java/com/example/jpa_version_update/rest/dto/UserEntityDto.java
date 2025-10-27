package com.example.jpa_version_update.rest.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Setter
@Getter
public class UserEntityDto {
    private String id;
    private Integer version;
    private String code;
    private String title;
    private String description;
    private DataSourceRead datasource;
}
