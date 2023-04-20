package com.noobied.demospringbootdatajpa.repository;

import com.noobied.demospringbootdatajpa.entity.IdProof;
import com.noobied.demospringbootdatajpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {
    @Autowired
    private StudentRepository repository;
    @Autowired
    private IdProofRepository idProofRepository;

    @Test
    void testSaveStudent() {

        Student student = Student.builder()
                .firstName("suriya")
                .lastName("s")
                .emailId("srui@info.com")
                .build();

        IdProof proof = IdProof.builder()
                .aadharId("12345678")
                .student(student)
                .build();

        idProofRepository.save(proof);
    }
}