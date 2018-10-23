package com.ixanq.entity;
//薪资
public class Salary {
    private Integer id;
    private Integer salary;
    private Integer employeeId;
    private Integer month;//几月份的
    private Integer year;
    private Integer workDay;

    public Salary() {
    }

    public Salary(Integer salary, Integer employeeId, Integer month, Integer year, Integer workDay) {

        this.salary = salary;
        this.employeeId = employeeId;
        this.month = month;
        this.year = year;
        this.workDay = workDay;
    }

    public Salary(Integer id, Integer salary, Integer employeeId, Integer month, Integer year, Integer workDay) {

        this.id = id;
        this.salary = salary;
        this.employeeId = employeeId;
        this.month = month;
        this.year = year;
        this.workDay = workDay;
    }

    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getWorkDay() {
        return workDay;
    }

    public void setWorkDay(Integer workDay) {
        this.workDay = workDay;
    }

    @Override
    public String toString() {
        return "Salary{" +
                "id=" + id +
                ", salary=" + salary +
                ", employeeId=" + employeeId +
                ", month=" + month +
                ", year=" + year +
                ", workDay=" + workDay +
                '}';
    }
}
