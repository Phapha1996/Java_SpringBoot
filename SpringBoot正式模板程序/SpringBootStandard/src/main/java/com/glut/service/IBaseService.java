package com.glut.service;

import java.io.Serializable;
/**
 * 
 * @author Caizhf
 * @date 2017年4月24日下午1:07:13
 * @version v.0.1
 * <p>Description: 基础的增删改查业务</p>
 *
 */
public interface IBaseService<T,ID extends Serializable> {
	public void saveOrUpdate(T entity);
	
	public T findById(ID id);
	
	public void delete(ID id);
}
