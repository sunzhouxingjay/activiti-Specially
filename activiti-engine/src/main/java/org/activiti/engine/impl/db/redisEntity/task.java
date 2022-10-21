package org.activiti.engine.impl.db.redisEntity;

import java.util.Date;

import org.activiti.engine.impl.persistence.entity.TaskEntityImpl;

public class task extends simpleEntity{
    private String name;
    private String parentTaskId;
    private String description;
    private int priority;
    private Date createTime;
    private String owner;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentTaskId() {
        return parentTaskId;
    }

    public void setParentTaskId(String parentTaskId) {
        this.parentTaskId = parentTaskId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getDelegationStateString() {
        return delegationStateString;
    }

    public void setDelegationStateString(String delegationStateString) {
        this.delegationStateString = delegationStateString;
    }

    public String getExecutionId() {
        return executionId;
    }

    public void setExecutionId(String executionId) {
        this.executionId = executionId;
    }

    public String getProcessInstanceId() {
        return processInstanceId;
    }

    public void setProcessInstanceId(String processInstanceId) {
        this.processInstanceId = processInstanceId;
    }

    public String getProcessDefinitionId() {
        return processDefinitionId;
    }

    public void setProcessDefinitionId(String processDefinitionId) {
        this.processDefinitionId = processDefinitionId;
    }

    public String getTaskDefinitionKey() {
        return taskDefinitionKey;
    }

    public void setTaskDefinitionKey(String taskDefinitionKey) {
        this.taskDefinitionKey = taskDefinitionKey;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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

    public String getFormKey() {
        return formKey;
    }

    public void setFormKey(String formKey) {
        this.formKey = formKey;
    }

    public Date getClaimTime() {
        return claimTime;
    }

    public void setClaimTime(Date claimTime) {
        this.claimTime = claimTime;
    }

    private String assignee;
    private String delegationStateString;
    private String executionId;
    private String processInstanceId;
    private String processDefinitionId;
    private String taskDefinitionKey;
    private Date dueDate;
    private String category;
    private int suspensionState;
    private String tenantId;
    private String formKey;
    private Date claimTime;

    public task(TaskEntityImpl taskEntity) {
        this.id=taskEntity.getId();
        this.revision=taskEntity.getRevision();
        this.name=taskEntity.getNameToCache();
        this.parentTaskId=taskEntity.getParentTaskId();
        this.description=taskEntity.getDescription();
        this.priority=taskEntity.getPriority();
        this.createTime=taskEntity.getCreateTime();
        this.owner=taskEntity.getOwner();
        this.assignee=taskEntity.getAssignee();
        this.delegationStateString=taskEntity.getDelegationStateString();
        this.executionId=taskEntity.getExecutionId();
        this.processInstanceId=taskEntity.getProcessInstanceId();
        this.processDefinitionId=taskEntity.getProcessDefinitionId();
        this.taskDefinitionKey=taskEntity.getTaskDefinitionKey();
        this.dueDate=taskEntity.getDueDate();
        this.category=taskEntity.getCategory();
        this.suspensionState=taskEntity.getSuspensionState();
        this.tenantId=taskEntity.getTenantId();
        this.formKey=taskEntity.getFormKey();
        this.claimTime=taskEntity.getClaimTime();
    }
    
    public TaskEntityImpl getEntity() {
        TaskEntityImpl entity=new TaskEntityImpl();
        entity.setId(id);
        entity.setRevision(revision);
        entity.setName(name);
        entity.setParentTaskId(parentTaskId);
        entity.setDescription(description);
        entity.setPriority(priority);
        entity.setCreateTime(createTime);
        entity.setOwner(owner);
        entity.setAssignee(assignee);
        entity.setDelegationStateString(delegationStateString);
        entity.setExecutionId(executionId);
        entity.setProcessInstanceId(processInstanceId);
        entity.setProcessDefinitionId(processDefinitionId);
        entity.setTaskDefinitionKey(taskDefinitionKey);
        entity.setDueDate(dueDate);
        entity.setCategory(category);
        entity.setSuspensionState(suspensionState);
        entity.setTenantId(tenantId);
        entity.setFormKey(formKey);
        entity.setClaimTime(claimTime);
        return entity;
    }

    public String getTypeString() {
        return typeTransfer.task;
    }
}
