package io.github.jithset.s3psqldemo.controller;

import io.github.jithset.s3psqldemo.domain.Employee;
import io.github.jithset.s3psqldemo.services.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
    }

    @PostMapping("/{id}/image")
    ResponseEntity<Employee> saveEmployeeImage(@PathVariable("id") Long id, @RequestParam(value = "image") MultipartFile image) {
        return new ResponseEntity<Employee>(employeeService.uploadImage(id, image), HttpStatus.CREATED);
    }
}
