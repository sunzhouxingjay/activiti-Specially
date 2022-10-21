package org.activiti.engine.impl.db.redisEntity;

import java.util.Date;

import org.activiti.engine.impl.persistence.entity.ExecutionEntityImpl;

public class execution extends simpleEntity{
    private String processInstanceId;
    private String businessKey;
    private String processDefinitionId;
    private String activityId;
    private boolean isActive;
    private boolean isConcurrent;
    private boolean isScope;
    public String getProcessInstanceId() {
        return processInstanceId;
    }

    public void setProcessInstanceId(String processInstanceId) {
        this.processInstanceId = processInstanceId;
    }

    public String getBusinessKey() {
        return businessKey;
    }

    public void setBusinessKey(String businessKey) {
        this.businessKey = businessKey;
    }

    public String getProcessDefinitionId() {
        return processDefinitionId;
    }

    public void setProcessDefinitionId(String processDefinitionId) {
        this.processDefinitionId = processDefinitionId;
    }

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    public boolean isConcurrent() {
        return isConcurrent;
    }

    public void setConcurrent(boolean isConcurrent) {
        this.isConcurrent = isConcurrent;
    }

    public boolean isScope() {
        return isScope;
    }

    public void setScope(boolean isScope) {
        this.isScope = isScope;
    }

    public boolean isEventScope() {
        return isEventScope;
    }

    public void setEventScope(boolean isEventScope) {
        this.isEventScope = isEventScope;
    }

    public boolean isMultiInstanceRoot() {
        return isMultiInstanceRoot;
    }

    public void setMultiInstanceRoot(boolean isMultiInstanceRoot) {
        this.isMultiInstanceRoot = isMultiInstanceRoot;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getSuperExecutionId() {
        return superExecutionId;
    }

    public void setSuperExecutionId(String superExecutionId) {
        this.superExecutionId = superExecutionId;
    }

    public String getRootProcessInstanceId() {
        return rootProcessInstanceId;
    }

    public void setRootProcessInstanceId(String rootProcessInstanceId) {
        this.rootProcessInstanceId = rootProcessInstanceId;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public String getStartUserId() {
        return startUserId;
    }

    public void setStartUserId(String startUserId) {
        this.startUserId = startUserId;
    }

    public boolean isCountEnabled() {
        return isCountEnabled;
    }

    public void setCountEnabled(boolean isCountEnabled) {
        this.isCountEnabled = isCountEnabled;
    }

    public int getEventSubscriptionCount() {
        return eventSubscriptionCount;
    }

    public void setEventSubscriptionCount(int eventSubscriptionCount) {
        this.eventSubscriptionCount = eventSubscriptionCount;
    }

    public int getTaskCount() {
        return taskCount;
    }

    public void setTaskCount(int taskCount) {
        this.taskCount = taskCount;
    }

    public int getJobCount() {
        return jobCount;
    }

    public void setJobCount(int jobCount) {
        this.jobCount = jobCount;
    }

    public int getTimerJobCount() {
        return timerJobCount;
    }

    public void setTimerJobCount(int timerJobCount) {
        this.timerJobCount = timerJobCount;
    }

    public int getSuspendedJobCount() {
        return suspendedJobCount;
    }

    public void setSuspendedJobCount(int suspendedJobCount) {
        this.suspendedJobCount = suspendedJobCount;
    }

    public int getDeadLetterJobCount() {
        return deadLetterJobCount;
    }

    public void setDeadLetterJobCount(int deadLetterJobCount) {
        this.deadLetterJobCount = deadLetterJobCount;
    }

    public int getVariableCount() {
        return variableCount;
    }

    public void setVariableCount(int variableCount) {
        this.variableCount = variableCount;
    }

    public int getIdentityLinkCount() {
        return identityLinkCount;
    }

    public void setIdentityLinkCount(int identityLinkCount) {
        this.identityLinkCount = identityLinkCount;
    }

    private boolean isEventScope;
    private boolean isMultiInstanceRoot;
    private String parentId;
    private String superExecutionId;
    private String rootProcessInstanceId;
    private int suspensionState;
    private String tenantId;
    private String name;
    private Date startTime;
    private String startUserId;
    private boolean isCountEnabled;
    private int eventSubscriptionCount;
    private int taskCount;
    private int jobCount;
    private int timerJobCount;
    private int suspendedJobCount;
    private int deadLetterJobCount;
    private int variableCount;
    private int identityLinkCount;

    public execution(ExecutionEntityImpl executionEntity) {
        this.id=executionEntity.getId();
        this.revision=executionEntity.getRevision();
        this.processInstanceId=executionEntity.getProcessInstanceId();
        this.businessKey=executionEntity.getBusinessKey();
        this.processDefinitionId=executionEntity.getProcessDefinitionId();
        this.activityId=executionEntity.getActivityId();
        this.isActive=executionEntity.isActive();
        this.isConcurrent=executionEntity.isConcurrent();
        this.isScope=executionEntity.isScope();
        this.isEventScope=executionEntity.isEventScope();
        this.isMultiInstanceRoot=executionEntity.isMultiInstanceRoot();
        this.parentId=executionEntity.getParentId();
        this.superExecutionId=executionEntity.getSuperExecutionId();
        this.rootProcessInstanceId=executionEntity.getRootProcessInstanceId();
        this.suspensionState=executionEntity.getSuspensionState();
        this.tenantId=executionEntity.getTenantId();
        this.name=executionEntity.getName();
        this.startTime=executionEntity.getStartTime();
        this.startUserId=executionEntity.getStartUserId();
        this.isCountEnabled=executionEntity.isCountEnabled();
        this.eventSubscriptionCount=executionEntity.getEventSubscriptionCount();
        this.taskCount=executionEntity.getTaskCount();
        this.jobCount=executionEntity.getJobCount();
        this.timerJobCount=executionEntity.getTimerJobCount();
        this.suspendedJobCount=executionEntity.getSuspendedJobCount();
        this.deadLetterJobCount=executionEntity.getDeadLetterJobCount();
        this.variableCount=executionEntity.getVariableCount();
        this.identityLinkCount=executionEntity.getIdentityLinkCount();
    }

    public ExecutionEntityImpl getEntity() {
        ExecutionEntityImpl entity=new ExecutionEntityImpl();
        entity.setId(id);
        entity.setRevision(revision);
        entity.setProcessInstanceId(processInstanceId);
        entity.setBusinessKey(businessKey);
        entity.setProcessDefinitionId(processDefinitionId);
        entity.setActivityId(activityId);
        entity.setActive(isActive);
        entity.setConcurrent(isConcurrent);
        entity.setScope(isScope);
        entity.setEventScope(isEventScope);
        entity.setMultiInstanceRoot(isMultiInstanceRoot);
        entity.setParentId(parentId);
        entity.setSuperExecutionId(superExecutionId);
        entity.setRootProcessInstanceId(rootProcessInstanceId);
        entity.setSuspensionState(suspensionState);
        entity.setTenantId(tenantId);
        entity.setName(name);
        entity.setStartTime(startTime);
        entity.setStartUserId(startUserId);
        entity.setCountEnabled(isCountEnabled);
        entity.setEventSubscriptionCount(eventSubscriptionCount);
        entity.setTaskCount(taskCount);
        entity.setJobCount(jobCount);
        entity.setTimerJobCount(timerJobCount);
        entity.setSuspendedJobCount(suspendedJobCount);
        entity.setDeadLetterJobCount(deadLetterJobCount);
        entity.setVariableCount(variableCount);
        entity.setIdentityLinkCount(identityLinkCount);
        return entity;
    }

    public String getTypeString() {
        return typeTransfer.execution;
    }
}
