package com.gwtjs.icustom.security.service;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.gwtjs.icustom.security.entity.SysResourceVO;
import com.gwtjs.icustom.security.service.IResourceRestService;
import com.gwtjs.icustom.security.SecurityMainApplicationTest;

public class IResourceRestServiceTest extends SecurityMainApplicationTest {
	
	/*@Autowired
	private ISysResourceDao sysResourceDao;*/
	
	@Autowired
	private IResourceRestService resourceRestService;
	
	@Test
	public void serviceAocTest() {
		assertTrue(resourceRestService != null);
	}
	
	@Test
	public void findAllTest() {
		List<SysResourceVO> list = resourceRestService.findAll();
		assertTrue(list != null);
	}
	
}
