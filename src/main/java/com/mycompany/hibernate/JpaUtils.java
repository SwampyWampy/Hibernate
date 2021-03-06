/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hibernate;

import java.util.Properties;
import lombok.experimental.UtilityClass;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author Paweł
 */
@UtilityClass
public class JpaUtils {
	
	public SessionFactory getSessionFactory() {

//		System.setProperty(org.slf4j.impl.SimpleLogger.DEFAULT_LOG_LEVEL_KEY, "error");
		System.setProperty("org.jboss.logging.provider", "slf4j");

		Properties properties = new Properties();
		properties.setProperty("hibernate.connection.driver_class", "org.h2.Driver");
		properties.setProperty("hibernate.connection.url", "jdbc:h2:mem:test");
		properties.setProperty("hibernate.connection.username", "sa");
		properties.setProperty("hibernate.connection.password", "");
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		properties.setProperty("hibernate.hbm2ddl.auto", "update");
//		properties.setProperty("hibernate.connection.pool_size", "1");

		properties.setProperty("hibernate.show_sql", "true");
		properties.setProperty("hibernate.format_sql", "true");
		properties.setProperty("hibernate.use_sql_comments", "true");
//		properties.setProperty("hibernate.temp.use_jdbc_metadata_defaults", "false");
		

		Configuration configuration = new Configuration().addProperties(properties);
		configuration.addAnnotatedClass(Student.class);
		configuration.addAnnotatedClass(Teacher.class);
                configuration.addAnnotatedClass(Clas.class);
		configuration.addAnnotatedClass(Subject.class);
                configuration.addAnnotatedClass(Grade.class);
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		return sessionFactory;
	}
	
}
