# Spring-Boot-JPA-Multi-Databases-And-Rollback-Transaction
Spring Data JPA multi-databases and roll back transaction


### Console Log


        .   ____          _            __ _ _
       /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
      ( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
       \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
        '  |____| .__|_| |_|_| |_\__, | / / / /
       =========|_|==============|___/=/_/_/_/
       :: Spring Boot ::  (v2.3.0.BUILD-SNAPSHOT)

      2020-02-20 22:57:47.692  INFO 10224 --- [           main] paMultiDatabaseAndTransactionApplication : Starting SpringBootJpaMultiDatabaseAndTransactionApplication on LAPTOP-LCVEMHB7 with PID 10224 (C:\Users\Lenovo-User\eclipse-workspace\Spring-Boot-JPA-Multi-Databases-And-Rollback-Transaction\target\classes started by Lenovo-User in C:\Users\Lenovo-User\eclipse-workspace\Spring-Boot-JPA-Multi-Databases-And-Rollback-Transaction)
      2020-02-20 22:57:47.694  INFO 10224 --- [           main] paMultiDatabaseAndTransactionApplication : No active profile set, falling back to default profiles: default
      2020-02-20 22:57:48.163  INFO 10224 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Multiple Spring Data modules found, entering strict repository configuration mode!
      2020-02-20 22:57:48.164  INFO 10224 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Bootstrapping Spring Data JPA repositories in DEFAULT mode.
      2020-02-20 22:57:48.237  INFO 10224 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Finished Spring Data repository scanning in 64ms. Found 1 JPA repository interfaces.
      2020-02-20 22:57:48.237  INFO 10224 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Multiple Spring Data modules found, entering strict repository configuration mode!
      2020-02-20 22:57:48.237  INFO 10224 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Bootstrapping Spring Data JPA repositories in DEFAULT mode.
      2020-02-20 22:57:48.238  INFO 10224 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Finished Spring Data repository scanning in 0ms. Found 0 JPA repository interfaces.
      2020-02-20 22:57:48.238  INFO 10224 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Multiple Spring Data modules found, entering strict repository configuration mode!
      2020-02-20 22:57:48.238  INFO 10224 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Bootstrapping Spring Data JPA repositories in DEFAULT mode.
      2020-02-20 22:57:48.243  INFO 10224 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Finished Spring Data repository scanning in 4ms. Found 1 JPA repository interfaces.
      2020-02-20 22:57:48.645  INFO 10224 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'org.springframework.transaction.annotation.ProxyTransactionManagementConfiguration' of type [org.springframework.transaction.annotation.ProxyTransactionManagementConfiguration] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
      2020-02-20 22:57:49.336  INFO 10224 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8000 (http)
      2020-02-20 22:57:49.345  INFO 10224 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
      2020-02-20 22:57:49.345  INFO 10224 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet engine: [Apache Tomcat/9.0.31]
      2020-02-20 22:57:49.430  INFO 10224 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
      2020-02-20 22:57:49.430  INFO 10224 --- [           main] o.s.web.context.ContextLoader            : Root WebApplicationContext: initialization completed in 1703 ms
      2020-02-20 22:57:49.541 DEBUG 10224 --- [           main] com.zaxxer.hikari.HikariConfig           : Driver class com.mysql.cj.jdbc.Driver found in Thread context class loader sun.misc.Launcher$AppClassLoader@73d16e93
      2020-02-20 22:57:49.704  INFO 10224 --- [           main] o.hibernate.jpa.internal.util.LogHelper  : HHH000204: Processing PersistenceUnitInfo [name: default]
      2020-02-20 22:57:49.779  INFO 10224 --- [           main] org.hibernate.Version                    : HHH000412: Hibernate Core {5.4.11.Final}
      2020-02-20 22:57:49.934  INFO 10224 --- [           main] o.hibernate.annotations.common.Version   : HCANN000001: Hibernate Commons Annotations {5.1.0.Final}
      2020-02-20 22:57:50.048 DEBUG 10224 --- [           main] com.zaxxer.hikari.HikariConfig           : MysqlPool - configuration:
      2020-02-20 22:57:50.050 DEBUG 10224 --- [           main] com.zaxxer.hikari.HikariConfig           : allowPoolSuspension.............false
      2020-02-20 22:57:50.050 DEBUG 10224 --- [           main] com.zaxxer.hikari.HikariConfig           : autoCommit......................true
      2020-02-20 22:57:50.050 DEBUG 10224 --- [           main] com.zaxxer.hikari.HikariConfig           : catalog.........................none
      2020-02-20 22:57:50.050 DEBUG 10224 --- [           main] com.zaxxer.hikari.HikariConfig           : connectionInitSql...............none
      2020-02-20 22:57:50.050 DEBUG 10224 --- [           main] com.zaxxer.hikari.HikariConfig           : connectionTestQuery.............none
      2020-02-20 22:57:50.050 DEBUG 10224 --- [           main] com.zaxxer.hikari.HikariConfig           : connectionTimeout...............60000
      2020-02-20 22:57:50.051 DEBUG 10224 --- [           main] com.zaxxer.hikari.HikariConfig           : dataSource......................none
      2020-02-20 22:57:50.051 DEBUG 10224 --- [           main] com.zaxxer.hikari.HikariConfig           : dataSourceClassName.............none
      2020-02-20 22:57:50.051 DEBUG 10224 --- [           main] com.zaxxer.hikari.HikariConfig           : dataSourceJNDI..................none
      2020-02-20 22:57:50.051 DEBUG 10224 --- [           main] com.zaxxer.hikari.HikariConfig           : dataSourceProperties............{password=<masked>}
      2020-02-20 22:57:50.051 DEBUG 10224 --- [           main] com.zaxxer.hikari.HikariConfig           : driverClassName................."com.mysql.cj.jdbc.Driver"
      2020-02-20 22:57:50.051 DEBUG 10224 --- [           main] com.zaxxer.hikari.HikariConfig           : healthCheckProperties...........{}
      2020-02-20 22:57:50.051 DEBUG 10224 --- [           main] com.zaxxer.hikari.HikariConfig           : healthCheckRegistry.............none
      2020-02-20 22:57:50.051 DEBUG 10224 --- [           main] com.zaxxer.hikari.HikariConfig           : idleTimeout.....................10000
      2020-02-20 22:57:50.051 DEBUG 10224 --- [           main] com.zaxxer.hikari.HikariConfig           : initializationFailTimeout.......1
      2020-02-20 22:57:50.051 DEBUG 10224 --- [           main] com.zaxxer.hikari.HikariConfig           : isolateInternalQueries..........false
      2020-02-20 22:57:50.052 DEBUG 10224 --- [           main] com.zaxxer.hikari.HikariConfig           : jdbcUrl.........................jdbc:mysql://localhost:3306/schema_mysql?useSSL=false
      2020-02-20 22:57:50.052 DEBUG 10224 --- [           main] com.zaxxer.hikari.HikariConfig           : leakDetectionThreshold..........0
      2020-02-20 22:57:50.052 DEBUG 10224 --- [           main] com.zaxxer.hikari.HikariConfig           : maxLifetime.....................300000
      2020-02-20 22:57:50.052 DEBUG 10224 --- [           main] com.zaxxer.hikari.HikariConfig           : maximumPoolSize.................17
      2020-02-20 22:57:50.052 DEBUG 10224 --- [           main] com.zaxxer.hikari.HikariConfig           : metricRegistry..................none
      2020-02-20 22:57:50.052 DEBUG 10224 --- [           main] com.zaxxer.hikari.HikariConfig           : metricsTrackerFactory...........none
      2020-02-20 22:57:50.052 DEBUG 10224 --- [           main] com.zaxxer.hikari.HikariConfig           : minimumIdle.....................11
      2020-02-20 22:57:50.052 DEBUG 10224 --- [           main] com.zaxxer.hikari.HikariConfig           : password........................<masked>
      2020-02-20 22:57:50.052 DEBUG 10224 --- [           main] com.zaxxer.hikari.HikariConfig           : poolName........................"MysqlPool"
      2020-02-20 22:57:50.052 DEBUG 10224 --- [           main] com.zaxxer.hikari.HikariConfig           : readOnly........................false
      2020-02-20 22:57:50.052 DEBUG 10224 --- [           main] com.zaxxer.hikari.HikariConfig           : registerMbeans..................false
      2020-02-20 22:57:50.052 DEBUG 10224 --- [           main] com.zaxxer.hikari.HikariConfig           : scheduledExecutor...............none
      2020-02-20 22:57:50.052 DEBUG 10224 --- [           main] com.zaxxer.hikari.HikariConfig           : schema..........................none
      2020-02-20 22:57:50.052 DEBUG 10224 --- [           main] com.zaxxer.hikari.HikariConfig           : threadFactory...................internal
      2020-02-20 22:57:50.052 DEBUG 10224 --- [           main] com.zaxxer.hikari.HikariConfig           : transactionIsolation............default
      2020-02-20 22:57:50.052 DEBUG 10224 --- [           main] com.zaxxer.hikari.HikariConfig           : username........................"root"
      2020-02-20 22:57:50.052 DEBUG 10224 --- [           main] com.zaxxer.hikari.HikariConfig           : validationTimeout...............5000
      2020-02-20 22:57:50.052  INFO 10224 --- [           main] com.zaxxer.hikari.HikariDataSource       : MysqlPool - Starting...
      2020-02-20 22:57:50.179 DEBUG 10224 --- [           main] com.zaxxer.hikari.pool.HikariPool        : MysqlPool - Added connection com.mysql.cj.jdbc.ConnectionImpl@228bda54
      2020-02-20 22:57:50.180  INFO 10224 --- [           main] com.zaxxer.hikari.HikariDataSource       : MysqlPool - Start completed.
      2020-02-20 22:57:50.198  INFO 10224 --- [           main] org.hibernate.dialect.Dialect            : HHH000400: Using dialect: org.hibernate.dialect.MySQL8Dialect
      2020-02-20 22:57:50.282 DEBUG 10224 --- [ool housekeeper] com.zaxxer.hikari.pool.HikariPool        : MysqlPool - Before cleanup stats (total=1, active=0, idle=1, waiting=0)
      2020-02-20 22:57:50.282 DEBUG 10224 --- [ool housekeeper] com.zaxxer.hikari.pool.HikariPool        : MysqlPool - After cleanup  stats (total=1, active=0, idle=1, waiting=0)
      2020-02-20 22:57:50.286 DEBUG 10224 --- [onnection adder] com.zaxxer.hikari.pool.HikariPool        : MysqlPool - Added connection com.mysql.cj.jdbc.ConnectionImpl@770ede31
      2020-02-20 22:57:50.298 DEBUG 10224 --- [onnection adder] com.zaxxer.hikari.pool.HikariPool        : MysqlPool - Added connection com.mysql.cj.jdbc.ConnectionImpl@3633d40a
      2020-02-20 22:57:50.302 DEBUG 10224 --- [onnection adder] com.zaxxer.hikari.pool.HikariPool        : MysqlPool - Added connection com.mysql.cj.jdbc.ConnectionImpl@74fa6fa
      2020-02-20 22:57:50.305 DEBUG 10224 --- [onnection adder] com.zaxxer.hikari.pool.HikariPool        : MysqlPool - Added connection com.mysql.cj.jdbc.ConnectionImpl@561c2b45
      2020-02-20 22:57:50.309 DEBUG 10224 --- [onnection adder] com.zaxxer.hikari.pool.HikariPool        : MysqlPool - Added connection com.mysql.cj.jdbc.ConnectionImpl@22db280d
      2020-02-20 22:57:50.311 DEBUG 10224 --- [onnection adder] com.zaxxer.hikari.pool.HikariPool        : MysqlPool - Added connection com.mysql.cj.jdbc.ConnectionImpl@525291f0
      2020-02-20 22:57:50.314 DEBUG 10224 --- [onnection adder] com.zaxxer.hikari.pool.HikariPool        : MysqlPool - Added connection com.mysql.cj.jdbc.ConnectionImpl@430e2c26
      2020-02-20 22:57:50.316 DEBUG 10224 --- [onnection adder] com.zaxxer.hikari.pool.HikariPool        : MysqlPool - Added connection com.mysql.cj.jdbc.ConnectionImpl@7408bff2
      2020-02-20 22:57:50.319 DEBUG 10224 --- [onnection adder] com.zaxxer.hikari.pool.HikariPool        : MysqlPool - Added connection com.mysql.cj.jdbc.ConnectionImpl@4acc38c5
      2020-02-20 22:57:50.322 DEBUG 10224 --- [onnection adder] com.zaxxer.hikari.pool.HikariPool        : MysqlPool - Added connection com.mysql.cj.jdbc.ConnectionImpl@51f0ed39
      2020-02-20 22:57:50.322 DEBUG 10224 --- [onnection adder] com.zaxxer.hikari.pool.HikariPool        : MysqlPool - After adding stats (total=11, active=0, idle=11, waiting=0)
      Hibernate: 

          create table MOCKUP (
             ID integer not null,
              MOCKUP_DESC varchar(255),
              MOCKUP_NAME varchar(255),
              primary key (ID)
          ) engine=InnoDB
      2020-02-20 22:57:50.778  INFO 10224 --- [           main] o.h.e.t.j.p.i.JtaPlatformInitiator       : HHH000490: Using JtaPlatform implementation: [org.hibernate.engine.transaction.jta.platform.internal.NoJtaPlatform]
      2020-02-20 22:57:50.786  INFO 10224 --- [           main] j.LocalContainerEntityManagerFactoryBean : Initialized JPA EntityManagerFactory for persistence unit 'default'
      2020-02-20 22:57:50.799 DEBUG 10224 --- [           main] com.zaxxer.hikari.HikariConfig           : Driver class oracle.jdbc.OracleDriver found in Thread context class loader sun.misc.Launcher$AppClassLoader@73d16e93
      2020-02-20 22:57:50.806  INFO 10224 --- [           main] o.hibernate.jpa.internal.util.LogHelper  : HHH000204: Processing PersistenceUnitInfo [name: default]
      2020-02-20 22:57:50.818 DEBUG 10224 --- [           main] com.zaxxer.hikari.HikariConfig           : OraclePool - configuration:
      2020-02-20 22:57:50.818 DEBUG 10224 --- [           main] com.zaxxer.hikari.HikariConfig           : allowPoolSuspension.............false
      2020-02-20 22:57:50.818 DEBUG 10224 --- [           main] com.zaxxer.hikari.HikariConfig           : autoCommit......................true
      2020-02-20 22:57:50.818 DEBUG 10224 --- [           main] com.zaxxer.hikari.HikariConfig           : catalog.........................none
      2020-02-20 22:57:50.818 DEBUG 10224 --- [           main] com.zaxxer.hikari.HikariConfig           : connectionInitSql...............none
      2020-02-20 22:57:50.818 DEBUG 10224 --- [           main] com.zaxxer.hikari.HikariConfig           : connectionTestQuery.............none
      2020-02-20 22:57:50.819 DEBUG 10224 --- [           main] com.zaxxer.hikari.HikariConfig           : connectionTimeout...............60000
      2020-02-20 22:57:50.819 DEBUG 10224 --- [           main] com.zaxxer.hikari.HikariConfig           : dataSource......................none
      2020-02-20 22:57:50.819 DEBUG 10224 --- [           main] com.zaxxer.hikari.HikariConfig           : dataSourceClassName.............none
      2020-02-20 22:57:50.819 DEBUG 10224 --- [           main] com.zaxxer.hikari.HikariConfig           : dataSourceJNDI..................none
      2020-02-20 22:57:50.819 DEBUG 10224 --- [           main] com.zaxxer.hikari.HikariConfig           : dataSourceProperties............{password=<masked>}
      2020-02-20 22:57:50.819 DEBUG 10224 --- [           main] com.zaxxer.hikari.HikariConfig           : driverClassName................."oracle.jdbc.OracleDriver"
      2020-02-20 22:57:50.819 DEBUG 10224 --- [           main] com.zaxxer.hikari.HikariConfig           : healthCheckProperties...........{}
      2020-02-20 22:57:50.819 DEBUG 10224 --- [           main] com.zaxxer.hikari.HikariConfig           : healthCheckRegistry.............none
      2020-02-20 22:57:50.819 DEBUG 10224 --- [           main] com.zaxxer.hikari.HikariConfig           : idleTimeout.....................10000
      2020-02-20 22:57:50.819 DEBUG 10224 --- [           main] com.zaxxer.hikari.HikariConfig           : initializationFailTimeout.......1
      2020-02-20 22:57:50.819 DEBUG 10224 --- [           main] com.zaxxer.hikari.HikariConfig           : isolateInternalQueries..........false
      2020-02-20 22:57:50.819 DEBUG 10224 --- [           main] com.zaxxer.hikari.HikariConfig           : jdbcUrl.........................jdbc:oracle:thin:@172.20.10.4:1521:xe
      2020-02-20 22:57:50.819 DEBUG 10224 --- [           main] com.zaxxer.hikari.HikariConfig           : leakDetectionThreshold..........0
      2020-02-20 22:57:50.819 DEBUG 10224 --- [           main] com.zaxxer.hikari.HikariConfig           : maxLifetime.....................300000
      2020-02-20 22:57:50.819 DEBUG 10224 --- [           main] com.zaxxer.hikari.HikariConfig           : maximumPoolSize.................20
      2020-02-20 22:57:50.819 DEBUG 10224 --- [           main] com.zaxxer.hikari.HikariConfig           : metricRegistry..................none
      2020-02-20 22:57:50.819 DEBUG 10224 --- [           main] com.zaxxer.hikari.HikariConfig           : metricsTrackerFactory...........none
      2020-02-20 22:57:50.819 DEBUG 10224 --- [           main] com.zaxxer.hikari.HikariConfig           : minimumIdle.....................5
      2020-02-20 22:57:50.819 DEBUG 10224 --- [           main] com.zaxxer.hikari.HikariConfig           : password........................<masked>
      2020-02-20 22:57:50.819 DEBUG 10224 --- [           main] com.zaxxer.hikari.HikariConfig           : poolName........................"OraclePool"
      2020-02-20 22:57:50.819 DEBUG 10224 --- [           main] com.zaxxer.hikari.HikariConfig           : readOnly........................false
      2020-02-20 22:57:50.819 DEBUG 10224 --- [           main] com.zaxxer.hikari.HikariConfig           : registerMbeans..................false
      2020-02-20 22:57:50.819 DEBUG 10224 --- [           main] com.zaxxer.hikari.HikariConfig           : scheduledExecutor...............none
      2020-02-20 22:57:50.820 DEBUG 10224 --- [           main] com.zaxxer.hikari.HikariConfig           : schema..........................none
      2020-02-20 22:57:50.820 DEBUG 10224 --- [           main] com.zaxxer.hikari.HikariConfig           : threadFactory...................internal
      2020-02-20 22:57:50.820 DEBUG 10224 --- [           main] com.zaxxer.hikari.HikariConfig           : transactionIsolation............default
      2020-02-20 22:57:50.820 DEBUG 10224 --- [           main] com.zaxxer.hikari.HikariConfig           : username........................"C##ORGANIZATION"
      2020-02-20 22:57:50.820 DEBUG 10224 --- [           main] com.zaxxer.hikari.HikariConfig           : validationTimeout...............5000
      2020-02-20 22:57:50.820  INFO 10224 --- [           main] com.zaxxer.hikari.HikariDataSource       : OraclePool - Starting...
      2020-02-20 22:57:51.545 DEBUG 10224 --- [           main] com.zaxxer.hikari.pool.HikariPool        : OraclePool - Added connection oracle.jdbc.driver.T4CConnection@79be91eb
      2020-02-20 22:57:51.545  INFO 10224 --- [           main] com.zaxxer.hikari.HikariDataSource       : OraclePool - Start completed.
      2020-02-20 22:57:51.547  INFO 10224 --- [           main] org.hibernate.dialect.Dialect            : HHH000400: Using dialect: org.hibernate.dialect.Oracle12cDialect
      2020-02-20 22:57:51.646 DEBUG 10224 --- [ool housekeeper] com.zaxxer.hikari.pool.HikariPool        : OraclePool - Before cleanup stats (total=1, active=1, idle=0, waiting=0)
      2020-02-20 22:57:51.646 DEBUG 10224 --- [ool housekeeper] com.zaxxer.hikari.pool.HikariPool        : OraclePool - After cleanup  stats (total=1, active=1, idle=0, waiting=0)
      2020-02-20 22:57:51.677 DEBUG 10224 --- [onnection adder] com.zaxxer.hikari.pool.HikariPool        : OraclePool - Added connection oracle.jdbc.driver.T4CConnection@1bc628d8
      2020-02-20 22:57:51.704 DEBUG 10224 --- [onnection adder] com.zaxxer.hikari.pool.HikariPool        : OraclePool - Added connection oracle.jdbc.driver.T4CConnection@41410c20
      2020-02-20 22:57:51.730 DEBUG 10224 --- [onnection adder] com.zaxxer.hikari.pool.HikariPool        : OraclePool - Added connection oracle.jdbc.driver.T4CConnection@393b0c52
      2020-02-20 22:57:51.756 DEBUG 10224 --- [onnection adder] com.zaxxer.hikari.pool.HikariPool        : OraclePool - Added connection oracle.jdbc.driver.T4CConnection@4387de39
      2020-02-20 22:57:51.787 DEBUG 10224 --- [onnection adder] com.zaxxer.hikari.pool.HikariPool        : OraclePool - Added connection oracle.jdbc.driver.T4CConnection@3e9a83d1
      2020-02-20 22:57:51.787 DEBUG 10224 --- [onnection adder] com.zaxxer.hikari.pool.HikariPool        : OraclePool - After adding stats (total=6, active=1, idle=5, waiting=0)
      2020-02-20 22:58:20.284 DEBUG 10224 --- [ool housekeeper] com.zaxxer.hikari.pool.HikariPool        : MysqlPool - Before cleanup stats (total=11, active=0, idle=11, waiting=0)
      2020-02-20 22:58:20.284 DEBUG 10224 --- [ool housekeeper] com.zaxxer.hikari.pool.HikariPool        : MysqlPool - After cleanup  stats (total=11, active=0, idle=11, waiting=0)
      2020-02-20 22:58:21.648 DEBUG 10224 --- [ool housekeeper] com.zaxxer.hikari.pool.HikariPool        : OraclePool - Before cleanup stats (total=6, active=1, idle=5, waiting=0)
      2020-02-20 22:58:21.648 DEBUG 10224 --- [ool housekeeper] com.zaxxer.hikari.pool.HikariPool        : OraclePool - After cleanup  stats (total=6, active=1, idle=5, waiting=0)
      Hibernate: 

          create table MOCKUP (
             ID number(10,0) not null,
              MOCKUP_DESC varchar2(255 char),
              MOCKUP_NAME varchar2(255 char),
              primary key (ID)
          )
      2020-02-20 22:58:27.619  INFO 10224 --- [           main] o.h.e.t.j.p.i.JtaPlatformInitiator       : HHH000490: Using JtaPlatform implementation: [org.hibernate.engine.transaction.jta.platform.internal.NoJtaPlatform]
      2020-02-20 22:58:27.619  INFO 10224 --- [           main] j.LocalContainerEntityManagerFactoryBean : Initialized JPA EntityManagerFactory for persistence unit 'default'
      2020-02-20 22:58:27.628 DEBUG 10224 --- [           main] com.zaxxer.hikari.HikariConfig           : Driver class org.postgresql.Driver found in Thread context class loader sun.misc.Launcher$AppClassLoader@73d16e93
      2020-02-20 22:58:27.634  INFO 10224 --- [           main] o.hibernate.jpa.internal.util.LogHelper  : HHH000204: Processing PersistenceUnitInfo [name: default]
      2020-02-20 22:58:27.645 DEBUG 10224 --- [           main] com.zaxxer.hikari.HikariConfig           : PostgresPool - configuration:
      2020-02-20 22:58:27.646 DEBUG 10224 --- [           main] com.zaxxer.hikari.HikariConfig           : allowPoolSuspension.............false
      2020-02-20 22:58:27.646 DEBUG 10224 --- [           main] com.zaxxer.hikari.HikariConfig           : autoCommit......................true
      2020-02-20 22:58:27.646 DEBUG 10224 --- [           main] com.zaxxer.hikari.HikariConfig           : catalog.........................none
      2020-02-20 22:58:27.646 DEBUG 10224 --- [           main] com.zaxxer.hikari.HikariConfig           : connectionInitSql...............none
      2020-02-20 22:58:27.646 DEBUG 10224 --- [           main] com.zaxxer.hikari.HikariConfig           : connectionTestQuery.............none
      2020-02-20 22:58:27.646 DEBUG 10224 --- [           main] com.zaxxer.hikari.HikariConfig           : connectionTimeout...............60000
      2020-02-20 22:58:27.646 DEBUG 10224 --- [           main] com.zaxxer.hikari.HikariConfig           : dataSource......................none
      2020-02-20 22:58:27.646 DEBUG 10224 --- [           main] com.zaxxer.hikari.HikariConfig           : dataSourceClassName.............none
      2020-02-20 22:58:27.646 DEBUG 10224 --- [           main] com.zaxxer.hikari.HikariConfig           : dataSourceJNDI..................none
      2020-02-20 22:58:27.646 DEBUG 10224 --- [           main] com.zaxxer.hikari.HikariConfig           : dataSourceProperties............{password=<masked>}
      2020-02-20 22:58:27.646 DEBUG 10224 --- [           main] com.zaxxer.hikari.HikariConfig           : driverClassName................."org.postgresql.Driver"
      2020-02-20 22:58:27.646 DEBUG 10224 --- [           main] com.zaxxer.hikari.HikariConfig           : healthCheckProperties...........{}
      2020-02-20 22:58:27.646 DEBUG 10224 --- [           main] com.zaxxer.hikari.HikariConfig           : healthCheckRegistry.............none
      2020-02-20 22:58:27.646 DEBUG 10224 --- [           main] com.zaxxer.hikari.HikariConfig           : idleTimeout.....................10000
      2020-02-20 22:58:27.646 DEBUG 10224 --- [           main] com.zaxxer.hikari.HikariConfig           : initializationFailTimeout.......1
      2020-02-20 22:58:27.646 DEBUG 10224 --- [           main] com.zaxxer.hikari.HikariConfig           : isolateInternalQueries..........false
      2020-02-20 22:58:27.646 DEBUG 10224 --- [           main] com.zaxxer.hikari.HikariConfig           : jdbcUrl.........................jdbc:postgresql://localhost:5433/postgres
      2020-02-20 22:58:27.646 DEBUG 10224 --- [           main] com.zaxxer.hikari.HikariConfig           : leakDetectionThreshold..........0
      2020-02-20 22:58:27.646 DEBUG 10224 --- [           main] com.zaxxer.hikari.HikariConfig           : maxLifetime.....................300000
      2020-02-20 22:58:27.646 DEBUG 10224 --- [           main] com.zaxxer.hikari.HikariConfig           : maximumPoolSize.................15
      2020-02-20 22:58:27.646 DEBUG 10224 --- [           main] com.zaxxer.hikari.HikariConfig           : metricRegistry..................none
      2020-02-20 22:58:27.646 DEBUG 10224 --- [           main] com.zaxxer.hikari.HikariConfig           : metricsTrackerFactory...........none
      2020-02-20 22:58:27.647 DEBUG 10224 --- [           main] com.zaxxer.hikari.HikariConfig           : minimumIdle.....................5
      2020-02-20 22:58:27.647 DEBUG 10224 --- [           main] com.zaxxer.hikari.HikariConfig           : password........................<masked>
      2020-02-20 22:58:27.647 DEBUG 10224 --- [           main] com.zaxxer.hikari.HikariConfig           : poolName........................"PostgresPool"
      2020-02-20 22:58:27.647 DEBUG 10224 --- [           main] com.zaxxer.hikari.HikariConfig           : readOnly........................false
      2020-02-20 22:58:27.647 DEBUG 10224 --- [           main] com.zaxxer.hikari.HikariConfig           : registerMbeans..................false
      2020-02-20 22:58:27.647 DEBUG 10224 --- [           main] com.zaxxer.hikari.HikariConfig           : scheduledExecutor...............none
      2020-02-20 22:58:27.647 DEBUG 10224 --- [           main] com.zaxxer.hikari.HikariConfig           : schema.........................."schema_postgres"
      2020-02-20 22:58:27.647 DEBUG 10224 --- [           main] com.zaxxer.hikari.HikariConfig           : threadFactory...................internal
      2020-02-20 22:58:27.647 DEBUG 10224 --- [           main] com.zaxxer.hikari.HikariConfig           : transactionIsolation............default
      2020-02-20 22:58:27.647 DEBUG 10224 --- [           main] com.zaxxer.hikari.HikariConfig           : username........................"postgres"
      2020-02-20 22:58:27.647 DEBUG 10224 --- [           main] com.zaxxer.hikari.HikariConfig           : validationTimeout...............5000
      2020-02-20 22:58:27.647  INFO 10224 --- [           main] com.zaxxer.hikari.HikariDataSource       : PostgresPool - Starting...
      2020-02-20 22:58:27.882 DEBUG 10224 --- [           main] com.zaxxer.hikari.pool.HikariPool        : PostgresPool - Added connection org.postgresql.jdbc.PgConnection@20027c44
      2020-02-20 22:58:27.882  INFO 10224 --- [           main] com.zaxxer.hikari.HikariDataSource       : PostgresPool - Start completed.
      2020-02-20 22:58:27.886  INFO 10224 --- [           main] org.hibernate.dialect.Dialect            : HHH000400: Using dialect: org.hibernate.dialect.PostgreSQL10Dialect
      Hibernate: 

          create table MOCKUP (
             ID int4 not null,
              MOCKUP_DESC varchar(255),
              MOCKUP_NAME varchar(255),
              primary key (ID)
          )
      2020-02-20 22:58:27.950  INFO 10224 --- [           main] o.h.e.t.j.p.i.JtaPlatformInitiator       : HHH000490: Using JtaPlatform implementation: [org.hibernate.engine.transaction.jta.platform.internal.NoJtaPlatform]
      2020-02-20 22:58:27.950  INFO 10224 --- [           main] j.LocalContainerEntityManagerFactoryBean : Initialized JPA EntityManagerFactory for persistence unit 'default'
      2020-02-20 22:58:27.984 DEBUG 10224 --- [ool housekeeper] com.zaxxer.hikari.pool.HikariPool        : PostgresPool - Before cleanup stats (total=1, active=0, idle=1, waiting=0)
      2020-02-20 22:58:27.984 DEBUG 10224 --- [ool housekeeper] com.zaxxer.hikari.pool.HikariPool        : PostgresPool - After cleanup  stats (total=1, active=0, idle=1, waiting=0)
      2020-02-20 22:58:28.068 DEBUG 10224 --- [onnection adder] com.zaxxer.hikari.pool.HikariPool        : PostgresPool - Added connection org.postgresql.jdbc.PgConnection@39187945
      2020-02-20 22:58:28.132 DEBUG 10224 --- [onnection adder] com.zaxxer.hikari.pool.HikariPool        : PostgresPool - Added connection org.postgresql.jdbc.PgConnection@37df9016
      2020-02-20 22:58:28.184 DEBUG 10224 --- [onnection adder] com.zaxxer.hikari.pool.HikariPool        : PostgresPool - Added connection org.postgresql.jdbc.PgConnection@33e01235
      2020-02-20 22:58:28.252 DEBUG 10224 --- [onnection adder] com.zaxxer.hikari.pool.HikariPool        : PostgresPool - Added connection org.postgresql.jdbc.PgConnection@76e29a2d
      2020-02-20 22:58:28.252 DEBUG 10224 --- [onnection adder] com.zaxxer.hikari.pool.HikariPool        : PostgresPool - After adding stats (total=5, active=0, idle=5, waiting=0)
      2020-02-20 22:58:28.963  INFO 10224 --- [           main] o.s.s.concurrent.ThreadPoolTaskExecutor  : Initializing ExecutorService 'applicationTaskExecutor'
      2020-02-20 22:58:29.356  INFO 10224 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8000 (http) with context path ''
      2020-02-20 22:58:29.358  INFO 10224 --- [           main] paMultiDatabaseAndTransactionApplication : Started SpringBootJpaMultiDatabaseAndTransactionApplication in 41.989 seconds (JVM running for 42.354)
      2020-02-20 22:58:50.285 DEBUG 10224 --- [ool housekeeper] com.zaxxer.hikari.pool.HikariPool        : MysqlPool - Before cleanup stats (total=11, active=0, idle=11, waiting=0)
      2020-02-20 22:58:50.285 DEBUG 10224 --- [ool housekeeper] com.zaxxer.hikari.pool.HikariPool        : MysqlPool - After cleanup  stats (total=11, active=0, idle=11, waiting=0)
      2020-02-20 22:58:51.648 DEBUG 10224 --- [ool housekeeper] com.zaxxer.hikari.pool.HikariPool        : OraclePool - Before cleanup stats (total=6, active=0, idle=6, waiting=0)
      2020-02-20 22:58:51.650 DEBUG 10224 --- [ool housekeeper] com.zaxxer.hikari.pool.HikariPool        : OraclePool - After cleanup  stats (total=5, active=0, idle=5, waiting=0)
      2020-02-20 22:58:51.651 DEBUG 10224 --- [nnection closer] com.zaxxer.hikari.pool.PoolBase          : OraclePool - Closing connection oracle.jdbc.driver.T4CConnection@3e9a83d1: (connection has passed idleTimeout)
