package com.tirmizee;

import java.util.Random;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootJpaMultiDatabaseAndTransactionApplication implements CommandLineRunner {

	public static final Logger logger = LoggerFactory.getLogger(SpringBootJpaMultiDatabaseAndTransactionApplication.class);
	
	@Autowired
    private ApplicationContext appContext;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaMultiDatabaseAndTransactionApplication.class, args);
	}

	@Override
	public void run(String...args) throws Exception {
		
		logger.info("Initializing complete");
		
		com.tirmizee.jpa.maria.repositories.MockupRepository mariaRepository = 
			appContext.getBean("mariaMockupRepository", com.tirmizee.jpa.maria.repositories.MockupRepository.class);
		com.tirmizee.jpa.mysql.repositories.MockupRepository mysqlRepository = 
			appContext.getBean("mysqlMockupRepository", com.tirmizee.jpa.mysql.repositories.MockupRepository.class);
		com.tirmizee.jpa.oracle.repositories.MockupRepository oracleRepository = 
			appContext.getBean("oracleMockupRepository", com.tirmizee.jpa.oracle.repositories.MockupRepository.class);
		com.tirmizee.jpa.postgres.repositories.MockupRepository postgresRepository = 
			appContext.getBean("postgresMockupRepository", com.tirmizee.jpa.postgres.repositories.MockupRepository.class);
		
//		com.tirmizee.jpa.maria.entities.Mockup mariaEntity = 
//			new com.tirmizee.jpa.maria.entities.Mockup(new Random().nextInt(),UUID.randomUUID().toString(),UUID.randomUUID().toString());
//		com.tirmizee.jpa.mysql.entities.Mockup mysqlEntity = 
//			new com.tirmizee.jpa.mysql.entities.Mockup(new Random().nextInt(),UUID.randomUUID().toString(),UUID.randomUUID().toString());
//		com.tirmizee.jpa.oracle.entities.Mockup oracleEntity = 
//			new com.tirmizee.jpa.oracle.entities.Mockup(null, UUID.randomUUID().toString(),UUID.randomUUID().toString());
//		com.tirmizee.jpa.postgres.entities.Mockup postgresEntity = 
//			new com.tirmizee.jpa.postgres.entities.Mockup(new Random().nextInt(),UUID.randomUUID().toString(),UUID.randomUUID().toString());
		
//		mariaRepository.save(mariaEntity);
//		mysqlRepository.save(mysqlEntity);
//		oracleRepository.save(oracleEntity);
//		postgresRepository.save(postgresEntity);
		
		mariaRepository.findAll().forEach(o -> System.out.println(o));
		mysqlRepository.findAll().forEach(o -> System.out.println(o));
		oracleRepository.findAll().forEach(o -> System.out.println(o));
		postgresRepository.findAll().forEach(o -> System.out.println(o));
		
	}

}
