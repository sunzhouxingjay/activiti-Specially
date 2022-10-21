package org.activiti.engine.impl.db.redisEntity;

import java.util.Date;

import org.activiti.engine.impl.persistence.entity.DeploymentEntityImpl;

public class deployment extends simpleEntity{
    private String name;
    private String category;
    private String key;
    private String tenantId;
    private Date deploymentTime;
    
    public deployment(DeploymentEntityImpl deploymentEntity) {
        this.id=deploymentEntity.getId();
        this.name=deploymentEntity.getName();
        this.category=deploymentEntity.getCategory();
        this.key=deploymentEntity.getKey();
        this.tenantId=deploymentEntity.getTenantId();
        this.deploymentTime=deploymentEntity.getDeploymentTime();
    }

    public DeploymentEntityImpl getEntity() {
        DeploymentEntityImpl entity=new DeploymentEntityImpl();
        entity.setId(id);
        entity.setName(name);
        entity.setCategory(category);
        entity.setKey(key);
        entity.setTenantId(tenantId);
        entity.setDeploymentTime(deploymentTime);
        return entity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public Date getDeploymentTime() {
        return deploymentTime;
    }

    public void setDeploymentTime(Date deploymentTime) {
        this.deploymentTime = deploymentTime;
    }

    public String getTypeString() {
        return typeTransfer.deployment;
    }
}
