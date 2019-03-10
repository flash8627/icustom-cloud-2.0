package com.gwtjs.icustom.security.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gwtjs.icustom.entity.PageVO;
import com.gwtjs.icustom.entity.PagedResult;
import com.gwtjs.icustom.security.entity.SysUserVO;

public interface ISysUserMgrDao{
	
	//
	PagedResult<SysUserVO> queryUserByPage(@Param("vo")SysUserVO record);
	
	/**
	 *@author aGuang 2011-3-30 下午03:51:48
	 *@param account
	 *@param session
	 *@return  字符数组
	 */
	/**用户权限名称*/
	List<String> loadUserAuthorities(SysUserVO record);
	
	/**
	 * 根据用户账号返回SysUsers实例对象。
	 * 
	 * @author aGuang 2011-4-8 下午01:53:05
	 *@param userAccount
	 *            用户账号，比如admin等。
	 *@return SysUsers实例对象。
	 */
	public SysUserVO findByUserAccount(SysUserVO record);
	
	//
	SysUserVO findByItem(SysUserVO record);
	
	//
	SysUserVO findItem(@Param("userId")long userId);

	PagedResult<SysUserVO> findUserByPage(@Param("vo")SysUserVO record,@Param("page")PageVO page);

	//
	int batchRemovePks(List<SysUserVO> records);

	//新增或修改，新增时有密码，保存时无密码修改
	int saveOrUpdate(List<SysUserVO> records);
	
	//更新密码
	int updateUserPwd(SysUserVO record);
	
}
