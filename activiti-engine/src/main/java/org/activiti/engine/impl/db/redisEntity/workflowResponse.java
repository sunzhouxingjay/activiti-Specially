package org.activiti.engine.impl.db.redisEntity;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Base64;
import java.util.HashSet;
import java.util.Set;

import org.activiti.engine.impl.db.redis.useRedis;

public class workflowResponse implements Serializable{
    private static final long serialVersionUID = 1L;
    private String Oid;
    private Set<String> fromTaskName;
    private Set<String> toTaskName;//本来是set,但是fastjson在多层上的性能有待考证，所有toTaskName采用string,用“,”间隔
    //private String businessData;//弃用，原因是业务数据流可以在上层进行处理，服务任务也是上层进行调用。
    private boolean isDeploy;
    private String deploymentName;
    private String businessData;
    
    public workflowResponse(cachedResponse cache) {
        this.Oid=cache.getOid();
        this.fromTaskName=cache.getFromTask()==null?new HashSet<String>():new HashSet<>(cache.getFromTask().keySet());
        this.toTaskName=cache.getToTasks()==null?new HashSet<String>():new HashSet<>(cache.getToTasks().keySet());
        this.isDeploy=cache.isDeploy();
        this.deploymentName=cache.getDeploymentName()==null?"...":cache.getDeploymentName();
        this.businessData=cache.getBusinessData()==null?"...":cache.getBusinessData();
    }



    public String getOid() {
        return Oid;
    }



    public void setOid(String oid) {
        Oid = oid;
    }



    public Set<String> getFromTaskName() {
        return fromTaskName;
    }



    public void setFromTaskName(Set<String> fromTaskName) {
        this.fromTaskName = fromTaskName;
    }



    public Set<String> getToTaskName() {
        return toTaskName;
    }



    public void setToTaskName(Set<String> toTaskName) {
        this.toTaskName = toTaskName;
    }



    public boolean isDeploy() {
        return isDeploy;
    }



    public void setDeploy(boolean isDeploy) {
        this.isDeploy = isDeploy;
    }



    public String getDeploymentName() {
        return deploymentName;
    }



    public void setDeploymentName(String deploymentName) {
        this.deploymentName = deploymentName;
    }



    public String getEncodeString() {
        try {
            ByteArrayOutputStream value=new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(value);
            out.writeObject(this);
            String res=Base64.getEncoder().encodeToString(value.toByteArray());
            out.close();
            value.close();
            return res;
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    public String getViewString() {
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append("Oid:").append(Oid).append("$$")
                     .append("fromTaskName:").append(fromTaskName.toString()).append("$$")
                     .append("toTaskName:").append(toTaskName.toString()).append("$$")
                     .append("isDeploy:").append(String.valueOf(isDeploy)).append("$$")
                     .append("deploymentName:").append(deploymentName).append("$$")
                     .append("businessData:").append(businessData);
        return stringBuilder.toString();
    }

    public String getViewEncodeString() {
        String str=getViewString();
        return useRedis.entityToStream(str);
    }
}
