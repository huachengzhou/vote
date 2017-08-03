use rt3;
drop table if exists address;
create table if not exists address(
	id int primary key auto_increment,
	location varchar(10) not null,
	ip varchar(30) not null
);
insert into address(location,ip) values('����','127.0.0.1');
insert into address(location,ip) values('����','192.168.10.1');
insert into address(location,ip) values('�Ϻ�','192.168.10.2');
insert into address(location,ip) values('��ɳ','192.168.10.3');
insert into address(location,ip) values('�人','192.168.10.4');
insert into address(location,ip) values('�人','192.168.10.4');
insert into address(location,ip) values('�й�','0:0:0:0:0:0:0:1');
select * from address;