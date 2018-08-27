package com.resale.foreground.pojo;

import java.util.Date;

public class RoleOpt {
    private Integer roptId;

    private Integer rId;

    private String roptName;

    private String roptType;

    private Date roptTime;

    public Integer getRoptId() {
        return roptId;
    }

    public void setRoptId(Integer roptId) {
        this.roptId = roptId;
    }

    public Integer getrId() {
        return rId;
    }

    public void setrId(Integer rId) {
        this.rId = rId;
    }

    public String getRoptName() {
        return roptName;
    }

    public void setRoptName(String roptName) {
        this.roptName = roptName == null ? null : roptName.trim();
    }

    public String getRoptType() {
        return roptType;
    }

    public void setRoptType(String roptType) {
        this.roptType = roptType == null ? null : roptType.trim();
    }

    public Date getRoptTime() {
        return roptTime;
    }

    public void setRoptTime(Date roptTime) {
        this.roptTime = roptTime;
    }
}