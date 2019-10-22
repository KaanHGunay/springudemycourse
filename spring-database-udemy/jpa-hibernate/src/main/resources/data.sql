insert into course(id, name, created_date, last_updated_date)
values (1000, 'Test1', sysdate, sysdate);
insert into course(id, name, created_date, last_updated_date)
values (1001, 'Test2', sysdate, sysdate);
insert into course(id, name, created_date, last_updated_date)
values (1002, 'Test3', sysdate, sysdate);

insert into passport(id,number)
values(4001,'E123456');
insert into passport(id,number)
values(4002,'N123457');
insert into passport(id,number)
values(4003,'L123890');

insert into student(id,name,passport_id)
values(2001,'Ranga',4001);
insert into student(id,name,passport_id)
values(2002,'Adam',4002);
insert into student(id,name,passport_id)
values(2003,'Jane',4003);

insert into review(id,rating,description,course_id)
values(5001,'5', 'Great Course',1000);
insert into review(id,rating,description,course_id)
values(5002,'4', 'Wonderful Course',1000);
insert into review(id,rating,description,course_id)
values(5003,'5', 'Awesome Course',1002);

insert into student_course(student_id,course_id)
values(2001,1001);
insert into student_course(student_id,course_id)
values(2002,1001);
insert into student_course(student_id,course_id)
values(2003,1001);
insert into student_course(student_id,course_id)
values(2001,1002);