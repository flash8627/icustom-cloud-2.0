package com.gwtjs.icustom.security.dao;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.gwtjs.icustom.entity.PageVO;
import com.gwtjs.icustom.entity.PagedResult;
import com.gwtjs.icustom.security.dao.ISysResourceDao;
import com.gwtjs.icustom.security.entity.SysResourceVO;

import com.gwtjs.icustom.security.SecurityMainApplicationTest;

public class ISysResourceDaoTest  extends SecurityMainApplicationTest {

	@Autowired
	private ISysResourceDao sysResourceDao;

	@Test
	public void serviceAocTest() {
		assertTrue(sysResourceDao != null);
	}

	@Test @Ignore
	public void saveOrUpdateTest() {
		List<SysResourceVO> list = new ArrayList<SysResourceVO>();
		
		SysResourceVO sys=new SysResourceVO();
		sys.setCreatedUser(0);
		sys.setUpdateLastUser(0);
		sys.setResourceName("test");
		sys.setResourceUrl("/test");
		sys.setMethodName("test");
		sys.setMethodPath("/test");
		sys.setRemark("junit test");
		list.add(sys);
		sysResourceDao.saveOrUpdate(list);
	}

	@Test
	public void findResourcesSiteMenuTest() {
		List<SysResourceVO> list = sysResourceDao.findResourcesTree(0);
		System.out.println(list);
	}
	
	@Test
	public void findResourcesSiteMenuTest2() {
		List<SysResourceVO> list = sysResourceDao.findResourcesTree(1);
		System.out.println(list);
	}

	@Test
	public void findAllTest() {
		List<SysResourceVO> list = sysResourceDao.findAll();
		System.out.println(list);
	}

	@Test
	public void findResourcePageTest() {
		SysResourceVO sys = new SysResourceVO();
		PageVO page = new PageVO();
		page.setCurPage(1);
		page.setPageSize(18);
		PagedResult<SysResourceVO> result = sysResourceDao.findResourcePage(sys,
				page);
		System.out.println("resource result:\n"+result);
		System.out.println("resource page result:\n"+result.getPageVO());
		System.out.println("resource VO   result:\n"+result.getResult());
	}

}
