package com.gwtjs.icustom.cloud.user.service.impl;

import org.springframework.stereotype.Service;

import com.gwtjs.icustom.cloud.user.model.UserVO;
import com.gwtjs.icustom.cloud.user.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Override
	public UserVO getUser(String id) {
		System.out.println(id + "进入实现类获取数据！");
		UserVO userVO = new UserVO();
		userVO.setId(id);
		userVO.setUsername("香菇,难受");
		userVO.setAge(18);
		return userVO;
	}

	@Override
	public void deleteUser(String id) {
		System.out.println(id + "进入实现类删除数据！");
	}

}
