INSERT INTO `zingpay`.`ref_service_broker` (`SERVICE_BROKER_ID`, `SERVICE_BROKER_NAME`, `SERVICE_BROKER_DESC`, `ACTIVE`) VALUES ('2', 'ZONG', 'ZONG', '1');


INSERT INTO `zingpay`.`ref_service_provider` (`SERVICE_PROVIDER_ID`, `SERVICE_BROKER_ID`, `SERVICE_PROVIDER_SHORT_NAME`, `SERVICE_PROVIDER_DISPLAY_NAME`, `SERVICE_PROVIDER_TYPE`, `CITY`, `SORT_ORDER`, `ACTIVE`) VALUES ('2', '2', 'ZONG', 'zong', 'MOBILE', 'Karachi, Lahore, Islamabad', '1', '1');


INSERT INTO `zingpay`.`ref_service_type` (`id`, `value`, `description`) VALUES ('1', 'LOAD', 'LOAD');
INSERT INTO `zingpay`.`ref_service_type` (`id`, `value`, `description`) VALUES ('2', 'BUNDLE', 'activate bundle');


INSERT INTO `zingpay`.`ref_service` (`SERVICE_ID`, `SERVICE_NAME`, `SERVICE_TYPE_ID`, `SERVICE_PROVIDER_ID`, `ACTIVE`, `SERVICE_CODE`)
Select 50, 'ZINGPAY_Load',(Select id from ref_service_type rst where rst.value = 'LOAD'), SERVICE_PROVIDER_ID, 1, '' from ref_service_provider
where SERVICE_PROVIDER_SHORT_NAME = 'zong' and SERVICE_BROKER_ID =(select SERVICE_BROKER_ID from ref_service_broker where SERVICE_BROKER_NAME = 'ZONG');

INSERT INTO `zingpay`.`ref_service` (`SERVICE_ID`, `SERVICE_NAME`, `PRICE`, `RETAIL_PRICE`, `SERVICE_TYPE_ID`, `SERVICE_PROVIDER_ID`, `ACTIVE`, `SERVICE_CODE`)
select 51, 'Internet SIM 8GB (Inc. 4GB - 4AM to 4PM)', '750', '750', (Select id from ref_service_type rst where rst.value = 'BUNDLE'), SERVICE_PROVIDER_ID, 1, '91027117' from ref_service_provider
where SERVICE_PROVIDER_SHORT_NAME = 'zong' and SERVICE_BROKER_ID=(select SERVICE_BROKER_ID from ref_service_broker where SERVICE_BROKER_NAME = 'ZONG');

INSERT INTO `zingpay`.`ref_service` (`SERVICE_ID`, `SERVICE_NAME`, `PRICE`, `RETAIL_PRICE`, `SERVICE_TYPE_ID`, `SERVICE_PROVIDER_ID`, `ACTIVE`, `SERVICE_CODE`)
select 52, 'Internet SIM 24GB (Inc. 12GB - 4AM to 4PM)', '1200', '1200', (Select id from ref_service_type rst where rst.value = 'BUNDLE'), SERVICE_PROVIDER_ID, 1, '91027118' from ref_service_provider
where SERVICE_PROVIDER_SHORT_NAME = 'zong' and SERVICE_BROKER_ID=(select SERVICE_BROKER_ID from ref_service_broker where SERVICE_BROKER_NAME = 'ZONG');

INSERT INTO `zingpay`.`ref_service` (`SERVICE_ID`, `SERVICE_NAME`, `PRICE`, `RETAIL_PRICE`, `SERVICE_TYPE_ID`, `SERVICE_PROVIDER_ID`, `ACTIVE`, `SERVICE_CODE`)
select 53, 'Internet SIM - 30GB', '1500', '1500', (Select id from ref_service_type rst where rst.value = 'BUNDLE'), SERVICE_PROVIDER_ID, 1, '91029907' from ref_service_provider
where SERVICE_PROVIDER_SHORT_NAME = 'zong' and SERVICE_BROKER_ID=(select SERVICE_BROKER_ID from ref_service_broker where SERVICE_BROKER_NAME = 'ZONG');

INSERT INTO `zingpay`.`ref_service` (`SERVICE_ID`, `SERVICE_NAME`, `PRICE`, `RETAIL_PRICE`, `SERVICE_TYPE_ID`, `SERVICE_PROVIDER_ID`, `ACTIVE`, `SERVICE_CODE`)
select 54, 'Prepaid MBB Monthly 60GB', '2000', '2000', (Select id from ref_service_type rst where rst.value = 'BUNDLE'), SERVICE_PROVIDER_ID, 1, '91026124' from ref_service_provider
where SERVICE_PROVIDER_SHORT_NAME = 'zong' and SERVICE_BROKER_ID=(select SERVICE_BROKER_ID from ref_service_broker where SERVICE_BROKER_NAME = 'ZONG');

INSERT INTO `zingpay`.`ref_service` (`SERVICE_ID`, `SERVICE_NAME`, `PRICE`, `RETAIL_PRICE`, `SERVICE_TYPE_ID`, `SERVICE_PROVIDER_ID`, `ACTIVE`, `SERVICE_CODE`)
select 55, 'Prepaid MBB Monthly 200 GB (Inc. 100 GB - 4AM to 4PM)', '3250', '3250', (Select id from ref_service_type rst where rst.value = 'BUNDLE'), SERVICE_PROVIDER_ID, 1, '91026125' from ref_service_provider
where SERVICE_PROVIDER_SHORT_NAME = 'zong' and SERVICE_BROKER_ID=(select SERVICE_BROKER_ID from ref_service_broker where SERVICE_BROKER_NAME = 'ZONG');

INSERT INTO `zingpay`.`ref_service` (`SERVICE_ID`, `SERVICE_NAME`, `PRICE`, `RETAIL_PRICE`, `SERVICE_TYPE_ID`, `SERVICE_PROVIDER_ID`, `ACTIVE`, `SERVICE_CODE`)
select 56, 'Prepaid MBB 6 Months Bundle 100GB/Month', '12000', '12000', (Select id from ref_service_type rst where rst.value = 'BUNDLE'), SERVICE_PROVIDER_ID, 1, '91020166' from ref_service_provider
where SERVICE_PROVIDER_SHORT_NAME = 'zong' and SERVICE_BROKER_ID=(select SERVICE_BROKER_ID from ref_service_broker where SERVICE_BROKER_NAME = 'ZONG');

INSERT INTO `zingpay`.`ref_service` (`SERVICE_ID`, `SERVICE_NAME`, `PRICE`, `RETAIL_PRICE`, `SERVICE_TYPE_ID`, `SERVICE_PROVIDER_ID`, `ACTIVE`, `SERVICE_CODE`)
select 57, 'Super Weekly Offer', '165', '165', (Select id from ref_service_type rst where rst.value = 'BUNDLE'), SERVICE_PROVIDER_ID, 1, '91000121' from ref_service_provider
where SERVICE_PROVIDER_SHORT_NAME = 'zong' and SERVICE_BROKER_ID=(select SERVICE_BROKER_ID from ref_service_broker where SERVICE_BROKER_NAME = 'ZONG');

INSERT INTO `zingpay`.`ref_service` (`SERVICE_ID`, `SERVICE_NAME`, `PRICE`, `RETAIL_PRICE`, `SERVICE_TYPE_ID`, `SERVICE_PROVIDER_ID`, `ACTIVE`, `SERVICE_CODE`)
select 58, 'Super Weekly Plus', '240', '240', (Select id from ref_service_type rst where rst.value = 'BUNDLE'), SERVICE_PROVIDER_ID, 1, '91029911' from ref_service_provider
where SERVICE_PROVIDER_SHORT_NAME = 'zong' and SERVICE_BROKER_ID=(select SERVICE_BROKER_ID from ref_service_broker where SERVICE_BROKER_NAME = 'ZONG');

INSERT INTO `zingpay`.`ref_service` (`SERVICE_ID`, `SERVICE_NAME`, `PRICE`, `RETAIL_PRICE`, `SERVICE_TYPE_ID`, `SERVICE_PROVIDER_ID`, `ACTIVE`, `SERVICE_CODE`)
select 59, 'Super Weekly Max', '299', '299', (Select id from ref_service_type rst where rst.value = 'BUNDLE'), SERVICE_PROVIDER_ID, 1, '95000646' from ref_service_provider
where SERVICE_PROVIDER_SHORT_NAME = 'zong' and SERVICE_BROKER_ID=(select SERVICE_BROKER_ID from ref_service_broker where SERVICE_BROKER_NAME = 'ZONG');

INSERT INTO `zingpay`.`ref_service` (`SERVICE_ID`, `SERVICE_NAME`, `PRICE`, `RETAIL_PRICE`, `SERVICE_TYPE_ID`, `SERVICE_PROVIDER_ID`, `ACTIVE`, `SERVICE_CODE`)
select 60, 'Monthly Premium 15GB', '1000', '1000', (Select id from ref_service_type rst where rst.value = 'BUNDLE'), SERVICE_PROVIDER_ID, 1, '91020067' from ref_service_provider
where SERVICE_PROVIDER_SHORT_NAME = 'zong' and SERVICE_BROKER_ID=(select SERVICE_BROKER_ID from ref_service_broker where SERVICE_BROKER_NAME = 'ZONG');

INSERT INTO `zingpay`.`ref_service` (`SERVICE_ID`, `SERVICE_NAME`, `PRICE`, `RETAIL_PRICE`, `SERVICE_TYPE_ID`, `SERVICE_PROVIDER_ID`, `ACTIVE`, `SERVICE_CODE`)
select 61, 'Whatsapp Offer', '50', '50', (Select id from ref_service_type rst where rst.value = 'BUNDLE'), SERVICE_PROVIDER_ID, 1, '91020404' from ref_service_provider
where SERVICE_PROVIDER_SHORT_NAME = 'zong' and SERVICE_BROKER_ID=(select SERVICE_BROKER_ID from ref_service_broker where SERVICE_BROKER_NAME = 'ZONG');

INSERT INTO `zingpay`.`ref_service` (`SERVICE_ID`, `SERVICE_NAME`, `PRICE`, `RETAIL_PRICE`, `SERVICE_TYPE_ID`, `SERVICE_PROVIDER_ID`, `ACTIVE`, `SERVICE_CODE`)
select 62, 'IMO Offer', '50', '50', (Select id from ref_service_type rst where rst.value = 'BUNDLE'), SERVICE_PROVIDER_ID, 1, '91029937' from ref_service_provider
where SERVICE_PROVIDER_SHORT_NAME = 'zong' and SERVICE_BROKER_ID=(select SERVICE_BROKER_ID from ref_service_broker where SERVICE_BROKER_NAME = 'ZONG');

INSERT INTO `zingpay`.`ref_service` (`SERVICE_ID`, `SERVICE_NAME`, `PRICE`, `RETAIL_PRICE`, `SERVICE_TYPE_ID`, `SERVICE_PROVIDER_ID`, `ACTIVE`, `SERVICE_CODE`)
select 63, 'All-In-One Monthly/ ZONG Super Card', '650', '650', (Select id from ref_service_type rst where rst.value = 'BUNDLE'), SERVICE_PROVIDER_ID, 1, '91000182' from ref_service_provider
where SERVICE_PROVIDER_SHORT_NAME = 'zong' and SERVICE_BROKER_ID=(select SERVICE_BROKER_ID from ref_service_broker where SERVICE_BROKER_NAME = 'ZONG');

INSERT INTO `zingpay`.`ref_service` (`SERVICE_ID`, `SERVICE_NAME`, `PRICE`, `RETAIL_PRICE`, `SERVICE_TYPE_ID`, `SERVICE_PROVIDER_ID`, `ACTIVE`, `SERVICE_CODE`)
select 64, 'Supreme Offer', '1000', '1000', (Select id from ref_service_type rst where rst.value = 'BUNDLE'), SERVICE_PROVIDER_ID, 1, '91023604' from ref_service_provider
where SERVICE_PROVIDER_SHORT_NAME = 'zong' and SERVICE_BROKER_ID=(select SERVICE_BROKER_ID from ref_service_broker where SERVICE_BROKER_NAME = 'ZONG');

INSERT INTO `zingpay`.`ref_service` (`SERVICE_ID`, `SERVICE_NAME`, `PRICE`, `RETAIL_PRICE`, `SERVICE_TYPE_ID`, `SERVICE_PROVIDER_ID`, `ACTIVE`, `SERVICE_CODE`)
select 65, 'Supreme Plus Offer', '1732', '1732', (Select id from ref_service_type rst where rst.value = 'BUNDLE'), SERVICE_PROVIDER_ID, 1, '91000180' from ref_service_provider
where SERVICE_PROVIDER_SHORT_NAME = 'zong' and SERVICE_BROKER_ID=(select SERVICE_BROKER_ID from ref_service_broker where SERVICE_BROKER_NAME = 'ZONG');

INSERT INTO `zingpay`.`ref_service` (`SERVICE_ID`, `SERVICE_NAME`, `PRICE`, `RETAIL_PRICE`, `SERVICE_TYPE_ID`, `SERVICE_PROVIDER_ID`, `ACTIVE`, `SERVICE_CODE`)
select 66, 'Weekly Hybrid Bundle', '200', '200', (Select id from ref_service_type rst where rst.value = 'BUNDLE'), SERVICE_PROVIDER_ID, 1, '91020181' from ref_service_provider
where SERVICE_PROVIDER_SHORT_NAME = 'zong' and SERVICE_BROKER_ID=(select SERVICE_BROKER_ID from ref_service_broker where SERVICE_BROKER_NAME = 'ZONG');

INSERT INTO `zingpay`.`ref_service` (`SERVICE_ID`, `SERVICE_NAME`, `PRICE`, `RETAIL_PRICE`, `SERVICE_TYPE_ID`, `SERVICE_PROVIDER_ID`, `ACTIVE`, `SERVICE_CODE`)
select 67, 'Weekly SMS', '29', '29', (Select id from ref_service_type rst where rst.value = 'BUNDLE'), SERVICE_PROVIDER_ID, 1, '91056273' from ref_service_provider
where SERVICE_PROVIDER_SHORT_NAME = 'zong' and SERVICE_BROKER_ID=(select SERVICE_BROKER_ID from ref_service_broker where SERVICE_BROKER_NAME = 'ZONG');

INSERT INTO `zingpay`.`ref_service` (`SERVICE_ID`, `SERVICE_NAME`, `PRICE`, `RETAIL_PRICE`, `SERVICE_TYPE_ID`, `SERVICE_PROVIDER_ID`, `ACTIVE`, `SERVICE_CODE`)
select 68, 'Monthly SMS', '68', '68', (Select id from ref_service_type rst where rst.value = 'BUNDLE'), SERVICE_PROVIDER_ID, 1, '91056272' from ref_service_provider
where SERVICE_PROVIDER_SHORT_NAME = 'zong' and SERVICE_BROKER_ID=(select SERVICE_BROKER_ID from ref_service_broker where SERVICE_BROKER_NAME = 'ZONG');

INSERT INTO `zingpay`.`ref_service` (`SERVICE_ID`, `SERVICE_NAME`, `PRICE`, `RETAIL_PRICE`, `SERVICE_TYPE_ID`, `SERVICE_PROVIDER_ID`, `ACTIVE`, `SERVICE_CODE`)
select 69, 'Ilaqai Offer/Punjab', '230', '230', (Select id from ref_service_type rst where rst.value = 'BUNDLE'), SERVICE_PROVIDER_ID, 1, '91029939' from ref_service_provider
where SERVICE_PROVIDER_SHORT_NAME = 'zong' and SERVICE_BROKER_ID=(select SERVICE_BROKER_ID from ref_service_broker where SERVICE_BROKER_NAME = 'ZONG');

INSERT INTO `zingpay`.`ref_service` (`SERVICE_ID`, `SERVICE_NAME`, `PRICE`, `RETAIL_PRICE`, `SERVICE_TYPE_ID`, `SERVICE_PROVIDER_ID`, `ACTIVE`, `SERVICE_CODE`)
select 70, 'Monthly Facebook', '100', '100', (Select id from ref_service_type rst where rst.value = 'BUNDLE'), SERVICE_PROVIDER_ID, 1, '91900004' from ref_service_provider
where SERVICE_PROVIDER_SHORT_NAME = 'zong' and SERVICE_BROKER_ID=(select SERVICE_BROKER_ID from ref_service_broker where SERVICE_BROKER_NAME = 'ZONG');

INSERT INTO `zingpay`.`ref_service` (`SERVICE_ID`, `SERVICE_NAME`, `PRICE`, `RETAIL_PRICE`, `SERVICE_TYPE_ID`, `SERVICE_PROVIDER_ID`, `ACTIVE`, `SERVICE_CODE`)
select 71, 'Weekly Youtube', '135', '135', (Select id from ref_service_type rst where rst.value = 'BUNDLE'), SERVICE_PROVIDER_ID, 1, '95000562' from ref_service_provider
where SERVICE_PROVIDER_SHORT_NAME = 'zong' and SERVICE_BROKER_ID=(select SERVICE_BROKER_ID from ref_service_broker where SERVICE_BROKER_NAME = 'ZONG');

INSERT INTO `zingpay`.`ref_service` (`SERVICE_ID`, `SERVICE_NAME`, `PRICE`, `RETAIL_PRICE`, `SERVICE_TYPE_ID`, `SERVICE_PROVIDER_ID`, `ACTIVE`, `SERVICE_CODE`)
select 72, 'KSA Offer', '2689', '2689', (Select id from ref_service_type rst where rst.value = 'BUNDLE'), SERVICE_PROVIDER_ID, 1, '95000474' from ref_service_provider
where SERVICE_PROVIDER_SHORT_NAME = 'zong' and SERVICE_BROKER_ID=(select SERVICE_BROKER_ID from ref_service_broker where SERVICE_BROKER_NAME = 'ZONG');

INSERT INTO `zingpay`.`ref_service` (`SERVICE_ID`, `SERVICE_NAME`, `PRICE`, `RETAIL_PRICE`, `SERVICE_TYPE_ID`, `SERVICE_PROVIDER_ID`, `ACTIVE`, `SERVICE_CODE`)
select 73, 'Weekly TIKTok Offer', '50', '50', (Select id from ref_service_type rst where rst.value = 'BUNDLE'), SERVICE_PROVIDER_ID, 1, '95000882' from ref_service_provider
where SERVICE_PROVIDER_SHORT_NAME = 'zong' and SERVICE_BROKER_ID=(select SERVICE_BROKER_ID from ref_service_broker where SERVICE_BROKER_NAME = 'ZONG');

INSERT INTO `zingpay`.`ref_service` (`SERVICE_ID`, `SERVICE_NAME`, `PRICE`, `RETAIL_PRICE`, `SERVICE_TYPE_ID`, `SERVICE_PROVIDER_ID`, `ACTIVE`, `SERVICE_CODE`)
select 74, 'Haftawar Load Offer', '250', '250', (Select id from ref_service_type rst where rst.value = 'BUNDLE'), SERVICE_PROVIDER_ID, 1, '91024007' from ref_service_provider
where SERVICE_PROVIDER_SHORT_NAME = 'zong' and SERVICE_BROKER_ID=(select SERVICE_BROKER_ID from ref_service_broker where SERVICE_BROKER_NAME = 'ZONG');

INSERT INTO `zingpay`.`ref_service` (`SERVICE_ID`, `SERVICE_NAME`, `PRICE`, `RETAIL_PRICE`, `SERVICE_TYPE_ID`, `SERVICE_PROVIDER_ID`, `ACTIVE`, `SERVICE_CODE`)
select 75, 'Mega Data Offer', '100', '100', (Select id from ref_service_type rst where rst.value = 'BUNDLE'), SERVICE_PROVIDER_ID, 1, '95001185' from ref_service_provider
where SERVICE_PROVIDER_SHORT_NAME = 'zong' and SERVICE_BROKER_ID=(select SERVICE_BROKER_ID from ref_service_broker where SERVICE_BROKER_NAME = 'ZONG');

INSERT INTO `zingpay`.`ref_service` (`SERVICE_ID`, `SERVICE_NAME`, `PRICE`, `RETAIL_PRICE`, `SERVICE_TYPE_ID`, `SERVICE_PROVIDER_ID`, `ACTIVE`, `SERVICE_CODE`)
select 76, 'Super Weekly Premium', '330', '330', (Select id from ref_service_type rst where rst.value = 'BUNDLE'), SERVICE_PROVIDER_ID, 1, '95000966' from ref_service_provider
where SERVICE_PROVIDER_SHORT_NAME = 'zong' and SERVICE_BROKER_ID=(select SERVICE_BROKER_ID from ref_service_broker where SERVICE_BROKER_NAME = 'ZONG');


INSERT INTO `zingpay`.`fee_group` (`NAME`, `ACTIVE_IND`) VALUES ('LOAD_ZONG_DEFAULT', '1'), ('LOAD_ZONG_ZINGPAY', '1'), ('LOAD_ZONG_AGENT_MASTER', '1'), ('LOAD_ZONG_AGENT', '1'), ('BUNDLE_ZONG_DEFAULT', '1'), ('BUNDLE_ZONG_ZINGPAY', '1'), ('BUNDLE_ZONG_AGENT_MASTER', '1'), ('BUNDLE_ZONG_AGENT', '1');


insert into service_fee_group (service_id, fee_group_id, ACTIVE_IND) select 50, fee_group_id, 1 from fee_group where name like '%LOAD_ZONG%';
insert into service_fee_group (service_id, fee_group_id, ACTIVE_IND) select 51, fee_group_id, 1 from fee_group where name like '%BUNDLE_ZONG%';
insert into service_fee_group (service_id, fee_group_id, ACTIVE_IND) select 52, fee_group_id, 1 from fee_group where name like '%BUNDLE_ZONG%';
insert into service_fee_group (service_id, fee_group_id, ACTIVE_IND) select 53, fee_group_id, 1 from fee_group where name like '%BUNDLE_ZONG%';
insert into service_fee_group (service_id, fee_group_id, ACTIVE_IND) select 54, fee_group_id, 1 from fee_group where name like '%BUNDLE_ZONG%';
insert into service_fee_group (service_id, fee_group_id, ACTIVE_IND) select 55, fee_group_id, 1 from fee_group where name like '%BUNDLE_ZONG%';
insert into service_fee_group (service_id, fee_group_id, ACTIVE_IND) select 56, fee_group_id, 1 from fee_group where name like '%BUNDLE_ZONG%';
insert into service_fee_group (service_id, fee_group_id, ACTIVE_IND) select 57, fee_group_id, 1 from fee_group where name like '%BUNDLE_ZONG%';
insert into service_fee_group (service_id, fee_group_id, ACTIVE_IND) select 58, fee_group_id, 1 from fee_group where name like '%BUNDLE_ZONG%';
insert into service_fee_group (service_id, fee_group_id, ACTIVE_IND) select 59, fee_group_id, 1 from fee_group where name like '%BUNDLE_ZONG%';
insert into service_fee_group (service_id, fee_group_id, ACTIVE_IND) select 60, fee_group_id, 1 from fee_group where name like '%BUNDLE_ZONG%';
insert into service_fee_group (service_id, fee_group_id, ACTIVE_IND) select 61, fee_group_id, 1 from fee_group where name like '%BUNDLE_ZONG%';
insert into service_fee_group (service_id, fee_group_id, ACTIVE_IND) select 62, fee_group_id, 1 from fee_group where name like '%BUNDLE_ZONG%';
insert into service_fee_group (service_id, fee_group_id, ACTIVE_IND) select 63, fee_group_id, 1 from fee_group where name like '%BUNDLE_ZONG%';
insert into service_fee_group (service_id, fee_group_id, ACTIVE_IND) select 64, fee_group_id, 1 from fee_group where name like '%BUNDLE_ZONG%';
insert into service_fee_group (service_id, fee_group_id, ACTIVE_IND) select 65, fee_group_id, 1 from fee_group where name like '%BUNDLE_ZONG%';
insert into service_fee_group (service_id, fee_group_id, ACTIVE_IND) select 66, fee_group_id, 1 from fee_group where name like '%BUNDLE_ZONG%';
insert into service_fee_group (service_id, fee_group_id, ACTIVE_IND) select 67, fee_group_id, 1 from fee_group where name like '%BUNDLE_ZONG%';
insert into service_fee_group (service_id, fee_group_id, ACTIVE_IND) select 68, fee_group_id, 1 from fee_group where name like '%BUNDLE_ZONG%';
insert into service_fee_group (service_id, fee_group_id, ACTIVE_IND) select 69, fee_group_id, 1 from fee_group where name like '%BUNDLE_ZONG%';
insert into service_fee_group (service_id, fee_group_id, ACTIVE_IND) select 70, fee_group_id, 1 from fee_group where name like '%BUNDLE_ZONG%';
insert into service_fee_group (service_id, fee_group_id, ACTIVE_IND) select 71, fee_group_id, 1 from fee_group where name like '%BUNDLE_ZONG%';
insert into service_fee_group (service_id, fee_group_id, ACTIVE_IND) select 72, fee_group_id, 1 from fee_group where name like '%BUNDLE_ZONG%';
insert into service_fee_group (service_id, fee_group_id, ACTIVE_IND) select 73, fee_group_id, 1 from fee_group where name like '%BUNDLE_ZONG%';
insert into service_fee_group (service_id, fee_group_id, ACTIVE_IND) select 74, fee_group_id, 1 from fee_group where name like '%BUNDLE_ZONG%';
insert into service_fee_group (service_id, fee_group_id, ACTIVE_IND) select 75, fee_group_id, 1 from fee_group where name like '%BUNDLE_ZONG%';
insert into service_fee_group (service_id, fee_group_id, ACTIVE_IND) select 76, fee_group_id, 1 from fee_group where name like '%BUNDLE_ZONG%';


insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 1, service_fee_group_id, 1 from service_fee_group where service_id = 50 and fee_group_id in (select fee_group_id from fee_group where name like '%LOAD_ZONG_DEFAULT');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 2, service_fee_group_id, 1 from service_fee_group where service_id = 50 and fee_group_id in (select fee_group_id from fee_group where name like '%LOAD_ZONG_ZINGPAY');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 3, service_fee_group_id, 1 from service_fee_group where service_id = 50 and fee_group_id in (select fee_group_id from fee_group where name like '%LOAD_ZONG_AGENT_MASTER');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 4, service_fee_group_id, 1 from service_fee_group where service_id = 50 and fee_group_id in (select fee_group_id from fee_group where name like '%LOAD_ZONG_AGENT');

insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 1, service_fee_group_id, 1 from service_fee_group where service_id = 51 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_ZONG_DEFAULT');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 2, service_fee_group_id, 1 from service_fee_group where service_id = 51 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_ZONG_ZINGPAY');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 3, service_fee_group_id, 1 from service_fee_group where service_id = 51 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_ZONG_AGENT_MASTER');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 4, service_fee_group_id, 1 from service_fee_group where service_id = 51 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_ZONG_AGENT');

insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 1, service_fee_group_id, 1 from service_fee_group where service_id = 52 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_ZONG_DEFAULT');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 2, service_fee_group_id, 1 from service_fee_group where service_id = 52 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_ZONG_ZINGPAY');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 3, service_fee_group_id, 1 from service_fee_group where service_id = 52 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_ZONG_AGENT_MASTER');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 4, service_fee_group_id, 1 from service_fee_group where service_id = 52 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_ZONG_AGENT');

insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 1, service_fee_group_id, 1 from service_fee_group where service_id = 53 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_ZONG_DEFAULT');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 2, service_fee_group_id, 1 from service_fee_group where service_id = 53 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_ZONG_ZINGPAY');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 3, service_fee_group_id, 1 from service_fee_group where service_id = 53 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_ZONG_AGENT_MASTER');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 4, service_fee_group_id, 1 from service_fee_group where service_id = 53 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_ZONG_AGENT');

insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 1, service_fee_group_id, 1 from service_fee_group where service_id = 54 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_ZONG_DEFAULT');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 2, service_fee_group_id, 1 from service_fee_group where service_id = 54 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_ZONG_ZINGPAY');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 3, service_fee_group_id, 1 from service_fee_group where service_id = 54 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_ZONG_AGENT_MASTER');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 4, service_fee_group_id, 1 from service_fee_group where service_id = 54 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_ZONG_AGENT');

insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 1, service_fee_group_id, 1 from service_fee_group where service_id = 55 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_ZONG_DEFAULT');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 2, service_fee_group_id, 1 from service_fee_group where service_id = 55 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_ZONG_ZINGPAY');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 3, service_fee_group_id, 1 from service_fee_group where service_id = 55 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_ZONG_AGENT_MASTER');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 4, service_fee_group_id, 1 from service_fee_group where service_id = 55 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_ZONG_AGENT');

insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 1, service_fee_group_id, 1 from service_fee_group where service_id = 56 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_ZONG_DEFAULT');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 2, service_fee_group_id, 1 from service_fee_group where service_id = 56 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_ZONG_ZINGPAY');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 3, service_fee_group_id, 1 from service_fee_group where service_id = 56 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_ZONG_AGENT_MASTER');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 4, service_fee_group_id, 1 from service_fee_group where service_id = 56 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_ZONG_AGENT');

insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 1, service_fee_group_id, 1 from service_fee_group where service_id = 57 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_ZONG_DEFAULT');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 2, service_fee_group_id, 1 from service_fee_group where service_id = 57 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_ZONG_ZINGPAY');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 3, service_fee_group_id, 1 from service_fee_group where service_id = 57 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_ZONG_AGENT_MASTER');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 4, service_fee_group_id, 1 from service_fee_group where service_id = 57 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_ZONG_AGENT');

insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 1, service_fee_group_id, 1 from service_fee_group where service_id = 58 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_ZONG_DEFAULT');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 2, service_fee_group_id, 1 from service_fee_group where service_id = 58 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_ZONG_ZINGPAY');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 3, service_fee_group_id, 1 from service_fee_group where service_id = 58 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_ZONG_AGENT_MASTER');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 4, service_fee_group_id, 1 from service_fee_group where service_id = 58 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_ZONG_AGENT');

insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 1, service_fee_group_id, 1 from service_fee_group where service_id = 59 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_ZONG_DEFAULT');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 2, service_fee_group_id, 1 from service_fee_group where service_id = 59 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_ZONG_ZINGPAY');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 3, service_fee_group_id, 1 from service_fee_group where service_id = 59 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_ZONG_AGENT_MASTER');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 4, service_fee_group_id, 1 from service_fee_group where service_id = 59 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_ZONG_AGENT');

insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 1, service_fee_group_id, 1 from service_fee_group where service_id = 60 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_ZONG_DEFAULT');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 2, service_fee_group_id, 1 from service_fee_group where service_id = 60 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_ZONG_ZINGPAY');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 3, service_fee_group_id, 1 from service_fee_group where service_id = 60 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_ZONG_AGENT_MASTER');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 4, service_fee_group_id, 1 from service_fee_group where service_id = 60 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_ZONG_AGENT');

insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 1, service_fee_group_id, 1 from service_fee_group where service_id = 61 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_ZONG_DEFAULT');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 2, service_fee_group_id, 1 from service_fee_group where service_id = 61 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_ZONG_ZINGPAY');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 3, service_fee_group_id, 1 from service_fee_group where service_id = 61 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_ZONG_AGENT_MASTER');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 4, service_fee_group_id, 1 from service_fee_group where service_id = 61 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_ZONG_AGENT');

insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 1, service_fee_group_id, 1 from service_fee_group where service_id = 62 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_ZONG_DEFAULT');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 2, service_fee_group_id, 1 from service_fee_group where service_id = 62 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_ZONG_ZINGPAY');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 3, service_fee_group_id, 1 from service_fee_group where service_id = 62 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_ZONG_AGENT_MASTER');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 4, service_fee_group_id, 1 from service_fee_group where service_id = 62 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_ZONG_AGENT');

insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 1, service_fee_group_id, 1 from service_fee_group where service_id = 63 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_ZONG_DEFAULT');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 2, service_fee_group_id, 1 from service_fee_group where service_id = 63 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_ZONG_ZINGPAY');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 3, service_fee_group_id, 1 from service_fee_group where service_id = 63 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_ZONG_AGENT_MASTER');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 4, service_fee_group_id, 1 from service_fee_group where service_id = 63 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_ZONG_AGENT');

insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 1, service_fee_group_id, 1 from service_fee_group where service_id = 64 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_ZONG_DEFAULT');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 2, service_fee_group_id, 1 from service_fee_group where service_id = 64 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_ZONG_ZINGPAY');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 3, service_fee_group_id, 1 from service_fee_group where service_id = 64 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_ZONG_AGENT_MASTER');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 4, service_fee_group_id, 1 from service_fee_group where service_id = 64 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_ZONG_AGENT');

insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 1, service_fee_group_id, 1 from service_fee_group where service_id = 65 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_ZONG_DEFAULT');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 2, service_fee_group_id, 1 from service_fee_group where service_id = 65 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_ZONG_ZINGPAY');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 3, service_fee_group_id, 1 from service_fee_group where service_id = 65 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_ZONG_AGENT_MASTER');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 4, service_fee_group_id, 1 from service_fee_group where service_id = 65 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_ZONG_AGENT');

insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 1, service_fee_group_id, 1 from service_fee_group where service_id = 66 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_ZONG_DEFAULT');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 2, service_fee_group_id, 1 from service_fee_group where service_id = 66 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_ZONG_ZINGPAY');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 3, service_fee_group_id, 1 from service_fee_group where service_id = 66 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_ZONG_AGENT_MASTER');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 4, service_fee_group_id, 1 from service_fee_group where service_id = 66 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_ZONG_AGENT');

insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 1, service_fee_group_id, 1 from service_fee_group where service_id = 67 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_ZONG_DEFAULT');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 2, service_fee_group_id, 1 from service_fee_group where service_id = 67 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_ZONG_ZINGPAY');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 3, service_fee_group_id, 1 from service_fee_group where service_id = 67 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_ZONG_AGENT_MASTER');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 4, service_fee_group_id, 1 from service_fee_group where service_id = 67 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_ZONG_AGENT');

insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 1, service_fee_group_id, 1 from service_fee_group where service_id = 68 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_ZONG_DEFAULT');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 2, service_fee_group_id, 1 from service_fee_group where service_id = 68 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_ZONG_ZINGPAY');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 3, service_fee_group_id, 1 from service_fee_group where service_id = 68 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_ZONG_AGENT_MASTER');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 4, service_fee_group_id, 1 from service_fee_group where service_id = 68 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_ZONG_AGENT');

insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 1, service_fee_group_id, 1 from service_fee_group where service_id = 69 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_ZONG_DEFAULT');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 2, service_fee_group_id, 1 from service_fee_group where service_id = 69 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_ZONG_ZINGPAY');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 3, service_fee_group_id, 1 from service_fee_group where service_id = 69 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_ZONG_AGENT_MASTER');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 4, service_fee_group_id, 1 from service_fee_group where service_id = 69 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_ZONG_AGENT');

insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 1, service_fee_group_id, 1 from service_fee_group where service_id = 70 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_ZONG_DEFAULT');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 2, service_fee_group_id, 1 from service_fee_group where service_id = 70 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_ZONG_ZINGPAY');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 3, service_fee_group_id, 1 from service_fee_group where service_id = 70 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_ZONG_AGENT_MASTER');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 4, service_fee_group_id, 1 from service_fee_group where service_id = 70 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_ZONG_AGENT');

insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 1, service_fee_group_id, 1 from service_fee_group where service_id = 71 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_ZONG_DEFAULT');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 2, service_fee_group_id, 1 from service_fee_group where service_id = 71 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_ZONG_ZINGPAY');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 3, service_fee_group_id, 1 from service_fee_group where service_id = 71 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_ZONG_AGENT_MASTER');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 4, service_fee_group_id, 1 from service_fee_group where service_id = 71 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_ZONG_AGENT');

insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 1, service_fee_group_id, 1 from service_fee_group where service_id = 72 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_ZONG_DEFAULT');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 2, service_fee_group_id, 1 from service_fee_group where service_id = 72 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_ZONG_ZINGPAY');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 3, service_fee_group_id, 1 from service_fee_group where service_id = 72 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_ZONG_AGENT_MASTER');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 4, service_fee_group_id, 1 from service_fee_group where service_id = 72 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_ZONG_AGENT');

insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 1, service_fee_group_id, 1 from service_fee_group where service_id = 73 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_ZONG_DEFAULT');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 2, service_fee_group_id, 1 from service_fee_group where service_id = 73 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_ZONG_ZINGPAY');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 3, service_fee_group_id, 1 from service_fee_group where service_id = 73 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_ZONG_AGENT_MASTER');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 4, service_fee_group_id, 1 from service_fee_group where service_id = 73 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_ZONG_AGENT');

insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 1, service_fee_group_id, 1 from service_fee_group where service_id = 74 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_ZONG_DEFAULT');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 2, service_fee_group_id, 1 from service_fee_group where service_id = 74 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_ZONG_ZINGPAY');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 3, service_fee_group_id, 1 from service_fee_group where service_id = 74 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_ZONG_AGENT_MASTER');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 4, service_fee_group_id, 1 from service_fee_group where service_id = 74 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_ZONG_AGENT');

insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 1, service_fee_group_id, 1 from service_fee_group where service_id = 75 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_ZONG_DEFAULT');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 2, service_fee_group_id, 1 from service_fee_group where service_id = 75 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_ZONG_ZINGPAY');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 3, service_fee_group_id, 1 from service_fee_group where service_id = 75 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_ZONG_AGENT_MASTER');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 4, service_fee_group_id, 1 from service_fee_group where service_id = 75 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_ZONG_AGENT');

insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 1, service_fee_group_id, 1 from service_fee_group where service_id = 76 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_ZONG_DEFAULT');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 2, service_fee_group_id, 1 from service_fee_group where service_id = 76 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_ZONG_ZINGPAY');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 3, service_fee_group_id, 1 from service_fee_group where service_id = 76 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_ZONG_AGENT_MASTER');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 4, service_fee_group_id, 1 from service_fee_group where service_id = 76 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_ZONG_AGENT');


insert into fee (fee_group_id, fee_type_id, type, fee_name, fee, active_ind) select fee_group_id, 2, 'TX_COMMISSION', 'COMMISSION', 4, 1 from fee_group where name like '%LOAD_ZONG_DEFAULT';
insert into fee (fee_group_id, fee_type_id, type, fee_name, fee, active_ind) select fee_group_id, 2, 'TX_SERVICE_CHARGE', 'SERVICE CHARGE', 0, 1 from fee_group where name like '%LOAD_ZONG_DEFAULT';

insert into fee (fee_group_id, fee_type_id, type, fee_name, fee, active_ind) select fee_group_id, 2, 'TX_COMMISSION', 'COMMISSION', 100, 1 from fee_group where name like '%LOAD_ZONG_ZINGPAY';
insert into fee (fee_group_id, fee_type_id, type, fee_name, fee, active_ind) select fee_group_id, 2, 'TX_SERVICE_CHARGE', 'SERVICE CHARGE', 0, 1 from fee_group where name like '%LOAD_ZONG_ZINGPAY';

insert into fee (fee_group_id, fee_type_id, type, fee_name, fee, active_ind) select fee_group_id, 2, 'TX_COMMISSION', 'COMMISSION', 0, 1 from fee_group where name like '%LOAD_ZONG_AGENT_MASTER';
insert into fee (fee_group_id, fee_type_id, type, fee_name, fee, active_ind) select fee_group_id, 2, 'TX_SERVICE_CHARGE', 'SERVICE CHARGE', 0, 1 from fee_group where name like '%LOAD_ZONG_AGENT_MASTER';

insert into fee (fee_group_id, fee_type_id, type, fee_name, fee, active_ind) select fee_group_id, 2, 'TX_COMMISSION', 'COMMISSION', 70, 1 from fee_group where name like '%LOAD_ZONG_AGENT';
insert into fee (fee_group_id, fee_type_id, type, fee_name, fee, active_ind) select fee_group_id, 2, 'TX_SERVICE_CHARGE', 'SERVICE CHARGE', 0, 1 from fee_group where name like '%LOAD_ZONG_AGENT';

insert into fee (fee_group_id, fee_type_id, type, fee_name, fee, active_ind) select fee_group_id, 2, 'TX_COMMISSION', 'COMMISSION', 4, 1 from fee_group where name like '%BUNDLE_ZONG_DEFAULT';
insert into fee (fee_group_id, fee_type_id, type, fee_name, fee, active_ind) select fee_group_id, 2, 'TX_SERVICE_CHARGE', 'SERVICE CHARGE', 0, 1 from fee_group where name like '%BUNDLE_ZONG_DEFAULT';

insert into fee (fee_group_id, fee_type_id, type, fee_name, fee, active_ind) select fee_group_id, 2, 'TX_COMMISSION', 'COMMISSION', 100, 1 from fee_group where name like '%BUNDLE_ZONG_ZINGPAY';
insert into fee (fee_group_id, fee_type_id, type, fee_name, fee, active_ind) select fee_group_id, 2, 'TX_SERVICE_CHARGE', 'SERVICE CHARGE', 0, 1 from fee_group where name like '%BUNDLE_ZONG_ZINGPAY';

insert into fee (fee_group_id, fee_type_id, type, fee_name, fee, active_ind) select fee_group_id, 2, 'TX_COMMISSION', 'COMMISSION', 0, 1 from fee_group where name like '%BUNDLE_ZONG_AGENT_MASTER';
insert into fee (fee_group_id, fee_type_id, type, fee_name, fee, active_ind) select fee_group_id, 2, 'TX_SERVICE_CHARGE', 'SERVICE CHARGE', 0, 1 from fee_group where name like '%BUNDLE_ZONG_AGENT_MASTER';

insert into fee (fee_group_id, fee_type_id, type, fee_name, fee, active_ind) select fee_group_id, 2, 'TX_COMMISSION', 'COMMISSION', 70, 1 from fee_group where name like '%BUNDLE_ZONG_AGENT';
insert into fee (fee_group_id, fee_type_id, type, fee_name, fee, active_ind) select fee_group_id, 2, 'TX_SERVICE_CHARGE', 'SERVICE CHARGE', 0, 1 from fee_group where name like '%BUNDLE_ZONG_AGENT';