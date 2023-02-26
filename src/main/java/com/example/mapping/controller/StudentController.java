package com.example.mapping.controller;

import com.example.mapping.module.Student;
import com.example.mapping.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService service;
    @PostMapping
    public String addStudent(@RequestBody Student student){
        service.addStudent(student);
        return "student saved";
    }
    @GetMapping(value="/studentId")
    public List<Student> getStudent(@Nullable @RequestParam Integer studentId){
        return service.getStudents(studentId);
    }
    @PutMapping(value="/{studentId}")
    public String update(@PathVariable Integer studentId,@RequestBody Student student){
        return service.updateStudent(studentId,student);
    }
    @DeleteMapping(value="{id}")
    public String delete(@PathVariable Integer id){
        return service.deleteStudent(id);
    }

}
