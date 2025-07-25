package com.school.ms.dto;

import java.time.LocalDate;

public class EnrollmentDTO {
    private Long id;
    private Long studentId;
    private Long courseId;
    private LocalDate enrollmentDate;
    private String grade;
    private Double marks;
    private Boolean preRequisiteDone;

    public EnrollmentDTO() {
    }

    public EnrollmentDTO(Long id, Long studentId, Long courseId, LocalDate enrollmentDate, String grade,Double marks,Boolean preRequisiteDone) {
        this.id = id;
        this.studentId = studentId;
        this.courseId = courseId;
        this.enrollmentDate = enrollmentDate;
        this.grade = grade;
        this.marks=marks;
        this.preRequisiteDone = preRequisiteDone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
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

    public Boolean getPreRequisiteDone() {
        return preRequisiteDone;
    }

    public void setPreRequisiteDone(Boolean preRequisiteDone) {
        this.preRequisiteDone = preRequisiteDone;
    }

    @Override
    public String toString() {
        return "EnrollmentDTO{" +
                "id=" + id +
                ", studentId=" + studentId +
                ", courseId=" + courseId +
                ", enrollmentDate=" + enrollmentDate +
                ", grade='" + grade + '\'' +
                '}';
    }

}