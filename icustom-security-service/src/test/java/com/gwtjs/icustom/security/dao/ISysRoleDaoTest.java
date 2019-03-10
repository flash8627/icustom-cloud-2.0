package com.gwtjs.icustom.security.dao;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.gwtjs.icustom.entity.PageVO;
import com.gwtjs.icustom.entity.PagedResult;
import com.gwtjs.icustom.security.dao.ISysRoleDao;
import com.gwtjs.icustom.security.entity.SysRoleVO;
import com.gwtjs.icustom.security.SecurityMainApplicationTest;

public class ISysRoleDaoTest extends SecurityMainApplicationTest {
	
	@Autowired
	private ISysRoleDao sysRoleDao;
	
	@Test
	public void serviceAocTest()
	{
		assertTrue(sysRoleDao!=null);
	}
	
	@Test
	public void saveOrUpdateTest()
	{
		List<SysRoleVO> roles = new ArrayList<SysRoleVO>();
		SysRoleVO role = new SysRoleVO();
		role.setRolename("site_test");
		role.setRemark("junit test");
		roles.add(role);
		role = new SysRoleVO();
		role.setRolename("user");
		role.setRemark("junit test");
		roles.add(role);
		role = new SysRoleVO();
		role.setRolename("test");
		role.setRemark("junit test");
		roles.add(role);
		sysRoleDao.saveOrUpdate(roles);
	}
	
	@Test
	public void deleteTest()
	{
		/*SysRoleVO role = new SysRoleVO();
		role.setId(4);
		sysRoleDao.delete(role);*/
	}
	
	@Test
	public void findRolePageTest()
	{
		SysRoleVO role = new SysRoleVO();
		//role.setRolename("user");
		
		PageVO page = new PageVO();
		page.setCurPage(1);
		page.setPageSize(10);
		
		PagedResult<SysRoleVO> result = sysRoleDao.findRolePage(role, page);
		System.out.println("role result:\n"+result);
		System.out.println("role page result:\n"+result.getPageVO());
		System.out.println("role VO   result:\n"+result.getResult());
	}
	
}
