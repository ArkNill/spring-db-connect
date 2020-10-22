package kr.com.inspect.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@PropertySource(value = "classpath:db.properties")
@EnableTransactionManagement
@EnableJpaRepositories({"kr.com.inspect.repository"})
public class PostgreConfig {
	
	/* JDBC 정보 */
	@Value("${jdbc.driverClassName}") 
	private String driverClassName;
	
	@Value("${jdbc.url}")
	private String url;
	
	@Value("${jdbc.username}")
	private String userName;
	
	@Value("${jdbc.password}")
	private String password;
	
	/* Hibernate 정보 */
	@Value("${hibernate.dialect}")
	private String dialect;
	
	@Value("${hibernate.show_sql}")
	private String showSql;
	
	@Value("${hibernate.format_sql}")
	private String formatSql;
	
	@Value("${hibernate.hbm2ddl.auto}")
	private String hbm2ddlAuto;
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(url);
		dataSource.setUsername(userName);
		dataSource.setPassword(password);
		return (DataSource)dataSource;
	}
	  
	private Properties hibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", dialect);
		properties.put("hibernate.show_sql", showSql);
		properties.put("hibernate.format_sql", formatSql);
		properties.put("hibernate.hbm2ddl.auto", hbm2ddlAuto);
		return properties;
	}
	  
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource());
		em.setPackagesToScan(new String[] { "kr.com.inspect.entity" });
		HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter((JpaVendorAdapter)hibernateJpaVendorAdapter);
		em.setJpaProperties(hibernateProperties());
		return em;
	}
	  
	@Bean
	public PlatformTransactionManager transactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
		return (PlatformTransactionManager)transactionManager;
	}
}
