create table app_user
(
    account_id int auto_increment,
    parent_id int null,
    branch_id int null,
    group_id int null,
    account_type_id int null,
    account_status_id int null,
    service_status_id int null,
    service_type_id int null,
    username varchar(255) null,
    password varchar(255) null,
    full_name varchar(255) null,
    address varchar(255) null,
    cell_phone varchar(255) null,
    email varchar(255) null,
    cnic_number varchar(255) null,
    alternate_cell_phone varchar(255) null,
    last_login long null,
    created_date_time long null,
    created_by int null,
    modified_date_time long null,
    modified_by int null,
    suspend_date_time long null,
    t_pin varchar(255) null,
    login_failed_count int null,
    is_generated_t_pin boolean null,
    sms_pin varchar(255) null,
    email_pin varchar(255) null,
    house_number varchar(255) null,
    transaction_amount long,
    transaction_date long,
    transaction_id varchar(255),
    business_name varchar(255),
    profile_picture blob,
    constraint app_user_pk
        primary key (account_id)
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

create unique index app_user_cell_phone_uindex
	on app_user (cell_phone);

create table user_account_type
(
    user_account_type_id int auto_increment,
    account_type_value varchar(255) null,
    description varchar(255) null,
    constraint user_account_type_pk
        primary key (user_account_type_id)
);

create table user_account_status
(
    user_account_status_id int auto_increment,
    account_status_value varchar(255) null,
    description varchar(255) null,
    constraint user_account_status_pk
        primary key (user_account_status_id)
);

create table user_group
(
    user_group_id int auto_increment,
    name varchar(255) null,
    type varchar(255) null,
    effective_start_date long null,
    effective_end_date long null,
    active_ind tinyint null,
    constraint user_group_pk
        primary key (user_group_id)
);

create unique index user_group_name_uindex
    on user_group (name);

