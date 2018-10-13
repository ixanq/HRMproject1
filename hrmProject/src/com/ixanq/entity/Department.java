package com.ixanq.entity;

import java.util.Date;

//部门
public class Department {
	private Integer id;
	private String name;//部门名字
	private Integer workPositionId;//职位id
	private Integer employeeId;
	private Date createTime;

	public Department() {
	}

	public Department(String name, Integer workPositionId, Integer employeeId, Date createTime) {
		this.name = name;
		this.workPositionId = workPositionId;
		this.employeeId = employeeId;
		this.createTime = createTime;
	}

	public Department(Integer id, String name, Integer workPositionId, Integer employeeId, Date createTime) {

		this.id = id;
		this.name = name;
		this.workPositionId = workPositionId;
		this.employeeId = employeeId;
		this.createTime = createTime;
	}

	public Integer getId() {

		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getWorkPositionId() {
		return workPositionId;
	}

	public void setWorkPositionId(Integer workPositionId) {
		this.workPositionId = workPositionId;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "Department{" +
				"id=" + id +
				", name='" + name + '\'' +
				", workPositionId=" + workPositionId +
				", employeeId=" + employeeId +
				", createTime=" + createTime +
				'}';
	}
}
