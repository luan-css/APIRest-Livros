package com.gft.socialbooks.openapi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SpringFoxConfig implements WebMvcConfigurer {

	@Bean
	public Docket apiDocket() {
		return new Docket(DocumentationType.SWAGGER_2).
				select().
				apis(RequestHandlerSelectors.basePackage("com.gft.socialbooks.resorces"))
				.build()
				.apiInfo(apiInfo())
				.tags(new Tag("Livros", "Gerencia os Livros"), new Tag("Autores", "Gerencia os Autores"));
	}
	
	public ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("Livros API")
				.description("Api aberta para clientes")
				.version("1")
				.contact(new Contact("Guilherme Azevedo", "github.com/gui-azesantos", "gui-azesantos@hotmail.com"))
				.build();
	}
	
	public void addResourceHandler(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/");
	}
	
	
}
