package com.tirmizee.jpa.postgres.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tirmizee.jpa.postgres.entities.Mockup;

@Repository("postgresMockupRepository")
public interface MockupRepository extends JpaRepository<Mockup, Integer> {

}
