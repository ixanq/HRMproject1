package com.ixanq.entity;

import java.util.Date;

//ÕÐÆ¸
public class Advertises {
    private Integer id;
    private String advertiseName;
    private String salary;
    private Integer needPersonNumber;
    private String advertiseDescreption;

    public Advertises() {
    }

    public Advertises(String advertiseName, String salary, Integer needPersonNumber, String advertiseDescreption) {
        this.advertiseName = advertiseName;
        this.salary = salary;
        this.needPersonNumber = needPersonNumber;
        this.advertiseDescreption = advertiseDescreption;
    }

    public Advertises(Integer id, String advertiseName, String salary, Integer needPersonNumber, String advertiseDescreption) {
        this.id = id;
        this.advertiseName = advertiseName;
        this.salary = salary;
        this.needPersonNumber = needPersonNumber;
        this.advertiseDescreption = advertiseDescreption;
    }

    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAdvertiseName() {
        return advertiseName;
    }

    public void setAdvertiseName(String advertiseName) {
        this.advertiseName = advertiseName;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public Integer getNeedPersonNumber() {
        return needPersonNumber;
    }

    public void setNeedPersonNumber(Integer needPersonNumber) {
        this.needPersonNumber = needPersonNumber;
    }

    public String getAdvertiseDescreption() {
        return advertiseDescreption;
    }

    public void setAdvertiseDescreption(String advertiseDescreption) {
        this.advertiseDescreption = advertiseDescreption;
    }

    @Override
    public String toString() {
        return "Advertises{" +
                "id=" + id +
                ", advertiseName='" + advertiseName + '\'' +
                ", salary='" + salary + '\'' +
                ", needPersonNumber=" + needPersonNumber +
                ", advertiseDescreption='" + advertiseDescreption + '\'' +
                '}';
    }
}
