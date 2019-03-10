package com.gwtjs.icustom.security.service;

import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.gwtjs.icustom.entity.PageVO;
import com.gwtjs.icustom.entity.PagedResult;
import com.gwtjs.icustom.security.entity.SysRoleVO;

@Path("/role")
@Produces(MediaType.APPLICATION_JSON) 
@Consumes(MediaType.APPLICATION_JSON )
public interface IRoleRestService {

	@POST @Path("/insert")
	public int insert(SysRoleVO role);
	
	@DELETE @Path("/delete")
	public int delete(SysRoleVO role);
	
	@PUT @Path("/update")
	public int update(SysRoleVO role);
	
	/**
	 * 查询所有用户-第一个-测试型
	 * 
	 * @return
	 */
	@GET @Path("/findRolePage/{curPage}/{pageSize}") 
	public PagedResult<SysRoleVO> findRolePage(@QueryParam("")SysRoleVO role,@PathParam("") PageVO page);

}
