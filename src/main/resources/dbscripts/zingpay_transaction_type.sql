create table zingpay_transaction_type
(
	zingpay_transaction_type_id int not null,
	zingpay_tramsaction_type_value varchar(45) null,
	description varchar(45) null,
	primary_flg tinyint null,
	constraint zingpay_transaction_type_pk
		primary key (zingpay_transaction_type_id)
);

INSERT INTO `zingpay_transaction_type` VALUES (1,'TX_RECHARGE','rep portal fund transfer',1),(2,'TX_FUND_TRANSFER','customer portal fund transfer',1),(3,'TX_BUY','Buy',1),(4,'TX_BILL_PAYMENT','Bill Payment',0),(5,'TX_COMMISSION','Commission',0),(6,'TX_SERVICE_CHARGE','Service charge',0),(7,'TX_LOAD','Load',1),(8,'TX_CASH_IN','Cash in',1);