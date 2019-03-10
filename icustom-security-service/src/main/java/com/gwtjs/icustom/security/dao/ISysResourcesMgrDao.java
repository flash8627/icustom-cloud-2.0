package com.gwtjs.icustom.security.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;

import com.gwtjs.icustom.security.entity.SysResourceVO;

/**
 * 栏目，菜单，导航
 * @author aGuang
 *
 */
@Resource
public interface ISysResourcesMgrDao {
	
	//菜单专用
	List<SysResourceVO> findMenuList(SysResourceVO record);
	
	//1027新增
	List<SysResourceVO> findAuthResourcesTree(SysResourceVO record);
	
	//1027新增
	List<SysResourceVO> findAuthResourcesTreeRoot();
	
	SysResourceVO findResourcesGridTreeRoot();
	
	List<SysResourceVO> findResourcesList(SysResourceVO record);
	
	int batchInsert(List<SysResourceVO> list);
	
	int batchRemoveResourcesPks(List<SysResourceVO> list);
	
	int deleteByPrimaryKey(@Param("resourceId") long resourceId);

    int insert(SysResourceVO record);

    Integer selectByItemId();
    
    SysResourceVO selectByPrimaryKey(@Param("resourceId") long resourceId);

    int updateByPrimaryKey(SysResourceVO record);
	
}

