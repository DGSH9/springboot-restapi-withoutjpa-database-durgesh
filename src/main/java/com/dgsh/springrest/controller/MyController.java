package com.dgsh.springrest.controller;

import com.dgsh.springrest.entity.Course;
import com.dgsh.springrest.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyController {

    @Autowired
    private CourseService courseService;

    //Get all cources
    @GetMapping("/courses")
    public List<Course> getCources(){
        return courseService.getCources();
    }

    //Get Course By Id
    @GetMapping("/courses/{id}")
    public Course getCourseById(@PathVariable("id") int courseId){
        return courseService.getCourseById(courseId);
    }

    //Create Course
    @PostMapping("/courses")
    public Course addCourse(@RequestBody Course course){
        return courseService.addCourse(course);
    }

    //Update Course
    @PutMapping("/courses")
    public Course updateCourse(@RequestBody Course course){
        return courseService.updateCourse(course);
    }

    //Delete Course
    @DeleteMapping("/courses/{id}")
    public ResponseEntity<HttpStatus> deleteCourse(@PathVariable("id") int id){
        try{
            courseService.deleteCourse(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


}
