package com.ixanq.test;

import com.ixanq.dao.EmployeeDao;
import com.ixanq.entity.CheckWorkAttendance;
import com.ixanq.service.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class EmployeeTest {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private EmployeeDao employeeDao;

    @Test
    public void findCheckWorkAttendanceDayLike(){
        //2017-12-12 12:12:12
        CheckWorkAttendance workAttendance=employeeDao.findCheckWorkAttendanceByEIdAndBeginDayLike(-1,"%-20 %");
        System.out.println(workAttendance);
    }
}
