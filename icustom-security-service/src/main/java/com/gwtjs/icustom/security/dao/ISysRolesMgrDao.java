package com.gwtjs.icustom.security.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gwtjs.icustom.entity.PageVO;
import com.gwtjs.icustom.entity.PagedResult;
import com.gwtjs.icustom.security.entity.SysRoleVO;

public interface ISysRolesMgrDao {
	
	//
	SysRoleVO findByItem(SysRoleVO record);
	
	//
	SysRoleVO findItem(@Param("roleId")long roleId);

	//
	PagedResult<SysRoleVO> findSysRoles(@Param("vo")SysRoleVO record,@Param("page")PageVO page);

	//
	int batchRemovePks(List<SysRoleVO> records);

	//
	int saveOrUpdate(List<SysRoleVO> records);

}
