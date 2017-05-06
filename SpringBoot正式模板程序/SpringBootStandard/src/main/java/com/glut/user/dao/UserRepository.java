package com.glut.user.dao;

import org.springframework.data.repository.CrudRepository;

import com.glut.domain.User;
/**
 * 
 * @author Caizhf
 * @date 2017年4月24日下午1:51:16
 * @version v.0.1
 * <p>Description: UserDao，只需要继承接口，Spring自动注入实现</p>
 *
 */
public interface UserRepository extends CrudRepository<User,Integer>{}
