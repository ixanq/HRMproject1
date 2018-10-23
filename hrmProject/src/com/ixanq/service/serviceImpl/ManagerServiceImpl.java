package com.ixanq.service.serviceImpl;

import com.ixanq.dao.ManagerDao;
import com.ixanq.entity.*;
import com.ixanq.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.View;
import java.util.List;

@Service("managerService")
public class ManagerServiceImpl implements ManagerService {
    @Autowired
    private ManagerDao managerDao;
    @Override
    public Manager findAdminByName(String byName) {
        return managerDao.findAdminByName(byName);
    }

    @Override
    public Manager findAdminByNameAndPassword(Manager manager) {
        return managerDao.findAdminByNameAndPassword(manager);
    }

    @Override
    public void addDepartment(Department department) {
        managerDao.addDepartment(department);
    }

    @Override
    public void deleteDepartment(Integer byID) {
        managerDao.deleteDepartment(byID);
    }

    @Override
    public void updateDepartment(Department department) {
        managerDao.updateDepartment(department);
    }

    @Override
    public Department findDepartmentbyId(Integer byId) {
        return managerDao.findDepartmentbyId(byId);
    }

    @Override
    public List<Department> findAllDepartment() {
        return managerDao.findAllDepartment();
    }

    @Override
    public void addWorkPosition(WorkPosition workPosition) {
        managerDao.addWorkPosition(workPosition);
    }

    @Override
    public void deleteWorkPosition(Integer byID) {
        managerDao.deleteWorkPosition(byID);
    }

    @Override
    public void updateWorkPosition(WorkPosition workPosition) {
        managerDao.updateWorkPosition(workPosition);
    }

    @Override
    public WorkPosition findWorkPositionById(Integer byId) {
        return managerDao.findWorkPositionById(byId);
    }

    @Override
    public List<WorkPosition> findAllWorkPosition() {
        return managerDao.findAllWorkPosition();
    }

    @Override
    public void addEmployee(Employee employee) {
        managerDao.addEmployee(employee);
    }

    @Override
    public void deleteEmployee(Integer byID) {
        managerDao.deleteEmployee(byID);
    }

    @Override
    public void updateEmployee(Employee employee) {
        managerDao.updateEmployee(employee);
    }

    @Override
    public Employee findEmployeeById(Integer byId) {
        return managerDao.findEmployeeById(byId);
    }

    @Override
    public List<Employee> findAllEmployee() {
        return managerDao.findAllEmployee();
    }

    @Override
    public void addSalary(Salary salary) {
        managerDao.addSalary(salary);
    }

    @Override
    public void deleteSalary(Integer byID) {
        managerDao.deleteSalary(byID);
    }

    @Override
    public void updateSalary(Salary salary) {
        managerDao.updateSalary(salary);
    }

    @Override
    public Salary findSalaryById(Integer byId) {
        return managerDao.findSalaryById(byId);
    }

    @Override
    public List<Salary> findAllSalary() {
        return managerDao.findAllSalary();
    }

    @Override
    public void addCheckWorkAttendance(CheckWorkAttendance checkWorkAttendance) {
        managerDao.addCheckWorkAttendance(checkWorkAttendance);
    }

    @Override
    public void deleteCheckWorkAttendance(Integer byID) {
        managerDao.deleteCheckWorkAttendance(byID);
    }

    @Override
    public void updateCheckWorkAttendance(CheckWorkAttendance checkWorkAttendance) {
        managerDao.updateCheckWorkAttendance(checkWorkAttendance);
    }

    @Override
    public CheckWorkAttendance findCheckWorkAttendanceByID(Integer byId) {
        return managerDao.findCheckWorkAttendanceByID(byId);
    }

    @Override
    public List<CheckWorkAttendance> findAllCheckWorkAttendance() {
        return managerDao.findAllCheckWorkAttendance();
    }

    @Override
    public void addTrain(Train train) {
        managerDao.addTrain(train);
    }

    @Override
    public void deleteTrain(Integer byID) {
        managerDao.deleteTrain(byID);
    }

    @Override
    public void updateTrain(Train train) {
        managerDao.updateTrain(train);
    }

    @Override
    public Train findTrainById(Integer byId) {
        return managerDao.findTrainById(byId);
    }

    @Override
    public List<Train> findAllTrain() {
        return managerDao.findAllTrain();
    }

    @Override
    public void addReward(Reward reward) {
        managerDao.addReward(reward);
    }

    @Override
    public void deleteReward(Integer byID) {
        managerDao.deleteReward(byID);
    }

    @Override
    public void updateReward(Reward reward) {
        managerDao.updateReward(reward);
    }

    @Override
    public Reward findRewardById(Integer byId) {
        return managerDao.findRewardById(byId);
    }

    @Override
    public List<Reward> findAllReward() {
        return managerDao.findAllReward();
    }

    @Override
    public List<WorkPosition> findWorkPositionByDepartmentId(Integer id) {
        return managerDao.findWorkPositionByDepartmentId(id);
    }

    @Override
    public List<ResumeForManager> findResumeByStatus(String status) {
        return managerDao.findResumeByStatus(status);
    }

    @Override
    public List<ResumeForManager> findAllResumeForManager() {
        return managerDao.findAllResumeForManager();
    }

    @Override
    public ResumeForManager findResumeById(Integer newId) {
        return managerDao.findResumeById(newId);
    }

    @Override
    public void updateResumeStatusForManager(ResumeForManager resumeById) {
        managerDao.updateResumeStatusForManager(resumeById);
    }

    @Override
    public void deleteResumeForManagerById(Integer id) {
        managerDao.deleteResumeForManagerById(id);
    }

    @Override
    public void addAdvertise(Advertises advertises) {
        managerDao.addAdvertise(advertises);
    }

    @Override
    public List<Advertises> finaAllAdvertise() {
        return managerDao.finaAllAdvertise();
    }

    @Override
    public Advertises findAdvertisesById(Integer newId) {
        return managerDao.findAdvertisesById(newId);
    }

    @Override
    public void deleteAdvertiseById(Integer id) {
        managerDao.deleteAdvertiseById(id);
    }

    @Override
    public void addInterviewforVisitor(Interview interview) {
        managerDao.addInterviewforVisitor(interview);
    }

    @Override
    public Interview findInterviewforVisitorByVisitorName(String visitorName) {
        return managerDao.findInterviewforVisitorByVisitorName(visitorName);
    }

    @Override
    public List<GoInterview> findGoInterviewByStatus(String viewStatus) {
        return managerDao.findGoInterviewByStatus(viewStatus);
    }

    @Override
    public List<GoInterview> findAllGoInterview() {
        return managerDao.findAllGoInterview();
    }

    @Override
    public GoInterview findGoInterviewByGointerviewId(Integer gointerviewId) {
        return managerDao.findGoInterviewByGointerviewId(gointerviewId);
    }

    @Override
    public List<ResumeForManager>  findResumeForManagerByVisitorName(String name) {
        return managerDao.findResumeForManagerByVisitorName(name);
    }

    @Override
    public void updateGoInterview(GoInterview goInterview1) {
        managerDao.updateGoInterview(goInterview1);
    }

    @Override
    public List<EmployeeInfo> findEmployeeInfoByworkPositionId(Integer workPositionId) {
        return managerDao.findEmployeeInfoByworkPositionId(workPositionId);
    }

    @Override
    public EmployeeInfo findEmployeeInfoByDepartmentId(Integer departmentId) {
        return managerDao.findEmployeeInfoByDepartmentId(departmentId);
    }

    @Override
    public List<EmployeeInfo> findAllEmployeeInfo() {
        return managerDao.findAllEmployeeInfo();
    }

    @Override
    public Employee findEmployeeByVisitorName(String name) {
        return managerDao.findEmployeeByVisitorName(name);
    }

    @Override
    public void addEmployeeInfo(EmployeeInfo employeeInfo) {
        managerDao.addEmployeeInfo(employeeInfo);
    }

    @Override
    public EmployeeInfo findEmployeeInfoByEmployeeId(Integer employeeId) {
        return managerDao.findEmployeeInfoByEmployeeId(employeeId);
    }

    @Override
    public void updateEmployeeInfo(EmployeeInfo eInfo) {
        managerDao.updateEmployeeInfo(eInfo);
    }

    @Override
    public void deleteGoInterviewById(Integer id) {
        managerDao.deleteGoInterviewById(id);
    }

    @Override
    public void deleteWorkPositionByDepartmentId(Integer departmentId) {
        managerDao.deleteWorkPositionByDepartmentId(departmentId);
    }

    @Override
    public List<Reward> findRewardByEmployeeId(Integer employeeId1) {
        return managerDao.findRewardByEmployeeId(employeeId1);
    }

    @Override
    public Train findTrainByDepartmentName(String department) {
        return managerDao.findTrainByDepartmentName(department);
    }

    @Override
    public List<CheckWorkAttendance> findCheckWorkAttendanceLikeDate(String stringMonth1) {
        return managerDao.findCheckWorkAttendanceLikeDate(stringMonth1);
    }

    @Override
    public List<CheckWorkAttendance> findAllCheckWorkAttendanceByEIdAndByMonth(Integer employeeId, String monthLike) {
        return managerDao.findAllCheckWorkAttendanceByEIdAndByMonth(employeeId,monthLike);
    }

    @Override
    public List<Reward> findRewardByEmployeeIdAndByMonthLike(Integer employeeId1, String monthLike) {
        return managerDao.findRewardByEmployeeIdAndByMonthLike(employeeId1,monthLike);
    }

    @Override
    public Salary findSalaryByEIdAndByYearAndByMonth(Integer employeeId1, int year, int month) {
        return managerDao.findSalaryByEIdAndByYearAndByMonth(employeeId1,year,month);
    }

    @Override
    public List<Reward> findAllRewardByEId(Integer eId, Integer month1, Integer year1) {
        return managerDao.findAllRewardByEId(eId,month1,year1);
    }

    @Override
    public List<Salary> findSalaryByEmployeeId(Integer id, Integer month, Integer year) {
        return managerDao.findSalaryByEmployeeId(id, month, year);
    }

    @Override
    public List<CheckWorkAttendance> findAllCheckWorkAttendanceByEIdMonthYear(Integer id, Integer month1, Integer year1) {
        return managerDao.findAllCheckWorkAttendanceByEIdMonthYear(id,month1,year1);
    }
}
