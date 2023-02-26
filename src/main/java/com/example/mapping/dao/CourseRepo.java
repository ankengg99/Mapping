package com.example.mapping.dao;

import com.example.mapping.dto.CourseDto;
import com.example.mapping.module.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepo extends JpaRepository<Course,Integer> {
}
