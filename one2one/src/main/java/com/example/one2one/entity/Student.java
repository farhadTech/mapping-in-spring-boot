package com.example.one2one.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long studentId;

    private String name;

    private Long mobile;

    public Student(String name, Long mobile) {
        this.name = name;
        this.mobile = mobile;
    }
}
