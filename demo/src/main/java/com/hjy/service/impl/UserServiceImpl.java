package com.hjy.service.impl;

import com.hjy.common.ServerResponse;
import com.hjy.dao.UserMapper;
import com.hjy.entity.User;
import com.hjy.service.UserService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author hjy
 * @create 2018/05/11
 **/
@Service("UserService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;

//	@Transactional(rollbackFor = Exception.class)
//	@Override
//	public int register(User user) {
//		if (user.getUsername() != null) {
//			user.setCreateTime(new Date());
//			user.setUpdateTime(new Date());
//			try {
//				int flag = userMapper.insert(user);
//				if (flag > 0) {
//					return 1;
//				} else {
//					throw new RuntimeException("dwq");
//				}
//			} catch (Exception e) {
//				throw new RuntimeException("ds" + e.getMessage());
//			}
//		} else {
//			throw new RuntimeException("dwq");
//		}
//	}

	@Override
	public List<User> getList() {

		return userMapper.getList();
	}

	@Override
	public ServerResponse saveUser(User user) {
		user.setCreateTime(new Date());
		user.setUpdateTime(new Date());
		int i = userMapper.insertSelective(user);
		if (i > 0) {
			return ServerResponse.createBySuccessMessage("添加成功");
		} else {
			return ServerResponse.createByErrorMessage("添加失败");
		}
	}

	@Override
	public ServerResponse deleteUser(Integer id) {
		int i = userMapper.deleteByPrimaryKey(id);
		if (i > 0) {
			return ServerResponse.createBySuccessMessage("删除成功");
		} else {
			return ServerResponse.createByErrorMessage("删除失败");
		}
	}

	@Override
	public ServerResponse updateUser(User user) {
		int i = userMapper.updateByPrimaryKeySelective(user);
		if (i > 0) {
			return ServerResponse.createBySuccessMessage("更新成功");
		} else {
			return ServerResponse.createByErrorMessage("更新失败");
		}
	}

	@Override
	public ServerResponse<User> queryUserById(Integer id) {

		User user = userMapper.selectByPrimaryKey(id);
		if (user.getId() != null) {
			return ServerResponse.createBySuccess(user);
		} else {
			return ServerResponse.createByErrorMessage("查询失败");
		}
	}
}
