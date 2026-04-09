package net.tutorial.cicdproject.service;

import net.tutorial.cicdproject.dto.StudentDTO;
import net.tutorial.cicdproject.entity.Student;
import net.tutorial.cicdproject.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public StudentDTO addStudent(StudentDTO studentDTO) {
        // Convert DTO to Entity
        Student student = new Student();
        student.setName(studentDTO.getName());
        student.setAge(studentDTO.getAge());

        // Save to database
        Student savedStudent = studentRepository.save(student);

        // Convert Entity to DTO
        StudentDTO responseDTO = new StudentDTO();
        responseDTO.setName(savedStudent.getName());
        responseDTO.setAge(savedStudent.getAge());

        return responseDTO;
    }
}
