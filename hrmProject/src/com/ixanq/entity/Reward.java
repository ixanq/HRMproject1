package com.ixanq.entity;
//奖赏

import java.util.Date;

public class Reward {
	private Integer id;
	private Integer employeeId;
	private String reason;//原因
	private Integer money;//赏金
	private Date time;//时间

	public Reward() {
	}

	public Reward(Integer employeeId, String reason, Integer money, Date time) {

		this.employeeId = employeeId;
		this.reason = reason;
		this.money = money;
		this.time = time;
	}

	public Reward(Integer id, Integer employeeId, String reason, Integer money, Date time) {

		this.id = id;
		this.employeeId = employeeId;
		this.reason = reason;
		this.money = money;
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

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Integer getMoney() {
		return money;
	}

	public void setMoney(Integer money) {
		this.money = money;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "Reward{" +
				"id=" + id +
				", employeeId=" + employeeId +
				", reason='" + reason + '\'' +
				", money=" + money +
				", time=" + time +
				'}';
	}
}
