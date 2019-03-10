package com.gwtjs.icustom.security.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.gwtjs.icustom.security.entity.SysResourceVO;

@Path("/resource")
@Produces(MediaType.APPLICATION_JSON) 
@Consumes(MediaType.APPLICATION_JSON)
public interface IResourceRestService {
	
	@POST @Path("/saveOrUpdate")
	int saveOrUpdate(List<SysResourceVO> sys);
	
	@DELETE @Path("/delete")
	public int delete(SysResourceVO role);
	
	@GET
	@Path("/findAll")
	List<SysResourceVO> findAll();
	
}
