package com.gwtjs.icustom.cloud.model;

import java.io.Serializable;

public class ZuulRouteVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9064727870704980096L;

	// #serviceId: user-service
	private String serviceId;
	// #url:http://localhost:8080/
	private String url;
	// #path: /api/**
	private String path;
	// #path: /api/**
	private String headers;

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getHeaders() {
		return headers;
	}

	public void setHeaders(String headers) {
		this.headers = headers;
	}

	@Override
	public String toString() {
		return "ZuulRouteVO [serviceId=" + serviceId + ", url=" + url + ", path=" + path + ", headers=" + headers + "]";
	}

}
