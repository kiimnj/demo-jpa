package com.example.demojpa.service;

import com.example.demojpa.domain.Student;
import com.example.demojpa.domain.StudentDto;
import com.example.demojpa.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StudentService {
    final public StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }
    @Transactional(readOnly = true)
    public Optional<Student> getStudent(String studentId) {
        return studentRepository.findById(studentId);
    }
    public String updateStudent(StudentDto studentDto) {
        Optional<Student> findStudent = studentRepository.findById(studentDto.getStudentId());
        Student student = findStudent.get();
        student.setStudentId(studentDto.getStudentId());
        student.setPoint(studentDto.getPoint());
        studentRepository.save(student);
        return "수정 완료";
    }
    public String deleteStudent(String studentId) {
        studentRepository.deleteById(studentId);
        return "삭제 완료";
    }
}
