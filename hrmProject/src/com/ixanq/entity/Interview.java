package com.ixanq.entity;

import java.util.Date;

public class Interview {
    private Integer id;
    private String visitorName;
    private Integer advertiseId;
    private Date viewTime;

    public Interview() {
    }

    public Interview(String visitorName, Integer advertiseId, Date viewTime) {

        this.visitorName = visitorName;
        this.advertiseId = advertiseId;
        this.viewTime = viewTime;
    }

    public Interview(Integer id, String visitorName, Integer advertiseId, Date viewTime) {

        this.id = id;
        this.visitorName = visitorName;
        this.advertiseId = advertiseId;
        this.viewTime = viewTime;
    }

    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVisitorName() {
        return visitorName;
    }

    public void setVisitorName(String visitorName) {
        this.visitorName = visitorName;
    }

    public Integer getAdvertiseId() {
        return advertiseId;
    }

    public void setAdvertiseId(Integer advertiseId) {
        this.advertiseId = advertiseId;
    }

    public Date getViewTime() {
        return viewTime;
    }

    public void setViewTime(Date viewTime) {
        this.viewTime = viewTime;
    }

    @Override
    public String toString() {
        return "Interview{" +
                "id=" + id +
                ", visitorName='" + visitorName + '\'' +
                ", advertiseId=" + advertiseId +
                ", viewTime=" + viewTime +
                '}';
    }
}
