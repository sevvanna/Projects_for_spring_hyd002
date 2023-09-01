package com.example.StudentDatabase.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.StudentDatabase.Service.StudentService;
import com.example.StudentDatabase.entity.Student;

@RestController
@RequestMapping()
public class StudentController {

	@Autowired
	StudentService studentService;
	
	@GetMapping("/login")
	public Student login(@RequestHeader String email ,
			@RequestHeader String password) {
		
		return studentService.login(email, password);  //golden java rule 
	}
	
	@PostMapping("/post")
	public Student addStudent(@RequestBody Student student) {
		
		return studentService.addStudent(student);
	}
	
	@PutMapping("/update")
	public Student update(@RequestHeader String email , @RequestBody Student student ) {
		
		return studentService.updatedb(email,student);
	}
	@DeleteMapping("/delete")
	public String delete(@RequestHeader String email) {
		studentService.Delete(email);
		return "data deleted";
	}
	
	
}
