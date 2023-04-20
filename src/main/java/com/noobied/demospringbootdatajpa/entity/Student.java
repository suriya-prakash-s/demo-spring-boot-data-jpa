package com.noobied.demospringbootdatajpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//Student Entity class
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(
        name = "tbl_student",
        uniqueConstraints = {
                @UniqueConstraint(name = "email_address_unique", columnNames = "email_address")
        }
)
public class Student {
    @Id
    @SequenceGenerator(
            name = "student_id_sequence",
            sequenceName = "student_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_id_sequence"
    )
    //primary key
    private Long studentId;

    private String firstName;

    private String lastName;

    @Column(name = "email_address", nullable = false)
    private String emailId;

    @Transient
    private IdProof idProof;


}
