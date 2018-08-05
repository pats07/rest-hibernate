package org.api.resthibernate.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:database.properties")
public class DatabaseConfiguration {

	private static final String DB_DRIVER_CLASS= "oracle.db.driver";
	private static final String DB_URL	= "oracle.db.url";
	private static final String DB_USERNAME = "oracle.db.usrname";
	private static final String DB_PASSWORD = "oracle.db.password";
	
	@Autowired
	private Environment env;
	
	@Bean
	public DataSource getDatasource() {
		DriverManagerDataSource datasource = new DriverManagerDataSource();
		datasource.setDriverClassName(env.getProperty(DB_DRIVER_CLASS));
		datasource.setUrl(env.getProperty(DB_URL));
		datasource.setUsername(env.getProperty(DB_USERNAME));
		datasource.setPassword(env.getProperty(DB_PASSWORD));
		return datasource;
	}

	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(getDatasource());
		sessionFactory.setPackagesToScan("org.api.resthibernate.domain");
		sessionFactory.setHibernateProperties(hibernateProperties());
		return sessionFactory;
	}

	@Bean
	public PlatformTransactionManager hibernateTransactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory().getObject());
		return transactionManager;
	}

	private Properties hibernateProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.hbm2ddl.auto", "update");
		properties.setProperty("hibernate.dialect",	"org.hibernate.dialect.Oracle10gDialect");
		properties.setProperty("show_sql", "true");
		return properties;
	}

}
