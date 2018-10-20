package com.ixanq.entity;
//��ѵ��

import java.util.Date;

public class Train {
	private Integer id;
	private String name;//��ѵ����
	private Date trainTime;//��ѵʱ��
	private String department;

	public Train() {
	}

	public Train(String name, Date trainTime, String department) {

		this.name = name;
		this.trainTime = trainTime;
		this.department = department;
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

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
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
}
