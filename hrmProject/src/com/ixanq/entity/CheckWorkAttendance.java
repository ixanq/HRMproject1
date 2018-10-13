package com.ixanq.entity;


import java.util.Date;
//����
public class CheckWorkAttendance {
	private Integer id;
	private Integer employeeID;
	private Date  beginWork;//�ϰ�ʱ��
	private Date endWork;//�°�ʱ��
	private String isLate;//�Ƿ�ٵ�
	private String isLeave;//�Ƿ�����

	public CheckWorkAttendance() {
	}

	public CheckWorkAttendance(Integer id, Integer employeeID, Date beginWork, Date endWork, String isLate, String isLeave) {

		this.id = id;
		this.employeeID = employeeID;
		this.beginWork = beginWork;
		this.endWork = endWork;
		this.isLate = isLate;
		this.isLeave = isLeave;
	}

	public Integer getId() {

		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(Integer employeeID) {
		this.employeeID = employeeID;
	}

	public Date getBeginWork() {
		return beginWork;
	}

	public void setBeginWork(Date beginWork) {
		this.beginWork = beginWork;
	}

	public Date getEndWork() {
		return endWork;
	}

	public void setEndWork(Date endWork) {
		this.endWork = endWork;
	}

	public String getIsLate() {
		return isLate;
	}

	public void setIsLate(String isLate) {
		this.isLate = isLate;
	}

	public String getIsLeave() {
		return isLeave;
	}

	public void setIsLeave(String isLeave) {
		this.isLeave = isLeave;
	}

	@Override
	public String toString() {
		return "CheckWorkAttendance{" +
				"id=" + id +
				", employeeID=" + employeeID +
				", beginWork=" + beginWork +
				", endWork=" + endWork +
				", isLate='" + isLate + '\'' +
				", isLeave='" + isLeave + '\'' +
				'}';
	}
}
