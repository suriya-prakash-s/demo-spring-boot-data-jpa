package com.noobied.demospringbootdatajpa.repository;

import com.noobied.demospringbootdatajpa.entity.IdProof;
import com.noobied.demospringbootdatajpa.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IdProofRepository extends JpaRepository<IdProof, Long> {
    @Modifying
    @Transactional
    @Query(
            value = "UPDATE tbl_id_proof SET aadhar_id = ?1 WHERE student_id = ?2 ",
            nativeQuery = true
    )
    void updateAadharIdDetail(String aadharId, int id);

    @Query(
            value = "SELECT * FROM tbl_id_proof where student_id = ?1",
            nativeQuery = true
    )
    Optional<IdProof> findByStudentId(int id);
}
