package com.gwtjs.icustom.security.service.impl;

import io.swagger.annotations.Api;

import org.springframework.beans.factory.annotation.Autowired;

import com.gwtjs.icustom.entity.PageVO;
import com.gwtjs.icustom.entity.PagedResult;
import com.gwtjs.icustom.security.dao.ISysRoleDao;
import com.gwtjs.icustom.security.entity.SysRoleVO;
import com.gwtjs.icustom.security.service.IRoleRestService;

@Api("/role")
public class RoleRestService implements IRoleRestService {

	@Autowired
	private ISysRoleDao sysRoleDao;

	@Override
	public int insert(SysRoleVO role) {
		// TODO Auto-generated method stub
		return 0;//sysRoleDao.insert(role);
	}

	@Override
	public int delete(SysRoleVO role) {
		// TODO Auto-generated method stub
		return 0;//sysRoleDao.delete(role);
	}

	@Override
	public int update(SysRoleVO role) {
		// TODO Auto-generated method stub
		return 0;//sysRoleDao.update(role);
	}

	@Override
	public PagedResult<SysRoleVO> findRolePage(SysRoleVO role,PageVO page) {
		System.out.println("role:\n"+role);
		System.out.println("page:\n"+page);
		// TODO Auto-generated method stub
		return sysRoleDao.findRolePage(role, page);
	}

}
