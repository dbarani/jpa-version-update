package com.example.jpa_version_update.core.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@Getter
@Setter
public class Entity {

    private Long id;
    private Integer version;
    @EqualsAndHashCode.Include
    private String code;
    private DataSource datasource;
    private FaultyDataSource faultyDataSource;

}