package com.example.mapping.module;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="laptop")
public class Laptop {
    @Id
    private String ID;
    private String name;
    private String brand;
    private Integer price;

    @OneToOne
    private Student student;
}
