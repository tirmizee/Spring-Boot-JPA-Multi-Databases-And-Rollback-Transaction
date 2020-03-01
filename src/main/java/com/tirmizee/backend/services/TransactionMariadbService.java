package com.tirmizee.backend.services;

import com.tirmizee.backend.api.data.MariaDTO;
import com.tirmizee.jpa.maria.entities.Mockup;

public interface TransactionMariadbService {
	
	Mockup save(MariaDTO dto);

}
