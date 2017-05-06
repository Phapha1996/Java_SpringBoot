package org.fage.repository;

import org.fage.domain.Grade;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;
/**
 * 
 * @author Caizhf
 * @date 2017年4月25日下午3:00:05
 * @version v.0.1
 * <p>Description: 与Student有级联关系</p>
 *
 */
@CacheConfig(cacheNames={"grades"})
public interface GradeRepository extends CrudRepository<Grade,String>{
	@Cacheable
	Grade findByName(String name);
}
