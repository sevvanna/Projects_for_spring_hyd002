package com.example.StudentDatabase.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.StudentDatabase.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	@Query(value =  "select * from User where username =?" , nativeQuery = true)
	User findByUsernameandPassword(String username,String password); 
		// TODO Auto-generated method stub
		

	
//	@Query(value = "delete from Student where email =?" , nativeQuery = true)
//	void deleteById(String email);

	
	
	
}
 


