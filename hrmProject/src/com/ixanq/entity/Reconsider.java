package com.ixanq.entity;
//∏¥“È
public class Reconsider {
    private Integer id;
    private Integer employeeId;
    private String content;//∏¥“È
    private String time;

    public Reconsider() {
    }

    public Reconsider(Integer employeeId, String content, String time) {

        this.employeeId = employeeId;
        this.content = content;
        this.time = time;
    }

    public Reconsider(Integer id, Integer employeeId, String content, String time) {

        this.id = id;
        this.employeeId = employeeId;
        this.content = content;
        this.time = time;
    }

    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Reconsider{" +
                "id=" + id +
                ", employeeId=" + employeeId +
                ", content='" + content + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
