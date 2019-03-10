package com.gwtjs.icustom.security.dao;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.gwtjs.icustom.entity.PageVO;
import com.gwtjs.icustom.entity.PagedResult;
import com.gwtjs.icustom.security.entity.SysRoleVO;

/**
 * 权限--用户管理--mybatis接口数据管理
 * 
 * @author aGuang
 */
@Mapper
public interface ISysRoleDao {
	
	List<SysRoleVO> findAll();

	SysRoleVO findByRoleName(@Param("roleName") String roleName);
	
	int saveOrUpdate(@Param("roles")List<SysRoleVO> role);
	
	public PagedResult<SysRoleVO> findRolePage(@Param("vo") SysRoleVO role,@Param("page") PageVO page);
	
}
