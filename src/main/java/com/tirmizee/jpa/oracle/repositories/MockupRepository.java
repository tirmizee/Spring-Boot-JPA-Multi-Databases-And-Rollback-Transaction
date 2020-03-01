package com.tirmizee.jpa.oracle.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tirmizee.jpa.oracle.entities.Mockup;

@Repository("oracleMockupRepository")
public interface MockupRepository extends JpaRepository<Mockup, Integer> {

}
