package com.school.ms.dto;

import java.time.LocalDate;

public class EnrollmentResponseDTO {
    private Long id;
    private StudentDTO student;
    private CourseDTO course;
    private LocalDate enrollmentDate;
    private String grade;
    private Double marks;

    public EnrollmentResponseDTO() {
    }

    public EnrollmentResponseDTO(Long id, StudentDTO student, CourseDTO course, LocalDate enrollmentDate, String grade, Double marks) {
        this.id = id;
        this.student = student;
        this.course = course;
        this.enrollmentDate = enrollmentDate;
        this.grade = grade;
        this.marks = marks;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StudentDTO getStudent() {
        return student;
    }

    public void setStudent(StudentDTO student) {
        this.student = student;
    }

    public CourseDTO getCourse() {
        return course;
    }

    public void setCourse(CourseDTO course) {
        this.course = course;
    }

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(LocalDate enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Double getMarks() {
        return marks;
    }

    public void setMarks(Double marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "EnrollmentResponseDTO{" +
                "id=" + id +
                ", student=" + student +
                ", course=" + course +
                ", enrollmentDate=" + enrollmentDate +
                ", grade='" + grade + '\'' +
                ", marks=" + marks +
                '}';
    }
}
