package com.noobied.demospringbootdatajpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
//Entity class for id proof
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tbl_id_proof",
        uniqueConstraints = {
                @UniqueConstraint(name = "aadhar_id_unique", columnNames = "aadharId")
        })
public class IdProof {
    //Primary key
    @Id
    @SequenceGenerator(
            name = "idproof_sequence",
            sequenceName = "idproof_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "idproof_sequence"
    )
    private Long id;
    private String aadharId;
    //1-1 mapping for Student(FK) and IdProof
    @OneToOne(
            cascade = CascadeType.ALL,
            fetch =  FetchType.LAZY
    )
    @JoinColumn(
            name = "student_id",
            referencedColumnName = "studentId"
    )
    private Student student;
}
