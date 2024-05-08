package com.ravi.rest.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ravi.rest.entity.Hospital;

@Repository
public interface HospitalRepo extends JpaRepository<Hospital, Long>{

}
