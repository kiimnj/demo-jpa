package com.example.demojpa.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Id;

public class StudentDto {
    @Id
    @Column(name="student_id")
    private String studentId;
    @Column(name="point")
    private float point;

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public float getPoint() {
        return point;
    }

    public void setPoint(float point) {
        this.point = point;
    }
}
