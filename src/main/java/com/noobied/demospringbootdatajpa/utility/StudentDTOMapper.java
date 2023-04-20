package com.noobied.demospringbootdatajpa.utility;

import com.noobied.demospringbootdatajpa.dto.StudentDTO;
import com.noobied.demospringbootdatajpa.entity.Student;

public class StudentDTOMapper {

    public static StudentDTO DtoBuilder(Student student){
        return new StudentDTO(
                student.getStudentId(),
                student.getFirstName(),
                student.getLastName(),
                student.getEmailId());
    }
}
