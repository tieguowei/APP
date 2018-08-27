package com.resale.foreground.pojo;

import java.util.Date;

public class DeptOpt {
    private Integer doptId;

    private Integer dId;

    private String doptName;

    private String doptType;

    private Date doptTime;

    public Integer getDoptId() {
        return doptId;
    }

    public void setDoptId(Integer doptId) {
        this.doptId = doptId;
    }

    public Integer getdId() {
        return dId;
    }

    public void setdId(Integer dId) {
        this.dId = dId;
    }

    public String getDoptName() {
        return doptName;
    }

    public void setDoptName(String doptName) {
        this.doptName = doptName == null ? null : doptName.trim();
    }

    public String getDoptType() {
        return doptType;
    }

    public void setDoptType(String doptType) {
        this.doptType = doptType == null ? null : doptType.trim();
    }

    public Date getDoptTime() {
        return doptTime;
    }

    public void setDoptTime(Date doptTime) {
        this.doptTime = doptTime;
    }
}