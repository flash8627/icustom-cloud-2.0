package com.gwtjs.icustom.security.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.gwtjs.icustom.entity.PageVO;
import com.gwtjs.icustom.entity.PagedResult;
import com.gwtjs.icustom.entity.ResultWrapper;
import com.gwtjs.icustom.log.ICustomLogger;
import com.gwtjs.icustom.log.ICustomLoggerFactory;
import com.gwtjs.icustom.security.dao.ISysUserMgrDao;
import com.gwtjs.icustom.security.entity.SysUserVO;
import com.gwtjs.icustom.security.service.IUserServices;

import io.swagger.annotations.Api;

@Api("/mgr/user")
public class UserServices implements IUserServices {
	
	private static final ICustomLogger log = ICustomLoggerFactory
			.getLogger(UserServices.class);
	
	@Inject
	private ISysUserMgrDao userDao;
	
	/*@Override
	public PagedResult<SysUserVO> findUserPage(SysUserVO record, PageVO page) {
		return userDao.findUserPage(record, page);
	}*/

	@Override
	public SysUserVO getUserPrincipal() {
		SysUserVO user = (SysUserVO) SecurityContextHolder.getContext().getAuthentication() .getPrincipal();
		log.info("current user:",user);
		return user;
	}

	@Override
	public List<String> loadUserAuthorities(SysUserVO record) {
		return userDao.loadUserAuthorities(record);
	}

	@Override
	public SysUserVO findByUserAccount(SysUserVO record) {
		// TODO Auto-generated method stub
		return userDao.findByUserAccount(record);
	}

	/**
	 * 分页的user 条目
	 */
	/*@Override
	public PagedResult<SysUserVO> findListRecords(SysUserVO record,
			PageVO page) {
		return userDao.findUserByPage(record, page);
	}*/

	@Override
	public ResultWrapper findItem(long roleId) {
		// TODO Auto-generated method stub
		return ResultWrapper.successResult(userDao.findItem(roleId));
	}

	@Override
	public PagedResult<SysUserVO> findUserList(SysUserVO record, PageVO page) {
		return userDao.findUserByPage(record, page);
	}

	/*@Override
	public ResultWrapper findUserListCount(SysUserVO record) {
		// TODO Auto-generated method stub
		return ResultWrapper.successResult(userDao
				.selectListCount(record, null));
	}*/

	@Override
	public ResultWrapper batchRemovePks(List<SysUserVO> records) {
		// TODO Auto-generated method stub
		userDao.batchRemovePks(records);
		return ResultWrapper.successResult(records);
	}

	@Override
	public ResultWrapper batchUpdate(List<SysUserVO> records) {
		records = setRecordsUser(records);
		userDao.saveOrUpdate(records);
		return ResultWrapper.successResult(records);
	}

	@Override
	public ResultWrapper batchInsert(List<SysUserVO> records) {
		records = setRecordsUser(records);
		userDao.saveOrUpdate(records);
		return genericResult(records);
	}

	@Override
	public ResultWrapper updateUserPwd(SysUserVO record) {
		userDao.updateUserPwd(record);
		return ResultWrapper.successResult(record);
	}

	@Override
	public ResultWrapper login(SysUserVO record) {
		userDao.updateUserPwd(record);
		SysUserVO user = userDao.findByUserAccount(record);
		if (user == null) {
			return ResultWrapper.constructErrorResult("用户　不存在!", record.toString());
		} else if (!user.getPassword().equals(record.getPassword())) {
			return ResultWrapper.constructErrorResult("密码错误!", record.getAccount());
		} else if (user.getUserEnabled() == 1) {
			return ResultWrapper.constructErrorResult("用户已经被禁用,请联系管理员!", record.toString());
		}
		return ResultWrapper.successResult(record);
	}

	private ResultWrapper genericResult(List<SysUserVO> list) {
		List<SysUserVO> records = new ArrayList<SysUserVO>();
		for (SysUserVO user : list) {
			records.add(userDao.findByItem(user));
		}
		return ResultWrapper.successResult(records);
	}

	/**
	 * 设置当前操作用户
	 * 
	 * @param records
	 * @return
	 */
	private List<SysUserVO> setRecordsUser(List<SysUserVO> records) {
		List<SysUserVO> result = new ArrayList<SysUserVO>();
		long createdUser = new Long(1);
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication() .getPrincipal();
		log.info("current user:",userDetails);

		for (SysUserVO vo : records) {
			vo.setCreatedUser(createdUser);
			vo.setUpdateLastUser(createdUser);
			result.add(vo);
		}
		return result;
	}

}
