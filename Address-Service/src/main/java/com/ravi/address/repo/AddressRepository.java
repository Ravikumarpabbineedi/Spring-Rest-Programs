package com.ravi.address.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ravi.address.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address,Long>{

}
