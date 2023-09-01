package com.example.StudentDatabase.Service;

import com.example.StudentDatabase.entity.Student;

public interface StudentService { 
	
	Student login(String email ,String password);

	Student addStudent(Student student);

	Student updatedb(String email, Student student);

	
	void Delete(String email);
}
