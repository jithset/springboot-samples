package io.github.jithset.hibernatepsql.services;

import io.github.jithset.hibernatepsql.domains.CourseMaterial;

import java.util.List;

public interface CourseMaterialService {

    void createCourseMaterial();
    List<CourseMaterial> getCourseMaterial();
}
