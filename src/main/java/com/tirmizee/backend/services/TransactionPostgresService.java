package com.tirmizee.backend.services;

import com.tirmizee.backend.api.data.PostgresDTO;
import com.tirmizee.jpa.postgres.entities.Mockup;

public interface TransactionPostgresService {
	
	Mockup save(PostgresDTO dto);

}
