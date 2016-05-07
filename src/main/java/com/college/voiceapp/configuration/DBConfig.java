package com.college.voiceapp.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:app.properties")
@ComponentScan(basePackages = "com.test")
public class DBConfig {
	@Autowired
	Environment env;

	@Bean(name = "dataSource")
	public DataSource getDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
		dataSource.setUrl(env.getProperty("jdbc.databaseurl"));
		dataSource.setUsername(env.getProperty("jdbc.username"));
		dataSource.setPassword(env.getProperty("jdbc.password"));
		return dataSource;
	}

	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory() throws Exception {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", env.getProperty("jdbc.dialect"));
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.hbm2ddl.auto", "create");
		/*properties.put("current_session_context_class", "thread");*/
		LocalSessionFactoryBean factory = new LocalSessionFactoryBean();
		factory.setPackagesToScan(new String[] { "com.college.voiceapp.entites" });
		factory.setDataSource(getDataSource());
		factory.setHibernateProperties(properties);
		factory.afterPropertiesSet();
		return factory.getObject();
	}

	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager() throws Exception {
		return new HibernateTransactionManager(getSessionFactory());
	}
	
	@Bean(name = "TstDao")
	public TstDao getTstDao()  {
		return new TstDao();
	}
}
