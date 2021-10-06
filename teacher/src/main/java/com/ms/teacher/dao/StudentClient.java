package com.ms.teacher.dao;

import java.util.List;

import com.ms.teacher.bean.StudentBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name ="student-service")
public interface StudentClient {
	
	@GetMapping("/all/teacher/{id}")
	public List<StudentBean> studentsForClassReacherId(@PathVariable int id);

}
