package com.school.ms.dto;

import java.time.LocalDate;

public class StudentDTO {
    private Long id;
    private String name;
    private String fathersName;
    private String email;
    private LocalDate dob;

    public StudentDTO() {
    }

    public StudentDTO(Long id, String name, String email, LocalDate dob,String fathersName) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.fathersName=fathersName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFathersName() {
        return fathersName;
    }

    public void setFathersName(String fathersName) {
        this.fathersName = fathersName;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "StudentDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", fathersName='" + fathersName + '\'' +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                '}';
    }
}
