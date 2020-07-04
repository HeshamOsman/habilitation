package com.app.habilitation.config;

import java.beans.PropertyVetoException;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.app.habilitation")
@PropertySource("classpath:application.properties")
public class DemoAppConfig {

	
	// Environment c'est lui qui permet de stocké les données apportés par "@PropertySource("classPath: persistence-mysql.properties")"
		@Autowired
		private Environment env;
		
		// définir le logger pour faire des tests
		
		private Logger logger = Logger.getLogger(getClass().getName());

		
		
		// definir un bean pour la sécurité de la datasource :
		
		@Bean
		public DataSource securityDataSource() {
			
			
			// create cnx pool
			
			ComboPooledDataSource securityDataSource = new ComboPooledDataSource();
			
			// set the jdbc driver class
			
			try {
				securityDataSource.setDriverClass(env.getProperty("spring.datasource.driver-class-name"));
			}
			
			catch(PropertyVetoException exc) {
				throw new RuntimeException(exc);
			}
			
			// log the cnx props
			
			logger.info("jdbc.url=" + env.getProperty("spring.datasource.url"));
			logger.info("jdbc.user=" + env.getProperty("spring.datasource.username"));
			
			// set database cnx props
			
			securityDataSource.setJdbcUrl(env.getProperty("spring.datasource.url"));
			securityDataSource.setUser(env.getProperty("spring.datasource.username"));
			securityDataSource.setPassword(env.getProperty("spring.datasource.password"));
			
			// set cnx pool props
			
			securityDataSource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
			securityDataSource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));
			securityDataSource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));
			securityDataSource.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));
			
			return securityDataSource;
		}
		
		// création d'une methode qui convertie une chaine string en int :
		
		private int getIntProperty(String propName) {
			
			String propVal = env.getProperty(propName);
			
			// convertion en int
			
			int intPropVal = Integer.parseInt(propVal);
			return intPropVal;
		}
}
