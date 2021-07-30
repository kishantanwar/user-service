package com.epam.user;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	private ApiInfo getApiInfo() {

		return new ApiInfoBuilder().title("User Service")
				.description("user-service")
				.contact(new Contact("Kishan Tanwar", "-",
						"kishan.mca.du@gmail.com"))
				.license("User Service").licenseUrl("-").version("1.0.0").build();
	}

	
	@Bean
	public Docket swaggerApi() {

		return new Docket(DocumentationType.SWAGGER_2).forCodeGeneration(true).apiInfo(getApiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("com.epam.user")).paths(PathSelectors.any()).build();
	}
}