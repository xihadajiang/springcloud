package com.inspur.incloud.ibase;

import javax.persistence.EntityManagerFactory;

import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernateEntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * The ibase application.
 *
 * @author lvxianguo
 */
@EnableTransactionManagement
@SpringBootApplication
public class InspurCloudIbaseApplication {

	/**
	 * The entry point of application.
	 *
	 * @param args the input arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(InspurCloudIbaseApplication.class, args);
	}
	
	 @Autowired
	 private EntityManagerFactory entityManagerFactory;
	 
	@Bean
	public SessionFactory getSessionFactory() {
	   if (entityManagerFactory.unwrap(SessionFactory.class) == null) {
	      throw new NullPointerException("factory is not a hibernate factory");
	   }
	   return entityManagerFactory.unwrap(SessionFactory.class);
     }
}
