package com.gwtjs.icustom.webservice.autoconfigure;

import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by aGuang on 2016/12/9.
 */
@Configuration
@ImportResource("classpath*:/config/*-service.xml")
public class WebServiceAutoConfiguration {

	@Bean
	@ConfigurationProperties(prefix = "icustom-web-cxf-servlet")
	public CXFServletConstants cxfServletConfigure() {
		return new CXFServletConstants();
	}

	/**
	 * @return
	 */
	@Bean
	@ConditionalOnClass({ CXFServlet.class })
	public ServletRegistrationBean CXFServlet() {
		// CXFServletConstants cfg = this.cxfServletConfigure();
		CXFServlet servlet = new CXFServlet();
		ServletRegistrationBean registration = new ServletRegistrationBean(
				servlet);
		registration.setName("cxfServlet");
		/*
		 * registration.addInitParameter("hide-service-list-page",
		 * Boolean.toString(cfg.isHideServiceListPage()));
		 * registration.addInitParameter("disable-address-updates",
		 * Boolean.toString(cfg.isDisableAddressUpdates()));
		 */
		registration.addUrlMappings("/services/*");
		registration.setLoadOnStartup(1);
		return registration;
	}

}
