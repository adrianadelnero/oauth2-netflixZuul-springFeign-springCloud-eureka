DROP TABLE IF EXISTS Student;

CREATE TABLE Student (
  id INT PRIMARY KEY,
  name VARCHAR(50) NOT NULL,
  class_section VARCHAR(50) NOT NULL,
  class_teacher_id INT NOT NULL
  
);

insert into student (id,name,class_section,class_teacher_id) values(1,'Maria','1A',3);
insert into student (id,name,class_section,class_teacher_id) values(2,'Pedro','1B',4);
insert into student (id,name,class_section,class_teacher_id) values(3,'Mariana','1A',3);
insert into student (id,name,class_section,class_teacher_id) values(4,'Bruno','1B',4);
insert into student (id,name,class_section,class_teacher_id) values(5,'Isaac','1A',3);
insert into student (id,name,class_section,class_teacher_id) values(6,'Abraão','1B',4);
insert into student (id,name,class_section,class_teacher_id) values(7,'Felipe','2B',5);
insert into student (id,name,class_section,class_teacher_id) values(8,'Silvia','2B',5);