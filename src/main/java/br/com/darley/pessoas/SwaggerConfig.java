package br.com.darley.pessoas;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket pessoaApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("br.com.darley.pessoas"))
				.paths(regex("/pessoas.*"))
				.build()
				.apiInfo(metaInfo());
	}
	

	private ApiInfo metaInfo() {
		@SuppressWarnings("rawtypes")
		ApiInfo apiInfo = new ApiInfo(
				"Spring Boot Swagger - Pessoas e seus endereços",
				"Para as pessoas verem seus endereços",
				"1.0",
				"terms of Service",
				new Contact("Darley Cardoso", "https://www.youtube.com/channel/UCeEhWnFX5ZQQJ8aDsWGyusw",
						"garciacardoso.darley@gmail.com"),
						"Apache License Version",
						"https://www.apache.org/licesen.html",
						new ArrayList<VendorExtension>());
		return apiInfo ;
	}
}
