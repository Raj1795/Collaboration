package com.trios.collaborate.Config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;


import com.trios.collaborate.dao.BlogDAO;
import com.trios.collaborate.dao.BlogDAOImpl;
import com.trios.collaborate.dao.ForumDAO;
import com.trios.collaborate.dao.ForumDAOImpl;
import com.trios.collaborate.model.Blog;
import com.trios.collaborate.model.Forum;

@Configuration
@ComponentScan("com.trios.collaborate")
@EnableTransactionManagement
public class DBConfig {

	public DataSource getOracleDataSource()
	{
		DriverManagerDataSource driverManagerDataSource=new DriverManagerDataSource();
		driverManagerDataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		driverManagerDataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE ");
		driverManagerDataSource.setUsername("collabration");
		driverManagerDataSource.setPassword("trios1795");
		
		return driverManagerDataSource;
		}
	public Properties getHibernateProperties()
	{
		Properties properties =new Properties();
		properties.setProperty("hibernate.hbm2ddl.auto","update");
		properties.put("hibernate.dialect","org.hibernate.dialect.Oracle10gDialect");
		
		return properties;
	}
	@Bean
	public SessionFactory getSessionFactory()
	{
		LocalSessionFactoryBuilder localSessionFactoryBuilder=new LocalSessionFactoryBuilder(getOracleDataSource());
		localSessionFactoryBuilder.addProperties(getHibernateProperties());
		localSessionFactoryBuilder.addAnnotatedClass(Blog.class);
		//localSessionFactoryBuilder.addAnnotatedClass(Forum.class);
		System.out.println("SessionFactory Bean Created");
		return localSessionFactoryBuilder.buildSessionFactory();
	}
	@Bean
	public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory)
	{
		return new HibernateTransactionManager(sessionFactory);
	}
	@Bean
	public BlogDAO getBlogDAO(SessionFactory sessionFactory)
	{
		return new BlogDAOImpl(sessionFactory);
	}
	@Bean
	public ForumDAO getForumDAO(SessionFactory sessionFactory)
	{
		return new ForumDAOImpl(sessionFactory);
	}
}
