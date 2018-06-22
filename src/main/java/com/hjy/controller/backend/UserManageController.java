package com.hjy.controller.backend;

import com.hjy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hjy
 * @create 2018/06/07
 **/
@RestController
@RequestMapping("/manage/user")
public class UserManageController {

	@Autowired
	private UserService userService;


}
