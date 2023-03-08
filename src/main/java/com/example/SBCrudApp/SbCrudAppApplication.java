package com.example.SBCrudApp;

import jakarta.persistence.EntityManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import jakarta.persistence.metamodel.Type;

@SpringBootApplication
public class SbCrudAppApplication {

	//comment for aniket
	public static void main(String[] args) {
		SpringApplication.run(SbCrudAppApplication.class, args);
	}

	@Bean
	public RepositoryRestConfigurer repositoryRestConfigurer(EntityManager entityManager) {
		return RepositoryRestConfigurer.withConfig(config -> {
			config.exposeIdsFor(entityManager.getMetamodel().getEntities()
					.stream().map(Type::getJavaType).toArray(Class[]::new));
		});
	}

}
