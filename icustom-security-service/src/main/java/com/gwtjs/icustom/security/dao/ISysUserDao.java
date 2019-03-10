package com.gwtjs.icustom.security.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.gwtjs.icustom.entity.PageVO;
import com.gwtjs.icustom.entity.PagedResult;
import com.gwtjs.icustom.security.entity.SysUserVO;

/**
 * 权限--用户管理--mybatis接口数据管理
 * 
 * @author aGuang
 */
@Mapper
public interface ISysUserDao {

	/**
	 * 查询某用户-第一个-测试型
	 * 
	 * @return
	 */
	SysUserVO findUser(@Param("id") Integer id);
	
	/**
	 * 查询某用户-第一个-测试型
	 * 
	 * @return
	 */
	SysUserVO findByUsername(@Param("username") String username);
	
	/**
	 * 查询某用户-第一个-测试型
	 * 
	 * @return
	 */
	SysUserVO findByAccount(@Param("account") String account);

	/**
	 * 查询所有用户-第一个-测试型
	 * 
	 * @return
	 */
	PagedResult<SysUserVO> findUserPage(@Param("user") SysUserVO user,@Param("page") PageVO page);

	/**
	 * 批量插入用户数据
	 * 
	 * @param userList
	 * @return
	 */
	int saveOrUpdate(@Param("users")List<SysUserVO> users);

	/**
	 * 更新用户密码
	 * 
	 * @param userList
	 * @return
	 */
	int updatePwd(SysUserVO user);
	
	/**
	 * 删除用户
	 * valid_flag = 2
	 * @param userList
	 * @return
	 */
	int delete(SysUserVO user);

}
