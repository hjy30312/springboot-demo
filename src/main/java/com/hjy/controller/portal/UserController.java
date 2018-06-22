package com.hjy.controller.portal;

import com.hjy.common.Const;
import com.hjy.common.ResponseCode;
import com.hjy.common.ServerResponse;
import com.hjy.entity.User;
import com.hjy.service.UserService;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
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

	private Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	/**
	 * 显示列表
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public ServerResponse getList(HttpSession session,
								  @RequestParam(value = "pageNum",defaultValue = "1") int pageNum,
								  @RequestParam(value = "pageSize",defaultValue = "10") int pageSize){
/*
		User user = (User)session.getAttribute(Const.CURRENT_USER);
		logger.info("user:" + user);

		if(user == null){
			return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"用户未登录,请登录管理员");
		}
		if(userService.checkAdminRole(user).isSuccess()){
			//填充业务
			return userService.getUserList(pageNum,pageSize);
		}else {
			return ServerResponse.createByErrorMessage("无权限操作");
		}*/
		return userService.getUserList(pageNum,pageSize);
	}

	/**
	 * 用户登录
	 * @param username
	 * @param password
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "login.do",method = RequestMethod.POST)
	public ServerResponse<User> login(String username, String password, HttpSession session){

		ServerResponse<User> response = userService.login(username,password);

		if(response.isSuccess()){
			logger.info("成功");
			session.setAttribute(Const.CURRENT_USER,response.getData());
		}

		return response;
	}

	/**
	 * 登录注销
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "logout.do",method = RequestMethod.POST)
	public ServerResponse<String> logout(HttpSession session){
		session.removeAttribute(Const.CURRENT_USER);
		return ServerResponse.createBySuccess("注销成功");
	}

	/**
	 * 用户注册
	 * @param user
	 * @return
	 */
	@PostMapping
	public ServerResponse register(User user) {
		return userService.register(user);
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
	 * @param ids
	 * @return
	 */
	@DeleteMapping("/{id}")
	public ServerResponse deleteUserById(@PathVariable("id") String ids) {
		return userService.deleteUser(ids);
	}

	/**
	 * 更新
	 * @param user
	 * @return
	 */
	@PutMapping("/{id}")
	public ServerResponse updateUser(@PathVariable("id") Integer id , User user) {
		if (user == null) {
			return ServerResponse.createByErrorMessage("输入参数有误！");
		}
		user.setId(id);
		return userService.updateUser(user);
	}

}
