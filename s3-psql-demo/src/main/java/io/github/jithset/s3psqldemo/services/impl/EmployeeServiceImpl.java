package io.github.jithset.s3psqldemo.services.impl;

import io.github.jithset.s3psqldemo.domain.Employee;
import io.github.jithset.s3psqldemo.exceptions.ResourceNotFoundException;
import io.github.jithset.s3psqldemo.repositories.EmployeeRepository;
import io.github.jithset.s3psqldemo.services.EmployeeService;
import io.github.jithset.s3psqldemo.utils.FileUtils;
import io.github.jithset.s3psqldemo.utils.S3Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    S3Utils s3Utils;

    public EmployeeServiceImpl(S3Utils s3Utils) {
        this.s3Utils = s3Utils;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee uploadImage(Long id, MultipartFile file) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() ->new ResourceNotFoundException("employee", "id", id));
        File fileObj = FileUtils.convertMultiPartFileToFile(file);
        String fileName = "employees/"+System.currentTimeMillis()+"_"+ file.getOriginalFilename();
        String image = s3Utils.saveFile(fileName, fileObj);
        employee.setImage(image);
        return employee;
    }
}
