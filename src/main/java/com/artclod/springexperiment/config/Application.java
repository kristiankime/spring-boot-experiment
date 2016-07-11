package com.artclod.springexperiment.config;

import com.artclod.springexperiment.ComponentPackage;
import com.artclod.springexperiment.db.dto.DTOPackage;
import com.artclod.springexperiment.db.entity.EntityPackage;
import com.artclod.springexperiment.db.repository.JPARepositoryPackage;
import hello.HelloController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackageClasses = { ComponentPackage.class, HelloController.class })
@EnableJpaRepositories(basePackageClasses = { JPARepositoryPackage.class })
@EntityScan(basePackageClasses = { EntityPackage.class, DTOPackage.class })
@PropertySource("classpath:application.properties")
public class Application extends SpringBootServletInitializer {
	private static final Class<Application> APPLICATION_CLASS = Application.class;

	public static void main(String[] args) {
		SpringApplication.run(APPLICATION_CLASS, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(APPLICATION_CLASS);
	}

}