package com.example.jpa_version_update.core.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BaseModel {

    private Long id;

    private int version;

}
