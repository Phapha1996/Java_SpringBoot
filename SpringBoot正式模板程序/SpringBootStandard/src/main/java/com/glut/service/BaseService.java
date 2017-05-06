package com.glut.service;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
/**
 * 
 * @author Caizhf
 * @date 2017年4月24日下午1:23:36
 * @version v.0.1
 * <p>Description: IBaseService的实现类</p>
 *
 */
@Transactional(/*readOnly=true,*/propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
public abstract class BaseService<T,ID extends Serializable> implements IBaseService<T,ID>{
	private CrudRepository<T,ID> repository;
	public void setRepository(CrudRepository<T,ID> repository) {
		this.repository = repository;
	}

	@Override
	public void saveOrUpdate(T entity) {
		repository.save(entity);
	}

	@Override
	public T findById(ID id) {
		return repository.findOne(id);
	}

	@Override
	public void delete(ID id) {
		repository.delete(id);
	}
	
}
