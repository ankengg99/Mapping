package com.example.mapping.controller;
import com.example.mapping.dto.LaptopDto;
import com.example.mapping.module.Laptop;
import com.example.mapping.service.LaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/laptop")
public class LaptopController {
    @Autowired
    LaptopService service;

    @PostMapping
    public String add(@RequestBody LaptopDto laptopDto) {
        return service.add(laptopDto);
    }

    @GetMapping("/{id}")
    public List<Laptop> get(@Nullable @PathVariable Integer id) {
        return service.findLaptop(id);
    }

    @PutMapping("/{id}")
    public String update(@PathVariable Integer id,@RequestBody LaptopDto laptopDto){
        return service.update(id,laptopDto);
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id){
        return service.delete(id);
    }
}
