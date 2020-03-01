package com.tirmizee.jpa.maria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tirmizee.jpa.maria.entities.Mockup;

@Repository("mariaMockupRepository")
public interface MockupRepository extends JpaRepository<Mockup, Integer> {

	
}
