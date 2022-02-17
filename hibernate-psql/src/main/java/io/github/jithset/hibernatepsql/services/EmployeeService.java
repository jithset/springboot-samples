package io.github.jithset.hibernatepsql.services;

import io.github.jithset.hibernatepsql.domains.Employee;

import java.util.List;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    List<Employee> getAllEmployees();
    Employee getAllEmployeeById(Long id);
    Employee updateEmployee(Employee employee, Long id);
    void deleteEmployee(Long id);
}
