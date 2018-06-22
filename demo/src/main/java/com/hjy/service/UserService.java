package com.hjy.service;

import com.hjy.common.ServerResponse;
import com.hjy.entity.User;
import com.mysql.fabric.Server;

import java.util.List;

/**
 * @author hjy
 * @create 2018/05/11
 **/
public interface UserService {

	//int register(User user);

	List<User> getList();

	ServerResponse saveUser(User user);

	ServerResponse deleteUser(Integer id);

	ServerResponse updateUser(User user);

	ServerResponse<User> queryUserById(Integer id);
}
