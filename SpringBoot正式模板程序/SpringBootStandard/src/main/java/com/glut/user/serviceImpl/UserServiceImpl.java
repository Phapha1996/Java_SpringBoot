package com.glut.user.serviceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glut.domain.User;
import com.glut.service.BaseService;
import com.glut.user.dao.UserRepository;
import com.glut.user.service.UserService;
/**
 * 
 * @author Caizhf
 * @date 2017年4月24日下午4:30:50
 * @version v.0.1
 * <p>Description: UserService实现类,由于继承基础实现类，所以有基本的crud方法</p>
 *
 */
@Service("userService")
public class UserServiceImpl extends BaseService<User,Integer> implements UserService{

	private UserRepository userRepository;

	@Autowired
	public void setUserRepository(UserRepository userRepository) {
		super.setRepository(userRepository);
		this.userRepository = userRepository;
	}


}
