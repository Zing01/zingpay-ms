INSERT INTO `zingpay`.`ref_service_broker` (`SERVICE_BROKER_ID`, `SERVICE_BROKER_NAME`, `SERVICE_BROKER_DESC`, `ACTIVE`) VALUES ('3', 'TELENOR', 'TELENOR', '1');

INSERT INTO `zingpay`.`ref_service_provider` (`SERVICE_PROVIDER_ID`, `SERVICE_BROKER_ID`, `SERVICE_PROVIDER_SHORT_NAME`, `SERVICE_PROVIDER_DISPLAY_NAME`, `SERVICE_PROVIDER_TYPE`, `CITY`, `SORT_ORDER`, `ACTIVE`) VALUES ('3', '3', 'TELENOR', 'telenor', 'MOBILE', 'Karachi, Lahore, Islamabad', '1', '1');

INSERT INTO `zingpay`.`ref_service` (`SERVICE_ID`, `SERVICE_NAME`, `SERVICE_TYPE_ID`, `SERVICE_PROVIDER_ID`, `ACTIVE`, `SERVICE_CODE`)
Select 150, 'ZINGPAY_Load',(Select id from ref_service_type rst where rst.value = 'LOAD'), SERVICE_PROVIDER_ID, 1, '' from ref_service_provider
where SERVICE_PROVIDER_SHORT_NAME = 'telenor' and SERVICE_BROKER_ID =(select SERVICE_BROKER_ID from ref_service_broker where SERVICE_BROKER_NAME = 'TELENOR');

INSERT INTO `zingpay`.`ref_service` (`SERVICE_ID`, `SERVICE_NAME`, `PRICE`, `RETAIL_PRICE`, `SERVICE_TYPE_ID`, `SERVICE_PROVIDER_ID`, `ACTIVE`, `SERVICE_CODE`)
select 151, '3G Monthly Starter-ADC', '400', '400', (Select id from ref_service_type rst where rst.value = 'BUNDLE'), SERVICE_PROVIDER_ID, 1, '501937' from ref_service_provider
where SERVICE_PROVIDER_SHORT_NAME = 'telenor' and SERVICE_BROKER_ID=(select SERVICE_BROKER_ID from ref_service_broker where SERVICE_BROKER_NAME = 'TELENOR');

INSERT INTO `zingpay`.`ref_service` (`SERVICE_ID`, `SERVICE_NAME`, `PRICE`, `RETAIL_PRICE`, `SERVICE_TYPE_ID`, `SERVICE_PROVIDER_ID`, `ACTIVE`, `SERVICE_CODE`)
select 152, 'Easycard 150 - replica for alternate channel', '150', '150', (Select id from ref_service_type rst where rst.value = 'BUNDLE'), SERVICE_PROVIDER_ID, 1, '501807' from ref_service_provider
where SERVICE_PROVIDER_SHORT_NAME = 'telenor' and SERVICE_BROKER_ID=(select SERVICE_BROKER_ID from ref_service_broker where SERVICE_BROKER_NAME = 'TELENOR');

INSERT INTO `zingpay`.`ref_service` (`SERVICE_ID`, `SERVICE_NAME`, `PRICE`, `RETAIL_PRICE`, `SERVICE_TYPE_ID`, `SERVICE_PROVIDER_ID`, `ACTIVE`, `SERVICE_CODE`)
select 153, '4G Weekly Ultra- alternate channels', '210', '210', (Select id from ref_service_type rst where rst.value = 'BUNDLE'), SERVICE_PROVIDER_ID, 1, '501925' from ref_service_provider
where SERVICE_PROVIDER_SHORT_NAME = 'telenor' and SERVICE_BROKER_ID=(select SERVICE_BROKER_ID from ref_service_broker where SERVICE_BROKER_NAME = 'TELENOR');

INSERT INTO `zingpay`.`ref_service` (`SERVICE_ID`, `SERVICE_NAME`, `PRICE`, `RETAIL_PRICE`, `SERVICE_TYPE_ID`, `SERVICE_PROVIDER_ID`, `ACTIVE`, `SERVICE_CODE`)
select 154, 'Easy Card 450 AC', '450', '450', (Select id from ref_service_type rst where rst.value = 'BUNDLE'), SERVICE_PROVIDER_ID, 1, '501773' from ref_service_provider
where SERVICE_PROVIDER_SHORT_NAME = 'telenor' and SERVICE_BROKER_ID=(select SERVICE_BROKER_ID from ref_service_broker where SERVICE_BROKER_NAME = 'TELENOR');

INSERT INTO `zingpay`.`ref_service` (`SERVICE_ID`, `SERVICE_NAME`, `PRICE`, `RETAIL_PRICE`, `SERVICE_TYPE_ID`, `SERVICE_PROVIDER_ID`, `ACTIVE`, `SERVICE_CODE`)
select 155, 'Easy Card 800 AC', '800', '800', (Select id from ref_service_type rst where rst.value = 'BUNDLE'), SERVICE_PROVIDER_ID, 1, '501946' from ref_service_provider
where SERVICE_PROVIDER_SHORT_NAME = 'telenor' and SERVICE_BROKER_ID=(select SERVICE_BROKER_ID from ref_service_broker where SERVICE_BROKER_NAME = 'TELENOR');

INSERT INTO `zingpay`.`ref_service` (`SERVICE_ID`, `SERVICE_NAME`, `PRICE`, `RETAIL_PRICE`, `SERVICE_TYPE_ID`, `SERVICE_PROVIDER_ID`, `ACTIVE`, `SERVICE_CODE`)
select 156, 'Easy Card 600 Replica', '600', '600', (Select id from ref_service_type rst where rst.value = 'BUNDLE'), SERVICE_PROVIDER_ID, 1, '502237' from ref_service_provider
where SERVICE_PROVIDER_SHORT_NAME = 'telenor' and SERVICE_BROKER_ID=(select SERVICE_BROKER_ID from ref_service_broker where SERVICE_BROKER_NAME = 'TELENOR');

INSERT INTO `zingpay`.`ref_service` (`SERVICE_ID`, `SERVICE_NAME`, `PRICE`, `RETAIL_PRICE`, `SERVICE_TYPE_ID`, `SERVICE_PROVIDER_ID`, `ACTIVE`, `SERVICE_CODE`)
select 157, 'Monthly Ultra', '599', '599', (Select id from ref_service_type rst where rst.value = 'BUNDLE'), SERVICE_PROVIDER_ID, 1, '502240' from ref_service_provider
where SERVICE_PROVIDER_SHORT_NAME = 'telenor' and SERVICE_BROKER_ID=(select SERVICE_BROKER_ID from ref_service_broker where SERVICE_BROKER_NAME = 'TELENOR');

INSERT INTO `zingpay`.`ref_service` (`SERVICE_ID`, `SERVICE_NAME`, `PRICE`, `RETAIL_PRICE`, `SERVICE_TYPE_ID`, `SERVICE_PROVIDER_ID`, `ACTIVE`, `SERVICE_CODE`)
select 158, 'CPO Offer', '140', '140', (Select id from ref_service_type rst where rst.value = 'BUNDLE'), SERVICE_PROVIDER_ID, 1, '502110' from ref_service_provider
where SERVICE_PROVIDER_SHORT_NAME = 'telenor' and SERVICE_BROKER_ID=(select SERVICE_BROKER_ID from ref_service_broker where SERVICE_BROKER_NAME = 'TELENOR');

INSERT INTO `zingpay`.`ref_service` (`SERVICE_ID`, `SERVICE_NAME`, `PRICE`, `RETAIL_PRICE`, `SERVICE_TYPE_ID`, `SERVICE_PROVIDER_ID`, `ACTIVE`, `SERVICE_CODE`)
select 159, 'Sahulat Offer', '170', '170', (Select id from ref_service_type rst where rst.value = 'BUNDLE'), SERVICE_PROVIDER_ID, 1, '502092' from ref_service_provider
where SERVICE_PROVIDER_SHORT_NAME = 'telenor' and SERVICE_BROKER_ID=(select SERVICE_BROKER_ID from ref_service_broker where SERVICE_BROKER_NAME = 'TELENOR');

INSERT INTO `zingpay`.`ref_service` (`SERVICE_ID`, `SERVICE_NAME`, `PRICE`, `RETAIL_PRICE`, `SERVICE_TYPE_ID`, `SERVICE_PROVIDER_ID`, `ACTIVE`, `SERVICE_CODE`)
select 160, 'Weekly Easy Card Mega', '250', '250', (Select id from ref_service_type rst where rst.value = 'BUNDLE'), SERVICE_PROVIDER_ID, 1, '502099' from ref_service_provider
where SERVICE_PROVIDER_SHORT_NAME = 'telenor' and SERVICE_BROKER_ID=(select SERVICE_BROKER_ID from ref_service_broker where SERVICE_BROKER_NAME = 'TELENOR');

INSERT INTO `zingpay`.`ref_service` (`SERVICE_ID`, `SERVICE_NAME`, `PRICE`, `RETAIL_PRICE`, `SERVICE_TYPE_ID`, `SERVICE_PROVIDER_ID`, `ACTIVE`, `SERVICE_CODE`)
select 161, 'Monthly Whatsapp & FB Offer', '50', '50', (Select id from ref_service_type rst where rst.value = 'BUNDLE'), SERVICE_PROVIDER_ID, 1, '502121' from ref_service_provider
where SERVICE_PROVIDER_SHORT_NAME = 'telenor' and SERVICE_BROKER_ID=(select SERVICE_BROKER_ID from ref_service_broker where SERVICE_BROKER_NAME = 'TELENOR');

INSERT INTO `zingpay`.`ref_service` (`SERVICE_ID`, `SERVICE_NAME`, `PRICE`, `RETAIL_PRICE`, `SERVICE_TYPE_ID`, `SERVICE_PROVIDER_ID`, `ACTIVE`, `SERVICE_CODE`)
select 162, 'Ticky Pack Offer', '11', '11', (Select id from ref_service_type rst where rst.value = 'BUNDLE'), SERVICE_PROVIDER_ID, 1, '500947' from ref_service_provider
where SERVICE_PROVIDER_SHORT_NAME = 'telenor' and SERVICE_BROKER_ID=(select SERVICE_BROKER_ID from ref_service_broker where SERVICE_BROKER_NAME = 'TELENOR');

INSERT INTO `zingpay`.`ref_service` (`SERVICE_ID`, `SERVICE_NAME`, `PRICE`, `RETAIL_PRICE`, `SERVICE_TYPE_ID`, `SERVICE_PROVIDER_ID`, `ACTIVE`, `SERVICE_CODE`)
select 163, 'Youtube Offer', '10', '10', (Select id from ref_service_type rst where rst.value = 'BUNDLE'), SERVICE_PROVIDER_ID, 1, '502146' from ref_service_provider
where SERVICE_PROVIDER_SHORT_NAME = 'telenor' and SERVICE_BROKER_ID=(select SERVICE_BROKER_ID from ref_service_broker where SERVICE_BROKER_NAME = 'TELENOR');

INSERT INTO `zingpay`.`ref_service` (`SERVICE_ID`, `SERVICE_NAME`, `PRICE`, `RETAIL_PRICE`, `SERVICE_TYPE_ID`, `SERVICE_PROVIDER_ID`, `ACTIVE`, `SERVICE_CODE`)
select 164, '4G Weekly Super', '130', '130', (Select id from ref_service_type rst where rst.value = 'BUNDLE'), SERVICE_PROVIDER_ID, 1, '501721' from ref_service_provider
where SERVICE_PROVIDER_SHORT_NAME = 'telenor' and SERVICE_BROKER_ID=(select SERVICE_BROKER_ID from ref_service_broker where SERVICE_BROKER_NAME = 'TELENOR');

INSERT INTO `zingpay`.`ref_service` (`SERVICE_ID`, `SERVICE_NAME`, `PRICE`, `RETAIL_PRICE`, `SERVICE_TYPE_ID`, `SERVICE_PROVIDER_ID`, `ACTIVE`, `SERVICE_CODE`)
select 165, '4 G Weekly Late Night Offer', '60', '60', (Select id from ref_service_type rst where rst.value = 'BUNDLE'), SERVICE_PROVIDER_ID, 1, '502134' from ref_service_provider
where SERVICE_PROVIDER_SHORT_NAME = 'telenor' and SERVICE_BROKER_ID=(select SERVICE_BROKER_ID from ref_service_broker where SERVICE_BROKER_NAME = 'TELENOR');

INSERT INTO `zingpay`.`ref_service` (`SERVICE_ID`, `SERVICE_NAME`, `PRICE`, `RETAIL_PRICE`, `SERVICE_TYPE_ID`, `SERVICE_PROVIDER_ID`, `ACTIVE`, `SERVICE_CODE`)
select 166, 'Easy Card - 200', '199', '199', (Select id from ref_service_type rst where rst.value = 'BUNDLE'), SERVICE_PROVIDER_ID, 1, '502174' from ref_service_provider
where SERVICE_PROVIDER_SHORT_NAME = 'telenor' and SERVICE_BROKER_ID=(select SERVICE_BROKER_ID from ref_service_broker where SERVICE_BROKER_NAME = 'TELENOR');


INSERT INTO `zingpay`.`fee_group` (`NAME`, `ACTIVE_IND`) VALUES ('LOAD_TELENOR_DEFAULT', '1'), ('LOAD_TELENOR_ZINGPAY', '1'), ('LOAD_TELENOR_AGENT_MASTER', '1'), ('LOAD_TELENOR_AGENT', '1'), ('BUNDLE_TELENOR_DEFAULT', '1'), ('BUNDLE_TELENOR_ZINGPAY', '1'), ('BUNDLE_TELENOR_AGENT_MASTER', '1'), ('BUNDLE_TELENOR_AGENT', '1');

insert into service_fee_group (service_id, fee_group_id, ACTIVE_IND) select 150, fee_group_id, 1 from fee_group where name like '%LOAD_TELENOR%';
insert into service_fee_group (service_id, fee_group_id, ACTIVE_IND) select 151, fee_group_id, 1 from fee_group where name like '%BUNDLE_TELENOR%';
insert into service_fee_group (service_id, fee_group_id, ACTIVE_IND) select 152, fee_group_id, 1 from fee_group where name like '%BUNDLE_TELENOR%';
insert into service_fee_group (service_id, fee_group_id, ACTIVE_IND) select 153, fee_group_id, 1 from fee_group where name like '%BUNDLE_TELENOR%';
insert into service_fee_group (service_id, fee_group_id, ACTIVE_IND) select 154, fee_group_id, 1 from fee_group where name like '%BUNDLE_TELENOR%';
insert into service_fee_group (service_id, fee_group_id, ACTIVE_IND) select 155, fee_group_id, 1 from fee_group where name like '%BUNDLE_TELENOR%';
insert into service_fee_group (service_id, fee_group_id, ACTIVE_IND) select 156, fee_group_id, 1 from fee_group where name like '%BUNDLE_TELENOR%';
insert into service_fee_group (service_id, fee_group_id, ACTIVE_IND) select 157, fee_group_id, 1 from fee_group where name like '%BUNDLE_TELENOR%';
insert into service_fee_group (service_id, fee_group_id, ACTIVE_IND) select 158, fee_group_id, 1 from fee_group where name like '%BUNDLE_TELENOR%';
insert into service_fee_group (service_id, fee_group_id, ACTIVE_IND) select 159, fee_group_id, 1 from fee_group where name like '%BUNDLE_TELENOR%';
insert into service_fee_group (service_id, fee_group_id, ACTIVE_IND) select 160, fee_group_id, 1 from fee_group where name like '%BUNDLE_TELENOR%';
insert into service_fee_group (service_id, fee_group_id, ACTIVE_IND) select 161, fee_group_id, 1 from fee_group where name like '%BUNDLE_TELENOR%';
insert into service_fee_group (service_id, fee_group_id, ACTIVE_IND) select 162, fee_group_id, 1 from fee_group where name like '%BUNDLE_TELENOR%';
insert into service_fee_group (service_id, fee_group_id, ACTIVE_IND) select 163, fee_group_id, 1 from fee_group where name like '%BUNDLE_TELENOR%';
insert into service_fee_group (service_id, fee_group_id, ACTIVE_IND) select 164, fee_group_id, 1 from fee_group where name like '%BUNDLE_TELENOR%';
insert into service_fee_group (service_id, fee_group_id, ACTIVE_IND) select 165, fee_group_id, 1 from fee_group where name like '%BUNDLE_TELENOR%';
insert into service_fee_group (service_id, fee_group_id, ACTIVE_IND) select 166, fee_group_id, 1 from fee_group where name like '%BUNDLE_TELENOR%';

insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 1, service_fee_group_id, 1 from service_fee_group where service_id = 150 and fee_group_id in (select fee_group_id from fee_group where name like '%LOAD_TELENOR_DEFAULT');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 2, service_fee_group_id, 1 from service_fee_group where service_id = 150 and fee_group_id in (select fee_group_id from fee_group where name like '%LOAD_TELENOR_ZINGPAY');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 3, service_fee_group_id, 1 from service_fee_group where service_id = 150 and fee_group_id in (select fee_group_id from fee_group where name like '%LOAD_TELENOR_AGENT_MASTER');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 4, service_fee_group_id, 1 from service_fee_group where service_id = 150 and fee_group_id in (select fee_group_id from fee_group where name like '%LOAD_TELENOR_AGENT');

insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 1, service_fee_group_id, 1 from service_fee_group where service_id = 151 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_TELENOR_DEFAULT');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 2, service_fee_group_id, 1 from service_fee_group where service_id = 151 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_TELENOR_ZINGPAY');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 3, service_fee_group_id, 1 from service_fee_group where service_id = 151 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_TELENOR_AGENT_MASTER');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 4, service_fee_group_id, 1 from service_fee_group where service_id = 151 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_TELENOR_AGENT');

insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 1, service_fee_group_id, 1 from service_fee_group where service_id = 152 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_TELENOR_DEFAULT');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 2, service_fee_group_id, 1 from service_fee_group where service_id = 152 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_TELENOR_ZINGPAY');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 3, service_fee_group_id, 1 from service_fee_group where service_id = 152 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_TELENOR_AGENT_MASTER');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 4, service_fee_group_id, 1 from service_fee_group where service_id = 152 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_TELENOR_AGENT');

insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 1, service_fee_group_id, 1 from service_fee_group where service_id = 153 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_TELENOR_DEFAULT');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 2, service_fee_group_id, 1 from service_fee_group where service_id = 153 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_TELENOR_ZINGPAY');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 3, service_fee_group_id, 1 from service_fee_group where service_id = 153 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_TELENOR_AGENT_MASTER');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 4, service_fee_group_id, 1 from service_fee_group where service_id = 153 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_TELENOR_AGENT');

insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 1, service_fee_group_id, 1 from service_fee_group where service_id = 154 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_TELENOR_DEFAULT');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 2, service_fee_group_id, 1 from service_fee_group where service_id = 154 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_TELENOR_ZINGPAY');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 3, service_fee_group_id, 1 from service_fee_group where service_id = 154 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_TELENOR_AGENT_MASTER');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 4, service_fee_group_id, 1 from service_fee_group where service_id = 154 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_TELENOR_AGENT');

insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 1, service_fee_group_id, 1 from service_fee_group where service_id = 155 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_TELENOR_DEFAULT');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 2, service_fee_group_id, 1 from service_fee_group where service_id = 155 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_TELENOR_ZINGPAY');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 3, service_fee_group_id, 1 from service_fee_group where service_id = 155 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_TELENOR_AGENT_MASTER');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 4, service_fee_group_id, 1 from service_fee_group where service_id = 155 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_TELENOR_AGENT');

insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 1, service_fee_group_id, 1 from service_fee_group where service_id = 156 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_TELENOR_DEFAULT');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 2, service_fee_group_id, 1 from service_fee_group where service_id = 156 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_TELENOR_ZINGPAY');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 3, service_fee_group_id, 1 from service_fee_group where service_id = 156 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_TELENOR_AGENT_MASTER');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 4, service_fee_group_id, 1 from service_fee_group where service_id = 156 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_TELENOR_AGENT');

insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 1, service_fee_group_id, 1 from service_fee_group where service_id = 157 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_TELENOR_DEFAULT');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 2, service_fee_group_id, 1 from service_fee_group where service_id = 157 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_TELENOR_ZINGPAY');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 3, service_fee_group_id, 1 from service_fee_group where service_id = 157 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_TELENOR_AGENT_MASTER');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 4, service_fee_group_id, 1 from service_fee_group where service_id = 157 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_TELENOR_AGENT');

insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 1, service_fee_group_id, 1 from service_fee_group where service_id = 158 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_TELENOR_DEFAULT');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 2, service_fee_group_id, 1 from service_fee_group where service_id = 158 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_TELENOR_ZINGPAY');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 3, service_fee_group_id, 1 from service_fee_group where service_id = 158 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_TELENOR_AGENT_MASTER');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 4, service_fee_group_id, 1 from service_fee_group where service_id = 158 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_TELENOR_AGENT');

insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 1, service_fee_group_id, 1 from service_fee_group where service_id = 159 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_TELENOR_DEFAULT');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 2, service_fee_group_id, 1 from service_fee_group where service_id = 159 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_TELENOR_ZINGPAY');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 3, service_fee_group_id, 1 from service_fee_group where service_id = 159 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_TELENOR_AGENT_MASTER');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 4, service_fee_group_id, 1 from service_fee_group where service_id = 159 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_TELENOR_AGENT');

insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 1, service_fee_group_id, 1 from service_fee_group where service_id = 160 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_TELENOR_DEFAULT');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 2, service_fee_group_id, 1 from service_fee_group where service_id = 160 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_TELENOR_ZINGPAY');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 3, service_fee_group_id, 1 from service_fee_group where service_id = 160 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_TELENOR_AGENT_MASTER');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 4, service_fee_group_id, 1 from service_fee_group where service_id = 160 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_TELENOR_AGENT');

insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 1, service_fee_group_id, 1 from service_fee_group where service_id = 161 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_TELENOR_DEFAULT');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 2, service_fee_group_id, 1 from service_fee_group where service_id = 161 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_TELENOR_ZINGPAY');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 3, service_fee_group_id, 1 from service_fee_group where service_id = 161 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_TELENOR_AGENT_MASTER');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 4, service_fee_group_id, 1 from service_fee_group where service_id = 161 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_TELENOR_AGENT');

insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 1, service_fee_group_id, 1 from service_fee_group where service_id = 162 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_TELENOR_DEFAULT');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 2, service_fee_group_id, 1 from service_fee_group where service_id = 162 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_TELENOR_ZINGPAY');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 3, service_fee_group_id, 1 from service_fee_group where service_id = 162 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_TELENOR_AGENT_MASTER');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 4, service_fee_group_id, 1 from service_fee_group where service_id = 162 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_TELENOR_AGENT');

insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 1, service_fee_group_id, 1 from service_fee_group where service_id = 163 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_TELENOR_DEFAULT');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 2, service_fee_group_id, 1 from service_fee_group where service_id = 163 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_TELENOR_ZINGPAY');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 3, service_fee_group_id, 1 from service_fee_group where service_id = 163 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_TELENOR_AGENT_MASTER');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 4, service_fee_group_id, 1 from service_fee_group where service_id = 163 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_TELENOR_AGENT');

insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 1, service_fee_group_id, 1 from service_fee_group where service_id = 164 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_TELENOR_DEFAULT');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 2, service_fee_group_id, 1 from service_fee_group where service_id = 164 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_TELENOR_ZINGPAY');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 3, service_fee_group_id, 1 from service_fee_group where service_id = 164 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_TELENOR_AGENT_MASTER');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 4, service_fee_group_id, 1 from service_fee_group where service_id = 164 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_TELENOR_AGENT');

insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 1, service_fee_group_id, 1 from service_fee_group where service_id = 165 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_TELENOR_DEFAULT');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 2, service_fee_group_id, 1 from service_fee_group where service_id = 165 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_TELENOR_ZINGPAY');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 3, service_fee_group_id, 1 from service_fee_group where service_id = 165 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_TELENOR_AGENT_MASTER');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 4, service_fee_group_id, 1 from service_fee_group where service_id = 165 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_TELENOR_AGENT');

insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 1, service_fee_group_id, 1 from service_fee_group where service_id = 166 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_TELENOR_DEFAULT');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 2, service_fee_group_id, 1 from service_fee_group where service_id = 166 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_TELENOR_ZINGPAY');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 3, service_fee_group_id, 1 from service_fee_group where service_id = 166 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_TELENOR_AGENT_MASTER');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select 4, service_fee_group_id, 1 from service_fee_group where service_id = 166 and fee_group_id in (select fee_group_id from fee_group where name like '%BUNDLE_TELENOR_AGENT');


insert into fee (fee_group_id, fee_type_id, type, fee_name, fee, active_ind) select fee_group_id, 2, 'TX_COMMISSION', 'COMMISSION', 4, 1 from fee_group where name like '%LOAD_TELENOR_DEFAULT';
insert into fee (fee_group_id, fee_type_id, type, fee_name, fee, active_ind) select fee_group_id, 2, 'TX_SERVICE_CHARGE', 'SERVICE CHARGE', 0, 1 from fee_group where name like '%LOAD_TELENOR_DEFAULT';

insert into fee (fee_group_id, fee_type_id, type, fee_name, fee, active_ind) select fee_group_id, 2, 'TX_COMMISSION', 'COMMISSION', 100, 1 from fee_group where name like '%LOAD_TELENOR_ZINGPAY';
insert into fee (fee_group_id, fee_type_id, type, fee_name, fee, active_ind) select fee_group_id, 2, 'TX_SERVICE_CHARGE', 'SERVICE CHARGE', 0, 1 from fee_group where name like '%LOAD_TELENOR_ZINGPAY';

insert into fee (fee_group_id, fee_type_id, type, fee_name, fee, active_ind) select fee_group_id, 2, 'TX_COMMISSION', 'COMMISSION', 0, 1 from fee_group where name like '%LOAD_TELENOR_AGENT_MASTER';
insert into fee (fee_group_id, fee_type_id, type, fee_name, fee, active_ind) select fee_group_id, 2, 'TX_SERVICE_CHARGE', 'SERVICE CHARGE', 0, 1 from fee_group where name like '%LOAD_TELENOR_AGENT_MASTER';

insert into fee (fee_group_id, fee_type_id, type, fee_name, fee, active_ind) select fee_group_id, 2, 'TX_COMMISSION', 'COMMISSION', 70, 1 from fee_group where name like '%LOAD_TELENOR_AGENT';
insert into fee (fee_group_id, fee_type_id, type, fee_name, fee, active_ind) select fee_group_id, 2, 'TX_SERVICE_CHARGE', 'SERVICE CHARGE', 0, 1 from fee_group where name like '%LOAD_TELENOR_AGENT';

insert into fee (fee_group_id, fee_type_id, type, fee_name, fee, active_ind) select fee_group_id, 2, 'TX_COMMISSION', 'COMMISSION', 4, 1 from fee_group where name like '%BUNDLE_TELENOR_DEFAULT';
insert into fee (fee_group_id, fee_type_id, type, fee_name, fee, active_ind) select fee_group_id, 2, 'TX_SERVICE_CHARGE', 'SERVICE CHARGE', 0, 1 from fee_group where name like '%BUNDLE_TELENOR_DEFAULT';

insert into fee (fee_group_id, fee_type_id, type, fee_name, fee, active_ind) select fee_group_id, 2, 'TX_COMMISSION', 'COMMISSION', 100, 1 from fee_group where name like '%BUNDLE_TELENOR_ZINGPAY';
insert into fee (fee_group_id, fee_type_id, type, fee_name, fee, active_ind) select fee_group_id, 2, 'TX_SERVICE_CHARGE', 'SERVICE CHARGE', 0, 1 from fee_group where name like '%BUNDLE_TELENOR_ZINGPAY';

insert into fee (fee_group_id, fee_type_id, type, fee_name, fee, active_ind) select fee_group_id, 2, 'TX_COMMISSION', 'COMMISSION', 0, 1 from fee_group where name like '%BUNDLE_TELENOR_AGENT_MASTER';
insert into fee (fee_group_id, fee_type_id, type, fee_name, fee, active_ind) select fee_group_id, 2, 'TX_SERVICE_CHARGE', 'SERVICE CHARGE', 0, 1 from fee_group where name like '%BUNDLE_TELENOR_AGENT_MASTER';

insert into fee (fee_group_id, fee_type_id, type, fee_name, fee, active_ind) select fee_group_id, 2, 'TX_COMMISSION', 'COMMISSION', 70, 1 from fee_group where name like '%BUNDLE_TELENOR_AGENT';
insert into fee (fee_group_id, fee_type_id, type, fee_name, fee, active_ind) select fee_group_id, 2, 'TX_SERVICE_CHARGE', 'SERVICE CHARGE', 0, 1 from fee_group where name like '%BUNDLE_TELENOR_AGENT';