package com.gwtjs.icustom.cloud.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * NoSuchMethodError: com.google.common.collect.FluentIterable.concat
 * @author zheng
 *
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {
	
	@Value("${server.version}")
	String version="1.0";
	
	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		String name = "dongzhengguang";
		String url = "flash8627@hotmail.com";
		String email = "flash8627@hotmail.com";;
		Contact contact = new Contact(name, url, email);
		
		return new ApiInfoBuilder().title("说明文档").description("接口说明文档").termsOfServiceUrl("")
				.contact(contact).version(version)
				.build();
	}
}
