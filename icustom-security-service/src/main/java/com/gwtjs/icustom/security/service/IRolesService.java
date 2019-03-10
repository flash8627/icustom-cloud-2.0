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
import com.gwtjs.icustom.security.entity.SysRoleVO;


@Path("/mgr/roles")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface IRolesService {
	
	@GET @Path("findItem/{roleId}")
	ResultWrapper findItem(@PathParam("roleId")long roleId);
	
	@GET @Path("findRolesList/{pageSize}/{curPage}")
	PagedResult<SysRoleVO> findRolesList(@QueryParam("")SysRoleVO record,@PathParam("")PageVO page);

	@PUT @Path("batchRemovePks")
	ResultWrapper batchRemovePks(List<SysRoleVO> records);

	@PUT @Path("batchUpdate")
	ResultWrapper batchUpdate(List<SysRoleVO> records);

	@POST @Path("batchInsert")
	ResultWrapper batchInsert(List<SysRoleVO> records);
	
}
