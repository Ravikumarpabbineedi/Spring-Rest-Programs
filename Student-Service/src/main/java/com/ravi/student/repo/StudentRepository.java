package com.ravi.student.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ravi.student.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long>{

}
