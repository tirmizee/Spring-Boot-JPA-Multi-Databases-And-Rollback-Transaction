package com.tirmizee.backend.services;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tirmizee.backend.api.data.PostgresDTO;
import com.tirmizee.core.config.BeanIds;
import com.tirmizee.core.exception.RollbackException;
import com.tirmizee.jpa.postgres.entities.Mockup;
import com.tirmizee.jpa.postgres.repositories.MockupRepository;

@Service
public class TransactionPostgresServiceImpl implements TransactionPostgresService {

	@Autowired
	@Qualifier("postgresMockupRepository")
	private MockupRepository mockupRepository;
	
	@Transactional(value = BeanIds.TRANSACTION_MANAGER_POSTGRES)
	@Override
	public Mockup save(PostgresDTO dto) {
		Mockup persist = new Mockup();
		persist.setId(new Random().nextInt());
		persist.setMockupName(dto.getMockupName());
		persist.setMockupDesc(dto.getMockupDesc());
		persist = mockupRepository.save(persist);
		if ("rollback".equalsIgnoreCase(persist.getMockupName())) {
			throw new RollbackException("rollback postgres");
		}
		return persist;
	}

}
