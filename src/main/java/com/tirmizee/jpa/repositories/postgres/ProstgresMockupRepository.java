package com.tirmizee.jpa.repositories.postgres;


import org.springframework.data.jpa.repository.JpaRepository;

import com.tirmizee.jpa.entities.postgres.Mockup;

public interface ProstgresMockupRepository extends JpaRepository<Mockup, Integer> {

}
