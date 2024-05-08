package com.ravi.studentservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ravi.studentservice.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long>{

}
