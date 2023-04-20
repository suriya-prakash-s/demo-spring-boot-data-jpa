package com.noobied.demospringbootdatajpa.dto;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;

public class StudentDtoHandler {

    public static ResponseEntity<Object> studentDtoHandler(String msg, Object data, HttpStatus status) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("message", msg);
        map.put("data", data);
        map.put("status", status);
        return new ResponseEntity<>(map, status);
    }
}
