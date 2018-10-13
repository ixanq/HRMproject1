package com.ixanq.entity;
//╫╠им

import java.util.Date;

public class Reward {
	private Integer id;
	private Integer money;//им╫П
	private Date time;//й╠╪Д

	public Reward() {
	}

	public Reward(Integer id, Integer money, Date time) {

		this.id = id;
		this.money = money;
		this.time = time;
	}

	public Integer getId() {

		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
				", money=" + money +
				", time=" + time +
				'}';
	}
}
