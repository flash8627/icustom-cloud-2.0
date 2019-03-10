package com.gwtjs.icustom.cloud.model;

/**
 * @description 统一 API响应结果封装
 * @author
 * @date
 * @Copyright
 * @memo 控制Result权限，构建结果Result对象统一使用 ResultFactory工厂类来创建
 */
public class ResultStatusVO {
	/**
	 * 响应状态码
	 */
	private int code;
	/**
	 * 响应提示信息
	 */
	private String message;
	/**
	 * 响应结果对象
	 */
	private Object data;
	
	public ResultStatusVO(int code, String message) {
		this.code = code;
		this.message = message;
	}

	ResultStatusVO(int code, String message, Object data) {
		this.code = code;
		this.message = message;
		this.data = data;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
