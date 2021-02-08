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
    lat varchar(255) null,
    lng varchar(255) null,
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

/*create table organization_branch
(
    branch_id int auto_increment,
    organization_id int null,
    branch_name varchar(255) null,
    description varchar(255) null,
    is_default boolean default true null,
    default_retailer_group_id int null,
    constraint organization_branch_pk
        primary key (branch_id)
);*/

CREATE TABLE organization
(
    ORGANIZATION_ID int(11) NOT NULL AUTO_INCREMENT,
    ORGANIZATION_NAME varchar(45) DEFAULT NULL,
    DESCRIPTION varchar(45) DEFAULT NULL,
    PRIMARY KEY (ORGANIZATION_ID),
    UNIQUE KEY ORG_NAME_UNQ (ORGANIZATION_NAME)
);

CREATE TABLE org_branch
(
    BRANCH_ID int(15) NOT NULL AUTO_INCREMENT,
    ORGANIZATION_ID int(15) NOT NULL,
    BRANCH_NAME varchar(45) DEFAULT NULL,
    DESCRIPTION varchar(45) DEFAULT NULL,
    IS_DEFAULT tinyint(4) DEFAULT '0',
    DEFAULT_RETAILER_GROUP_ID int(15) DEFAULT NULL,
    PRIMARY KEY (BRANCH_ID),
    KEY FK_ORGANIZATION_BRANCH (ORGANIZATION_ID),
    CONSTRAINT FK_ORGANIZATION_BRANCH FOREIGN KEY (ORGANIZATION_ID)
        REFERENCES organization (ORGANIZATION_ID) ON DELETE NO ACTION ON UPDATE NO ACTION
);

create table ref_payment_type
(
    id int auto_increment not null,
    value varchar(255) null,
    description varchar(255) null,
    constraint ref_payment_type_pk
        primary key (id)
);

create unique index app_user_cnic_number_uindex
    on app_user (cnic_number);

alter table app_user
    add kyc_status_id int null;

alter table app_user
    add kyc_description varchar(255) null;

alter table app_user
    add device_id varchar(255) not null;

CREATE TABLE cash_deposit_transaction (
    CASH_DEPOSIT_TRANSACTION_ID int(11) NOT NULL AUTO_INCREMENT,
    ACCOUNT_ID int(11) DEFAULT NULL,
    TRANSACTION_REFERENCE varchar(45) DEFAULT NULL,
    RECEPIENT_ACCOUNT_ID int(11) DEFAULT NULL,
    CASH_DEPOSIT_TYPE_ID int(11) DEFAULT NULL,
    CURRENT_STATUS_ID int(11) DEFAULT NULL,
    SENDER_ACCOUNT_ID int(11) DEFAULT NULL,
    AMOUNT double(21,2) DEFAULT NULL,
    DESCRIPTION varchar(100) DEFAULT NULL,
    CASH_DEPOSIT_DATETIME datetime DEFAULT NULL,
    BANK_NAME varchar(45) DEFAULT NULL,
    BANK_BRANCH varchar(45) DEFAULT NULL,
    CASH_DEPOSIT_REFERENCE varchar(45) DEFAULT NULL,
    SENDER_CNIC varchar(45) DEFAULT NULL,
    SENDER_FULL_NAME varchar(45) DEFAULT NULL,
    SENDER_CELL_PHONE varchar(15) DEFAULT NULL,
    MODIFIED_BY int(11) DEFAULT NULL,
    MODIFIED_DATETIME datetime DEFAULT NULL,
    PRIMARY KEY (CASH_DEPOSIT_TRANSACTION_ID) USING BTREE,
    KEY FK_CASH_DEPOSIT_TRANSACTION_02_idx (CASH_DEPOSIT_TYPE_ID),
    KEY FK_CASH_DEPOSIT_TRANSACTION_03_idx (CURRENT_STATUS_ID),
    KEY FK_CASH_DEPOSIT_TRANSACTION_04_idx (RECEPIENT_ACCOUNT_ID),
    KEY FK_CASH_DEPOSIT_TRANSACTION_05_idx (SENDER_ACCOUNT_ID),
    KEY FK_CASH_DEPOSIT_TRANSACTION_06 (CASH_DEPOSIT_DATETIME),
    KEY FK_CASH_DEPOSIT_TRANSACTION_07_idx (TRANSACTION_REFERENCE),
    KEY CASH_DEPOSIT_TRAN_IDX (ACCOUNT_ID,CURRENT_STATUS_ID),
    CONSTRAINT FK_CASH_DEPOSIT_TRANSACTION_01 FOREIGN KEY (ACCOUNT_ID) REFERENCES app_user (ACCOUNT_ID) ON DELETE NO ACTION ON UPDATE NO ACTION,
    CONSTRAINT FK_CASH_DEPOSIT_TRANSACTION_02 FOREIGN KEY (CASH_DEPOSIT_TYPE_ID) REFERENCES ref_payment_type (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
    -- CONSTRAINT FK_CASH_DEPOSIT_TRANSACTION_03 FOREIGN KEY (CURRENT_STATUS_ID) REFERENCES ref_request_status (REQUEST_STATUS_ID) ON DELETE NO ACTION ON UPDATE NO ACTION,
    CONSTRAINT FK_CASH_DEPOSIT_TRANSACTION_04 FOREIGN KEY (RECEPIENT_ACCOUNT_ID) REFERENCES app_user (ACCOUNT_ID) ON DELETE NO ACTION ON UPDATE NO ACTION,
    CONSTRAINT FK_CASH_DEPOSIT_TRANSACTION_05 FOREIGN KEY (SENDER_ACCOUNT_ID) REFERENCES app_user (ACCOUNT_ID) ON DELETE NO ACTION ON UPDATE NO ACTION
);