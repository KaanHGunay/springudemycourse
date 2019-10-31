insert into city(name) values ('Ankara');
insert into city(name) values ('Bursa');
insert into city(name) values ('Aydın');
insert into city(name) values ('Şırnak');

insert into personnel(batch_number, is_active, name, rutbe, surname, place_of_birth_id) VALUES ( '378', true , 'test', 'Polis Memuru', 'test', 1);

insert into user(active, password, permissions, roles, username) values ( true, '$2b$10$cdWp0wFZpqXUuABPs6Q3uuYQp6QP2lkGcYXRTGIdhZpXX.LcCqZZ.', '', 'ADMIN', 'a' );