package com.ixanq.service;

import com.ixanq.entity.*;

import java.util.List;

public interface ManagerService {
    /* 管理员信息*/
    Manager findAdminByName(String byName);
    Manager findAdminByNameAndPassword(Manager manager);

    /*部门增删改查*/
    public void addDepartment(Department department);
    public void deleteDepartment(Integer byID);
    public void updateDepartment(Department department);
    public Department findDepartmentbyId(Integer byId);
    public List<Department> findAllDepartment();

    /*职位增删改查*/
    public void addWorkPosition(WorkPosition workPosition);
    public void deleteWorkPosition(Integer byID);
    public void updateWorkPosition(WorkPosition workPosition);
    public WorkPosition findWorkPositionById(Integer byId);
    public List<WorkPosition> findAllWorkPosition();


    /* 员工的增删改查*/
    public void addEmployee(Employee employee);
    public void deleteEmployee(Integer byID);
    public void updateEmployee(Employee employee);
    public Employee findEmployeeById(Integer byId);
    public List<Employee> findAllEmployee();

    /* 薪资的增删改查*/
    public void addSalary(Salary salary);
    public void deleteSalary(Integer byID);
    public void updateSalary(Salary salary);
    public Salary findSalaryById(Integer byId);
    public List<Salary> findAllSalary();

    /*考勤增删改查*/
    public void addCheckWorkAttendance(CheckWorkAttendance checkWorkAttendance);
    public void deleteCheckWorkAttendance(Integer byID);
    public void updateCheckWorkAttendance(CheckWorkAttendance checkWorkAttendance);
    public CheckWorkAttendance findCheckWorkAttendanceByID(Integer byId);
    public List<CheckWorkAttendance> findAllCheckWorkAttendance();

    /* 培训的增删改查*/
    public void addTrain(Train train);
    public void deleteTrain(Integer byID);
    public void updateTrain(Train train);
    public Train findTrainById(Integer byId);
    public List<Train> findAllTrain();


    /* 奖惩增删改查*/
    public void addReward(Reward reward);
    public void deleteReward(Integer byID);
    public void updateReward(Reward reward);
    public Reward findRewardById(Integer byId);
    public List<Reward> findAllReward();

    List<WorkPosition> findWorkPositionByDepartmentId(Integer id);

    List<ResumeForManager> findResumeByStatus(String status);

    List<ResumeForManager> findAllResumeForManager();

    ResumeForManager findResumeById(Integer newId);

    void updateResumeStatusForManager(ResumeForManager resumeById);

    void deleteResumeForManagerById(Integer id);
}
