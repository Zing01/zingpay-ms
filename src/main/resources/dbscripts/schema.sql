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
	t_pin varchar(255) null,
	constraint app_user_pk
		primary key (id)
);

create table authority
(
	id smallint auto_increment,
	name varchar(255) null,
	description varchar(255) null,
	constraint authority_pk
		primary key (id)
);

create unique index authority_name_uindex
	on authority (name);

create unique index app_user_email_uindex
	on app_user (email);

create unique index app_user_mobile_number_uindex
	on app_user (mobile_number);
