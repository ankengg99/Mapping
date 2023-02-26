package com.example.mapping.service;

import com.example.mapping.dao.BookRepo;
import com.example.mapping.dao.StudentRepo;
import com.example.mapping.dto.BookDto;
import com.example.mapping.module.Book;
import com.example.mapping.module.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepo bookRepo;

    @Autowired
    StudentRepo studentRepo;

    public String addBook(BookDto bookDto) {
        if (!studentRepo.findById(Integer.valueOf(bookDto.getStudentID())).isPresent()) {
            return "not found student";
        }

        Student Student = studentRepo.findById(Integer.valueOf(bookDto.getStudentID())).get();
        Book book = new Book();
        book.setAuthor(bookDto.getAuthor());
        book.setTitle(bookDto.getTitle());
        book.setPrice(bookDto.getPrice());
        book.setStudent(Student);
        book.setDescription(book.getDescription());
        bookRepo.save(book);

        return "book saved";
    }

    public List<Book> findAllBookByStudentId(Integer id) {
        if (studentRepo.findById(id).isPresent()) {
            Student student = studentRepo.findById(id).get();
            return bookRepo.findAllBookByStudent(student);
        }
        return new ArrayList<>();
    }


    public List<Book> findAllBook(Integer id) {
        List<Book> book = new ArrayList<>();
        if (null != id) {
            book.add(bookRepo.findById(id).get());
            return book;
        }
        return bookRepo.findAll();
    }

    public String updateBook(Integer id, BookDto bookDto) {
        Integer studentId = Integer.valueOf(bookDto.getStudentID());

        if (!bookRepo.findById(id).isPresent() || !studentRepo.findById(studentId).isPresent()) {
            return "not found";

        }
        Student student = studentRepo.findById(studentId).get();
        Book book = bookRepo.findById(id).get();
        book.setDescription(bookDto.getDescription());
        book.setTitle(bookDto.getTitle());
        book.setPrice(bookDto.getPrice());
        book.setStudent(student);
        book.setAuthor(bookDto.getAuthor());
        return "book updated";
    }
    public String deleteBook(Integer id){
        if(bookRepo.findById(id).isPresent()){
            bookRepo.deleteById(id);
            return "deleted";
        }
        return "not found";
    }
}
