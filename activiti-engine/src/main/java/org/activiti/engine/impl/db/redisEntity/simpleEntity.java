package org.activiti.engine.impl.db.redisEntity;

import java.io.Serializable;

import org.activiti.engine.impl.persistence.entity.Entity;

public abstract class simpleEntity implements Serializable{
    public String id;
    public int revision=1;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public int getRevision() {
        return revision;
    }
    public void setRevision(int revision) {
        this.revision = revision;
    }
    public abstract Entity getEntity(); 
    public abstract String getTypeString();
}
