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
	
	
}
