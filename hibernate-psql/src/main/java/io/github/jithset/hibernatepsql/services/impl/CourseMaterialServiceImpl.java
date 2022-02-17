package io.github.jithset.hibernatepsql.services.impl;

import io.github.jithset.hibernatepsql.domains.Course;
import io.github.jithset.hibernatepsql.domains.CourseMaterial;
import io.github.jithset.hibernatepsql.repositories.CourseMaterialRepository;
import io.github.jithset.hibernatepsql.services.CourseMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseMaterialServiceImpl implements CourseMaterialService {

    @Autowired
    CourseMaterialRepository courseMaterialRepository;

    @Override
    public void createCourseMaterial() {
        Course course =
                Course.builder()
                        .title(".net")
                        .credit(6)
                        .build();

        CourseMaterial courseMaterial =
                CourseMaterial.builder()
                        .url("www.dailycodebuffer.com")
                        .course(course)
                        .build();

        courseMaterialRepository.save(courseMaterial);

    }

    @Override
    public List<CourseMaterial> getCourseMaterial() {
        return courseMaterialRepository.findAll();
    }
}
