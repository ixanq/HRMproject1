package com.ixanq.entity;

public class EmployeeInfo {
    private Integer id;
    private Integer employeeId;//用于查看个人信息
    private Integer trainId;//培训信息
    private Integer salaryId;
    private Integer rewardId;//奖惩信息
    private Integer checkworkattendId;//考勤
    private Integer departmentId;//部门
    private Integer workPositionId;//职位

    public EmployeeInfo() {
    }

    public EmployeeInfo(Integer employeeId, Integer trainId, Integer salaryId, Integer rewardId, Integer checkworkattendId, Integer departmentId, Integer workPositionId) {

        this.employeeId = employeeId;
        this.trainId = trainId;
        this.salaryId = salaryId;
        this.rewardId = rewardId;
        this.checkworkattendId = checkworkattendId;
        this.departmentId = departmentId;
        this.workPositionId = workPositionId;
    }

    public EmployeeInfo(Integer id, Integer employeeId, Integer trainId, Integer salaryId, Integer rewardId, Integer checkworkattendId, Integer departmentId, Integer workPositionId) {

        this.id = id;
        this.employeeId = employeeId;
        this.trainId = trainId;
        this.salaryId = salaryId;
        this.rewardId = rewardId;
        this.checkworkattendId = checkworkattendId;
        this.departmentId = departmentId;
        this.workPositionId = workPositionId;
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

    public Integer getTrainId() {
        return trainId;
    }

    public void setTrainId(Integer trainId) {
        this.trainId = trainId;
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

    public Integer getCheckworkattendId() {
        return checkworkattendId;
    }

    public void setCheckworkattendId(Integer checkworkattendId) {
        this.checkworkattendId = checkworkattendId;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public Integer getWorkPositionId() {
        return workPositionId;
    }

    public void setWorkPositionId(Integer workPositionId) {
        this.workPositionId = workPositionId;
    }

    @Override
    public String toString() {
        return "EmployeeInfo{" +
                "id=" + id +
                ", employeeId=" + employeeId +
                ", trainId=" + trainId +
                ", salaryId=" + salaryId +
                ", rewardId=" + rewardId +
                ", checkworkattendId=" + checkworkattendId +
                ", departmentId=" + departmentId +
                ", workPositionId=" + workPositionId +
                '}';
    }
}
