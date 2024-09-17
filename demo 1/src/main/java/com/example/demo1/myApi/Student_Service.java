package com.example.demo1.myApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Student_Service {
    @Autowired
 private Student_Repo studentService;
 public Student save(Student sampleDb)
 {
     return studentService.save(sampleDb);
 }

    public List<Student> stu() {
     return stu();
    }
}

