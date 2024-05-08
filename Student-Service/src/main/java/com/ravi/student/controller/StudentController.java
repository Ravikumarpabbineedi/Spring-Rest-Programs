package com.ravi.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ravi.student.entity.Student;
import com.ravi.student.model.StudentDetails;
import com.ravi.student.model.StudentResponse;
import com.ravi.student.service.StudentService;

@RestController
@RequestMapping("/api/student")
public class StudentController {

	@Autowired
	StudentService studentService;
	
	@PostMapping("/save")
	public Student createStudent(@RequestBody StudentDetails studentDetails) {
		return studentService.saveStudent(studentDetails);
	}
	
	@GetMapping("/getbyid/{id}")
	public StudentResponse getStudent(@PathVariable Long id) {
		return studentService.getStudentById(id);
	}
}
