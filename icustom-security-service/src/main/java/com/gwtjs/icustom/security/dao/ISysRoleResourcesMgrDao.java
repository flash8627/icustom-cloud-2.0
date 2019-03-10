package com.gwtjs.icustom.security.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gwtjs.icustom.security.entity.SysRoleResourceVO;

/**
 * 角色的资源
 * @author aGuang
 *
 */
public interface ISysRoleResourcesMgrDao {
	
	//角色的资源
	List<SysRoleResourceVO> findByRoleResource(@Param("roleId")long roleId);
	
	/**批量新增用户的角色*/
	int saveOrUpdate(List<SysRoleResourceVO> records);
	
	/**
	 * 删除数据,批量
	 * @param records
	 * @return
	 */
	int batchRemovePks(List<SysRoleResourceVO> records);
	/**
	 * 删除数据,批量
	 * @param records
	 * @return
	 */
	int removeRoleResources(@Param("roleId")long roleId);
}

