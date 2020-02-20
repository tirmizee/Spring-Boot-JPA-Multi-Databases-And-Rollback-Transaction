package com.tirmizee.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Pratya Yeekhaday
 *
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
	basePackages = "com.tirmizee.jpa.repositories.oracle",
	entityManagerFactoryRef = "oracleEntityManagerFactory",
	transactionManagerRef = "oracleTransactionManager"
)
//@ConditionalOnProperty(
//    value="enabled", 
//    havingValue = "true", 
//    matchIfMissing = true)
@PropertySource("classpath:db_oracle.properties")
public class RepositoryOracleConfig {
	
    @Bean(name = "oracleDataSource")
    @ConfigurationProperties("spring.datasource")
    public DataSource oracleDataSource() {
        return DataSourceBuilder.create().build();
    }
	
    @Bean(name = "oracleProperties")
    @ConfigurationProperties("spring.jpa.properties")
    public Properties oracleProperties() {
        return new Properties();
    }
    
    @Bean(name = "oracleEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean oracleEntityManagerFactory(DataSource oracleDataSource, Properties oracleProperties) {
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setDataSource(oracleDataSource);
        factory.setPersistenceUnitName("oracle-persistence");
        factory.setPackagesToScan(new String[]{"com.tirmizee.jpa.entities.oracle"});
        factory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        factory.setJpaProperties(oracleProperties);
        return factory;
    }
	
    @Bean(name = "oracleTransactionManager")
    public PlatformTransactionManager oracleTransactionManager(LocalContainerEntityManagerFactoryBean oracleEntityManagerFactory){
    	return new JpaTransactionManager(oracleEntityManagerFactory.getObject());
    }
    
}
