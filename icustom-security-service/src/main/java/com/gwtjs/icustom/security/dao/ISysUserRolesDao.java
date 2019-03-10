package com.gwtjs.icustom.security.dao;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.gwtjs.icustom.security.entity.SysRoleVO;

/**
 * 权限--用户管理--mybatis接口数据管理
 * 
 * @author aGuang
 */
@Mapper
public interface ISysUserRolesDao {
	
	List<SysRoleVO> findByUserRoles(@Param("userId") long userId);
	
}
