package com.gwtjs.icustom.cloud.user.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import com.gwtjs.icustom.cloud.user.model.User;

public interface UserService {

	@Cacheable(key = "'user_'+#id", value = "'user'+#id")
	User getUser(String id);

	@CacheEvict(key = "'user_'+#id", value = "users", condition = "#id!=1")
	void deleteUser(String id);

}