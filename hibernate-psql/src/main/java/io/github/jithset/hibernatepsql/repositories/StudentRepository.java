package io.github.jithset.hibernatepsql.repositories;

import io.github.jithset.hibernatepsql.domains.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
