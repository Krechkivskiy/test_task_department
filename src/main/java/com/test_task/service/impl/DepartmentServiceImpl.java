package com.test_task.service.impl;

import com.test_task.dao.DepartmentDao;
import com.test_task.model.Department;
import com.test_task.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentDao repository;

    @Override
    public void save(Department department) {
        repository.save(department);
    }

    @Override
    public List<Long> findAllByDepartmentDoesntExceedThreePeople() {
        return repository.findAllWhereDepartmentDoesntExceedThreePeople();
    }

    @Override
    public List<Long> findAllByMaxTotalSalary() {
        return repository.findAllByMaxTotalSalary();
    }
}
