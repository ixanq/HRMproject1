package com.ixanq.entity;
//ÅàÑµÀà

import java.util.Date;

public class Train {
	private Integer id;
	private String name;//ÅàÑµÃû³Æ
	private Date trainTime;//ÅàÑµÊ±¼ä
	private String department;

	public Train() {
	}

	public Train(Integer id, String name, Date trainTime) {

		this.id = id;
		this.name = name;
		this.trainTime = trainTime;
	}

	public Train(Integer id, String name, Date trainTime, String department) {
		this.id = id;
		this.name = name;
		this.trainTime = trainTime;
		this.department = department;
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

	public Date getTrainTime() {
		return trainTime;
	}

	public void setTrainTime(Date trainTime) {
		this.trainTime = trainTime;
	}

	@Override
	public String toString() {
		return "Train{" +
				"id=" + id +
				", name='" + name + '\'' +
				", trainTime=" + trainTime +
				", department='" + department + '\'' +
				'}';
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
}
