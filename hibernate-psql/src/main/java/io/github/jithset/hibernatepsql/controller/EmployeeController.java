package io.github.jithset.hibernatepsql.controller;

import io.github.jithset.hibernatepsql.domains.Employee;
import io.github.jithset.hibernatepsql.services.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        super();
        this.employeeService = employeeService;
    }

    @PostMapping
    ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
    }
    @GetMapping
    ResponseEntity<List<Employee>> getEmployees() {
        return new ResponseEntity<List<Employee>>(employeeService.getAllEmployees(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    ResponseEntity<Employee> getEmployeesById(@PathVariable("id") Long id) {
        return new ResponseEntity<Employee>(employeeService.getAllEmployeeById(id), HttpStatus.OK);
    }

    @PutMapping("{id}")
    ResponseEntity<Employee> updateEmployee(@PathVariable("id") Long id, @RequestBody Employee employee) {
        return new ResponseEntity<Employee>(employeeService.updateEmployee(employee, id), HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    ResponseEntity<String> deleteEmployee(@PathVariable("id") Long id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<String>("Employee Deleted", HttpStatus.OK);
    }
}
