package com.gwtjs.icustom.webservice.autoconfigure;

public class RequestContextConstants {
	
	/**
	* 请求常量
	*/

	/**
	* RequestContext URI 的key，一般不推荐取此值，对单元测试有一些不利影响
	*/
	public static final String KEY_URI = "ICustomRequestURI";
	/**
	* requestContext 的header
	*/
	public static final String KEY_HEADER = "ICustomRequestHeader";
	/**
	* 当前角色对应的KEY
	*/
	public static final String KEY_CURRENT_ROLE = "ICustomCurrentRole";
	/**
	* 请求类别对应的KEY
	*/
	public static final String KEY_REQUEST_TYPE = "ICustomRequestType";
	/**
	* cookies类别对应的KEY
	*/
	public static final String KEY_COOKIES_TYPE = "ICustomCookiesType";
	/**
	* 请求类型：标准Servlet请求
	*/
	public static final String TYPE_SERVLET = "servlet";
	/**
	* 请求类型：私有服务（供本地JS调用）
	*/
	public static final String TYPE_PRIVATE_SERVICES = "services";
	/**
	* 请求类型：内部服务
	*/
	public static final String TYPE_INTERNAL_SERVICES = "internalservices";
	/**
	* 请求类型：跨产品服务
	*/
	public static final String TYPE_PUBLIC_SERVICES = "publicservices";
	/**
	* 请求类型：资源请求
	*/
	public static final String TYPE_RESOURCES = "resources";

	/**
	* 请求类型：springmvc请求
	*/
	public static final String TYPE_SPRINGMVC = "springmvc";
	
}
