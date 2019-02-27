package com.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class Teacher {

    public void sayTeacher() {
        System.out.println("teacher hello");
    }
}
