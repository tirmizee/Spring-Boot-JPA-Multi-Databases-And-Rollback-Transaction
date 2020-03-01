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
	basePackages = "com.tirmizee.jpa.postgres.repositories",
	entityManagerFactoryRef = BeanIds.ENTITY_MANAGER_FACTORY_POSTGRES,
	transactionManagerRef = BeanIds.TRANSACTION_MANAGER_POSTGRES
)
@PropertySource("classpath:db_postgresql.properties")
public class RepositoryPostgresConfig {
	
    @Bean(name = BeanIds.DATASOURCE_POSTGRES)
    @ConfigurationProperties("spring.datasource.postgres.hikari")
    public DataSource postgresDataSource() {
        return new HikariDataSource();
    }
    
    @Bean(name = BeanIds.PROPERTIES_POSTGRES)
    @ConfigurationProperties("spring.jpa.properties.postgres")
    public Properties postgresProperties() {
        return new Properties();
    }
    
    @Bean(name = BeanIds.ENTITY_MANAGER_FACTORY_POSTGRES)
    public LocalContainerEntityManagerFactoryBean postgresEntityManagerFactory(
    		@Qualifier(BeanIds.DATASOURCE_POSTGRES) DataSource postgresDataSource, 
    		@Qualifier(BeanIds.PROPERTIES_POSTGRES) Properties postgresProperties) {
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setDataSource(postgresDataSource);
        factory.setPackagesToScan(new String[]{"com.tirmizee.jpa.postgres.entities"});
        factory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        factory.setJpaProperties(postgresProperties);
        return factory;
    }
    
    @Bean(name = BeanIds.TRANSACTION_MANAGER_POSTGRES)
    public PlatformTransactionManager postgresTransactionManager(
    		@Qualifier(BeanIds.ENTITY_MANAGER_FACTORY_POSTGRES) LocalContainerEntityManagerFactoryBean entityManagerFactory){
        return new JpaTransactionManager(entityManagerFactory.getObject());
    }
    
}
