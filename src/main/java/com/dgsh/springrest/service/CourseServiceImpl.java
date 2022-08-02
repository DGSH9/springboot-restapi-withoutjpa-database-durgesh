package com.dgsh.springrest.service;

import com.dgsh.springrest.entity.Course;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class CourseServiceImpl implements CourseService {

    List<Course> list = new ArrayList<>();
    public CourseServiceImpl(){
        list.add(new Course(140,"Java","This is Java courses"));
        list.add(new Course(141,"Python","This is Python courses"));
        list.add(new Course(142,"Node","This is Node Js courses"));
    }

    @Override
    public List<Course> getCources() {
        return list;
    }

    @Override
    public Course getCourseById(int id) {
        Course c = null;
        for(Course element:list){
            if(element.getId()==id){
                c = element;
                break;
            }
        }
        return c;
    }

    @Override
    public Course addCourse(Course course) {
        list.add(course);
        return course;
    }

    @Override
    public Course updateCourse(Course course) {
        list.forEach(e -> {
            if(e.getId()==course.getId()){
                e.setTitle(course.getTitle());
                e.setDescription(e.getDescription());
            }
        });
        return course;
    }

    @Override
    public void deleteCourse(int id) {
        list = list.stream().filter(e-> e.getId() !=id).collect(Collectors.toList());
    }

}
