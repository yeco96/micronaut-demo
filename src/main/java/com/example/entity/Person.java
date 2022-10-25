package com.example.entity;


import lombok.Data;

import javax.validation.constraints.Size;

@Data
public class Person {
    @Size(min = 2, message = "The name should have more than 2 characters")
    private String name;
    private String lastName;
    private int age;
}
