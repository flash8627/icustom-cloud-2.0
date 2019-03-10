package com.gwtjs.icustom.security.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gwtjs.icustom.security.entity.SysRoleVO;
import com.gwtjs.icustom.security.entity.SysUserRoleVO;

public interface ISysUserRolesMgrDao{
	
	/**
	 * 某用户的所有角色
	 * @param userId
	 * @return
	 */
	List<SysRoleVO> findByUserRoles(@Param("userId") long userId);
	
	/**批量新增用户的角色*/
	int saveOrUpdate(List<SysUserRoleVO> records);
	
	/**
	 * 删除数据,批量
	 * @param records
	 * @return
	 */
	int batchRemovePks(List<SysUserRoleVO> records);
	/**
	 * 删除数据,批量
	 * @param records
	 * @return
	 */
	int removeUserRoles(@Param("userId")long userId);
}
