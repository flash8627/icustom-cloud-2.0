package com.gwtjs.icustom.security.dao;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.gwtjs.icustom.entity.PageVO;
import com.gwtjs.icustom.entity.PagedResult;
import com.gwtjs.icustom.security.dao.ISysUserDao;
import com.gwtjs.icustom.security.entity.SysUserVO;
import com.gwtjs.icustom.security.SecurityMainApplicationTest;

public class ISysUserDaoTest extends SecurityMainApplicationTest {
	
	@Autowired
	private ISysUserDao sysUserDao;
	
	@Test @Ignore
	public void serviceAocTest()
	{
		System.out.println(sysUserDao);
	}
	
	@Test
	public void findUserBynameTest()
	{
		String name = "admin";
		SysUserVO user = sysUserDao.findByUsername(name);
		System.out.println(user);
		assertTrue(user!=null);
	}
	
	@Test
	public void findUserPageTest()
	{
		SysUserVO user = new SysUserVO();
		//user.setName("d3g");
		//user.setEmail("flash8627@hotmail.com");
		PageVO page = new PageVO();
		page.setCurPage(1);
		page.setPageSize(12);
		page.setMysqlStartIndex(0);
		page.setMysqlEndIndex(8);
		PagedResult<SysUserVO> result = sysUserDao.findUserPage(user, page);
		System.out.println("PagedResult:"+result);
		System.out.println("PagedResult page:"+result.getPageVO());
		System.out.println("PagedResult vo:"+result.getResult());
		assertTrue(user!=null);
	}
	
	@Test
	public void findUserTest()
	{
		SysUserVO user = sysUserDao.findUser(1);
		System.out.println(user);
		assertTrue(user==null);
	}
	
	@Test
	public void saveOrUpdateTest()
	{
		BCryptPasswordEncoder bc=new BCryptPasswordEncoder(4);
		List<SysUserVO> list = new ArrayList<>();
		SysUserVO user = new SysUserVO();
		user.setUsername("dzg");
		user.setEmail("8538191@qq.com");
		user.setPassword(bc.encode("dddddd"));
		user.setAccount("dzg");
		user.setCreatedUser(0);
		user.setUpdateLastUser(0);
		//user.setSRoles(SysRoles);
		list.add(user);
		int result = sysUserDao.saveOrUpdate(list);
		System.out.println(result);
	}
	
	@Test
	public void saveOrUpdateAdminTest()
	{
		BCryptPasswordEncoder bc=new BCryptPasswordEncoder(4);
		List<SysUserVO> list = new ArrayList<>();
		SysUserVO user = new SysUserVO();
		user.setUsername("admin");
		user.setEmail("8538191@qq.com");
		user.setPassword(bc.encode("dddddd"));
		user.setAccount("admin");
		user.setCreatedUser(0);
		user.setUpdateLastUser(0);
		//user.setSRoles(SysRoles);
		list.add(user);
		int result = sysUserDao.saveOrUpdate(list);
		System.out.println(result);
	}
	
	@Test
	public void saveOrUpdateTest2()
	{
		BCryptPasswordEncoder bc=new BCryptPasswordEncoder(4);
		List<SysUserVO> list = new ArrayList<>();
		SysUserVO user = new SysUserVO();
		user.setUsername("dzg");
		user.setEmail("8538191@qq.com");
		user.setPassword(bc.encode("dddddd"));
		user.setAccount("dzg");
		user.setCreatedUser(0);
		user.setUpdateLastUser(0);
		//user.setSRoles(SysRoles);
		list.add(user);
		int result = sysUserDao.saveOrUpdate(list);
		System.out.println(result);
	}
	
	@Test
	public void deleteTest()
	{
		SysUserVO user = new SysUserVO();
		user.setId(new Long("1001"));
		//user.setAccount("dzg");
		sysUserDao.delete(user);
	}
	
	@Test
	public void updatePwdTest()
	{
		BCryptPasswordEncoder bc=new BCryptPasswordEncoder(4);
		SysUserVO user = new SysUserVO();
		user.setId(new Long("1002"));
		//user.setAccount("dzg");
		String password = bc.encode("dddddd");
		user.setPassword(password);
	}
	
}
