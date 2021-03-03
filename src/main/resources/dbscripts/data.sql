INSERT INTO `user_account_status` VALUES (1, 'ACTIVE', 'Active state'), (2, 'PENDING', 'Pending state is used until user activates his account by verifying email or cell phone number'), (3, 'SUSPEND', 'Suspend state is used when user tries for wrong password'), (4, 'INACTIVE', 'Inactive state is used when we need to block user');

INSERT INTO user_account_type (user_account_type_id, account_type_value, description) VALUES (1, 'VIRTUAL_AGENT', 'Virtual Agent');
INSERT INTO user_account_type (user_account_type_id, account_type_value, description) VALUES (2, 'RETAILER', 'Retailer');
INSERT INTO user_account_type (user_account_type_id, account_type_value, description) VALUES (3, 'SUPERSUPERREP', 'ZingPay executive user');
INSERT INTO user_account_type (user_account_type_id, account_type_value, description) VALUES (4, 'SUPERREP', 'Executive User');
INSERT INTO user_account_type (user_account_type_id, account_type_value, description) VALUES (5, 'REP', 'Reep User');
INSERT INTO user_account_type (user_account_type_id, account_type_value, description) VALUES (6, 'CONSUMER', 'Consumer User');

INSERT INTO authority (id, name, description) VALUES (1, 'USER_READ', 'User Read Authority');
INSERT INTO authority (id, name, description) VALUES (2, 'USER_WRITE', 'User Write Authority');
INSERT INTO authority (id, name, description) VALUES (3, 'USER_UPDATE', 'User Update Authority');
INSERT INTO authority (id, name, description) VALUES (4, 'USER_DELETE', 'User Delete Authority');

INSERT INTO `deposit_type` VALUES (1, 'BANK_DEPOSIT', 'Bank Deposit'),(2, 'BANK_TRANSFER', 'Bank Transfer'),(3, 'EASY_PAISA', 'Easy Paisa');

/*INSERT INTO role (id, name, description) VALUES (1, 'DEFAULT', 'Default Role');*/

INSERT INTO `service_type` VALUES (1, 'HOUSE', 'House'),(2, 'SHOP', 'Shop');

INSERT INTO `transaction_status` VALUES (1,'SUCCESS','Successfull Transactions'),(2,'FAILED','Failed Transactions'),(3,'PENDING','Pending Transactions');

INSERT INTO `transaction_type` VALUES (1,'DEBIT','DEBIT'),(2,'CREDIT','CREDIT');

INSERT INTO `zingpay_transaction_type` VALUES (1,'TX_RECHARGE','rep portal fund transfer',1),(2,'TX_FUND_TRANSFER','customer portal fund transfer',1),(3,'TX_BUY','Buy',1),(4,'TX_BILL_PAYMENT','Bill Payment',0),(5,'TX_COMMISSION','Commission',0),(6,'TX_SERVICE_CHARGE','Service charge',0),(7,'TX_LOAD','Load',1),(8,'TX_CASH_IN','Cash in',1);

INSERT INTO user_group VALUES (1, 'DEFAULT', null, null, null, 1), (2, 'ZINGPAY', null, null, null, 1), (3, 'AGENT_MASTER', null, null, null, 1), (4, 'AGENT', null, null, null, 1);

INSERT INTO ref_fee_type (FEE_TYPE_ID, FEE_TYPE, DESCRIPTION) VALUES (1, 'ABSOLUTE', 'Service Fee in amount'), (2, 'VARIABLE', 'Service Fee in percentage');

INSERT INTO ref_payment_type (id, value, description) VALUES (1, 'Cash', 'cash'), (2, 'Credit', 'credit');

INSERT INTO ref_service_broker (SERVICE_BROKER_ID, SERVICE_BROKER_NAME, SERVICE_BROKER_DESC, ACTIVE) VALUES ('4', 'TELENOR_BANK', 'TELENOR_BANK', '1');

INSERT INTO ref_service_provider (SERVICE_PROVIDER_ID, SERVICE_BROKER_ID, SERVICE_PROVIDER_SHORT_NAME, SERVICE_PROVIDER_DISPLAY_NAME, SERVICE_PROVIDER_TYPE, CITY, SORT_ORDER, ACTIVE) VALUES ('4', '4', 'telenor bank', 'Telenor Bank', 'Mobile', 'All', '1', '1');

INSERT INTO ref_service_type (id, value, description) VALUES ('4', 'CASHIN', 'Cash Deposit');

INSERT INTO ref_service (SERVICE_ID, SERVICE_NAME, SERVICE_TYPE_ID,SERVICE_PROVIDER_ID,ACTIVE,PRICE,RETAIL_PRICE,SORT_ORDER) Select 1, 'CASHIN',(Select id from ref_service_type rst where rst.value = 'CASHIN'), SERVICE_PROVIDER_ID, 1,0,0,0 from ref_service_provider where SERVICE_PROVIDER_SHORT_NAME = 'telenor bank' and SERVICE_BROKER_ID =(select SERVICE_BROKER_ID from ref_service_broker where SERVICE_BROKER_NAME = 'TELENOR_BANK');

INSERT INTO ref_payment_method VALUES ('1', 'Cash', 'cash'), ('2', 'Bank', 'bank');

INSERT INTO ref_request_status VALUES ('1', 'Pending', 'pending'),('2', 'Submitted', 'submitted'), ('3', 'Approved', 'approved'), ('4', 'Rejected', 'rejected');

INSERT INTO app_user (account_type_id, account_status_id, username, password, full_name, cell_phone, alternate_cell_phone, is_generated_t_pin, device_id) VALUES (3, 1, 'GJHERJKGH', '{bcrypt}$2a$10$VlhfyywhdHwEBZTJD5Wk5u8qFImoN/ZhDQPFlC15KPIXivGR3hz36', 'TELENOR BANK', '22222222222', '00000000000', 1, 0);