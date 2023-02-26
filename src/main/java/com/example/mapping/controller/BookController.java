package com.example.mapping.controller;

import com.example.mapping.dto.BookDto;
import com.example.mapping.module.Book;
import com.example.mapping.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping
    public String addBook(@RequestBody BookDto book) {
      return bookService.addBook(book);
    }

    @GetMapping("/{bookId}")
    public List<Book> getBook(@Nullable @PathVariable Integer bookId) {
     return  bookService.findAllBook(bookId);
    }
    @GetMapping("/student/{studentId}")
    public List<Book> getAllBook(@PathVariable Integer studentId){
      return bookService.findAllBookByStudentId(studentId);
    }
    @PutMapping("{bookId}")
    public String update(@PathVariable Integer bookId,@RequestBody BookDto bookDto){
        return bookService.updateBook(bookId,bookDto);
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id){
        return bookService.deleteBook(id);
    }
}
