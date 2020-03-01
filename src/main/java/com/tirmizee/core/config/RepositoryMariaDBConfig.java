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
	basePackages = "com.tirmizee.jpa.maria.repositories",
	entityManagerFactoryRef = BeanIds.ENTITY_MANAGER_FACTORY_MARIA,
	transactionManagerRef = BeanIds.TRANSACTION_MANAGER_MARIA
)
@PropertySource("classpath:db_maria.properties")
public class RepositoryMariaDBConfig {
	
    @Bean(name = BeanIds.DATASOURCE_MARIA)
    @ConfigurationProperties("spring.datasource.maria.hikari")
    public DataSource mariaDataSource() {
        return new HikariDataSource();
    }
    
    @Bean(name = BeanIds.PROPERTIES_MARIA)
    @ConfigurationProperties("spring.jpa.properties.maria")
    public Properties mariaProperties() {
        return new Properties();
    }
    
    @Bean(name = BeanIds.ENTITY_MANAGER_FACTORY_MARIA)
    public LocalContainerEntityManagerFactoryBean mariaEntityManagerFactory(
    		@Qualifier(BeanIds.DATASOURCE_MARIA) DataSource dataSource, 
    		@Qualifier(BeanIds.PROPERTIES_MARIA) Properties properties) {
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setDataSource(dataSource);
        factory.setPackagesToScan(new String[]{"com.tirmizee.jpa.maria.entities"});
        factory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        factory.setJpaProperties(properties);
        return factory;
    }
    
    @Bean(name = BeanIds.TRANSACTION_MANAGER_MARIA)
    public PlatformTransactionManager mariaTransactionManager(
    		@Qualifier(BeanIds.ENTITY_MANAGER_FACTORY_MARIA) LocalContainerEntityManagerFactoryBean entityManagerFactory){
    	return new JpaTransactionManager(entityManagerFactory.getObject());
    }

}
