package com.noobied.demospringbootdatajpa.repository;

import com.noobied.demospringbootdatajpa.entity.IdProof;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IdProofRepository extends JpaRepository<IdProof, Long> {
}
