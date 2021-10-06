
DROP TABLE IF EXISTS teacher;

CREATE TABLE teacher (
  id INT PRIMARY KEY,
  name VARCHAR(50) NOT NULL,
  designation VARCHAR(50) NOT NULL
  
);

insert into teacher (id,name,designation) values(1,'Claudia','Artes');
insert into teacher (id,name,designation) values(2,'Roberta','Português');
insert into teacher (id,name,designation) values(3,'Augusta','Inglês');
insert into teacher (id,name,designation) values(4,'Samuel','Ed Fisica');
insert into teacher (id,name,designation) values(5,'Mauro','Historia');