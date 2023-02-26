package com.example.mapping.service;

import com.example.mapping.dao.BookRepo;
import com.example.mapping.dao.LaptopRepo;
import com.example.mapping.dao.StudentRepo;
import com.example.mapping.dto.BookDto;
import com.example.mapping.dto.LaptopDto;
import com.example.mapping.module.Book;
import com.example.mapping.module.Laptop;
import com.example.mapping.module.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LaptopService {
    @Autowired
    LaptopRepo laptopRepo;

    @Autowired
    StudentRepo studentRepo;

    public String add(LaptopDto laptopDto) {
        if (!studentRepo.findById(Integer.valueOf(laptopDto.getStudentID())).isPresent()) {
            return "not found student";
        }

        Student student = studentRepo.findById(Integer.valueOf(laptopDto.getStudentID())).get();
      Laptop laptop=new Laptop();
       laptop.setStudent(student);
       laptop.setPrice(laptopDto.getPrice());
       laptop.setBrand(laptopDto.getBrand());
       laptop.setName(laptopDto.getName());

        return "laptop saved";
    }




    public List<Laptop> findLaptop(Integer id) {
        List<Laptop> laptops = new ArrayList<>();
        if (null != id) {
            laptops.add(laptopRepo.findById(id).get());
            return laptops;
        }
        return laptopRepo.findAll();
    }

    public String update(Integer id, LaptopDto laptopDto) {
        Integer studentId = Integer.valueOf(laptopDto.getStudentID());

        if (!laptopRepo.findById(id).isPresent() || !studentRepo.findById(studentId).isPresent()) {
            return "not found";

        }
        Student student=studentRepo.findById(studentId).get();
       Laptop laptop=laptopRepo.findById(id).get();
        laptop.setName(laptopDto.getName());
        laptop.setPrice(laptopDto.getPrice());
        laptop.setStudent(student);
        return "laptop updated";
    }
    public String delete(Integer id){
        if(laptopRepo.findById(id).isPresent()){
            laptopRepo.deleteById(id);
            return "deleted";
        }
        return "not found";
    }
}
