package com.example.mapping.dao;

import com.example.mapping.module.Book;
import com.example.mapping.module.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepo extends JpaRepository<Book,Integer> {
    List<Book> findAllBookByStudent(Student student);
}
