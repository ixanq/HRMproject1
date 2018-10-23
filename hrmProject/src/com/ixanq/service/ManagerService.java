package com.ixanq.service;

import com.ixanq.entity.*;

import javax.swing.text.View;
import java.util.List;

public interface ManagerService {
    /* ����Ա��Ϣ*/
    Manager findAdminByName(String byName);
    Manager findAdminByNameAndPassword(Manager manager);

    /*������ɾ�Ĳ�*/
    public void addDepartment(Department department);
    public void deleteDepartment(Integer byID);
    public void updateDepartment(Department department);
    public Department findDepartmentbyId(Integer byId);
    public List<Department> findAllDepartment();

    /*ְλ��ɾ�Ĳ�*/
    public void addWorkPosition(WorkPosition workPosition);
    public void deleteWorkPosition(Integer byID);
    public void updateWorkPosition(WorkPosition workPosition);
    public WorkPosition findWorkPositionById(Integer byId);
    public List<WorkPosition> findAllWorkPosition();


    /* Ա������ɾ�Ĳ�*/
    public void addEmployee(Employee employee);
    public void deleteEmployee(Integer byID);
    public void updateEmployee(Employee employee);
    public Employee findEmployeeById(Integer byId);
    public List<Employee> findAllEmployee();

    /* н�ʵ���ɾ�Ĳ�*/
    public void addSalary(Salary salary);
    public void deleteSalary(Integer byID);
    public void updateSalary(Salary salary);
    public Salary findSalaryById(Integer byId);
    public List<Salary> findAllSalary();

    /*������ɾ�Ĳ�*/
    public void addCheckWorkAttendance(CheckWorkAttendance checkWorkAttendance);
    public void deleteCheckWorkAttendance(Integer byID);
    public void updateCheckWorkAttendance(CheckWorkAttendance checkWorkAttendance);
    public CheckWorkAttendance findCheckWorkAttendanceByID(Integer byId);
    public List<CheckWorkAttendance> findAllCheckWorkAttendance();

    /* ��ѵ����ɾ�Ĳ�*/
    public void addTrain(Train train);
    public void deleteTrain(Integer byID);
    public void updateTrain(Train train);
    public Train findTrainById(Integer byId);
    public List<Train> findAllTrain();


    /* ������ɾ�Ĳ�*/
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

    void addAdvertise(Advertises advertises);

    List<Advertises> finaAllAdvertise();

    Advertises findAdvertisesById(Integer newId);

    void deleteAdvertiseById(Integer id);

    void addInterviewforVisitor(Interview interview);

    Interview findInterviewforVisitorByVisitorName(String visitorName);

    List<GoInterview> findGoInterviewByStatus(String viewStatus);

    List<GoInterview> findAllGoInterview();

    GoInterview findGoInterviewByGointerviewId(Integer gointerviewId);

    List<ResumeForManager>  findResumeForManagerByVisitorName(String name);

    void updateGoInterview(GoInterview goInterview1);

    List<EmployeeInfo> findEmployeeInfoByworkPositionId(Integer workPositionId);

    EmployeeInfo findEmployeeInfoByDepartmentId(Integer departmentId);

    List<EmployeeInfo> findAllEmployeeInfo();

    Employee findEmployeeByVisitorName(String name);

    void addEmployeeInfo(EmployeeInfo employeeInfo);

    EmployeeInfo findEmployeeInfoByEmployeeId(Integer employeeId);

    void updateEmployeeInfo(EmployeeInfo eInfo);

    void deleteGoInterviewById(Integer id);

    void deleteWorkPositionByDepartmentId(Integer departmentId);

    List<Reward> findRewardByEmployeeId(Integer employeeId1);

    Train findTrainByDepartmentName(String department);

    List<CheckWorkAttendance> findCheckWorkAttendanceLikeDate(String stringMonth1);

    List<CheckWorkAttendance> findAllCheckWorkAttendanceByEIdAndByMonth(Integer employeeId, String monthLike);

    List<Reward> findRewardByEmployeeIdAndByMonthLike(Integer employeeId1, String monthLike);

    Salary findSalaryByEIdAndByYearAndByMonth(Integer employeeId1, int year, int month);

    List<Salary> findSalaryByEmployeeId(Integer id,Integer month,Integer year);


    List<Reward> findAllRewardByEId(Integer id, Integer month, Integer year);

    List<CheckWorkAttendance> findAllCheckWorkAttendanceByEIdMonthYear(Integer id, Integer month, Integer year);
}
