use rt3;
drop table info;
create table info(
 id int primary key auto_increment,
 ip varchar(30) not null,
 votetime timestamp
);


