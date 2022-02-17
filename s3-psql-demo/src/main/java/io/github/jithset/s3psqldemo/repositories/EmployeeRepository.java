package io.github.jithset.s3psqldemo.repositories;

import io.github.jithset.s3psqldemo.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
