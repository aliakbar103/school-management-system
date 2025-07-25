package com.school.ms.entities;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "ENROLLMENTS")
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "STUDENT_ID") // FK to Student table
    private Student student;

    @ManyToOne
    @JoinColumn(name = "COURSE_ID") // FK to Course table
    private Course course;

    @Column(name = "GRADE")
    private String grade; // E.g., A, B, C, etc.

    @Column(name = "MARKS")
    private Double marks; // E.g., 90, 70, 50, etc.

    @Column(name = "COMPLETED")
    private boolean completed;

    @Column(name = "ENROLLMENT_DATE")
    private LocalDate enrollmentDate;

    public Enrollment() {
    }

    public Enrollment(Long id, Student student, Course course, String grade, boolean completed,Double marks,LocalDate enrollmentDate) {
        this.id = id;
        this.student = student;
        this.course = course;
        this.grade = grade;
        this.completed = completed;
        this.marks=marks;
        this.enrollmentDate=enrollmentDate;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public Double getMarks() {
        return marks;
    }

    public void setMarks(Double marks) {
        this.marks = marks;
    }

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(LocalDate enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }
}

