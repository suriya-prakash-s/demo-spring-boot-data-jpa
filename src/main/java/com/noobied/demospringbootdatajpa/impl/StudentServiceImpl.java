package com.noobied.demospringbootdatajpa.impl;

import com.noobied.demospringbootdatajpa.dto.StudentDTO;
import com.noobied.demospringbootdatajpa.entity.Student;
import com.noobied.demospringbootdatajpa.exception.StudentNotFoundException;
import com.noobied.demospringbootdatajpa.repository.StudentRepository;
import com.noobied.demospringbootdatajpa.service.StudentService;
import com.noobied.demospringbootdatajpa.utility.StudentDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    private StudentRepository studentRepository;
    
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public StudentDTO saveStudent(Student s) {
        Student saved_student = studentRepository.save(s);
        StudentDTO studentDTO = StudentDTOMapper.DtoBuilder(saved_student);
        return studentDTO;
    }

    @Override
    public StudentDTO findStudentById(Long id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if(optionalStudent.isPresent()){
            StudentDTO studentDTO = StudentDTOMapper.DtoBuilder(optionalStudent.get());
            return studentDTO;
        } else {
            throw new StudentNotFoundException("Requested student not found");
        }
    }
}
