package com.example.jpa_version_update.core.ports;


import com.example.jpa_version_update.core.model.Entity;

public interface IEntityRepository {

    Entity saveEntityInsideNewConfiguration(Entity entityToPersist);

}
