package com.noobied.demospringbootdatajpa.controller;

import com.noobied.demospringbootdatajpa.dto.StudentDTO;
import com.noobied.demospringbootdatajpa.dto.StudentDtoHandler;
import com.noobied.demospringbootdatajpa.entity.IdProof;
import com.noobied.demospringbootdatajpa.entity.Student;
import com.noobied.demospringbootdatajpa.service.IdProofService;
import com.noobied.demospringbootdatajpa.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/students")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private IdProofService idProofService;

    @PostMapping("/save")
    public ResponseEntity<Object> saveStudentDetails(@RequestBody Student student) {
        IdProof proof = IdProof.builder()
                .aadharId(student.getIdProof().getAadharId())
                .student(student)
                .build();

        IdProof savedIdProof = idProofService.saveIdProof(proof);

        Long studentId = savedIdProof.getStudent().getStudentId();

        StudentDTO studentById = studentService.findStudentById(studentId);

        ResponseEntity<Object> saved_successfully = StudentDtoHandler.studentDtoHandler(
                "Saved Successfully",
                studentById,
                HttpStatus.CREATED);

        return saved_successfully;
    }
}
