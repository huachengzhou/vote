use rt3;
drop table admin;
create table admin(
 id int primary key auto_increment,
 username varchar(20) not null,
 password varchar(6) not null
);
insert into admin(username,password) values("blake","123456");
insert into admin(username,password) values("alice","666666");
select * from admin;








