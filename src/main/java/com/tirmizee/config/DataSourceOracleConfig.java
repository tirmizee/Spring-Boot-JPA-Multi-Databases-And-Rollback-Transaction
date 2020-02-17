package com.tirmizee.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

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

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
	basePackages = "com.tirmizee.repositories.oracle",
	entityManagerFactoryRef = "oracleEntityManager",
	transactionManagerRef = "oracleTransactionManager"
)
@PropertySource("classpath:db_oracle.properties")
public class DataSourceOracleConfig {
	
	@Bean
	@ConfigurationProperties("spring.datasource")
    public DataSource oracleDataSource() {
        return DataSourceBuilder.create().build();
    }
	
	@Bean
	@ConfigurationProperties("spring.jpa.properties")
    public Properties oracleProperties() {
        return new Properties();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean oracleEntityManagerFactory(DataSource oracleDataSource, Properties oracleProperties) {
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setDataSource(oracleDataSource);
        factory.setPackagesToScan(new String[]{"com.tirmizee.entities.oracle"});
        factory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        factory.setJpaProperties(oracleProperties);
        return factory;
    }
	
    @Bean
    public PlatformTransactionManager securityTransactionManager(LocalContainerEntityManagerFactoryBean oracleEntityManagerFactory){
        EntityManagerFactory factory = oracleEntityManagerFactory.getObject();
        return new JpaTransactionManager(factory);
    }
    
}
