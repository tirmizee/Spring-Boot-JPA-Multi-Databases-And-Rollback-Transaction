package com.tirmizee.backend.services;

import com.tirmizee.backend.api.data.OracleDTO;
import com.tirmizee.jpa.oracle.entities.Mockup;

public interface TransactionOracleService {

	Mockup save(OracleDTO dto);
	
}
