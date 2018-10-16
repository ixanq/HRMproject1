package com.ixanq.dao;

import com.ixanq.entity.CheckWorkAttendance;
import com.ixanq.entity.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeDao {

                        /*员工登录*/
    public Employee findEmployeeByName(String byName);
    public Employee findEmployeeByNameAndPassword(@Param("name")String name,@Param("password") String password);
                        /*考勤增删改查*/
    public void addCheckWorkAttendance(CheckWorkAttendance checkWorkAttendance);
    public void deleteCheckWorkAttendance(Integer byID);
    public void updateCheckWorkAttendance(CheckWorkAttendance checkWorkAttendance);
    public CheckWorkAttendance findCheckWorkAttendanceByID(Integer byId);
    public List<CheckWorkAttendance> findAllCheckWorkAttendance();
}
