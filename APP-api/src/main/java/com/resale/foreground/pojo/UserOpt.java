package com.resale.foreground.pojo;

import java.util.Date;

public class UserOpt {
    private Integer uoptId;

    private Integer uId;

    private String uoptName;

    private String uoptType;

    private Date uoptTime;

    public Integer getUoptId() {
        return uoptId;
    }

    public void setUoptId(Integer uoptId) {
        this.uoptId = uoptId;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getUoptName() {
        return uoptName;
    }

    public void setUoptName(String uoptName) {
        this.uoptName = uoptName == null ? null : uoptName.trim();
    }

    public String getUoptType() {
        return uoptType;
    }

    public void setUoptType(String uoptType) {
        this.uoptType = uoptType == null ? null : uoptType.trim();
    }

    public Date getUoptTime() {
        return uoptTime;
    }

    public void setUoptTime(Date uoptTime) {
        this.uoptTime = uoptTime;
    }
}