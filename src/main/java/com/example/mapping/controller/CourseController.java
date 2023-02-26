package com.example.mapping.controller;

import com.example.mapping.dto.CourseDto;
import com.example.mapping.dto.CourseStudentDto;

import com.example.mapping.module.Course;

import com.example.mapping.service.CourseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    CourseService service;

    @PostMapping
    public String add(@RequestBody CourseDto courseDto) {
        return service.add(courseDto);
    }

    @GetMapping("/{id}")
    public List<Course> get(@Nullable @PathVariable Integer id) {
        return service.get(id);
    }
    @PostMapping("/course-student")
    public Course getEnrollStudentList(@RequestBody CourseStudentDto courseDto){
        return service.addCourseToStudent(courseDto);
    }
    @PutMapping("/{id}")
    public String update(@PathVariable Integer id,@RequestBody CourseDto courseDto){
        return service.update(id,courseDto);
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id){
        return service.delete(id);
    }
}
