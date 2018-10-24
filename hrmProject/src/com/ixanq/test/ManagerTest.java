package com.ixanq.test;

import com.ixanq.dao.ManagerDao;
import com.ixanq.entity.*;
import com.ixanq.service.ManagerService;
import com.ixanq.service.VisitorService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class ManagerTest {
    @Autowired
    private ManagerDao managerDao;
    @Autowired
    private VisitorService visitorService;
    @Autowired
    private ManagerService managerService;

    @Test
    public void addDepartment(){
        Department department=new Department(-1,"qqq",new Date());
        managerDao.addDepartment(department);
    }

    @Test
    public void deleteDepartment(){
       managerDao.deleteDepartment(7);
    }

    @Test
    public void updateDepartment(){
        Department department=new Department(8,"qqq",new Date());
        managerDao.updateDepartment(department);
    }

    @Test
    public void findDepartmentbyId(){
        Department department = managerDao.findDepartmentbyId(9);
        System.out.println(department);
    }
    @Test
    public void selectAllDepartment(){
        List<Department> allDepartment = managerDao.findAllDepartment();
        System.out.println(allDepartment);
    }

    @Test
    public void findAllWorkPosition(){
        List<WorkPosition> allWorkPosition = managerDao.findAllWorkPosition();
        System.out.println(allWorkPosition);
    }

    @Test
    public void findAllEmployee(){
        List<Employee> allEmployee = managerDao.findAllEmployee();
        System.out.println(allEmployee);
    }

    @Test
    public void adminLogin(){
        Manager manager = managerService.findAdminByName("admin");
        Manager manager2=new Manager("zzz","zzz");
        Manager manager1 = managerService.findAdminByNameAndPassword(manager2);
        System.out.println(manager);
        System.out.println(manager1);;
    }

    @Test
    public void findResumeByStatus(){
        List<ResumeForManager> resumes = managerService.findResumeByStatus("Î´¶Á");
        System.out.println(resumes);

    }

    @Test
    public void findAllResumeForManager(){
        List<ResumeForManager> resumesForManager= managerService.findAllResumeForManager();
        System.out.println(resumesForManager);

    }

    @Test
    public void addReward(){
       managerDao.addReward(new Reward(-1,"ÄãºÃ",200,new Date()));
    }

    @Test
    public void findEmployeeInfoByworkPositionId(){
        List<EmployeeInfo> employeeInfos = managerService.findEmployeeInfoByworkPositionId(16);
        System.out.println(employeeInfos);
        List<EmployeeInfo> emp = managerService.findEmployeeInfoByworkPositionId(19);
        System.out.println(emp);
    }




}
