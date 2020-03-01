package com.tirmizee.backend.services;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tirmizee.backend.api.data.MariaDTO;
import com.tirmizee.core.config.BeanIds;
import com.tirmizee.core.exception.RollbackException;
import com.tirmizee.jpa.maria.entities.Mockup;
import com.tirmizee.jpa.maria.repositories.MockupRepository;

@Service
public class TransactionMariadbServiceImpl implements TransactionMariadbService {

	@Autowired
	@Qualifier("mariaMockupRepository")
	private MockupRepository mockupRepository;
	
	@Transactional(value = BeanIds.TRANSACTION_MANAGER_MARIA)
	@Override
	public Mockup save(MariaDTO dto) {
		Mockup persist = new Mockup();
		persist.setId(new Random().nextInt());
		persist.setMockupName(dto.getMockupName());
		persist.setMockupDesc(dto.getMockupDesc());
		persist = mockupRepository.save(persist);
		if ("rollback".equalsIgnoreCase(persist.getMockupName())) {
			throw new RollbackException("rollback mariadb");
		}
		return persist;
	}

}
