package com.ixanq.service.serviceImpl;

import com.ixanq.dao.EmployeeDao;
import com.ixanq.entity.CheckWorkAttendance;
import com.ixanq.entity.Employee;
import com.ixanq.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public Employee findEmployeeByName(String byName) {
        return employeeDao.findEmployeeByName(byName);
    }

    @Override
    public Employee findEmployeeByNameAndPassword(String Byname, String byPassword) {
        return employeeDao.findEmployeeByNameAndPassword(Byname, byPassword);
    }

    @Override
    public CheckWorkAttendance findCheckWorkAttendanceByEIdAndBeginDayLike(Integer eId,String likeDay) {
        return employeeDao.findCheckWorkAttendanceByEIdAndBeginDayLike(eId,likeDay);
    }

    @Override
    public void addCheckWorkAttendance(CheckWorkAttendance checkWorkAttendance) {
        employeeDao.addCheckWorkAttendance(checkWorkAttendance);
    }

    @Override
    public void deleteCheckWorkAttendance(Integer byID) {

    }

    @Override
    public void updateCheckWorkAttendance(CheckWorkAttendance checkWorkAttendance) {

    }

    @Override
    public CheckWorkAttendance findCheckWorkAttendanceByID(Integer byId) {
        return null;
    }

    @Override
    public List<CheckWorkAttendance> findAllCheckWorkAttendance() {
        return null;
    }
}
