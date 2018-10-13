package com.ixanq.dao;

import com.ixanq.entity.CheckWorkAttendance;

import java.util.List;

public interface EmployeeDao {

                        /*¿¼ÇÚÔöÉ¾¸Ä²é*/
    public void addCheckWorkAttendance(CheckWorkAttendance checkWorkAttendance);
    public void deleteCheckWorkAttendance(Integer byID);
    public void updateCheckWorkAttendance(CheckWorkAttendance checkWorkAttendance);
    public CheckWorkAttendance findCheckWorkAttendanceByID(Integer byId);
    public List<CheckWorkAttendance> findAllCheckWorkAttendance();
}
