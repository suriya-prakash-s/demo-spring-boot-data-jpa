package com.noobied.demospringbootdatajpa.repository;

import com.noobied.demospringbootdatajpa.entity.IdProof;
import com.noobied.demospringbootdatajpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {
    @Autowired
    private StudentRepository repository;
    @Autowired
    private IdProofRepository idProofRepository;

    @Test
    void testSaveStudent() {

        Optional<IdProof> byStudentId = idProofRepository.findByStudentId(3);
        IdProof proof = byStudentId.get();
        System.out.println(proof.getAadharId());
    }
}