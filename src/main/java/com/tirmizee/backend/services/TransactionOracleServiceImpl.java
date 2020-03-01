package com.tirmizee.backend.services;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tirmizee.backend.api.data.OracleDTO;
import com.tirmizee.core.config.BeanIds;
import com.tirmizee.core.exception.RollbackException;
import com.tirmizee.jpa.oracle.entities.Mockup;
import com.tirmizee.jpa.oracle.repositories.MockupRepository;

@Service
public class TransactionOracleServiceImpl implements TransactionOracleService {

	@Autowired
	@Qualifier("oracleMockupRepository")
	private MockupRepository mockupRepository;
	
	@Transactional(value = BeanIds.TRANSACTION_MANAGER_ORACLE)
	@Override
	public Mockup save(OracleDTO dto) {
		Mockup persist = new Mockup();
		persist.setId(new Random().nextInt());
		persist.setMockupName(dto.getMockupName());
		persist.setMockupDesc(dto.getMockupDesc());
		persist = mockupRepository.save(persist);
		if ("rollback".equalsIgnoreCase(persist.getMockupName())) {
			throw new RollbackException("rollback oracle");
		}
		return persist;
	}

}
