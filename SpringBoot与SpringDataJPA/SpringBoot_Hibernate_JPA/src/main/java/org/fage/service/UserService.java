package org.fage.service;


import javax.annotation.Resource;

import org.fage.domain.User;
import org.fage.repository.UserReponsitory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
/**
 * 
 * @author Fapha
 * @date 2017年4月7日上午9:52:48
 * <p>Title: </p> 
 * <p>Description: 自动处理事务</p>
 *
 */
@Service
@Transactional(propagation=Propagation.REQUIRED)
public class UserService {
	@Resource
	private UserReponsitory userRepository;
	
	
	public void saveByEntity(User user){
		userRepository.save(user);
	}
	
	public void deleteById(int id){
		userRepository.delete(id);
	}
	
	public User getById(int id){
		return userRepository.findOne(id);
	}
	
	public void updateUser(int id){
		userRepository.update("doudou",id);
	}
}
