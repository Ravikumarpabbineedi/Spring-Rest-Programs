package com.ravi.studentservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ravi.studentservice.entity.Student;
import com.ravi.studentservice.model.StudentDetails;
import com.ravi.studentservice.model.StudentResponse;
import com.ravi.studentservice.service.StudentService;

@RestController
@RequestMapping("/api/student")
public class StudentController {

	@Autowired
	StudentService studentService;
	
	@PostMapping("/savestudent")
	public Student createStudent(@RequestBody StudentDetails details) {
		return studentService.saveStudent(details);
	}
	
	@GetMapping("/getById/{id}")
	public StudentResponse getStudentWithAddress(@PathVariable Long id) {
		return studentService.findStudentWithAddress(id);
	}
}
