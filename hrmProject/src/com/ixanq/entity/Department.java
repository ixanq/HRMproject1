package com.ixanq.entity;

import java.util.Date;

//部门
public class Department {
	private Integer id;
	private String name;//部门名字
	private Date createTime;

	public Department() {
	}

	public Department(Integer id, String name, Date createTime) {
		this.id = id;
		this.name = name;
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
				", createTime=" + createTime +
				'}';
	}
}
