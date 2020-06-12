package com.websocket;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
//@ComponentScan({ "com." })
//@PropertySource(value = {"classpath:application.properties"})
public class WebSocketAppConfig {
	
	@Autowired
	private Environment environment;
		
	@Bean
	public DataSource dataSource() {		
		
		 DriverManagerDataSource dataSource = new DriverManagerDataSource();		 
		 dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		 dataSource.setUrl("jdbc:mysql://localhost:3306/DB_sample?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
		 dataSource.setUsername("patrick");
		 dataSource.setPassword("Umuamanu1");
		 dataSource.setConnectionProperties(hibernateProperties());
		 		
		/*DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getRequiredProperty("spring.datasource.driverClassName"));
        dataSource.setUrl(environment.getRequiredProperty("spring.datasource.url"));
        dataSource.setUsername(environment.getRequiredProperty("spring.datasource.username"));
        dataSource.setPassword(environment.getRequiredProperty("spring.datasource.password"));
         dataSource.setConnectionProperties(hibernateProperties());*/
		
        return (DataSource)dataSource;
		
		//return (DataSource) source;
	}
	
	@Bean
	public EntityManagerFactory entityManagerFactory() {
		HibernateJpaVendorAdapter vendor = new HibernateJpaVendorAdapter();
		vendor.setGenerateDdl(true);
		
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		
		factory.setDataSource(dataSource());
		//factory.setJpaDialect(jpaDialect);
		factory.setJpaVendorAdapter(vendor);
		//factory.getPersistenceUnitInfo();
		factory.setPackagesToScan("com.websocket");
		// factory.setPersistenceUnitName("org.hibernate.jpa.HibernatePersistenceProvider");
		factory.setPersistenceUnitName("PERSISTENCE");
		//factory.afterPropertiesSet();
		factory.setJpaProperties(hibernateProperties());
		factory.setPersistenceProviderClass(HibernatePersistenceProvider.class);		
		factory.afterPropertiesSet();
		return factory.getObject();
	}
	
	@Bean
	public Properties hibernateProperties() {
		Properties properties = new Properties();
	      properties.put("hibernate.dialect", environment.getRequiredProperty("spring.jpa.properties.hibernate.dialect"));
	      properties.put("hibernate.show_sql", environment.getRequiredProperty("spring.jpa.show-sql"));
		  properties.put("spring.data.jpa.repositories.enabled", environment.getRequiredProperty("spring.data.jpa.repositories.enabled"));
	      properties.put("spring.jpa.hibernate.ddl-auto", environment.getRequiredProperty("spring.jpa.hibernate.ddl-auto"));
		  properties.put("spring.jpa.hibernate.use-new-id-generator-mappings", environment.getRequiredProperty("spring.jpa.hibernate.use-new-id-generator-mappings"));
	      properties.put("spring.jpa.open-in-view", environment.getRequiredProperty("spring.jpa.open-in-view"));
		/*
		 * properties.put("spring.jpa.properties.hibernate.dialect",
		 * "org.hibernate.dialect.MySQL5Dialect"); properties.put("hibernate.show_sql",
		 * true); properties.put("spring.data.jpa.repositories.enabled", true);
		 * properties.put("spring.jpa.hibernate.ddl-auto", "update");
		 * properties.put("spring.jpa.hibernate.use-new-id-generator-mappings", true);
		 * properties.put("spring.jpa.open-in-view", false);
		 */
	        return properties;
	}

}
