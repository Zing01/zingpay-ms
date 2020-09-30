create table transaction
(
	transaction_id int auto_increment,
	account_id int not null,
	transaction_type_id int null,
	transaction_status_id int null,
	one_load_transaction_type_id int null,
	amount double default 0.00 not null,
	retailer_network varchar(20) null,
	service_provider varchar(15) null,
	description varchar(1024) null,
	ref_from varchar(20) null,
	ref_to varchar(45) null,
	datetime timestamp not null,
	service_id int null,
	constraint transaction_pk
		primary key (transaction_id),
	constraint transaction_app_user_account_id_fk
		foreign key (account_id) references app_user (account_id),
	constraint transaction_transaction_status_id_fk
		foreign key (transaction_status_id) references transaction_status (id),
	constraint transaction_transaction_type_id_fk
		foreign key (transaction_type_id) references transaction_type (id)
);

