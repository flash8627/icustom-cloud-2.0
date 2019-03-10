package com.gwtjs.icustom;


import org.springframework.boot.SpringApplication;
/*import org.springframework.boot.actuate.endpoint.MetricReaderPublicMetrics;
import java.util.Collections;
import org.springframework.boot.actuate.endpoint.MetricsEndpoint;
import org.springframework.boot.actuate.metrics.reader.MetricRegistryMetricReader;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import com.codahale.metrics.MetricRegistry;*/
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@EnableEurekaClient
@SpringBootApplication
public class ICustomCxfApplication {

	public static void main(String[] args) {
		SpringApplication.run(ICustomCxfApplication.class, args);
	}
	
	/*@Bean
    public MetricRegistry metricRegistry() {
        return new MetricRegistry();
    }

    @Bean
    public MetricsEndpoint metricsEndpoint(final MetricRegistry registry) {
        return new MetricsEndpoint(Collections.singleton(new MetricReaderPublicMetrics(
            new MetricRegistryMetricReader(registry))));
    }*/
    
}
