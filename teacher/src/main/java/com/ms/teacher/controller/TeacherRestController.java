package com.ms.teacher;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeacherRestController {
	
	@Autowired	
	 private TeacherRepository teacherRepository;
	
	@Autowired	
	 private StudentClient studentClient;
	
	@GetMapping("/all")
	public List<Teacher> teachers(){
		return teacherRepository.findAll();
	}

	@GetMapping("/{id}")
	public Optional<Teacher> teacherById(@PathVariable int id){
		return teacherRepository.findById(id);
	}
	
	@GetMapping("/{id}/students")
	public List<StudentBean> studentsForClassTeacherId(@PathVariable int id){
		return studentClient.studentsForClassReacherId(id);
		
	}
}

