package org.activiti.engine.impl.db.redisEntity;

import org.activiti.engine.impl.persistence.entity.ByteArrayRef;
import org.activiti.engine.impl.persistence.entity.VariableInstanceEntityImpl;
import org.activiti.engine.impl.variable.VariableType;

public class variable extends simpleEntity{
    private VariableType type;
    private String name;
    private String processInstanceId;
    private String executionId;
    private String taskId;
    private String byteArrayId;
    private Double doubleValue;
    private Long longValue;
    private String textValue;
    private String textValue2;
    public variable(VariableInstanceEntityImpl variableEntity) {
        this.id=variableEntity.getId();
        this.revision=variableEntity.getRevision();
        this.type=variableEntity.getType();
        this.name=variableEntity.getName();
        this.processInstanceId=variableEntity.getProcessInstanceId();
        this.executionId=variableEntity.getExecutionId();
        this.taskId=variableEntity.getTaskId();
        this.byteArrayId=variableEntity.getByteArrayRef().getId();
        this.doubleValue=variableEntity.getDoubleValue();
        this.longValue=variableEntity.getLongValue();
        this.textValue=variableEntity.getTextValue();
        this.textValue2=variableEntity.getTextValue2();
    }
    
    public VariableType getType() {
        return type;
    }

    public void setType(VariableType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProcessInstanceId() {
        return processInstanceId;
    }

    public void setProcessInstanceId(String processInstanceId) {
        this.processInstanceId = processInstanceId;
    }

    public String getExecutionId() {
        return executionId;
    }

    public void setExecutionId(String executionId) {
        this.executionId = executionId;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getByteArrayId() {
        return byteArrayId;
    }

    public void setByteArrayId(String byteArrayId) {
        this.byteArrayId = byteArrayId;
    }

    public Double getDoubleValue() {
        return doubleValue;
    }

    public void setDoubleValue(Double doubleValue) {
        this.doubleValue = doubleValue;
    }

    public Long getLongValue() {
        return longValue;
    }

    public void setLongValue(Long longValue) {
        this.longValue = longValue;
    }

    public String getTextValue() {
        return textValue;
    }

    public void setTextValue(String textValue) {
        this.textValue = textValue;
    }

    public String getTextValue2() {
        return textValue2;
    }

    public void setTextValue2(String textValue2) {
        this.textValue2 = textValue2;
    }

    public VariableInstanceEntityImpl getEntity() {
        VariableInstanceEntityImpl entity=new VariableInstanceEntityImpl();
        entity.setId(id);
        entity.setRevision(revision);
        entity.setType(type);
        entity.setName(name);
        entity.setProcessInstanceId(processInstanceId);
        entity.setExecutionId(executionId);
        entity.setTaskId(taskId);
        entity.setByteArrayRef(new ByteArrayRef(byteArrayId));
        entity.setDoubleValue(doubleValue);
        entity.setLongValue(longValue);
        entity.setTextValue(textValue);
        entity.setTextValue2(textValue2);
        return entity;
    }

    public String getTypeString() {
        return typeTransfer.variable;
    }
}
