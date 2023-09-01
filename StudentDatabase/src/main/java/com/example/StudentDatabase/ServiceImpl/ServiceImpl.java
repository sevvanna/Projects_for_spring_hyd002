package com.example.StudentDatabase.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.StudentDatabase.Exception.ResourceNotFoundException;
import com.example.StudentDatabase.Repository.StudentRepo;
import com.example.StudentDatabase.Service.StudentService;
import com.example.StudentDatabase.entity.Student;

@Service
public class ServiceImpl implements StudentService {

	@Autowired
	StudentRepo studentRepo;
	
	@Override
	public Student login(String email, String password) {
		 Student s = studentRepo.findByEmail(email);
		 
		 if(s!=null) {
			 if(s.getPassword().equals(password)) {
				 return s;
			 }else {
				throw new ResourceNotFoundException();
			}
		 }else {
			 throw new ResourceNotFoundException();
		 }
	  
	}

	@Override
	public Student addStudent(Student student) {
		// TODO Auto-generated method stub
		return  studentRepo.save(student);
	}

	@Override
	public Student updatedb(String email, Student student) {
		// TODO Auto-generated method stub
		
		Student s1 = studentRepo.findByEmail(email);
		
		if(s1!=null) {
			s1.setFirstName(student.getFirstName());   // old to new set
			s1.setLastName(student.getLastName());
			s1.setPassword(student.getPassword());
		return studentRepo.save(s1);
		} 
		else 
		{
			throw new ResourceNotFoundException();
		} 
	}

	@Override
	public void Delete(String email) {
		// TODO Auto-generated method stub
		
		Student s2 = studentRepo.findByEmail(email);
		
		if(s2!=null) {
			studentRepo.delete(s2);
		}
		else {
			throw new ResourceNotFoundException();
		}		 
	}

	
	
}
