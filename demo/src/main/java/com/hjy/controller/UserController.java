package com.hjy.controller;

import com.hjy.common.ServerResponse;
import com.hjy.entity.User;
import com.hjy.service.UserService;
import com.mysql.fabric.Server;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hjy
 * @create 2018/05/11
 **/
@RestController
@RequestMapping("/user")
public class UserController {


	@Autowired
	private UserService userService;

	/**
	 * 显示列表
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public Map<String,Object> getList(){
		Map<String,Object> map = new HashMap<String, Object>();
		List<User> userList=  userService.getList();
		map.put("userList",userList);

		return map;
	}

	/**
	 * 添加
	 * @param user
	 * @return
	 */
	@PostMapping
	public ServerResponse saveUser(User user) {
		return userService.saveUser(user);
	}

	/**
	 * 查询
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}")
	public ServerResponse queryUserById(@PathVariable("id") Integer id) {
		return userService.queryUserById(id);
	}

	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@DeleteMapping("/{id}")
	public ServerResponse deleteUserById(Integer id) {
		return userService.deleteUser(id);
	}

	/**
	 * 更新
	 * @param user
	 * @return
	 */
	@PutMapping("/{id}")
	public ServerResponse updateUser(@PathVariable Integer id ,@RequestBody User user) {
		user.setId(id);
		return userService.updateUser(user);
	}

}
