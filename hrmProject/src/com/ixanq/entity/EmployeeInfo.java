package com.ixanq.entity;

public class EmployeeInfo {
    private Integer id;
    private Integer employeeId;//���ڲ鿴������Ϣ
    private Integer trainID;//��ѵ��Ϣ
    private Integer salaryId;
    private Integer rewardId;//������Ϣ
    private Integer checkWorkAttendId;//����
    private Integer departmentId;//����
    private Integer workPositionId;//ְλ

    public EmployeeInfo() {
    }

    public EmployeeInfo(Integer id, Integer employeeId, Integer trainID, Integer salaryId, Integer rewardId, Integer checkWorkAttendId, Integer departmentId, Integer workPositionId) {

        this.id = id;
        this.employeeId = employeeId;
        this.trainID = trainID;
        this.salaryId = salaryId;
        this.rewardId = rewardId;
        this.checkWorkAttendId = checkWorkAttendId;
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
                ", trainID=" + trainID +
                ", salaryId=" + salaryId +
                ", rewardId=" + rewardId +
                ", checkWorkAttendId=" + checkWorkAttendId +
                ", departmentId=" + departmentId +
                ", workPositionId=" + workPositionId +
                '}';
    }
}
