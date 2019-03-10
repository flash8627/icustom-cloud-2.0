package com.gwtjs.icustom.security.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.gwtjs.icustom.security.dao.ISysResourceDao;
import com.gwtjs.icustom.security.entity.SysResourceVO;
import com.gwtjs.icustom.security.service.IResourceRestService;

import io.swagger.annotations.Api;

@Api("/resource")
public class ResourceRestService implements IResourceRestService {

	@Autowired
	private ISysResourceDao sysResourceDao;

	@Override
	public int saveOrUpdate(List<SysResourceVO> sys) {
		// TODO Auto-generated method stub
		return sysResourceDao.saveOrUpdate(sys);
	}


	@Override
	public int delete(SysResourceVO role) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override @CrossOrigin
	public List<SysResourceVO> findAll() {
		System.out.println("==================>sysResourceDao:"+this.sysResourceDao);
		// TODO Auto-generated method stub
		//return sysResourceDao.findAll();
		return getMenu();
	}
	
	private List<SysResourceVO> getMenu()
	{
		List<SysResourceVO> result = new ArrayList<>();
		SysResourceVO vo = new SysResourceVO();
		vo.setResourceId(1L);
		vo.setResourceName("HOME");
		vo.setResourceUrl("/");
		result.add(vo);
		
		vo = new SysResourceVO();
		vo.setResourceId(2L);
		vo.setResourceName("Product");
		vo.setResourceUrl("/Product");
		result.add(vo);
		
		vo = new SysResourceVO();
		vo.setResourceId(3L);
		vo.setResourceName("Shopping");
		vo.setResourceUrl("/Shopping");
		result.add(vo);
		
		vo = new SysResourceVO();
		vo.setResourceId(3L);
		vo.setResourceName("System Manager");
		vo.setResourceUrl("/System-Manager");
		result.add(vo);
		
		return result;
	}

}
