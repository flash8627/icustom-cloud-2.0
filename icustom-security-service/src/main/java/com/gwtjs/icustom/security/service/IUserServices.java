package com.gwtjs.icustom.security.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.gwtjs.icustom.entity.PageVO;
import com.gwtjs.icustom.entity.PagedResult;
import com.gwtjs.icustom.entity.ResultWrapper;
import com.gwtjs.icustom.security.entity.SysUserVO;

/**
 * 系统用户
 * @author aGuang
 *
 */
@Path("/mgr/user")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface IUserServices {
	
	/**
	 * 获取当前用户
	 * @return
	 */
	SysUserVO getUserPrincipal();
	
	@GET @Path("findItem/{userId}")
	ResultWrapper findItem(@PathParam("userId")long userId);
	
	/**
	 * 管理页面,带分页sql
	 * @param record
	 * @param page
	 * @return
	 */
	@GET @Path("findUserList/{pageSize}/{curPage}")
	PagedResult<SysUserVO> findUserList(@QueryParam("")SysUserVO record,@PathParam("")PageVO page);

	@PUT @Path("batchRemovePks")
	ResultWrapper batchRemovePks(List<SysUserVO> records);

	@PUT @Path("batchUpdate")
	ResultWrapper batchUpdate(List<SysUserVO> records);

	@POST @Path("batchInsert")
	ResultWrapper batchInsert(List<SysUserVO> records);
	
	@POST @Path("updateUserPwd")
	public ResultWrapper updateUserPwd(SysUserVO record);
	
	@POST @Path("login")
	public ResultWrapper login(SysUserVO record) ;
	
	/**
	 *@author aGuang 2011-3-30 下午03:51:48
	 *@param account
	 *@param session
	 *@return  字符数组
	 */
	
	/**用户权限名称*/@GET @Path("loadUserAuthorities")
	List<String> loadUserAuthorities(SysUserVO record);
	
	/**
	 * 根据用户账号返回SysUsers实例对象。
	 * 
	 * @author aGuang 2011-4-8 下午01:53:05
	 *@param userAccount
	 *            用户账号，比如admin等。
	 *@return SysUsers实例对象。
	 */@GET @Path("findByUserAccount")
	public SysUserVO findByUserAccount(SysUserVO record);
	
}
