create table deposit_type
(
	id int null,
	value varchar(255) null,
	description varchar(255) null
);

INSERT INTO `deposit_type` VALUES (1, 'BANK_DEPOSIT', 'Bank Deposit'),(2, 'BANK_TRANSFER', 'Bank Transfer'),(3, 'EASY_PAISA', 'Easy Paisa');