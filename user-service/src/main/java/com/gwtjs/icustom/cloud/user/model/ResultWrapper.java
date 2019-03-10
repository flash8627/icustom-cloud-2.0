package com.gwtjs.icustom.cloud.user.model;

import java.util.HashMap;
import java.util.Map;

/**
 * 统一的返回类型
 * 
 * @author aGuang
 *
 */
public class ResultWrapper {
	/**
	 * 请求成功
	 */
	public static short STATUS_SUCCESS = 1;
	/**
	 * 请求失败
	 */
	public static int STATUS_ERROR = 0;
	
	private static final int FAULT_STATUS = 2; //Fault
	
	/**
	 * 狀態值
	 */
	private int status;
	/**
	 * 消息
	 */
	private String msg;
	/**
	 * 數據對象【普通對象，列表，分頁對象】
	 */
	private Object data;
	/**
	 * 錯誤碼【請求失敗時賦值】
	 */
	private String errorCode;
	
	private Object obj; //返回的对象
	
	private ResultWrapper() {
	};
	
	private ResultWrapper(int status, String msg, Object data,
			String errorCode) {
		this.status = status;
		this.msg = msg;
		this.data = data;
		this.errorCode = errorCode;
	};

	public static ResultWrapper successResult(Object data) {
		return new ResultWrapper(ResultWrapper.STATUS_SUCCESS, "", data, null);
	}

	public static ResultWrapper constructSuccessResult(Object data) {
		return new ResultWrapper(ResultWrapper.STATUS_SUCCESS, "", data, null);
	}

	public static ResultWrapper constructSuccessResult(String msg, Object data) {
		return new ResultWrapper(ResultWrapper.STATUS_SUCCESS, msg, data, null);
	}

	public static ResultWrapper constructErrorResult(String msg,
			String errorCode) {
		return new ResultWrapper(ResultWrapper.STATUS_ERROR, msg, null,
				errorCode);
	}

	public static ResultWrapper constructSingleSuccessResult(String msg,
			String key, String data) {
		Map<String, String> resultMap = new HashMap<String, String>();
		resultMap.put(key, data);
		return new ResultWrapper(ResultWrapper.STATUS_SUCCESS, msg, resultMap,
				null);
	}

	public ResultWrapper(String msg, int status, Object obj) {
		this.msg = msg;
		this.status = status;
		this.obj = obj;
	}

	/**
	 * 成功的返回
	 * 
	 * @param msg
	 * @param obj
	 * @return
	 */
	static public ResultWrapper successResult() {
		ResultWrapper war = new ResultWrapper();
		war.setMsg("操作成功!");
		// war.setObj(obj);
		war.setStatus(STATUS_SUCCESS);
		return war;
	}

	/**
	 * 成功的返回
	 * 
	 * @param msg
	 * @param obj
	 * @return
	 */
	static public ResultWrapper successResult(Object msg, Object obj) {
		ResultWrapper war = new ResultWrapper();
		war.setMsg(msg.toString());
		war.setObj(obj);
		war.setStatus(STATUS_SUCCESS);
		return war;
	}

	/**
	 * 成功的返回
	 * 
	 * @param msg
	 * @param obj
	 * @return
	 */
	static public ResultWrapper successResult(String msg, Object obj) {
		ResultWrapper war = new ResultWrapper();
		war.setMsg(msg);
		war.setObj(obj);
		war.setStatus(STATUS_SUCCESS);
		return war;
	}

	/**
	 * 错误的返回
	 * 
	 * @param msg
	 * @param obj
	 * @return
	 */
	static public ResultWrapper faultResult(String msg, Object obj) {
		ResultWrapper war = new ResultWrapper();
		war.setMsg(msg);
		war.setObj(obj);
		war.setStatus(FAULT_STATUS);
		return war;
	}

	/**
	 * 错误的返回
	 * 
	 * @param msg
	 * @param obj
	 * @return
	 */
	static public ResultWrapper errorResult(String msg, Object obj) {
		ResultWrapper war = new ResultWrapper();
		war.setMsg(msg);
		war.setObj(obj);
		war.setStatus(STATUS_ERROR);
		return war;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}
	
}
