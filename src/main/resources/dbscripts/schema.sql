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
    pin varchar(255) null,
    house_number varchar(255) null,
    transaction_amount long,
    transaction_date long,
    transaction_id varchar(255),
    business_name varchar(255),
    profile_picture longblob,
    house_type_id int null,
    deposit_type_id int null,
    bussiness_name varchar(255) null,
    mobile_location varchar(255) null,
    cnic_issue_date mediumtext null,
    cnic_front longblob null,
    cnic_back longblob null,
    other_attachment longblob null,
    m_pin varchar(255) null,
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

/*create table user_group
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
    on user_group (name);*/


create table channel_type
(
    id int auto_increment not null,
    value varchar(255) null,
    description varchar(255) null,
    constraint channel_type_pk
        primary key (id)
);

create table deposit_type
(
    id int auto_increment not null,
    value varchar(255) null,
    description varchar(255) null,
    constraint deposit_type_pk
        primary key (id)
);

create table service_type
(
    id int auto_increment not null,
    value varchar(255) null,
    description varchar(255) null,
    constraint service_type_pk
        primary key (id)
);

create table transaction_status
(
    id int auto_increment,
    value varchar(255) null,
    description varchar(255) null,
    constraint transaction_status_pk
        primary key (id)
);

create table transaction_type
(
    id int auto_increment,
    value varchar(255) null,
    description varchar(255) null,
    constraint transaction_type_pk
        primary key (id)
);

create table transaction
(
    transaction_id int auto_increment,
    account_id int not null,
    transaction_type_id int null,
    transaction_status_id int null,
    zingpay_transaction_type_id int null,
    amount double default 0.00 not null,
    retailer_network varchar(20) null,
    service_provider varchar(15) null,
    description varchar(1024) null,
    ref_from varchar(20) null,
    ref_to varchar(45) null,
    datetime timestamp not null,
    service_id int null,
    retailer_ref_num varchar(255) null,
    provider_ref_num int null,
    channel_type_id int null,
    billing_month varchar(255) null,
    constraint transaction_pk
        primary key (transaction_id),
    constraint transaction_app_user_account_id_fk
        foreign key (account_id) references app_user (account_id),
    constraint transaction_transaction_status_id_fk
        foreign key (transaction_status_id) references transaction_status (id),
    constraint transaction_transaction_type_id_fk
        foreign key (transaction_type_id) references transaction_type (id)
);

create table zingpay_transaction_type
(
    zingpay_transaction_type_id int not null,
    zingpay_tramsaction_type_value varchar(45) null,
    description varchar(45) null,
    primary_flg tinyint null,
    constraint zingpay_transaction_type_pk
        primary key (zingpay_transaction_type_id)
);

create table organization_branch
(
    branch_id int auto_increment,
    organization_id int null,
    branch_name varchar(255) null,
    description varchar(255) null,
    is_default boolean default true null,
    default_retailer_group_id int null,
    constraint organization_branch_pk
        primary key (branch_id)
);

create unique index app_user_cnic_number_uindex
    on app_user (cnic_number);

alter table app_user
    add kyc_status_id int null;

alter table app_user
    add kyc_description varchar(255) null;

alter table app_user
    add device_id varchar(255) not null;