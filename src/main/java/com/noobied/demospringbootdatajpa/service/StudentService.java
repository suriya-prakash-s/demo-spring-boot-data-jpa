package com.noobied.demospringbootdatajpa.service;

import com.noobied.demospringbootdatajpa.dto.StudentDTO;
import com.noobied.demospringbootdatajpa.entity.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

public interface StudentService {
    //abstract method to save student obj
    StudentDTO saveStudent(Student s);

    StudentDTO findStudentById(Long id);
}
