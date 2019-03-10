package com.gwtjs.icustom.security.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.security.core.context.SecurityContextHolder;

import com.gwtjs.icustom.entity.ResultWrapper;
import com.gwtjs.icustom.log.ICustomLogger;
import com.gwtjs.icustom.log.ICustomLoggerFactory;
import com.gwtjs.icustom.security.dao.ISysResourcesMgrDao;
import com.gwtjs.icustom.security.entity.SysResourceVO;
import com.gwtjs.icustom.security.entity.SysUserVO;
import com.gwtjs.icustom.security.service.IResourcesService;

import io.swagger.annotations.Api;

@Api("/mgr/resource")
public class ResourcesService implements IResourcesService {
	
	@Inject
	private ISysResourcesMgrDao resourcesDAO;
	
	private static final ICustomLogger log = ICustomLoggerFactory
			.getLogger(ResourcesService.class);
	
	@Override
	public Integer selectByItemId() {
		// TODO Auto-generated method stub
		return resourcesDAO.selectByItemId();
	}

	/**
	 * 站点菜单
	 */
	@Override
	public List<SysResourceVO> findResourcesSiteMenu() {
		SysUserVO user = new SysUserVO();//(SysUserVO) SecurityContextHolder.getContext().getAuthentication() .getPrincipal();
		log.info("current user:",user);
		SysResourceVO nav = resourcesDAO.findResourcesGridTreeRoot();
		List<SysResourceVO> menus = this.findMenus(nav.getResourceId());
		for (SysResourceVO menu : menus) {
			List<SysResourceVO> child = this
					.findMenus(menu.getResourceId());
			if(child.size()>0){
				menu.setChildren(child);
			}
		}
		return menus;
	}
	
	private List<SysResourceVO> findMenus(long parentId) {
		List<SysResourceVO> list = this.findSiteMenuChildren(parentId);
		for (SysResourceVO record : list) {
			if (record.isLeaf()) {
				List<SysResourceVO> children = this
						.findSiteMenuChildren(record.getResourceId());
				record.setChildren(children);
			}
		}
		return list;
	}
	
	/**
	 * 重载封装
	 * 
	 * @param parentId
	 * @return
	 */
	private List<SysResourceVO> findSiteMenuChildren(long parentId) {
		SysResourceVO record = new SysResourceVO();
		record.setParentId(parentId);
		return resourcesDAO.findMenuList(record);
	}
	
	@Override
	public List<SysResourceVO> findResourcesGridTree(long parentId) {
		List<SysResourceVO> list = this.findResourcesChildren(parentId);
		for (SysResourceVO record : list) {
			if (record.isLeaf()) {
				List<SysResourceVO> children = this
						.findResourcesChildren(record.getResourceId());
				record.setChildren(children);
			}
		}
		return list;
	}
	
	@Override
	public List<SysResourceVO> findResourcesGridTree() {
		SysResourceVO record = resourcesDAO.findResourcesGridTreeRoot();
		List<SysResourceVO> list = new ArrayList<SysResourceVO>();

		if(record!=null && record.isLeaf()){
			List<SysResourceVO> children = this.findResourcesChildren(record.getResourceId());
			record.setChildren(children);
		}
		list.add(record);
		log.debug("", list);
		return list;
	}

	@Override
	public List<SysResourceVO> findResourcesList() {
		SysResourceVO record = new SysResourceVO();
		return this.findResourcesList(record);
	}
	
	/**
	 * 重载封装
	 * 
	 * @param parentId
	 * @return
	 */
	private List<SysResourceVO> findResourcesChildren(long parentId) {
		SysResourceVO record = new SysResourceVO();
		record.setParentId(parentId);
		return resourcesDAO.findResourcesList(record);
	}

	@Override
	public List<SysResourceVO> findResourcesList(SysResourceVO record) {
		return resourcesDAO.findResourcesList(record);
	}

	@Override
	public SysResourceVO selectByPrimaryKey(long resourceId) {
		return resourcesDAO.selectByPrimaryKey(resourceId);
	}

	@Override
	public ResultWrapper batchInsert(List<SysResourceVO> list) {
		int msg = resourcesDAO.batchInsert(list);
		return ResultWrapper.successResult(msg, list);
	}

	@Override
	public ResultWrapper batchRemoveResourcesPks(List<SysResourceVO> list) {
		int msg = resourcesDAO.batchRemoveResourcesPks(list);
		return ResultWrapper.successResult(msg, list);
	}

	@Override
	public ResultWrapper deleteByPrimaryKey(long resourceId) {
		int msg = resourcesDAO.deleteByPrimaryKey(resourceId);
		return ResultWrapper.successResult(msg);
	}

	@Override
	public ResultWrapper insert(SysResourceVO record) {
		SysUserVO user = (SysUserVO) SecurityContextHolder.getContext().getAuthentication() .getPrincipal();
		log.info("current user:",user);
		//Integer resourceId = resourcesDAO.selectByItemId();
		//record.setItemId(resourceId);
		record.setCreatedUser(user.getId());
		record.setUpdateLastUser(user.getId());
		record.setCreatedDate(new Date());
		int msg = resourcesDAO.insert(record);
		return ResultWrapper.successResult(msg, record);
	}

	@Override
	public ResultWrapper updateByPrimaryKey(SysResourceVO record) {
		int msg = resourcesDAO.updateByPrimaryKey(record);
		return ResultWrapper.successResult(msg, record);
	}
	
}
