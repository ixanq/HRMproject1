package com.ixanq.dao;

import com.ixanq.entity.CheckWorkAttendance;
import com.ixanq.entity.Employee;
import com.ixanq.entity.EmployeeInfo;
import com.ixanq.entity.Reconsider;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
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

    CheckWorkAttendance findCheckWorkAttendanceByEIdAndBeginStringDateLike(@Param("eId")Integer eId,@Param("likeDay") String likeDay);

    CheckWorkAttendance findCheckWorkAttendanceByEIdAndEndStringDateLike(@Param("employeeId")Integer employeeId,@Param("likeDay")String likeDay);

    EmployeeInfo findEmployeeInfoByEId(Integer employeeId);

    void addReconsider(Reconsider reconsider);
}
