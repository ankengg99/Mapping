package com.example.mapping.service;

import com.example.mapping.dao.CourseRepo;
import com.example.mapping.dao.LaptopRepo;
import com.example.mapping.dao.StudentRepo;
import com.example.mapping.dto.CourseDto;
import com.example.mapping.dto.CourseStudentDto;
import com.example.mapping.dto.LaptopDto;
import com.example.mapping.module.Course;
import com.example.mapping.module.Laptop;
import com.example.mapping.module.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CourseService {
    @Autowired
    CourseRepo courseRepo;

    @Autowired
    StudentRepo studentRepo;

    public String add(CourseDto courseDto) {
       Course course=new Course();
       course.setDescription(courseDto.getDescription());
       course.setID(courseDto.getID());
       course.setDuration(courseDto.getDuration());
       course.setTitle(courseDto.getTitle());
       courseRepo.save(course);
        return "course saved";
    }

    public List<Course> get(Integer id) {
        List<Course> courses = new ArrayList<>();
        if (null != id) {
            courses.add(courseRepo.findById(id).get());
            return courses;
        }
        return courseRepo.findAll();
    }

    public String update(Integer id, CourseDto courseDto) {
        Integer courseId = Integer.valueOf(courseDto.getID());

        if (!courseRepo.findById(id).isPresent()) {
            return "not found";

        }
        Course course=courseRepo.findById(courseId).get();
        course.setDescription(courseDto.getDescription());
        course.setID(courseDto.getID());
        course.setDuration(courseDto.getDuration());
        course.setTitle(courseDto.getTitle());
        courseRepo.save(course);
        return "course updated";
    }
    public Course addCourseToStudent(CourseStudentDto course) {
        if(!studentRepo.existsById(Integer.valueOf(course.getStudentId())) ||
                !courseRepo.existsById(Integer.valueOf(course.getCourseId()))){
            return null;
        }
        Student student = studentRepo.findById(Integer.valueOf(course.getStudentId())).get();




            Course course1 = courseRepo.findById(Integer.valueOf(course.getCourseId())).get();
            List<Student> studentList = course1.getStudentList();

            studentList.add(student);
            course1.setStudentList(studentList);
            Course updatedCourse = courseRepo.save(course1);
            return updatedCourse;


    }
    public String delete(Integer id){
        if(courseRepo.findById(id).isPresent()){
            courseRepo.deleteById(id);
            return "deleted";
        }
        return "not found";
    }
}
