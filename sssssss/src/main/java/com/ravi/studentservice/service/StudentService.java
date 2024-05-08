package com.ravi.studentservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ravi.studentservice.entity.Student;
import com.ravi.studentservice.model.StudentDetails;
import com.ravi.studentservice.model.StudentResponse;
import com.ravi.studentservice.repo.StudentRepository;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;
	
	public Student saveStudent(StudentDetails details) {
		 Student student = new Student();
		 
		 student.setFirstName(details.getFirstName());
		 student.setLastName(details.getLastName());
		 student.setEmail(details.getEmail());
		 
		 return studentRepository.save(student);
	}

	public StudentResponse findStudentWithAddress(long id) {
		
		Student student = studentRepository.findById(id).get();
		
		StudentResponse studentResponse = new StudentResponse();
		
		studentResponse.setId(student.getId());
		studentResponse.setFirstName(student.getFirstName());
		studentResponse.setLastName(student.getLastName());
		studentResponse.setEmail(student.getEmail());
		
		
	}

}
