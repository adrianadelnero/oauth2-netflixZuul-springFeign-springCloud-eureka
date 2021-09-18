package com.ms.student;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentRestController {

@Autowired	
 private StudentRepository studentRepository;

@Autowired	
private Environment environment;

@GetMapping("/")
public String ping() {
	String port = environment.getProperty("local.server.port");
	return "Student instance with port "+ port;
}

@GetMapping("/all")
public List<Student> students(){
	return studentRepository.findAll();
}

@GetMapping("/{id}")
public Optional<Student> studentById(@PathVariable int id){
	return studentRepository.findById(id);
}

@GetMapping("/all/teacher/{id}")
public List<Student> studentsForClassTeacher(@PathVariable int id){
	return studentRepository.findByClassTeacherId(id);
}


}
