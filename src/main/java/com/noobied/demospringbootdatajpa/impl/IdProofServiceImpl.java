package com.noobied.demospringbootdatajpa.impl;

import com.noobied.demospringbootdatajpa.entity.IdProof;
import com.noobied.demospringbootdatajpa.exception.IdProofNotFoundException;
import com.noobied.demospringbootdatajpa.repository.IdProofRepository;
import com.noobied.demospringbootdatajpa.service.IdProofService;
import org.hibernate.sql.Update;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class IdProofServiceImpl implements IdProofService {

    private IdProofRepository idProofRepository;

    public IdProofServiceImpl(IdProofRepository idProofRepository) {
        this.idProofRepository = idProofRepository;
    }

    @Override
    public IdProof saveIdProof(IdProof proof) {
        IdProof idProof = idProofRepository.save(proof);
        return idProof;
    }

    @Override
    public String updateIdProofDetails(String newId, int id) {

        Optional<IdProof> byStudentId = idProofRepository.findByStudentId(id);
        if(byStudentId.isPresent()){
            idProofRepository.updateAadharIdDetail(newId, id);
            return "Updated Successfully";
        } else  {
            throw new IdProofNotFoundException("Requested ID not found");
        }

    }
}
