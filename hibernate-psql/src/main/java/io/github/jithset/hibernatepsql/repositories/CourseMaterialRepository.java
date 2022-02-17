package io.github.jithset.hibernatepsql.repositories;

import io.github.jithset.hibernatepsql.domains.CourseMaterial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseMaterialRepository extends JpaRepository<CourseMaterial, Long> {
}
