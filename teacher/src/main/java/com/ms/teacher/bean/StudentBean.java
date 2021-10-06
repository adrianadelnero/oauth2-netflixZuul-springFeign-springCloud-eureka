package com.ms.teacher.bean;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class StudentBean {
	
	private int id;
	
	private String name;
	
	private String classSection;
	
	private Integer classTeacherId;

}
