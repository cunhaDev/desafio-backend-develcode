create table usuarios(

	id bigint not null auto_increment,
	first_name varchar(255) not null,
	date_nasc varchar(255) not null,
	profile_picture varchar(255) not null,
	
	primary key(id));