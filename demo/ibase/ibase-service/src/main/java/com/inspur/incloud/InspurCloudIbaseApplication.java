package com.inspur.incloud;

import javax.persistence.EntityManagerFactory;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.inspur.incloud.common.util.SpringContextUtil;

/**
 * The ibase application.
 *
 * @author lvxianguo
 */
@EnableTransactionManagement(proxyTargetClass=true)
@SpringBootApplication
@SpringBootConfiguration
@EnableFeignClients
@ServletComponentScan
public class InspurCloudIbaseApplication {

	/**
	 * The entry point of application.
	 *
	 * @param args the input arguments
	 */
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(InspurCloudIbaseApplication.class, args);
		SpringContextUtil.setApplicationContext(context);
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
	@Bean
	@Autowired
	public JpaTransactionManager transactionManager() {
	    final JpaTransactionManager transactionManager = new JpaTransactionManager();
	    transactionManager.setEntityManagerFactory(entityManagerFactory);
	    return transactionManager;
	}
}
