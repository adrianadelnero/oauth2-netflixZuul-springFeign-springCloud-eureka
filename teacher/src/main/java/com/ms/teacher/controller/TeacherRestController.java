package com.ms.teacher.controller;

import java.util.List;
import com.ms.teacher.bean.StudentBean;
import com.ms.teacher.dao.StudentClient;
import com.ms.teacher.dao.TeacherRepository;
import com.ms.teacher.entity.Teacher;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class TeacherRestController {
	
	@Autowired	
	 private TeacherRepository teacherRepository;
	
	@Autowired	
	 private StudentClient studentClient;

	@RequestMapping(value = "/teacher", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Teacher> teachers(){
		return teacherRepository.findAll();
	}

	@RequestMapping(value = "/teacher/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Teacher teacherById(@PathVariable int id) throws NotFoundException {
		return teacherRepository.findById(id).orElseThrow(() -> new NotFoundException("ID não encontrado"));
	}

	@RequestMapping(value = "/teacher/{id}/students", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<StudentBean> studentsForClassTeacherId(@PathVariable int id){
		return studentClient.studentsForClassReacherId(id);
		
	}
}

