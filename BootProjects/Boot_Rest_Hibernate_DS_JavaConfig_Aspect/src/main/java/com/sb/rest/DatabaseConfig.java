package com.sb.rest;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
/*
 *   Datasource using Java Configuration
 */

@Configuration
@PropertySource("persistence-user.properties")
@EnableTransactionManagement
public class DatabaseConfig {

	@Autowired
    private Environment env;
	
 
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource  ds = new DriverManagerDataSource ();
        ds.setDriverClassName(env.getProperty("jdbc.driverClassName"));
        ds.setUrl(env.getProperty("jdbc.url"));
        ds.setUsername(env.getProperty("jdbc.user"));
        ds.setPassword(env.getProperty("jdbc.pass"));
 
        return ds;
    }
 
    private final Properties hibernateProperties() {
    	final Properties hibProps = new Properties();
		hibProps.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
    	hibProps.setProperty("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
    	hibProps.setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
        return hibProps;
    }
    
	@Bean
    public LocalSessionFactoryBean sessionFactory() {
        final LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        
        sessionFactory.setPackagesToScan(new String[] {"com.sb"});
        sessionFactory.setHibernateProperties(hibernateProperties());
 
        return sessionFactory;
    }
	
	@Bean
	   public PlatformTransactionManager transactionManager(){
	      JpaTransactionManager transactionManager
	        = new JpaTransactionManager();
	      transactionManager.setEntityManagerFactory(
	    		  sessionFactory().getObject() );
	      return transactionManager;
	   }
    
}
