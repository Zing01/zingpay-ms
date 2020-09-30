create table transaction_status
(
	id int auto_increment,
	value varchar(255) null,
	description varchar(255) null,
	constraint transaction_status_pk
		primary key (id)
);

INSERT INTO `transaction_status` VALUES (1,'SUCCESS','Successfull Transactions'),(2,'FAILED','Failed Transactions'),(3,'PENDING','Pending Transactions');