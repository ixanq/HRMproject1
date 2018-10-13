package com.ixanq.entity;

public class EmployeeInfo {
    private Integer id;
    private Integer employeeId;//用于查看个人信息
    private Integer trainID;//培训信息
    private Integer salaryId;
    private Integer rewardId;//奖惩信息
    private Integer checkWorkAttendId;//考勤
    private String departWork;//部门职位，通过二级联动获取

    public EmployeeInfo() {
    }

    public EmployeeInfo(Integer id, Integer employeeId, Integer trainID, Integer salaryId, Integer rewardId, Integer checkWorkAttendId, String departWork) {

        this.id = id;
        this.employeeId = employeeId;
        this.trainID = trainID;
        this.salaryId = salaryId;
        this.rewardId = rewardId;
        this.checkWorkAttendId = checkWorkAttendId;
        this.departWork = departWork;
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

    public Integer getTrainID() {
        return trainID;
    }

    public void setTrainID(Integer trainID) {
        this.trainID = trainID;
    }

    public Integer getSalaryId() {
        return salaryId;
    }

    public void setSalaryId(Integer salaryId) {
        this.salaryId = salaryId;
    }

    public Integer getRewardId() {
        return rewardId;
    }

    public void setRewardId(Integer rewardId) {
        this.rewardId = rewardId;
    }

    public Integer getCheckWorkAttendId() {
        return checkWorkAttendId;
    }

    public void setCheckWorkAttendId(Integer checkWorkAttendId) {
        this.checkWorkAttendId = checkWorkAttendId;
    }

    public String getDepartWork() {
        return departWork;
    }

    public void setDepartWork(String departWork) {
        this.departWork = departWork;
    }

    @Override
    public String toString() {
        return "EmployeeInfo{" +
                "id=" + id +
                ", employeeId=" + employeeId +
                ", trainID=" + trainID +
                ", salaryId=" + salaryId +
                ", rewardId=" + rewardId +
                ", checkWorkAttendId=" + checkWorkAttendId +
                ", departWork='" + departWork + '\'' +
                '}';
    }
}
