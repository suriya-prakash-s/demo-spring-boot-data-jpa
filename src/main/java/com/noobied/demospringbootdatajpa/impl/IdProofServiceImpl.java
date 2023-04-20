package com.noobied.demospringbootdatajpa.impl;

import com.noobied.demospringbootdatajpa.entity.IdProof;
import com.noobied.demospringbootdatajpa.repository.IdProofRepository;
import com.noobied.demospringbootdatajpa.service.IdProofService;
import org.springframework.stereotype.Service;

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
}
