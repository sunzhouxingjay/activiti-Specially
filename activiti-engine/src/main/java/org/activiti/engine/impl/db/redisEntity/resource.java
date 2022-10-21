package org.activiti.engine.impl.db.redisEntity;

import org.activiti.engine.impl.persistence.entity.ResourceEntityImpl;

public class resource extends simpleEntity{
    private String name;
    private byte[] bytes;
    private String deploymentId;
    private boolean generated;
    
    public resource(ResourceEntityImpl resourceEntity) {
        this.id=resourceEntity.getId();
        this.name=resourceEntity.getName();
        this.bytes=resourceEntity.getBytes();
        this.deploymentId=resourceEntity.getDeploymentId();
        this.generated=resourceEntity.isGenerated();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }

    public String getDeploymentId() {
        return deploymentId;
    }

    public void setDeploymentId(String deploymentId) {
        this.deploymentId = deploymentId;
    }

    public boolean isGenerated() {
        return generated;
    }

    public void setGenerated(boolean generated) {
        this.generated = generated;
    }

    public ResourceEntityImpl getEntity() {
        ResourceEntityImpl entity=new ResourceEntityImpl();
        entity.setId(id);
        entity.setName(name);
        entity.setBytes(bytes);
        entity.setDeploymentId(deploymentId);
        entity.setGenerated(generated);
        return entity;
    }

    public String getTypeString() {
        return typeTransfer.resource;
    }
}
