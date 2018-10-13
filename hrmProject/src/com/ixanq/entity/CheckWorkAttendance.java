package com.ixanq.entity;


import java.util.Date;
//考勤
public class CheckWorkAttendance {
	private Integer id;
	private Integer employeeID;
	private Date  beginWork;//上班时间
	private Date endWork;//下班时间
	private String isLate;//是否迟到
	private String isLeave;//是否早退

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
