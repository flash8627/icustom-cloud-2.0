package com.gwtjs.icustom.cloud.api.fallback;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

@Component
public class UserFallbackProvider implements FallbackProvider {

	/**
	 * 路由服务名称 
	 */
	@Override
	public String getRoute() {
		return "user-service";
	}

	@Override
	public ClientHttpResponse fallbackResponse() {
		return this.fallbackResponse(null);
	}

	@Override
	public ClientHttpResponse fallbackResponse(Throwable cause) {
		return new ClientHttpResponse() {

			@Override
			public HttpHeaders getHeaders() {
				HttpHeaders headers = new HttpHeaders();
				headers.setContentType(MediaType.APPLICATION_JSON);
				return headers;
			}

			@Override
			public InputStream getBody() throws IOException {
				return new ByteArrayInputStream("user service error......".getBytes());
			}

			@Override
			public String getStatusText() throws IOException {
				return "OK";
			}

			@Override
			public HttpStatus getStatusCode() throws IOException {
				return HttpStatus.OK;
			}

			@Override
			public int getRawStatusCode() throws IOException {
				return 200;
			}

			@Override
			public void close() {

			}
		};
	}

}
