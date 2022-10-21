package org.activiti.engine.impl.db.redisEntity;

import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntityImpl;

public class processDefinition extends simpleEntity{
    private String category;
    private String name;
    private int version;
    private String deploymentId;
    private String resourceName;
    private String diagramResourceName;
    private String description;
    private boolean hasStartFormKey;
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getDeploymentId() {
        return deploymentId;
    }

    public void setDeploymentId(String deploymentId) {
        this.deploymentId = deploymentId;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getDiagramResourceName() {
        return diagramResourceName;
    }

    public void setDiagramResourceName(String diagramResourceName) {
        this.diagramResourceName = diagramResourceName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isHasStartFormKey() {
        return hasStartFormKey;
    }

    public void setHasStartFormKey(boolean hasStartFormKey) {
        this.hasStartFormKey = hasStartFormKey;
    }

    public boolean isGraphicalNotationDefined() {
        return isGraphicalNotationDefined;
    }

    public void setGraphicalNotationDefined(boolean isGraphicalNotationDefined) {
        this.isGraphicalNotationDefined = isGraphicalNotationDefined;
    }

    public int getSuspensionState() {
        return suspensionState;
    }

    public void setSuspensionState(int suspensionState) {
        this.suspensionState = suspensionState;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getEngineVersion() {
        return engineVersion;
    }

    public void setEngineVersion(String engineVersion) {
        this.engineVersion = engineVersion;
    }

    private boolean isGraphicalNotationDefined;
    private int suspensionState;
    private String tenantId;
    private String engineVersion;
    
    public processDefinition(ProcessDefinitionEntityImpl processDefinitionEntity) {
        this.id=processDefinitionEntity.getId();
        this.revision=processDefinitionEntity.getRevision();
        this.category=processDefinitionEntity.getCategory();
        this.name=processDefinitionEntity.getName();
        this.version=processDefinitionEntity.getVersion();
        this.deploymentId=processDefinitionEntity.getDeploymentId();
        this.resourceName=processDefinitionEntity.getResourceName();
        this.diagramResourceName=processDefinitionEntity.getDiagramResourceName();
        this.description=processDefinitionEntity.getDescription();
        this.hasStartFormKey=processDefinitionEntity.getHasStartFormKey();
        this.isGraphicalNotationDefined=processDefinitionEntity.isGraphicalNotationDefined();
        this.suspensionState=processDefinitionEntity.getSuspensionState();
        this.tenantId=processDefinitionEntity.getTenantId();
        this.engineVersion=processDefinitionEntity.getEngineVersion();
    }

    public ProcessDefinitionEntityImpl getEntity() {
        ProcessDefinitionEntityImpl entity=new ProcessDefinitionEntityImpl();
        entity.setId(id);
        entity.setRevision(revision);
        entity.setCategory(category);
        entity.setName(name);
        entity.setVersion(version);
        entity.setDeploymentId(deploymentId);
        entity.setResourceName(resourceName);
        entity.setDiagramResourceName(diagramResourceName);
        entity.setDescription(description);
        entity.setHasStartFormKey(hasStartFormKey);
        entity.setGraphicalNotationDefined(isGraphicalNotationDefined);
        entity.setSuspensionState(suspensionState);
        entity.setTenantId(tenantId);
        entity.setEngineVersion(engineVersion);
        return entity;
    }

    public String getTypeString() {
        return typeTransfer.processDefinition;
    }
}
