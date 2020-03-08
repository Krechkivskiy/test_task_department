package com.test_task.dao;

import com.test_task.model.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeDao extends CrudRepository<Employee, Long> {

    //TODO Get a list of employees receiving a salary greater than that of the boss
    @Query(
            value = "SELECT * FROM employee as e inner join employee as m on e.boss_id=m.id " +
                    "where e.salary > m.salary",
            nativeQuery = true)
    List<Employee> findAllWhereSalaryGreaterThatBoss();

    //TODO Get a list of employees receiving the maximum salary in their department
    @Query(
            value = "SELECT *" +
                    " from employee as e where salary =\n" +
                    "(select salary from employee as empl inner join department as dep\n" +
                    "on empl.department_id = dep.id   where dep.id=e.department_id  order by salary desc limit 1)" +
                    " order by salary desc",
            nativeQuery = true)
    List<Employee> findAllByMaxSalary();

    //TODO Get a list of employees who do not have boss in the same department
    @Query(value = "SELECT * from employee as e where e.boss_id is null ",
            nativeQuery = true)
    List<Employee> findAllWithoutBoss();
}
