package com.tirmizee.core.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariDataSource;

/**
 * @author Pratya Yeekhaday
 *
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
	basePackages = "com.tirmizee.jpa.oracle.repositories",
	entityManagerFactoryRef = BeanIds.ENTITY_MANAGER_FACTORY_ORACLE,
	transactionManagerRef = BeanIds.TRANSACTION_MANAGER_ORACLE
)
@PropertySource("classpath:db_oracle.properties")
public class RepositoryOracleConfig {
	
    @Bean(name = BeanIds.DATASOURCE_ORACLE)
    @ConfigurationProperties("spring.datasource.oracle.hikari")
    public DataSource oracleDataSource() {
        return new HikariDataSource();
    }
	
    @Bean(name = BeanIds.PROPERTIES_ORACLE)
    @ConfigurationProperties("spring.jpa.properties.oracle")
    public Properties oracleProperties() {
        return new Properties();
    }
    
    @Bean(name = BeanIds.ENTITY_MANAGER_FACTORY_ORACLE)
    public LocalContainerEntityManagerFactoryBean oracleEntityManagerFactory(
    		@Qualifier(BeanIds.DATASOURCE_ORACLE) DataSource dataSource, 
    		@Qualifier(BeanIds.PROPERTIES_ORACLE) Properties properties) {
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setDataSource(dataSource);
        factory.setPackagesToScan(new String[]{"com.tirmizee.jpa.oracle.entities"});
        factory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        factory.setJpaProperties(properties);
        return factory;
    }
    
    @Bean(name = BeanIds.TRANSACTION_MANAGER_ORACLE)
    public PlatformTransactionManager oracleTransactionManager(
    		@Qualifier(BeanIds.ENTITY_MANAGER_FACTORY_ORACLE) LocalContainerEntityManagerFactoryBean entityManagerFactory){
    	return new JpaTransactionManager(entityManagerFactory.getObject());
    }
    
}
