INSERT INTO `user_account_status` VALUES (1, "ACTIVE", "Active state"), (2, "PENDING", "Pending state is used until user activates his account by verifying email or cell phone number"), (3, "SUSPEND", "Suspend state is used when user tries for wrong password"), (4, "INACTIVE", "Inactive state is used when we need to block user");

INSERT INTO user_account_type (user_account_type_id, account_type_value, description) VALUES (1, "VIRTUAL_AGENT", "Virtual Agent");
INSERT INTO user_account_type (user_account_type_id, account_type_value, description) VALUES (2, "RETAILER", "Retailer");
INSERT INTO user_account_type (user_account_type_id, account_type_value, description) VALUES (3, "SUPERSUPERREP", "ZingPay executive user");
INSERT INTO user_account_type (user_account_type_id, account_type_value, description) VALUES (4, "SUPERREP", "Executive User");
INSERT INTO user_account_type (user_account_type_id, account_type_value, description) VALUES (5, "REP", "Reep User");
INSERT INTO user_account_type (user_account_type_id, account_type_value, description) VALUES (6, "CONSUMER", "Consumer User");

INSERT INTO authority (id, name, description) VALUES (1, 'USER_READ', 'User Read Authority');
INSERT INTO authority (id, name, description) VALUES (2, 'USER_WRITE', 'User Write Authority');
INSERT INTO authority (id, name, description) VALUES (3, 'USER_UPDATE', 'User Update Authority');
INSERT INTO authority (id, name, description) VALUES (4, 'USER_DELETE', 'User Delete Authority');

INSERT INTO `deposit_type` VALUES (1, 'BANK_DEPOSIT', 'Bank Deposit'),(2, 'BANK_TRANSFER', 'Bank Transfer'),(3, 'EASY_PAISA', 'Easy Paisa');

/*INSERT INTO role (id, name, description) VALUES (1, 'DEFAULT', 'Default Role');*/

INSERT INTO `service_type` VALUES (1, 'HOUSE', 'House'),(2, 'SHOP', 'Shop');

INSERT INTO `transaction_status` VALUES (1,'SUCCESS','Successfull Transactions'),(2,'FAILED','Failed Transactions'),(3,'PENDING','Pending Transactions');

INSERT INTO `transaction_type` VALUES (1,'DEBIT','DEBIT'),(2,'CREDIT','CREDIT');

INSERT INTO user_group(user_group_id, name, type, effective_start_date, effective_end_date, active_ind) VALUES (1, "zingpay", "", "", "", 1);

INSERT INTO `zingpay_transaction_type` VALUES (1,'TX_RECHARGE','rep portal fund transfer',1),(2,'TX_FUND_TRANSFER','customer portal fund transfer',1),(3,'TX_BUY','Buy',1),(4,'TX_BILL_PAYMENT','Bill Payment',0),(5,'TX_COMMISSION','Commission',0),(6,'TX_SERVICE_CHARGE','Service charge',0),(7,'TX_LOAD','Load',1),(8,'TX_CASH_IN','Cash in',1);