package com.tirmizee.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.hibernate.dialect.PostgreSQL92Dialect;
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
	basePackages = "com.tirmizee.jpa.repositories.postgres",
	entityManagerFactoryRef = "postgresEntityManagerFactory",
	transactionManagerRef = "postgresTransactionManager"
)
@ConditionalOnProperty(
    value="enabled", 
    havingValue = "true", 
    matchIfMissing = true)
@PropertySource("classpath:db_postgresql.properties")
public class RepositoryPostgresConfig {
	
    @Bean(name = "postgresDataSource")
    @ConfigurationProperties("spring.datasource")
    public DataSource postgresDataSource() {
        return DataSourceBuilder.create().build();
    }
    
    @Bean(name = "postgresProperties")
    @ConfigurationProperties("spring.jpa.properties")
    public Properties postgresProperties() {
        return new Properties();
    }
    
    @Bean(name = "postgresEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean postgresEntityManagerFactory(DataSource postgresDataSource, Properties postgresProperties) {
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setDataSource(postgresDataSource);
        factory.setPersistenceUnitName("postgres-persistence");
        factory.setPackagesToScan(new String[]{"com.tirmizee.jpa.entities.postgres"});
        factory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        factory.setJpaProperties(postgresProperties);
        return factory;
    }
	
    @Bean(name = "postgresTransactionManager")
    public PlatformTransactionManager postgresTransactionManager(LocalContainerEntityManagerFactoryBean postgresEntityManagerFactory){
        return new JpaTransactionManager(postgresEntityManagerFactory.getObject());
    }
    
}
