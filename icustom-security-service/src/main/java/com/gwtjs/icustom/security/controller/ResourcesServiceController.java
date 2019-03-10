package com.gwtjs.icustom.security.controller;

import java.util.Objects;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gwtjs.icustom.log.ICustomLogger;
import com.gwtjs.icustom.log.ICustomLoggerFactory;
import com.gwtjs.icustom.security.dao.ISysUserMgrDao;
import com.gwtjs.icustom.security.entity.ResultFactory;
import com.gwtjs.icustom.security.entity.ResultStatusVO;
import com.gwtjs.icustom.security.entity.SysUserVO;
import com.gwtjs.icustom.security.service.impl.UserServices;

import io.swagger.annotations.Api;

@Api("/mvc")
@RestController
public class ResourcesServiceController {
	
	private static final ICustomLogger log = ICustomLoggerFactory
			.getLogger(UserServices.class);
	
	@Inject
	private ISysUserMgrDao userDao;
	
	/**
	 * 登录控制器，前后端分离用的不同协议和端口，所以需要加入@CrossOrigin支持跨域。
	 * 给VueLoginInfoVo对象加入@Valid注解，并在参数中加入BindingResult来获取错误信息。
	 * 在逻辑处理中我们判断BindingResult知否含有错误信息，如果有错误信息，则直接返回错误信息。
	 */
	@CrossOrigin
	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
	@ResponseBody
	public ResultStatusVO login(@Valid @RequestBody SysUserVO loginInfoVo, BindingResult bindingResult) {
		
		System.out.println("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>::::user Dao"+userDao);
		log.info("\n============================================="+this.userDao);
		
		String message = "登陆成功。";
		if (bindingResult.hasErrors()) {
			message = String.format("登陆失败，详细信息[%s]。", bindingResult.getFieldError().getDefaultMessage());
			return ResultFactory.buildFailResult(message);
		}
		if (!Objects.equals("dzg", loginInfoVo.getUsername())
				|| !Objects.equals("123456", loginInfoVo.getPassword())) {
			message = String.format("登陆失败，详细信息[用户名、密码信息不正确]。");
			return ResultFactory.buildFailResult(message);
		}
		return ResultFactory.buildSuccessResult(message);
		
	}

}
