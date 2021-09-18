package com.ms.teacher;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Teacher {
	
	@Id
	private int id;
	
	@Column
	@NotNull
	private String name;
	
	@Column
	@NotNull
	private String designation;
}
