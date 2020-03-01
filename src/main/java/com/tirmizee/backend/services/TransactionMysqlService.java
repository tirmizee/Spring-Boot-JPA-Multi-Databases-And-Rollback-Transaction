package com.tirmizee.backend.services;

import com.tirmizee.backend.api.data.MysqlDTO;
import com.tirmizee.jpa.mysql.entities.Mockup;

public interface TransactionMysqlService {
	
	Mockup save(MysqlDTO dto);

}
