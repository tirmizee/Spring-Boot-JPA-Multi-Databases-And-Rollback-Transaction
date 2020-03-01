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
	basePackages = "com.tirmizee.jpa.mysql.repositories",
	entityManagerFactoryRef = BeanIds.ENTITY_MANAGER_FACTORY_MYSQL,
	transactionManagerRef = BeanIds.TRANSACTION_MANAGER_MYSQL
)
@PropertySource("classpath:db_mysql.properties")
public class RepositoryMysqlConfig {
	
    @Bean(name = BeanIds.DATASOURCE_MYSQL)
    @ConfigurationProperties("spring.datasource.mysql.hikari")
    public DataSource mysqlDataSource() {
        return new HikariDataSource();
    }
	
    @Bean(name = BeanIds.PROPERTIES_MYSQL)
    @ConfigurationProperties("spring.jpa.properties.mysql")
    public Properties mysqlProperties() {
        return new Properties();
    }
    
    @Bean(name = BeanIds.ENTITY_MANAGER_FACTORY_MYSQL)
    public LocalContainerEntityManagerFactoryBean mysqlEntityManagerFactory(
    		@Qualifier(BeanIds.DATASOURCE_MYSQL) DataSource dataSource, 
    		@Qualifier(BeanIds.PROPERTIES_MYSQL) Properties properties) {
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setDataSource(dataSource);
        factory.setPackagesToScan(new String[]{"com.tirmizee.jpa.mysql.entities"});
        factory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        factory.setJpaProperties(properties);
        return factory;
    }
    
    @Bean(name = BeanIds.TRANSACTION_MANAGER_MYSQL)
    public PlatformTransactionManager mysqlTransactionManager(
    		@Qualifier(BeanIds.ENTITY_MANAGER_FACTORY_MYSQL) LocalContainerEntityManagerFactoryBean entityManagerFactory){
    	return new JpaTransactionManager(entityManagerFactory.getObject());
    }
    
}
