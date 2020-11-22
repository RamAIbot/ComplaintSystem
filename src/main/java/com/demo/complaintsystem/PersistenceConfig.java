package com.demo.complaintsystem;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.apache.tomcat.dbcp.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@PropertySource({"classpath:database-properties.properties"})
@ComponentScan({"com.demo.complaintsystem"})

public class PersistenceConfig {

	@Autowired
	private Environment env;
	
	@Bean
	@Autowired
	public HibernateTransactionManager transcationManager(SessionFactory sessionFactory) {
		HibernateTransactionManager tran =  new HibernateTransactionManager();
		tran.setSessionFactory(sessionFactory);
		return tran;
	}
	
	@Bean LocalSessionFactoryBean sessionFactory()
	{
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan(new String[] {"com.demo.complaintsystem.entities"});
		sessionFactory.setHibernateProperties(hibernateConfig());
		return sessionFactory;
	}
	
	@Bean
	public DataSource dataSource()
	{
	BasicDataSource dataSource = new BasicDataSource();
	dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
	dataSource.setUrl(env.getProperty("jdbc.url"));
	dataSource.setUsername(env.getProperty("jdbc.user"));
	dataSource.setPassword(env.getProperty("jdbc.password"));
	return dataSource;
	}
	
	Properties hibernateConfig() {
		Properties toReturn =  new Properties();
		toReturn.setProperty("hibernate.hdm2ddl.auto", env.getProperty("hibernate.hdm2ddl.auto"));
		toReturn.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
		toReturn.setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
		return toReturn;
	}
}
