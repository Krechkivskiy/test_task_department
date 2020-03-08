package com.test_task.service.impl;

import com.test_task.dao.EmployeeDao;
import com.test_task.model.Employee;
import com.test_task.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeDao employeeDao;

    @Override
    public List<Employee> findAllBySalaryGreaterThatBoss() {
        return employeeDao.findAllWhereSalaryGreaterThatBoss();
    }

    @Override
    public List<Employee> findAllByMaxSalary() {
        return employeeDao.findAllByMaxSalary();
    }

    @Override
    public List<Employee> findAllWithoutBoss() {
        return employeeDao.findAllWithoutBoss();
    }

    @Override
    public Long fireEmployee(String name) {
        Iterable<Employee> employees = employeeDao.findAll();
        //TODO Implement method using Collection
        // ---write your code here
        final Long[] employeeId = {new Long(0l)};
        List<Employee> result = new ArrayList<>();
        employees.forEach(employee -> {
            if (!employee.getName().equals(name)) {
                result.add(employee);
            } else {
                employeeId[0] = employee.getId();
            }
        });
        employeeDao.saveAll(result);
        return employeeId[0];
    }

    @Override
    public Long changeSalary(String name) {
        Iterable<Employee> employees = employeeDao.findAll();
        final Long[] employeeId = {new Long(0l)};
        //TODO Implement method using Collection
        // ---write your code here
        List<Employee> result = new ArrayList<>();
        employees.forEach(employee -> {
            if (!employee.getName().equals(name)) {
                result.add(employee);
            } else {
                employee.setSalary(new BigDecimal(1200000));
                employeeId[0] = employee.getId();
                result.add(employee);
            }
        });
        employeeDao.saveAll(result);
        return employeeId[0];
    }

    @Override
    public Long hireEmployee(Employee employee) {
        //TODO Implement method using Collection and DAO
        // ---write your code here
        Employee save = employeeDao.save(employee);
        return save.getId();
    }
}
