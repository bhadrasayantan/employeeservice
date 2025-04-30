package com.example.employeeservice.configuration;

import java.util.Properties;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.envers.repository.support.EnversRevisionRepositoryFactoryBean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.orm.jpa.JpaDialect;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.support.SharedEntityManagerBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.example.employeeservice.repo.employee", repositoryFactoryBeanClass = EnversRevisionRepositoryFactoryBean.class)
public class PersistenceConfiguration {
	@Autowired
	private DataSourceConfiguration configuration;
	@Bean(name="dataSource")
	public DataSource datasource() throws IllegalArgumentException, NamingException {
		HikariConfig config = new HikariConfig();
		config.setDataSourceJNDI("java:comp/env/" + configuration.getJndiName());
		config.setConnectionTimeout(configuration.getConnectionTimeOut());
		config.setIdleTimeout(configuration.getIdleTimeout());
		config.setKeepaliveTime(configuration.getKeepAliveTime());
		config.setLeakDetectionThreshold(configuration.getLeakDetectionThreshhold());
		config.setMaxLifetime(configuration.getMaxLifeTime());
		config.setMaximumPoolSize(configuration.getMaxPoolSize());
		config.setMinimumIdle(configuration.getMinIdle());
		config.setValidationTimeout(configuration.getValidationTimeout());
		return new HikariDataSource(config);
	}
	@Bean(name="jpaVendorAdapter")
	public JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
		jpaVendorAdapter.setDatabase(Database.MYSQL);
		return jpaVendorAdapter;
	}
	@Bean(name="jpaDialect")
	public JpaDialect jpaDialect() {
		return new HibernateJpaDialect();
		
	}

	@Bean(name="entityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource,JpaVendorAdapter jpaVendorAdapter,JpaDialect jpaDialect)
			throws IllegalArgumentException, NamingException {
		final LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		emf.setDataSource(dataSource);
		emf.setPersistenceUnitName("EmployeeServicePU");
		emf.setPackagesToScan("com.example.employeeservice.entity");
		emf.setJpaVendorAdapter(jpaVendorAdapter);
		emf.setJpaDialect(jpaDialect);
		emf.setJpaProperties(hibernateProperties());
		return emf;
	}
	@Bean(name="entityManager")
	public SharedEntityManagerBean entityManager(EntityManagerFactory entityManagerFactory) {
		SharedEntityManagerBean entityManager = new SharedEntityManagerBean();
		entityManager.setEntityManagerFactory(entityManagerFactory);
		return entityManager;
		
	}
	
	@Primary
	@Bean(name="txJpa")
    public PlatformTransactionManager jpaTransactionManager(EntityManagerFactory entityManagerFactory) throws IllegalArgumentException, NamingException {
        final JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }
	@Bean(name="jdbcTemplate")
	public JdbcTemplate jdbcTemplate() throws IllegalArgumentException, NamingException {
		return new JdbcTemplate(datasource());
	}
	@Bean(name="transactionManager")
	@Qualifier("txJdbc")
	public PlatformTransactionManager jdbcTransactionManager(DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}

	private final Properties hibernateProperties() {
		final Properties hibernateProperties = new Properties();
		hibernateProperties.setProperty("hibernate.max_fetch_depth",configuration.getMaxFetchDepth());
		hibernateProperties.setProperty("hibernate.jdbc.fetch_size",configuration.getJdbcFetchSize());
		hibernateProperties.setProperty("hibernate.jdbc.batch_size",configuration.getJdbcBatchSize());
		hibernateProperties.setProperty("hibernate.order_updates",configuration.getOrderUpdates());
		hibernateProperties.setProperty("hibernate.order_inserts",configuration.getOrderInserts());
		hibernateProperties.setProperty("hibernate.default_schema",configuration.getDefaultSchema());
		hibernateProperties.setProperty("hibernate.param_null_passing",configuration.getNullProcParam());
		hibernateProperties.setProperty("hibernate.format_sql",configuration.getFormatSql());
		hibernateProperties.setProperty("hibernate.show_sql",configuration.getShowSql());
		hibernateProperties.setProperty("hibernate.dialect",configuration.getDialect());
		hibernateProperties.setProperty("hibernate.hbm2ddl.auto",configuration.getDdlAuto());
		hibernateProperties.setProperty("hibernate.implicit_naming_strategy",configuration.getImplicitNamingStrategy());
		hibernateProperties.setProperty("hibernate.physical_naming_strategy",configuration.getPhysicalNamingStrategy());
		hibernateProperties.setProperty("hibernate.show-sql",configuration.getShowSql());



		return hibernateProperties;
	}
}
