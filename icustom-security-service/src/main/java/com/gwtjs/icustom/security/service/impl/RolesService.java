package com.gwtjs.icustom.security.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import com.gwtjs.icustom.entity.PageVO;
import com.gwtjs.icustom.entity.PagedResult;
import com.gwtjs.icustom.entity.ResultWrapper;
import com.gwtjs.icustom.security.dao.ISysRolesMgrDao;
import com.gwtjs.icustom.security.entity.SysRoleVO;
import com.gwtjs.icustom.security.service.IRolesService;

import io.swagger.annotations.Api;

@Api("/mgr/roles")
public class RolesService implements IRolesService {
	
	@Inject
	private ISysRolesMgrDao rolesDao;
	
	@Override
	public ResultWrapper findItem(long roleId) {
		// TODO Auto-generated method stub
		return ResultWrapper.successResult(rolesDao.findItem(roleId));
	}

	@Override
	public PagedResult<SysRoleVO> findRolesList(SysRoleVO record, PageVO page) {
		return rolesDao.findSysRoles(record, page);
	}

	@Override
	public ResultWrapper batchRemovePks(List<SysRoleVO> records) {
		// TODO Auto-generated method stub
		rolesDao.batchRemovePks(records);
		return ResultWrapper.successResult(records);
	}

	@Override
	public ResultWrapper batchUpdate(List<SysRoleVO> records) {
		records = setRecordsRoles(records);
		rolesDao.saveOrUpdate(records);
		return ResultWrapper.successResult(records);
	}

	@Override
	public ResultWrapper batchInsert(List<SysRoleVO> records) {
		records = setRecordsRoles(records);
		rolesDao.saveOrUpdate(records);
		return genericResult(records);
	}

	private ResultWrapper genericResult(List<SysRoleVO> list)
	{
		List<SysRoleVO> records = new ArrayList<SysRoleVO>();
		for (SysRoleVO user : list) {
			records.add(rolesDao.findByItem(user));
		}
		return ResultWrapper.successResult(records);
	}
	
	/**
	 * 设置当前操作用户 
	 * @param records
	 * @return
	 */
	private List<SysRoleVO> setRecordsRoles(List<SysRoleVO> records){
		List<SysRoleVO> result = new ArrayList<SysRoleVO>();
		long createdUser = new Long(1);
		
		for (SysRoleVO vo : records) {
			vo.setCreatedUser(createdUser);
			vo.setUpdateLastUser(createdUser);
			result.add(vo);
		}
		return result;
	}
	
}
