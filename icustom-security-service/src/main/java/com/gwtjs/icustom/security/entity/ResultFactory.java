package com.gwtjs.icustom.security.entity;

/**
 * @description 响应结果生成工厂类
 * @memo
 */
public class ResultFactory {

	public static ResultStatusVO buildSuccessResult(Object data) {
		return buidResult(ResultCodeVO.SUCCESS, "成功", data);
	}

	public static ResultStatusVO buildFailResult(String message) {
		return buidResult(ResultCodeVO.FAIL, message, null);
	}

	public static ResultStatusVO buidResult(ResultCodeVO resultCodeVO, String message, Object data) {
		return buidResult(resultCodeVO.code, message, data);
	}

	public static ResultStatusVO buidResult(int resultCode, String message, Object data) {
		return new ResultStatusVO(resultCode, message, data);
	}
}
