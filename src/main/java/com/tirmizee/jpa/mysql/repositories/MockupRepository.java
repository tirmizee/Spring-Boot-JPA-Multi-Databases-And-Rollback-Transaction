package com.tirmizee.jpa.mysql.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tirmizee.jpa.mysql.entities.Mockup;

@Repository("mysqlMockupRepository")
public interface MockupRepository extends JpaRepository<Mockup, Integer> {

	
}
