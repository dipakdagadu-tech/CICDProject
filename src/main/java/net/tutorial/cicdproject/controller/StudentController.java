package net.tutorial.cicdproject.controller;

import net.tutorial.cicdproject.dto.StudentDTO;
import net.tutorial.cicdproject.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/add")
    public ResponseEntity<StudentDTO> addStudent(@RequestBody StudentDTO studentDTO) {
        StudentDTO savedStudent = studentService.addStudent(studentDTO);
        return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
    }
}