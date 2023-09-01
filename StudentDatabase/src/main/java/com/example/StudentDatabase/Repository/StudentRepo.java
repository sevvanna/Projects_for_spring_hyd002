package com.example.StudentDatabase.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.StudentDatabase.entity.Student;
@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {

	@Query(value =  "select * from Student where email =?" , nativeQuery = true)
	Student findByEmail(String email);

	
//	@Query(value = "delete from Student where email =?" , nativeQuery = true)
//	void deleteById(String email);

	
	
	
}
