package com.ixanq.service.serviceImpl;

import com.ixanq.dao.EmployeeDao;
import com.ixanq.entity.Employee;
import com.ixanq.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
