package org.mall_hsj_mbg.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class TTxException implements Serializable {
    private Long id;

    private Date createTime;

    private Short exState;

    private String groupId;

    private String modId;

    private Short registrar;

    private String remark;

    private Integer transactionState;

    private String unitId;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Short getExState() {
        return exState;
    }

    public void setExState(Short exState) {
        this.exState = exState;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getModId() {
        return modId;
    }

    public void setModId(String modId) {
        this.modId = modId;
    }

    public Short getRegistrar() {
        return registrar;
    }

    public void setRegistrar(Short registrar) {
        this.registrar = registrar;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getTransactionState() {
        return transactionState;
    }

    public void setTransactionState(Integer transactionState) {
        this.transactionState = transactionState;
    }

    public String getUnitId() {
        return unitId;
    }

    public void setUnitId(String unitId) {
        this.unitId = unitId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", createTime=").append(createTime);
        sb.append(", exState=").append(exState);
        sb.append(", groupId=").append(groupId);
        sb.append(", modId=").append(modId);
        sb.append(", registrar=").append(registrar);
        sb.append(", remark=").append(remark);
        sb.append(", transactionState=").append(transactionState);
        sb.append(", unitId=").append(unitId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}