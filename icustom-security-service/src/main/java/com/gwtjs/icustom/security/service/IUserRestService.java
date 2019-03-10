package com.gwtjs.icustom.security.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.gwtjs.icustom.security.entity.SysUserVO;

/**
 * http://localhost:8080/api/application.wadl
 * 
 * http://localhost:8080/security/core/api/user/findAllUserList
 * 
 * @author aGuang
 *
 */
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/user") 
public interface IUserRestService {
	
	/**
	 * 用户登陆会用到
	 */
	@GET
	@Path("/findByUsername/{username}")
	public SysUserVO findByUsername(String username);
	
	/**
	 * 用户登陆会用到
	 */
	@GET
	@Path("/findByAccount/{account}")
	public SysUserVO findByAccount(@PathParam("account") String account);
	
	/**
	 * 批量插入用户数据
	 * 
	 * @param userList
	 * @return
	 */
	@POST
	@Path("/saveOrUpdate")
	int saveOrUpdate(List<SysUserVO> userList);
	
}
