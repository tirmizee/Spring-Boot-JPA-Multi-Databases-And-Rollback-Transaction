# Spring-Boot-JPA-Multi-Databases-And-Rollback-Transaction
Spring Data JPA multi-databases and rollback transaction using Hikari connection pool.

![Untitled Diagram](https://user-images.githubusercontent.com/15135199/75026009-c139ac80-54ce-11ea-866c-0548d677312f.jpg)


### Project structure

![app](https://user-images.githubusercontent.com/15135199/75090765-cb27e200-5598-11ea-8217-e15115f16b7b.PNG)

### Config application.properties

in src/main/resources

        spring.autoconfigure.exclude[0]=org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
        spring.autoconfigure.exclude[1]=org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration
        spring.autoconfigure.exclude[2]=org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration

        server.port=8000

        logging.level.org.springframework.orm.jpa.JpaTransactionManager=DEBUG
        logging.level.com.zaxxer.hikari.HikariConfig=DEBUG
        logging.level.com.zaxxer.hikari=TRACE


### Config database

in src/main/resources

- db_oracle.properties

        enabled=true

        spring.datasource.oracle.hikari.jdbc-url=jdbc:oracle:thin:@192.168.20.114:1521:xe
        spring.datasource.oracle.hikari.username=C##ORGANIZATION
        spring.datasource.oracle.hikari.password=organization
        spring.datasource.oracle.hikari.driver-class-name=oracle.jdbc.OracleDriver
        spring.datasource.oracle.hikari.connection-timeout=60000
        spring.datasource.oracle.hikari.minimum-idle=5
        spring.datasource.oracle.hikari.maximum-pool-size=20 
        spring.datasource.oracle.hikari.idle-timeout=10000
        spring.datasource.oracle.hikari.max-lifetime=300000
        spring.datasource.oracle.hikari.auto-commit=true
        spring.datasource.oracle.hikari.type=com.zaxxer.oracle.hikari.HikariDataSource
        spring.datasource.oracle.hikari.pool-name=OraclePool

        spring.jpa.properties.oracle.hibernate.dialect=org.hibernate.dialect.Oracle12cDialect
        spring.jpa.properties.oracle.hibernate.hbm2ddl.auto=update
        spring.jpa.properties.oracle.hibernate.show_sql=true
        spring.jpa.properties.oracle.hibernate.use_sql_comments=true
        spring.jpa.properties.oracle.hibernate.format_sql=true
        spring.jpa.properties.oracle.hibernate.type=trace

- db_maria.properties

        enabled=true

        spring.datasource.maria.hikari.jdbc-url=jdbc:mariadb://localhost:3305/schema_mariadb
        spring.datasource.maria.hikari.username=root
        spring.datasource.maria.hikari.password=root
        spring.datasource.maria.hikari.schema=schema_mariadb
        spring.datasource.maria.hikari.driver-class-name=org.mariadb.jdbc.Driver
        spring.datasource.maria.hikari.type=com.zaxxer.maria.hikari.HikariDataSource
        spring.datasource.maria.hikari.connection-timeout=60000
        spring.datasource.maria.hikari.minimum-idle=2
        spring.datasource.maria.hikari.maximum-pool-size=5 
        spring.datasource.maria.hikari.idle-timeout=10000
        spring.datasource.maria.hikari.max-lifetime=300000
        spring.datasource.maria.hikari.auto-commit=true
        spring.datasource.maria.hikari.pool-name=MariaPool

        spring.jpa.properties.maria.hibernate.dialect=org.hibernate.dialect.MariaDB103Dialect
        spring.jpa.properties.maria.hibernate.hbm2ddl.auto=update
        spring.jpa.properties.maria.hibernate.show_sql=true
        spring.jpa.properties.maria.hibernate.use_sql_comments=true
        spring.jpa.properties.maria.hibernate.format_sql=true
        spring.jpa.properties.maria.hibernate.type=trace
        
- db_mysql.properties
        
        enabled=true

        spring.datasource.mysql.hikari.jdbc-url=jdbc:mysql://localhost:3306/schema_mysql?useSSL=false&allowPublicKeyRetrieval=true
        spring.datasource.mysql.hikari.username=root
        spring.datasource.mysql.hikari.password=root
        spring.datasource.mysql.hikari.driver-class-name=com.mysql.cj.jdbc.Driver
        spring.datasource.mysql.hikari.connection-timeout=60000
        spring.datasource.mysql.hikari.minimum-idle=11
        spring.datasource.mysql.hikari.maximum-pool-size=17 
        spring.datasource.mysql.hikari.idle-timeout=10000
        spring.datasource.mysql.hikari.max-lifetime=300000
        spring.datasource.mysql.hikari.auto-commit=true
        spring.datasource.mysql.hikari.type=com.zaxxer.mysql.hikari.HikariDataSource
        spring.datasource.mysql.hikari.pool-name=MysqlPool

        spring.jpa.properties.mysql.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
        spring.jpa.properties.mysql.hibernate.hbm2ddl.auto=update
        spring.jpa.properties.mysql.hibernate.show_sql=true
        spring.jpa.properties.mysql.hibernate.use_sql_comments=true
        spring.jpa.properties.mysql.hibernate.format_sql=true
        spring.jpa.properties.mysql.hibernate.type=trace
        
- db_postgres.properties        
        
        enabled=true

        spring.datasource.postgres.hikari.jdbc-url=jdbc:postgresql://localhost:5433/postgres
        spring.datasource.postgres.hikari.username=postgres
        spring.datasource.postgres.hikari.password=postgres
        spring.datasource.postgres.hikari.schema=schema_postgres
        spring.datasource.postgres.hikari.driver-class-name=org.postgresql.Driver
        spring.datasource.postgres.hikari.connection-timeout=60000
        spring.datasource.postgres.hikari.minimum-idle=5
        spring.datasource.postgres.hikari.maximum-pool-size=15 
        spring.datasource.postgres.hikari.idle-timeout=10000
        spring.datasource.postgres.hikari.max-lifetime= 300000
        spring.datasource.postgres.hikari.auto-commit =true
        spring.datasource.postgres.hikari.type=com.zaxxer.hikari.HikariDataSource
        spring.datasource.postgres.hikari.pool-name=PostgresPool

        spring.jpa.properties.postgres.hibernate.dialect=org.hibernate.dialect.PostgreSQL10Dialect
        spring.jpa.properties.postgres.hibernate.hbm2ddl.auto=update
        spring.jpa.properties.postgres.hibernate.show_sql=true
        spring.jpa.properties.postgres.hibernate.use_sql_comments=true
        spring.jpa.properties.postgres.hibernate.format_sql=true
        spring.jpa.properties.postgres.hibernate.type=trace
        

### Handle transaction in service layer

- Mysql service 

![handle transaction](https://user-images.githubusercontent.com/15135199/75090688-01189680-5598-11ea-9bf7-b621302e2211.PNG)

- Mariadb service 

![handle transaction](https://user-images.githubusercontent.com/15135199/75091779-ab49eb80-55a3-11ea-838b-7c61a34c2c47.PNG)

- Oracle service 

![handle transaction](https://user-images.githubusercontent.com/15135199/75091624-fa8f1c80-55a1-11ea-9b4c-829198d4167d.PNG)

- Postgres service 

![handle transaction](https://user-images.githubusercontent.com/15135199/75091759-70e04e80-55a3-11ea-9642-9f1925a21605.PNG)


### Test transactions

- Test Mysql transaction

![ezgif com-resize](https://user-images.githubusercontent.com/15135199/75093714-c7a35380-55b6-11ea-9c46-916fc68a0718.gif)

- Test Mariadb transaction

- Test Oracle transaction

![ezgif com-resize](https://user-images.githubusercontent.com/15135199/75093881-7e540380-55b8-11ea-9d30-0da1dde4eae4.gif)

- Test Postgres transaction

### Console Log



          .   ____          _            __ _ _
         /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
        ( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
         \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
          '  |____| .__|_| |_|_| |_\__, | / / / /
         =========|_|==============|___/=/_/_/_/
         :: Spring Boot ::  (v2.3.0.BUILD-SNAPSHOT)

        2020-02-21 17:27:16.209  INFO 13912 --- [           main] paMultiDatabaseAndTransactionApplication : Starting SpringBootJpaMultiDatabaseAndTransactionApplication on LAPTOP-LCVEMHB7 with PID 13912 (C:\Users\Lenovo-User\eclipse-workspace\Spring-Boot-JPA-Multi-Databases-And-Rollback-Transaction\target\classes started by Lenovo-User in C:\Users\Lenovo-User\eclipse-workspace\Spring-Boot-JPA-Multi-Databases-And-Rollback-Transaction)
        2020-02-21 17:27:16.212  INFO 13912 --- [           main] paMultiDatabaseAndTransactionApplication : No active profile set, falling back to default profiles: default
        2020-02-21 17:27:16.655  INFO 13912 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Multiple Spring Data modules found, entering strict repository configuration mode!
        2020-02-21 17:27:16.655  INFO 13912 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Bootstrapping Spring Data JPA repositories in DEFAULT mode.
        2020-02-21 17:27:16.725  INFO 13912 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Finished Spring Data repository scanning in 62ms. Found 1 JPA repository interfaces.
        2020-02-21 17:27:16.726  INFO 13912 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Multiple Spring Data modules found, entering strict repository configuration mode!
        2020-02-21 17:27:16.726  INFO 13912 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Bootstrapping Spring Data JPA repositories in DEFAULT mode.
        2020-02-21 17:27:16.731  INFO 13912 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Finished Spring Data repository scanning in 4ms. Found 1 JPA repository interfaces.
        2020-02-21 17:27:16.731  INFO 13912 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Multiple Spring Data modules found, entering strict repository configuration mode!
        2020-02-21 17:27:16.731  INFO 13912 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Bootstrapping Spring Data JPA repositories in DEFAULT mode.
        2020-02-21 17:27:16.732  INFO 13912 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Finished Spring Data repository scanning in 0ms. Found 0 JPA repository interfaces.
        2020-02-21 17:27:16.732  INFO 13912 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Multiple Spring Data modules found, entering strict repository configuration mode!
        2020-02-21 17:27:16.732  INFO 13912 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Bootstrapping Spring Data JPA repositories in DEFAULT mode.
        2020-02-21 17:27:16.736  INFO 13912 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Finished Spring Data repository scanning in 3ms. Found 1 JPA repository interfaces.
        2020-02-21 17:27:17.151  INFO 13912 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'org.springframework.transaction.annotation.ProxyTransactionManagementConfiguration' of type [org.springframework.transaction.annotation.ProxyTransactionManagementConfiguration] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
        2020-02-21 17:27:17.935  INFO 13912 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8000 (http)
        2020-02-21 17:27:17.944  INFO 13912 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
        2020-02-21 17:27:17.945  INFO 13912 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet engine: [Apache Tomcat/9.0.31]
        2020-02-21 17:27:18.026  INFO 13912 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
        2020-02-21 17:27:18.026  INFO 13912 --- [           main] o.s.web.context.ContextLoader            : Root WebApplicationContext: initialization completed in 1780 ms
        2020-02-21 17:27:18.138 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : Driver class org.mariadb.jdbc.Driver found in Thread context class loader sun.misc.Launcher$AppClassLoader@73d16e93
        2020-02-21 17:27:18.325  INFO 13912 --- [           main] o.hibernate.jpa.internal.util.LogHelper  : HHH000204: Processing PersistenceUnitInfo [name: default]
        2020-02-21 17:27:18.392  INFO 13912 --- [           main] org.hibernate.Version                    : HHH000412: Hibernate Core {5.4.11.Final}
        2020-02-21 17:27:18.872  INFO 13912 --- [           main] o.hibernate.annotations.common.Version   : HCANN000001: Hibernate Commons Annotations {5.1.0.Final}
        2020-02-21 17:27:19.406 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : MariaPool - configuration:
        2020-02-21 17:27:19.415 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : allowPoolSuspension.............false
        2020-02-21 17:27:19.416 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : autoCommit......................true
        2020-02-21 17:27:19.416 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : catalog.........................none
        2020-02-21 17:27:19.416 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : connectionInitSql...............none
        2020-02-21 17:27:19.416 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : connectionTestQuery.............none
        2020-02-21 17:27:19.416 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : connectionTimeout...............60000
        2020-02-21 17:27:19.416 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : dataSource......................none
        2020-02-21 17:27:19.416 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : dataSourceClassName.............none
        2020-02-21 17:27:19.416 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : dataSourceJNDI..................none
        2020-02-21 17:27:19.417 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : dataSourceProperties............{password=<masked>}
        2020-02-21 17:27:19.417 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : driverClassName................."org.mariadb.jdbc.Driver"
        2020-02-21 17:27:19.417 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : healthCheckProperties...........{}
        2020-02-21 17:27:19.417 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : healthCheckRegistry.............none
        2020-02-21 17:27:19.417 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : idleTimeout.....................10000
        2020-02-21 17:27:19.417 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : initializationFailTimeout.......1
        2020-02-21 17:27:19.417 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : isolateInternalQueries..........false
        2020-02-21 17:27:19.417 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : jdbcUrl.........................jdbc:mariadb://localhost:3305/schema_mariadb
        2020-02-21 17:27:19.417 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : leakDetectionThreshold..........0
        2020-02-21 17:27:19.417 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : maxLifetime.....................300000
        2020-02-21 17:27:19.417 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : maximumPoolSize.................5
        2020-02-21 17:27:19.417 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : metricRegistry..................none
        2020-02-21 17:27:19.417 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : metricsTrackerFactory...........none
        2020-02-21 17:27:19.417 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : minimumIdle.....................2
        2020-02-21 17:27:19.417 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : password........................<masked>
        2020-02-21 17:27:19.418 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : poolName........................"MariaPool"
        2020-02-21 17:27:19.418 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : readOnly........................false
        2020-02-21 17:27:19.418 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : registerMbeans..................false
        2020-02-21 17:27:19.418 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : scheduledExecutor...............none
        2020-02-21 17:27:19.418 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : schema.........................."schema_mariadb"
        2020-02-21 17:27:19.418 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : threadFactory...................internal
        2020-02-21 17:27:19.418 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : transactionIsolation............default
        2020-02-21 17:27:19.418 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : username........................"root"
        2020-02-21 17:27:19.418 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : validationTimeout...............5000
        2020-02-21 17:27:19.418  INFO 13912 --- [           main] com.zaxxer.hikari.HikariDataSource       : MariaPool - Starting...
        2020-02-21 17:27:19.528 DEBUG 13912 --- [           main] com.zaxxer.hikari.pool.HikariPool        : MariaPool - Added connection org.mariadb.jdbc.MariaDbConnection@5d1e0fbb
        2020-02-21 17:27:19.531  INFO 13912 --- [           main] com.zaxxer.hikari.HikariDataSource       : MariaPool - Start completed.
        2020-02-21 17:27:19.615  INFO 13912 --- [           main] org.hibernate.dialect.Dialect            : HHH000400: Using dialect: org.hibernate.dialect.MariaDB103Dialect
        2020-02-21 17:27:19.632 DEBUG 13912 --- [ool housekeeper] com.zaxxer.hikari.pool.HikariPool        : MariaPool - Before cleanup stats (total=1, active=1, idle=0, waiting=0)
        2020-02-21 17:27:19.632 DEBUG 13912 --- [ool housekeeper] com.zaxxer.hikari.pool.HikariPool        : MariaPool - After cleanup  stats (total=1, active=1, idle=0, waiting=0)
        2020-02-21 17:27:19.634 DEBUG 13912 --- [onnection adder] com.zaxxer.hikari.pool.HikariPool        : MariaPool - Added connection org.mariadb.jdbc.MariaDbConnection@38db5f23
        2020-02-21 17:27:19.635 DEBUG 13912 --- [onnection adder] com.zaxxer.hikari.pool.HikariPool        : MariaPool - Added connection org.mariadb.jdbc.MariaDbConnection@361cb648
        2020-02-21 17:27:19.636 DEBUG 13912 --- [onnection adder] com.zaxxer.hikari.pool.HikariPool        : MariaPool - After adding stats (total=3, active=1, idle=2, waiting=0)
        Hibernate: 

            create table MOCKUP (
               ID integer not null,
                MOCKUP_DESC varchar(255),
                MOCKUP_NAME varchar(255),
                primary key (ID)
            ) engine=InnoDB
        2020-02-21 17:27:20.599  INFO 13912 --- [           main] o.h.e.t.j.p.i.JtaPlatformInitiator       : HHH000490: Using JtaPlatform implementation: [org.hibernate.engine.transaction.jta.platform.internal.NoJtaPlatform]
        2020-02-21 17:27:20.636  INFO 13912 --- [           main] j.LocalContainerEntityManagerFactoryBean : Initialized JPA EntityManagerFactory for persistence unit 'default'
        2020-02-21 17:27:20.648 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : Driver class com.mysql.cj.jdbc.Driver found in Thread context class loader sun.misc.Launcher$AppClassLoader@73d16e93
        2020-02-21 17:27:20.656  INFO 13912 --- [           main] o.hibernate.jpa.internal.util.LogHelper  : HHH000204: Processing PersistenceUnitInfo [name: default]
        2020-02-21 17:27:20.670 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : MysqlPool - configuration:
        2020-02-21 17:27:20.671 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : allowPoolSuspension.............false
        2020-02-21 17:27:20.671 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : autoCommit......................true
        2020-02-21 17:27:20.671 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : catalog.........................none
        2020-02-21 17:27:20.671 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : connectionInitSql...............none
        2020-02-21 17:27:20.672 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : connectionTestQuery.............none
        2020-02-21 17:27:20.672 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : connectionTimeout...............60000
        2020-02-21 17:27:20.672 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : dataSource......................none
        2020-02-21 17:27:20.672 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : dataSourceClassName.............none
        2020-02-21 17:27:20.672 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : dataSourceJNDI..................none
        2020-02-21 17:27:20.672 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : dataSourceProperties............{password=<masked>}
        2020-02-21 17:27:20.672 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : driverClassName................."com.mysql.cj.jdbc.Driver"
        2020-02-21 17:27:20.672 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : healthCheckProperties...........{}
        2020-02-21 17:27:20.672 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : healthCheckRegistry.............none
        2020-02-21 17:27:20.672 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : idleTimeout.....................10000
        2020-02-21 17:27:20.672 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : initializationFailTimeout.......1
        2020-02-21 17:27:20.672 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : isolateInternalQueries..........false
        2020-02-21 17:27:20.672 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : jdbcUrl.........................jdbc:mysql://localhost:3306/schema_mysql?useSSL=false&allowPublicKeyRetrieval=true
        2020-02-21 17:27:20.672 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : leakDetectionThreshold..........0
        2020-02-21 17:27:20.672 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : maxLifetime.....................300000
        2020-02-21 17:27:20.672 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : maximumPoolSize.................17
        2020-02-21 17:27:20.672 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : metricRegistry..................none
        2020-02-21 17:27:20.672 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : metricsTrackerFactory...........none
        2020-02-21 17:27:20.673 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : minimumIdle.....................11
        2020-02-21 17:27:20.673 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : password........................<masked>
        2020-02-21 17:27:20.673 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : poolName........................"MysqlPool"
        2020-02-21 17:27:20.673 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : readOnly........................false
        2020-02-21 17:27:20.673 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : registerMbeans..................false
        2020-02-21 17:27:20.673 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : scheduledExecutor...............none
        2020-02-21 17:27:20.673 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : schema..........................none
        2020-02-21 17:27:20.673 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : threadFactory...................internal
        2020-02-21 17:27:20.673 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : transactionIsolation............default
        2020-02-21 17:27:20.673 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : username........................"root"
        2020-02-21 17:27:20.673 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : validationTimeout...............5000
        2020-02-21 17:27:20.673  INFO 13912 --- [           main] com.zaxxer.hikari.HikariDataSource       : MysqlPool - Starting...
        2020-02-21 17:27:20.951 DEBUG 13912 --- [           main] com.zaxxer.hikari.pool.HikariPool        : MysqlPool - Added connection com.mysql.cj.jdbc.ConnectionImpl@222acad
        2020-02-21 17:27:20.951  INFO 13912 --- [           main] com.zaxxer.hikari.HikariDataSource       : MysqlPool - Start completed.
        2020-02-21 17:27:20.953  INFO 13912 --- [           main] org.hibernate.dialect.Dialect            : HHH000400: Using dialect: org.hibernate.dialect.MySQL8Dialect
        Hibernate: 

            create table MOCKUP (
               ID integer not null,
                MOCKUP_DESC varchar(255),
                MOCKUP_NAME varchar(255),
                primary key (ID)
            ) engine=InnoDB
        2020-02-21 17:27:21.052 DEBUG 13912 --- [ool housekeeper] com.zaxxer.hikari.pool.HikariPool        : MysqlPool - Before cleanup stats (total=1, active=1, idle=0, waiting=0)
        2020-02-21 17:27:21.052 DEBUG 13912 --- [ool housekeeper] com.zaxxer.hikari.pool.HikariPool        : MysqlPool - After cleanup  stats (total=1, active=1, idle=0, waiting=0)
        2020-02-21 17:27:21.057 DEBUG 13912 --- [onnection adder] com.zaxxer.hikari.pool.HikariPool        : MysqlPool - Added connection com.mysql.cj.jdbc.ConnectionImpl@75425972
        2020-02-21 17:27:21.061 DEBUG 13912 --- [onnection adder] com.zaxxer.hikari.pool.HikariPool        : MysqlPool - Added connection com.mysql.cj.jdbc.ConnectionImpl@347f5349
        2020-02-21 17:27:21.065 DEBUG 13912 --- [onnection adder] com.zaxxer.hikari.pool.HikariPool        : MysqlPool - Added connection com.mysql.cj.jdbc.ConnectionImpl@501677a
        2020-02-21 17:27:21.068 DEBUG 13912 --- [onnection adder] com.zaxxer.hikari.pool.HikariPool        : MysqlPool - Added connection com.mysql.cj.jdbc.ConnectionImpl@5450ac06
        2020-02-21 17:27:21.071 DEBUG 13912 --- [onnection adder] com.zaxxer.hikari.pool.HikariPool        : MysqlPool - Added connection com.mysql.cj.jdbc.ConnectionImpl@414cdaf9
        2020-02-21 17:27:21.076 DEBUG 13912 --- [onnection adder] com.zaxxer.hikari.pool.HikariPool        : MysqlPool - Added connection com.mysql.cj.jdbc.ConnectionImpl@501e14f7
        2020-02-21 17:27:21.079 DEBUG 13912 --- [onnection adder] com.zaxxer.hikari.pool.HikariPool        : MysqlPool - Added connection com.mysql.cj.jdbc.ConnectionImpl@6e09edf
        2020-02-21 17:27:21.082  INFO 13912 --- [           main] o.h.e.t.j.p.i.JtaPlatformInitiator       : HHH000490: Using JtaPlatform implementation: [org.hibernate.engine.transaction.jta.platform.internal.NoJtaPlatform]
        2020-02-21 17:27:21.082  INFO 13912 --- [           main] j.LocalContainerEntityManagerFactoryBean : Initialized JPA EntityManagerFactory for persistence unit 'default'
        2020-02-21 17:27:21.082 DEBUG 13912 --- [onnection adder] com.zaxxer.hikari.pool.HikariPool        : MysqlPool - Added connection com.mysql.cj.jdbc.ConnectionImpl@13e06d60
        2020-02-21 17:27:21.086 DEBUG 13912 --- [onnection adder] com.zaxxer.hikari.pool.HikariPool        : MysqlPool - Added connection com.mysql.cj.jdbc.ConnectionImpl@67801dea
        2020-02-21 17:27:21.091 DEBUG 13912 --- [onnection adder] com.zaxxer.hikari.pool.HikariPool        : MysqlPool - Added connection com.mysql.cj.jdbc.ConnectionImpl@1dd29ebd
        2020-02-21 17:27:21.092 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : Driver class oracle.jdbc.OracleDriver found in Thread context class loader sun.misc.Launcher$AppClassLoader@73d16e93
        2020-02-21 17:27:21.098  INFO 13912 --- [           main] o.hibernate.jpa.internal.util.LogHelper  : HHH000204: Processing PersistenceUnitInfo [name: default]
        2020-02-21 17:27:21.112 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : OraclePool - configuration:
        2020-02-21 17:27:21.112 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : allowPoolSuspension.............false
        2020-02-21 17:27:21.113 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : autoCommit......................true
        2020-02-21 17:27:21.113 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : catalog.........................none
        2020-02-21 17:27:21.113 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : connectionInitSql...............none
        2020-02-21 17:27:21.113 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : connectionTestQuery.............none
        2020-02-21 17:27:21.113 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : connectionTimeout...............60000
        2020-02-21 17:27:21.113 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : dataSource......................none
        2020-02-21 17:27:21.113 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : dataSourceClassName.............none
        2020-02-21 17:27:21.113 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : dataSourceJNDI..................none
        2020-02-21 17:27:21.113 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : dataSourceProperties............{password=<masked>}
        2020-02-21 17:27:21.113 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : driverClassName................."oracle.jdbc.OracleDriver"
        2020-02-21 17:27:21.113 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : healthCheckProperties...........{}
        2020-02-21 17:27:21.113 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : healthCheckRegistry.............none
        2020-02-21 17:27:21.113 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : idleTimeout.....................10000
        2020-02-21 17:27:21.113 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : initializationFailTimeout.......1
        2020-02-21 17:27:21.113 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : isolateInternalQueries..........false
        2020-02-21 17:27:21.113 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : jdbcUrl.........................jdbc:oracle:thin:@192.168.20.114:1521:xe
        2020-02-21 17:27:21.113 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : leakDetectionThreshold..........0
        2020-02-21 17:27:21.113 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : maxLifetime.....................300000
        2020-02-21 17:27:21.113 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : maximumPoolSize.................20
        2020-02-21 17:27:21.113 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : metricRegistry..................none
        2020-02-21 17:27:21.113 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : metricsTrackerFactory...........none
        2020-02-21 17:27:21.114 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : minimumIdle.....................5
        2020-02-21 17:27:21.114 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : password........................<masked>
        2020-02-21 17:27:21.114 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : poolName........................"OraclePool"
        2020-02-21 17:27:21.114 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : readOnly........................false
        2020-02-21 17:27:21.114 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : registerMbeans..................false
        2020-02-21 17:27:21.114 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : scheduledExecutor...............none
        2020-02-21 17:27:21.114 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : schema..........................none
        2020-02-21 17:27:21.114 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : threadFactory...................internal
        2020-02-21 17:27:21.114 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : transactionIsolation............default
        2020-02-21 17:27:21.114 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : username........................"C##ORGANIZATION"
        2020-02-21 17:27:21.114 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : validationTimeout...............5000
        2020-02-21 17:27:21.114  INFO 13912 --- [           main] com.zaxxer.hikari.HikariDataSource       : OraclePool - Starting...
        2020-02-21 17:27:22.406 DEBUG 13912 --- [           main] com.zaxxer.hikari.pool.HikariPool        : OraclePool - Added connection oracle.jdbc.driver.T4CConnection@60b1ff3b
        2020-02-21 17:27:22.406  INFO 13912 --- [           main] com.zaxxer.hikari.HikariDataSource       : OraclePool - Start completed.
        2020-02-21 17:27:22.411  INFO 13912 --- [           main] org.hibernate.dialect.Dialect            : HHH000400: Using dialect: org.hibernate.dialect.Oracle12cDialect
        2020-02-21 17:27:22.508 DEBUG 13912 --- [ool housekeeper] com.zaxxer.hikari.pool.HikariPool        : OraclePool - Before cleanup stats (total=1, active=1, idle=0, waiting=0)
        2020-02-21 17:27:22.508 DEBUG 13912 --- [ool housekeeper] com.zaxxer.hikari.pool.HikariPool        : OraclePool - After cleanup  stats (total=1, active=1, idle=0, waiting=0)
        2020-02-21 17:27:22.537 DEBUG 13912 --- [onnection adder] com.zaxxer.hikari.pool.HikariPool        : OraclePool - Added connection oracle.jdbc.driver.T4CConnection@38c7f88
        2020-02-21 17:27:22.564 DEBUG 13912 --- [onnection adder] com.zaxxer.hikari.pool.HikariPool        : OraclePool - Added connection oracle.jdbc.driver.T4CConnection@13a92cbc
        2020-02-21 17:27:22.593 DEBUG 13912 --- [onnection adder] com.zaxxer.hikari.pool.HikariPool        : OraclePool - Added connection oracle.jdbc.driver.T4CConnection@6bcb76db
        2020-02-21 17:27:22.937 DEBUG 13912 --- [onnection adder] com.zaxxer.hikari.pool.HikariPool        : OraclePool - Added connection oracle.jdbc.driver.T4CConnection@4082a231
        2020-02-21 17:27:22.982 DEBUG 13912 --- [onnection adder] com.zaxxer.hikari.pool.HikariPool        : OraclePool - Added connection oracle.jdbc.driver.T4CConnection@26d0d4db
        2020-02-21 17:27:22.982 DEBUG 13912 --- [onnection adder] com.zaxxer.hikari.pool.HikariPool        : OraclePool - After adding stats (total=6, active=1, idle=5, waiting=0)
        2020-02-21 17:27:49.634 DEBUG 13912 --- [ool housekeeper] com.zaxxer.hikari.pool.HikariPool        : MariaPool - Before cleanup stats (total=3, active=0, idle=3, waiting=0)
        2020-02-21 17:27:49.635 DEBUG 13912 --- [ool housekeeper] com.zaxxer.hikari.pool.HikariPool        : MariaPool - After cleanup  stats (total=2, active=0, idle=2, waiting=0)
        2020-02-21 17:27:49.635 DEBUG 13912 --- [nnection closer] com.zaxxer.hikari.pool.PoolBase          : MariaPool - Closing connection org.mariadb.jdbc.MariaDbConnection@361cb648: (connection has passed idleTimeout)
        2020-02-21 17:27:51.053 DEBUG 13912 --- [ool housekeeper] com.zaxxer.hikari.pool.HikariPool        : MysqlPool - Before cleanup stats (total=11, active=0, idle=11, waiting=0)
        2020-02-21 17:27:51.053 DEBUG 13912 --- [ool housekeeper] com.zaxxer.hikari.pool.HikariPool        : MysqlPool - After cleanup  stats (total=11, active=0, idle=11, waiting=0)
        2020-02-21 17:27:52.509 DEBUG 13912 --- [ool housekeeper] com.zaxxer.hikari.pool.HikariPool        : OraclePool - Before cleanup stats (total=6, active=1, idle=5, waiting=0)
        2020-02-21 17:27:52.509 DEBUG 13912 --- [ool housekeeper] com.zaxxer.hikari.pool.HikariPool        : OraclePool - After cleanup  stats (total=6, active=1, idle=5, waiting=0)
        Hibernate: 

            create table MOCKUP (
               ID number(10,0) not null,
                MOCKUP_DESC varchar2(255 char),
                MOCKUP_NAME varchar2(255 char),
                primary key (ID)
            )
        2020-02-21 17:28:01.054  INFO 13912 --- [           main] o.h.e.t.j.p.i.JtaPlatformInitiator       : HHH000490: Using JtaPlatform implementation: [org.hibernate.engine.transaction.jta.platform.internal.NoJtaPlatform]
        2020-02-21 17:28:01.054  INFO 13912 --- [           main] j.LocalContainerEntityManagerFactoryBean : Initialized JPA EntityManagerFactory for persistence unit 'default'
        2020-02-21 17:28:01.068 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : Driver class org.postgresql.Driver found in Thread context class loader sun.misc.Launcher$AppClassLoader@73d16e93
        2020-02-21 17:28:01.075  INFO 13912 --- [           main] o.hibernate.jpa.internal.util.LogHelper  : HHH000204: Processing PersistenceUnitInfo [name: default]
        2020-02-21 17:28:01.087 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : PostgresPool - configuration:
        2020-02-21 17:28:01.088 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : allowPoolSuspension.............false
        2020-02-21 17:28:01.088 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : autoCommit......................true
        2020-02-21 17:28:01.088 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : catalog.........................none
        2020-02-21 17:28:01.088 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : connectionInitSql...............none
        2020-02-21 17:28:01.088 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : connectionTestQuery.............none
        2020-02-21 17:28:01.088 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : connectionTimeout...............60000
        2020-02-21 17:28:01.088 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : dataSource......................none
        2020-02-21 17:28:01.088 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : dataSourceClassName.............none
        2020-02-21 17:28:01.088 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : dataSourceJNDI..................none
        2020-02-21 17:28:01.088 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : dataSourceProperties............{password=<masked>}
        2020-02-21 17:28:01.088 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : driverClassName................."org.postgresql.Driver"
        2020-02-21 17:28:01.088 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : healthCheckProperties...........{}
        2020-02-21 17:28:01.088 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : healthCheckRegistry.............none
        2020-02-21 17:28:01.088 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : idleTimeout.....................10000
        2020-02-21 17:28:01.088 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : initializationFailTimeout.......1
        2020-02-21 17:28:01.088 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : isolateInternalQueries..........false
        2020-02-21 17:28:01.089 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : jdbcUrl.........................jdbc:postgresql://localhost:5433/postgres
        2020-02-21 17:28:01.089 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : leakDetectionThreshold..........0
        2020-02-21 17:28:01.089 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : maxLifetime.....................300000
        2020-02-21 17:28:01.089 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : maximumPoolSize.................15
        2020-02-21 17:28:01.089 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : metricRegistry..................none
        2020-02-21 17:28:01.089 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : metricsTrackerFactory...........none
        2020-02-21 17:28:01.089 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : minimumIdle.....................5
        2020-02-21 17:28:01.089 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : password........................<masked>
        2020-02-21 17:28:01.089 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : poolName........................"PostgresPool"
        2020-02-21 17:28:01.089 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : readOnly........................false
        2020-02-21 17:28:01.089 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : registerMbeans..................false
        2020-02-21 17:28:01.089 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : scheduledExecutor...............none
        2020-02-21 17:28:01.089 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : schema.........................."schema_postgres"
        2020-02-21 17:28:01.089 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : threadFactory...................internal
        2020-02-21 17:28:01.089 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : transactionIsolation............default
        2020-02-21 17:28:01.089 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : username........................"postgres"
        2020-02-21 17:28:01.089 DEBUG 13912 --- [           main] com.zaxxer.hikari.HikariConfig           : validationTimeout...............5000
        2020-02-21 17:28:01.089  INFO 13912 --- [           main] com.zaxxer.hikari.HikariDataSource       : PostgresPool - Starting...
        2020-02-21 17:28:01.273 DEBUG 13912 --- [           main] com.zaxxer.hikari.pool.HikariPool        : PostgresPool - Added connection org.postgresql.jdbc.PgConnection@3cf4dec7
        2020-02-21 17:28:01.273  INFO 13912 --- [           main] com.zaxxer.hikari.HikariDataSource       : PostgresPool - Start completed.
        2020-02-21 17:28:01.291  INFO 13912 --- [           main] org.hibernate.dialect.Dialect            : HHH000400: Using dialect: org.hibernate.dialect.PostgreSQL10Dialect
        2020-02-21 17:28:01.374 DEBUG 13912 --- [ool housekeeper] com.zaxxer.hikari.pool.HikariPool        : PostgresPool - Before cleanup stats (total=1, active=1, idle=0, waiting=0)
        2020-02-21 17:28:01.374 DEBUG 13912 --- [ool housekeeper] com.zaxxer.hikari.pool.HikariPool        : PostgresPool - After cleanup  stats (total=1, active=1, idle=0, waiting=0)
        2020-02-21 17:28:01.388  INFO 13912 --- [           main] o.h.e.t.j.p.i.JtaPlatformInitiator       : HHH000490: Using JtaPlatform implementation: [org.hibernate.engine.transaction.jta.platform.internal.NoJtaPlatform]
        2020-02-21 17:28:01.389  INFO 13912 --- [           main] j.LocalContainerEntityManagerFactoryBean : Initialized JPA EntityManagerFactory for persistence unit 'default'
        2020-02-21 17:28:01.417 DEBUG 13912 --- [onnection adder] com.zaxxer.hikari.pool.HikariPool        : PostgresPool - Added connection org.postgresql.jdbc.PgConnection@273db9b6
        2020-02-21 17:28:01.452 DEBUG 13912 --- [onnection adder] com.zaxxer.hikari.pool.HikariPool        : PostgresPool - Added connection org.postgresql.jdbc.PgConnection@29fa5321
        2020-02-21 17:28:01.486 DEBUG 13912 --- [onnection adder] com.zaxxer.hikari.pool.HikariPool        : PostgresPool - Added connection org.postgresql.jdbc.PgConnection@2dc5d2c6
        2020-02-21 17:28:01.529 DEBUG 13912 --- [onnection adder] com.zaxxer.hikari.pool.HikariPool        : PostgresPool - Added connection org.postgresql.jdbc.PgConnection@68c7591a
        2020-02-21 17:28:02.567  INFO 13912 --- [           main] o.s.s.concurrent.ThreadPoolTaskExecutor  : Initializing ExecutorService 'applicationTaskExecutor'
        2020-02-21 17:28:03.034  INFO 13912 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8000 (http) with context path ''
        2020-02-21 17:28:03.036  INFO 13912 --- [           main] paMultiDatabaseAndTransactionApplication : Started SpringBootJpaMultiDatabaseAndTransactionApplication in 47.149 seconds (JVM running for 47.485)
