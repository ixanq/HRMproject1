package com.ixanq.entity;
//����

import java.util.Date;

public class Reward {
	private Integer id;
	private String reason;//ԭ��
	private Integer money;//�ͽ�
	private Date time;//ʱ��

	public Reward() {
	}

	public Reward(Integer id, String reason, Integer money, Date time) {
		this.id = id;
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
				", reason='" + reason + '\'' +
				", money=" + money +
				", time=" + time +
				'}';
	}
}
