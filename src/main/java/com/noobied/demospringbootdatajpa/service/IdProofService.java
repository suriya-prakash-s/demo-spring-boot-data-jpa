package com.noobied.demospringbootdatajpa.service;

import com.noobied.demospringbootdatajpa.entity.IdProof;
import org.springframework.stereotype.Service;


public interface IdProofService {
    IdProof saveIdProof(IdProof proof);

    String updateIdProofDetails(String newId, int id);
}
