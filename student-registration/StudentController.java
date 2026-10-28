package com.example.student_registration;

import java.util.ArrayList;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController {
	private ArrayList<Student> students = new ArrayList<>();

    @PostMapping
    public String registerStudent(@RequestBody Student student) {
        students.add(student);
        return "Student registered successfully";
    }

    @GetMapping
    public ArrayList<Student> getAllStudents() {
        return students;
    }

}
