package com.tirmizee.backend.services;

import java.util.Random;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tirmizee.core.config.BeanIds;
import com.tirmizee.core.exception.RollbackException;

@Service
public class TransactionChainedServiceImpl implements TransactionChainedService {

	private com.tirmizee.jpa.mysql.repositories.MockupRepository mysqlMockupRepository;
	private com.tirmizee.jpa.maria.repositories.MockupRepository mariaMockupRepository;
	private com.tirmizee.jpa.oracle.repositories.MockupRepository oracleMockupRepository;
	private com.tirmizee.jpa.postgres.repositories.MockupRepository postgresMockupRepository;
	
	public TransactionChainedServiceImpl(
		com.tirmizee.jpa.mysql.repositories.MockupRepository mysqlMockupRepository,
		com.tirmizee.jpa.maria.repositories.MockupRepository mariaMockupRepository,
		com.tirmizee.jpa.oracle.repositories.MockupRepository oracleMockupRepository,
		com.tirmizee.jpa.postgres.repositories.MockupRepository postgresMockupRepository) {
		this.mysqlMockupRepository = mysqlMockupRepository;
		this.mariaMockupRepository = mariaMockupRepository;
		this.oracleMockupRepository = oracleMockupRepository;
		this.postgresMockupRepository = postgresMockupRepository;
	}
	
	@Transactional(value = BeanIds.TRANSACTION_MANAGER_CHAINED)
	@Override
	public void save(String name) {
		
		//persist oracle
		com.tirmizee.jpa.oracle.entities.Mockup oracle = new com.tirmizee.jpa.oracle.entities.Mockup();
		oracle.setId(new Random().nextInt());
		oracle.setMockupName(name);
		oracle = oracleMockupRepository.save(oracle);
		
		//persist maria
		com.tirmizee.jpa.maria.entities.Mockup maria = new com.tirmizee.jpa.maria.entities.Mockup();
		maria.setId(new Random().nextInt());
		maria.setMockupName(name);
		maria = mariaMockupRepository.save(maria);
		
		//persist mysql
		com.tirmizee.jpa.mysql.entities.Mockup mysql = new com.tirmizee.jpa.mysql.entities.Mockup();
		mysql.setId(new Random().nextInt());
		mysql.setMockupName(name);
		mysql = mysqlMockupRepository.save(mysql);
		
		//persist postgres
		com.tirmizee.jpa.postgres.entities.Mockup postgres = new com.tirmizee.jpa.postgres.entities.Mockup();
		postgres.setId(new Random().nextInt());
		postgres.setMockupName(name);
		postgres = postgresMockupRepository.save(postgres);
		
		if ("rollback".equalsIgnoreCase(name)) {
			throw new RollbackException("rollback all databases");
		}
		
	}

}
