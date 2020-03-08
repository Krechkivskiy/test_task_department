package com.test_task.service;


import com.test_task.model.Department;

import java.util.List;

public interface DepartmentService {

    void save(Department department);

    List<Long> findAllByDepartmentDoesntExceedThreePeople();

    List<Long> findAllByMaxTotalSalary();
}
