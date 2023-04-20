package com.noobied.demospringbootdatajpa.controller;

import com.noobied.demospringbootdatajpa.dto.StudentDtoHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/idproof")
public class IdProofController {
    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateIdProofDetails(@PathVariable("id") int id, @RequestBody String aadharid) {
        ResponseEntity<Object> updated_successfully = StudentDtoHandler.studentDtoHandler(
                "Updated Successfully",
                Optional.empty(),
                HttpStatus.OK
        );
        return  updated_successfully;
    }
}
