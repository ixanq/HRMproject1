package com.ixanq.service;

import com.ixanq.entity.Employee;

public interface EmployeeService {
    public Employee findEmployeeByName(String byName);
    public Employee findEmployeeByNameAndPassword(String Byname,String byPassword);

}
