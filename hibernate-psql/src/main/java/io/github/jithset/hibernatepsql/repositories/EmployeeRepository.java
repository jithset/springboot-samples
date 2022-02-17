package io.github.jithset.hibernatepsql.repositories;

import io.github.jithset.hibernatepsql.domains.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
