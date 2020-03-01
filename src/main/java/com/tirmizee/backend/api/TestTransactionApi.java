package com.tirmizee.backend.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tirmizee.backend.api.data.MariaDTO;
import com.tirmizee.backend.api.data.MysqlDTO;
import com.tirmizee.backend.api.data.OracleDTO;
import com.tirmizee.backend.api.data.PostgresDTO;
import com.tirmizee.backend.services.TransactionChainedService;
import com.tirmizee.backend.services.TransactionMariadbService;
import com.tirmizee.backend.services.TransactionMysqlService;
import com.tirmizee.backend.services.TransactionOracleService;
import com.tirmizee.backend.services.TransactionPostgresService;


/**
 * @author Pratya Yeekhaday
 *
 */
@RestController
@RequestMapping(path = "/transaction")
public class TestTransactionApi {
	
	@Autowired
	private TransactionMysqlService transactionMysqlService;
	
	@Autowired
	private TransactionOracleService transactionOracleService;
	
	@Autowired
	private TransactionMariadbService transactionMariadbService;
	
	@Autowired
	private TransactionPostgresService transactionPostgresService;
	
	@Autowired
	private TransactionChainedService transactionChainedService;
	
	@PostMapping(path = "/mysql")
	public com.tirmizee.jpa.mysql.entities.Mockup mysql(@RequestBody MysqlDTO dto){
		return transactionMysqlService.save(dto);
	}
	
	@PostMapping(path = "/oracle")
	public com.tirmizee.jpa.oracle.entities.Mockup mysql(@RequestBody OracleDTO dto){
		return transactionOracleService.save(dto);
	}
	
	@PostMapping(path = "/maria")
	public com.tirmizee.jpa.maria.entities.Mockup mysql(@RequestBody MariaDTO dto){
		return transactionMariadbService.save(dto);
	}
	
	@PostMapping(path = "/postgres")
	public com.tirmizee.jpa.postgres.entities.Mockup mysql(@RequestBody PostgresDTO dto){
		return transactionPostgresService.save(dto);
	}
	
	@PostMapping(path = "/alldatabase")
	public String all(@RequestBody PostgresDTO dto){
		transactionChainedService.save(dto.getMockupName());
		return "success transaction";
	}
	
}
