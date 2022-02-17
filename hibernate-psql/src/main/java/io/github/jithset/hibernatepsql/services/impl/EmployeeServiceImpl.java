package io.github.jithset.hibernatepsql.services.impl;

import io.github.jithset.hibernatepsql.domains.Employee;
import io.github.jithset.hibernatepsql.exceptions.ResourceNotFoundException;
import io.github.jithset.hibernatepsql.repositories.EmployeeRepository;
import io.github.jithset.hibernatepsql.services.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        super();
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getAllEmployeeById(Long id) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if (employeeOptional.isPresent())
            return employeeOptional.get();
        throw  new ResourceNotFoundException("Employee", "Id", id);
    }

    @Override
    public Employee updateEmployee(Employee employee, Long id) {
        Employee existingEmployee = employeeRepository.findById(id).orElseThrow(() ->  new ResourceNotFoundException("employee", "id", id));
        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmail(employee.getEmail());
        employeeRepository.save(existingEmployee);
        return existingEmployee;
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.findById(id).orElseThrow(() ->  new ResourceNotFoundException("employee", "id", id));
        employeeRepository.deleteById(id);
    }
}
