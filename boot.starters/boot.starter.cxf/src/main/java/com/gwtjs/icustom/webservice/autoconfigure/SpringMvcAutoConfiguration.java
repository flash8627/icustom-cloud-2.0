package com.gwtjs.icustom.webservice.autoconfigure;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.gwtjs.icustom.interceptor.SpringRestServiceRequestInterceptor;

@Configuration  
@EnableWebMvc
public class SpringMvcAutoConfiguration extends WebMvcConfigurerAdapter {
	
	@Bean
	@ConditionalOnClass({ DispatcherServlet.class })
	public ServletRegistrationBean springMvc(DispatcherServlet dispatcherServlet) {
		ServletRegistrationBean registration = new ServletRegistrationBean(
				dispatcherServlet);
		registration.setName("springMvcServlet");	
		registration.getUrlMappings().clear();
		registration.addUrlMappings(String.format("/%s/services/*",
				RequestContextConstants.TYPE_SPRINGMVC));// 鍏ч儴鏈嶅姟
		registration.addUrlMappings(String.format("/%s/internalservices/*",
				RequestContextConstants.TYPE_SPRINGMVC));// 鍏ч儴鏈嶅姟锛宻so璁よ瘉
		registration.addUrlMappings(String.format("/%s/publicservices/*",
				RequestContextConstants.TYPE_SPRINGMVC));// 澶栭儴鍏叡鏈嶅姟锛孲gavence绠℃帶
		registration.setLoadOnStartup(2);
		//registration.setLoadOnStartup(0);
		//registration.setOrder(Ordered.HIGHEST_PRECEDENCE);

		return registration;
	}

	@Bean
	public SpringRestServiceRequestInterceptor springRestServiceRequestInterceptor() {
		return new SpringRestServiceRequestInterceptor();
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(springRestServiceRequestInterceptor());
	}
}
