package com.shopping.shoppingBackend.config;

import java.util.Properties;

import javax.activation.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = {"com.shopping.shoppingBackend.dto"})
@EnableTransactionManagement 
public class HibernateConfig {

	private final static String DATABASE_URL = "jdbc:mysql://localhost:3306/onlineshopping?useSSL=false";
	private final static String DATABASE_DRIVER = "com.mysql.jdbc.Driver";
	private final static String DATABASE_DIALECT = "org.hibernate.dialect.MySQL5Dialect";
	private final static String DATABASE_USERNAME = "root";
	private final static String DATABASE_PASSWORD = "1234567";
	
	//DATASOURCE BEAN
	@Bean
	private DataSource getDataSource() {
		
		//Providing Database Information //
		BasicDataSource datasource = new BasicDataSource();
		datasource.setDriverClassName(DATABASE_DRIVER);
		datasource.setUrl(DATABASE_URL);
		datasource.setUsername(DATABASE_USERNAME);
		datasource.setPassword(DATABASE_PASSWORD);
		return (DataSource) datasource;
		
		
	}
	
	//SESSION FACTORY BEAN
	@Bean
	public SessionFactory getSessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder((javax.sql.DataSource) dataSource);
		builder.addProperties(getHibernateProperties());
		
		builder.scanPackages("com.shopping.shoppingBackend.dto");
		
		return builder.buildSessionFactory();
	}

	
	//All THE HIBERNATE PROPERTIES WILL BE RETURNED HERE
	private Properties getHibernateProperties() {
		Properties prop = new Properties();
		
		prop.put("hibernate.dialect", DATABASE_DIALECT);
		prop.put("hibernate.show_sql", "true");
		prop.put("hibernate.hbm2ddl.auto", "create");
		return prop;
	}
	
	// HIBERNATE TRANSACTION BEAN
	@Bean
	public HibernateTransactionManager geTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
	return transactionManager; 
	
	}
}
