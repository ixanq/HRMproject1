package com.ixanq.entity;
//员工

import java.util.Date;

public class Employee {
	private Integer id;
	private String name;//从游客那里获取
	private String password;//从游客那里获取
	//以下是从简历中获取
	private String realName;
	private String gender;
	private Integer age;
	private String degree;//学位
	private String email;

	private Date  beginTime;//入职时间
	private String status;//是否离职
	private Integer workPositionId;

	public Employee() {
	}

	public Employee(String name, String password, String realName, String gender, Integer age, String degree, String email, Date beginTime, String status, Integer workPositionId) {

		this.name = name;
		this.password = password;
		this.realName = realName;
		this.gender = gender;
		this.age = age;
		this.degree = degree;
		this.email = email;
		this.beginTime = beginTime;
		this.status = status;
		this.workPositionId = workPositionId;
	}

	public Employee(Integer id, String name, String password, String realName, String gender, Integer age, String degree, String email, Date beginTime, String status, Integer workPositionId) {

		this.id = id;
		this.name = name;
		this.password = password;
		this.realName = realName;
		this.gender = gender;
		this.age = age;
		this.degree = degree;
		this.email = email;
		this.beginTime = beginTime;
		this.status = status;
		this.workPositionId = workPositionId;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getWorkPositionId() {
		return workPositionId;
	}

	public void setWorkPositionId(Integer workPositionId) {
		this.workPositionId = workPositionId;
	}

	@Override
	public String toString() {
		return "Employee{" +
				"id=" + id +
				", name='" + name + '\'' +
				", password='" + password + '\'' +
				", realName='" + realName + '\'' +
				", gender='" + gender + '\'' +
				", age=" + age +
				", degree='" + degree + '\'' +
				", email='" + email + '\'' +
				", beginTime=" + beginTime +
				", status='" + status + '\'' +
				", workPositionId=" + workPositionId +
				'}';
	}
}
