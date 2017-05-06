package org.fage.repository;

import org.fage.domain.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
/**
 * @author Fapha
 * @date 2017年4月5日下午10:48:53
 * <p>Title: Repository</p> 
 * <p>Description: UserDao
 * 	可以选择使用继承 extends CrudRepository<User,Integer>来实现
 *  三个接口:Repository、CrudRepository、PagingAndSortRepository;
 * </p>
 *
 */
//@RepositoryDefinition(domainClass = User.class, idClass = Integer.class) 
public interface UserReponsitory extends CrudRepository<User,Integer>{
	
	/**
	 * 
	 * @param username
	 * @param id
	 * <p>Description:JPQL更新、删除操作非常的特殊，需要加入Modifying注解<p/>
	 */
	@Modifying
	@Query("update User set username=:username where id=:id")
	public void update(@Param("username") String username,@Param("id")int id);
	
	@Modifying
	@Query("update User set department_id=:d_id where id=:u_id")
	public void updateByDepartmentIdAndUserId(@Param("d_id")int d_id,@Param("u_id")int u_id);

}
