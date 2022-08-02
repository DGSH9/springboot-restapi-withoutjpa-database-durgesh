package com.dgsh.springrest.service;

import com.dgsh.springrest.entity.Course;

import java.util.List;

public interface CourseService {
    public List<Course> getCources();
    public Course getCourseById(int id);
    public Course addCourse(Course course);
    public Course updateCourse(Course course);
    public void deleteCourse(int id);
}
