package com.gwtjs.icustom.security.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.gwtjs.icustom.entity.PageVO;
import com.gwtjs.icustom.entity.PagedResult;
import com.gwtjs.icustom.security.entity.SysRoleResourceVO;
import com.gwtjs.icustom.security.entity.SysRoleVO;

/**
 * 权限--资源目录--mybatis接口数据管理
 * @author aGuang
 *
 */
@Mapper
public interface ISysRoleResourceDao {
	
	/**
	 * 查询角色的资源
	 * @param role
	 * @param page
	 * @return	
	 */
	PagedResult<SysRoleResourceVO> findByRoleResource(@Param("roles")List<SysRoleVO> list,@Param("page")PageVO page);
	
	List<SysRoleResourceVO> findByRoleResource(@Param("roleId")long roleId);

	List<SysRoleResourceVO> findByRole(@Param("list")List<Integer> roleIds);
	
}
