package io.github.jithset.s3psqldemo.services;

import io.github.jithset.s3psqldemo.domain.Employee;
import org.springframework.web.multipart.MultipartFile;

public interface EmployeeService {

    Employee saveEmployee(Employee employee);
    Employee uploadImage(Long id, MultipartFile file);


}
