package com.example.demojpa.controller;

import com.example.demojpa.domain.Student;
import com.example.demojpa.domain.StudentDto;
import com.example.demojpa.repository.StudentRepository;
import com.example.demojpa.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public Student addStudent(Student student) {
        return studentService.addStudent(student);
    }
    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }
    @GetMapping("/{studentId}")
    public Student getStudent(@PathVariable String studentId) {
        return studentService.getStudent(studentId).get(); //.get() - Optional이라서
    }
    @PutMapping("/{studentId}")
    public String updateStudent(@PathVariable String studentId, //studentId 안쓰임
                                @RequestBody StudentDto studentDto) {
        return studentService.updateStudent(studentDto);
    }
    @DeleteMapping("/{studentId}")
    public String deleteStudent(@PathVariable String studentId) {
        return studentService.deleteStudent(studentId);
    }
}
