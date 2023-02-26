package com.example.mapping.service;

import com.example.mapping.dao.StudentRepo;
import com.example.mapping.module.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepo studentRepo;
    public void addStudent(Student student){
       studentRepo.save(student);
    }
    public List<Student> getStudents(Integer id){
        List<Student> students=new ArrayList<>();
        if(null!=id && studentRepo.findById(id).isPresent()){
            students.add(studentRepo.findById(id).get());
        }
        else{
            return studentRepo.findAll();
        }
        return students;
    }
    public String updateStudent(Integer id,Student newStudent){
        if(studentRepo.findById(id).isPresent()){
            Student student=studentRepo.findById(id).get();
            newStudent.setAddress(student.getAddress());
            newStudent.setAge(student.getAge());
            newStudent.setBranch(student.getBranch());
            newStudent.setDepartment(student.getDepartment());
            newStudent.setAddress(student.getAddress());
            newStudent.setPhoneNumber(student.getPhoneNumber());
            studentRepo.save(newStudent);
            return "student updated";
        }
        return "Student not found";
    }
    public String deleteStudent(Integer id){
        if(studentRepo.findById(id).isPresent()){
            studentRepo.delete(studentRepo.findById(id).get());
            return "student deleted";
        }
        return "not found";
    }
}
