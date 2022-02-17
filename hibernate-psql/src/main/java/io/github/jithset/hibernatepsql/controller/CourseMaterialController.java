package io.github.jithset.hibernatepsql.controller;

import io.github.jithset.hibernatepsql.domains.CourseMaterial;
import io.github.jithset.hibernatepsql.services.CourseMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/course-material")
public class CourseMaterialController {
    @Autowired
    CourseMaterialService courseMaterialService;
    @GetMapping()
    public ResponseEntity<String> get() {
        courseMaterialService.createCourseMaterial();
        return new ResponseEntity<String>("Created", HttpStatus.OK);
    }

    @GetMapping("list")
    public ResponseEntity<List<CourseMaterial>> getAll() {

        return new ResponseEntity<>(courseMaterialService.getCourseMaterial(), HttpStatus.OK);
    }
}
