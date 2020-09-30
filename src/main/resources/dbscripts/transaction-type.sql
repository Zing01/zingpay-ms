create table transaction_type
(
	id int auto_increment,
	value varchar(255) null,
	description varchar(255) null,
	constraint transaction_type_pk
		primary key (id)
);

INSERT INTO `transaction_type` VALUES (1,'DEBIT','DEBIT'),(2,'CREDIT','CREDIT');