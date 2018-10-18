package com.ixanq.entity;

public class GoInterview {
    private Integer id;
    private String visitorName;
    private String viewStatus;
    private String passStatus;

    public GoInterview() {
    }

    public GoInterview(String visitorName, String viewStatus, String passStatus) {

        this.visitorName = visitorName;
        this.viewStatus = viewStatus;
        this.passStatus = passStatus;
    }

    public GoInterview(Integer id, String visitorName, String viewStatus, String passStatus) {

        this.id = id;
        this.visitorName = visitorName;
        this.viewStatus = viewStatus;
        this.passStatus = passStatus;
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

    public String getViewStatus() {
        return viewStatus;
    }

    public void setViewStatus(String viewStatus) {
        this.viewStatus = viewStatus;
    }

    public String getPassStatus() {
        return passStatus;
    }

    public void setPassStatus(String passStatus) {
        this.passStatus = passStatus;
    }

    @Override
    public String toString() {
        return "GoInterview{" +
                "id=" + id +
                ", visitorName='" + visitorName + '\'' +
                ", viewStatus='" + viewStatus + '\'' +
                ", passStatus='" + passStatus + '\'' +
                '}';
    }
}
