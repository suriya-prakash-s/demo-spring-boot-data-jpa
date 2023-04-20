package com.noobied.demospringbootdatajpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "tbl_course")
public class Course {
    @Id
    @SequenceGenerator(
            name = "course_sequence",
            sequenceName = "course_sequence",
            allocationSize = 1
    )
    private long courseId;
    private String title;
    private long credit;
    @ManyToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    @JoinColumn(
            name = "teacher_id",
            referencedColumnName = "teacherId"
    )
    private Teacher teacher;

    @OneToOne(
            mappedBy = "course"
    )
    private CourseMaterial courseMaterial;

    @ManyToMany(
            cascade = CascadeType.ALL
    )
    @JoinTable(
            name = "tbl_student_course_map",
            joinColumns = {
                    @JoinColumn(
                            name = "course_id",
                            referencedColumnName = "courseId"
                    )
            },
            inverseJoinColumns = {
                    @JoinColumn(
                            name = "student_id",
                            referencedColumnName = "studentId"
                    )
            }
    )
    private List<Student> students;

    public void addStudents(Student student) {
        if(students.isEmpty())
            students = new ArrayList<>();
        students.add(student);
    }
}
