package com.tirmizee.core.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.transaction.ChainedTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * @author Pratya Yeekhaday
 *
 */
@Configuration
public class TransactionManagerConfig {
	
	@Bean(name = BeanIds.TRANSACTION_MANAGER_CHAINED)
    public ChainedTransactionManager transactionManager (
        @Qualifier(BeanIds.TRANSACTION_MANAGER_MYSQL) PlatformTransactionManager mysqlTx,
        @Qualifier(BeanIds.TRANSACTION_MANAGER_MARIA) PlatformTransactionManager mariaTx,
        @Qualifier(BeanIds.TRANSACTION_MANAGER_POSTGRES) PlatformTransactionManager postgresTx,
        @Qualifier(BeanIds.TRANSACTION_MANAGER_ORACLE) PlatformTransactionManager oracleTx) {
        return new ChainedTransactionManager(mysqlTx, mariaTx, postgresTx, oracleTx);
    }

}
