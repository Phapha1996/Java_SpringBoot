package org.fage.repository;

import java.util.List;

import org.fage.domain.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface StudentRepository extends CrudRepository<Student,String>{
	
	@Query("select s from Student s left join s.grade g where g.name=:gradeName")
	List<Student> findByGName(@Param("gradeName")String gradeName);
	
}
