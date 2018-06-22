package com.hjy.service;

import com.hjy.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {


	@Autowired
	private UserService userService;

	@Test
	public void getList() throws Exception {
		Map<String,Object> map = new HashMap<String, Object>();
		List<User> userList=  userService.getList();
		map.put("userList",userList);
		System.out.println(map);
	}

	@Test
	public void register() throws Exception {
		User user = new User();
		user.setUsername("3122222222");
		user.setPassword("321");
		user.setRole(0);
		user.setCreateTime(new Date());
		user.setUpdateTime(new Date());

	}

}