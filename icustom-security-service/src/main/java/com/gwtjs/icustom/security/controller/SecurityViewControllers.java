package com.gwtjs.icustom.security.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityViewControllers {

	// 页面访问路径为
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String upload() {
		return "login";
	}

	// 页面访问路径为
	@RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
	public String accessDenied() {
		return "accessDenied";
	}

	// 页面访问路径为
	@RequestMapping(value = "/error", method = RequestMethod.GET)
	public String error() {
		return "error";
	}

}
