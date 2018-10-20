package com.ixanq.service;

import com.ixanq.entity.CheckWorkAttendance;
import com.ixanq.entity.Employee;

import java.util.Date;
import java.util.List;

public interface EmployeeService {
    public Employee findEmployeeByName(String byName);
    public Employee findEmployeeByNameAndPassword(String Byname,String byPassword);
    public void addCheckWorkAttendance(CheckWorkAttendance checkWorkAttendance);
    public void deleteCheckWorkAttendance(Integer byID);
    public void updateCheckWorkAttendance(CheckWorkAttendance checkWorkAttendance);
    public CheckWorkAttendance findCheckWorkAttendanceByID(Integer byId);
    public List<CheckWorkAttendance> findAllCheckWorkAttendance();

    CheckWorkAttendance findCheckWorkAttendanceByEIdAndBeginDayLike(Integer eId,String likeDay);

}
