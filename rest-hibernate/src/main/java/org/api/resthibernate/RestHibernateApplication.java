package org.api.resthibernate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"org.api.resthibernate"})
public class RestHibernateApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestHibernateApplication.class, args);
	}
}