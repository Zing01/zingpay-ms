create table app_user
(
	id int auto_increment,
	full_name varchar(255) null,
	mobile_number varchar(255) null,
	sms_pin int null,
	password varchar(255) null,
	cnic varchar(255) null,
	email varchar(255) null,
	email_pin int null,
	active boolean null,
	security_code varchar(255) null,
	picture varchar(255) null,
	person_name varchar(255) null,
	place_type varchar(255) null,
	agent_type varchar(255) null,
	address varchar(255) null,
	house_type varchar(255) null,
	location varchar(255) null,
	cnicf varchar(255) null,
	cnicb varchar(255) null,
	other_attachment varchar(255) null,
	t_pin int null,
	constraint app_user_pk
		primary key (id)
);