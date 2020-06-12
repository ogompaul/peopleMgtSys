package com.myGPSPackage.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
public class GPSConfigClass {
	@Autowired
	private Environment env;

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/GPS?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
		ds.setUsername("Patrick");
		ds.setPassword("password");
		ds.setConnectionProperties(hibernateProperties());
		return (DataSource) ds;
	}
	
	@Bean
	public EntityManagerFactory entityManagerFactory() {
		HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
		jpaVendorAdapter.setGenerateDdl(true);

		LocalContainerEntityManagerFactoryBean lcemfb = new LocalContainerEntityManagerFactoryBean();
		lcemfb.setDataSource(dataSource());
		lcemfb.setJpaVendorAdapter(jpaVendorAdapter);
		lcemfb.setPackagesToScan("com.myGPSPackage.models");
		lcemfb.setJpaProperties(hibernateProperties());
		//lcemfb.setDataSource(dataSource());
		lcemfb.setPersistenceUnitName("PERSISTENCE");
		lcemfb.afterPropertiesSet();

		return lcemfb.getObject();
	}
	
	// it should be private not public?
	@Bean
	public Properties hibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", env.getRequiredProperty("hibernate.dialect"));
		properties.put("hibernate.show_sql", env.getRequiredProperty("hibernate.show_sql"));
		properties.put("hibernate.ddl-auto", env.getRequiredProperty("hibernate.ddl-auto"));
		properties.put("hibernate.connection.driver_class",
				env.getRequiredProperty("hibernate.connection.driver_class"));
		properties.put("hibernate.connection.url", env.getRequiredProperty("hibernate.connection.url"));
		properties.put("hibernate.connection.username",
				env.getRequiredProperty("hibernate.connection.username"));
		properties.put("hibernate.connection.password",
				env.getRequiredProperty("hibernate.connection.password"));
		properties.put("spring.jpa.open-in-view", env.getRequiredProperty("spring.jpa.open-in-view"));
		return properties;
	}

	// @Bean
	/*public SessionFactory sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan(new String[] { "com.status.servlet" });
		sessionFactory.setHibernateProperties(hibernateProperties());

		return (SessionFactory) sessionFactory;
	}*/
	
	//Thymeleaf setting	 
	 /*
	 @Override
	    public void addResourceHandlers(ResourceHandlerRegistry registry) {
	        registry.addResourceHandler(
	                "/webjars/**",
	                "/img/**",
	                "/css/**",
	                "/js/**")
	                .addResourceLocations(
	                        "classpath:/META-INF/resources/webjars/",
	                        "classpath:/static/img/",
	                        "classpath:/static/css/",
	                        "classpath:/static/js/");
	    }*/

}
