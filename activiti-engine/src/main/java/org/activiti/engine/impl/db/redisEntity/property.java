package org.activiti.engine.impl.db.redisEntity;

import org.activiti.engine.impl.persistence.entity.PropertyEntityImpl;

public class property extends simpleEntity{
    private String name;
    private String value;

    public property(PropertyEntityImpl entity) {
        this.revision=entity.getRevision();
        this.name=entity.getName();
        this.value=entity.getValue();
    }

    public PropertyEntityImpl getEntity() {
        PropertyEntityImpl entity=new PropertyEntityImpl();
        entity.setRevision(revision);
        entity.setName(name);
        entity.setValue(value);
        return entity;
    }

    public String getTypeString() {
        return typeTransfer.property;
    }
}
