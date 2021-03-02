INSERT INTO ref_service_broker (SERVICE_BROKER_ID, SERVICE_BROKER_NAME, SERVICE_BROKER_DESC, ACTIVE) VALUES ('5', 'CARDWALLA', 'CARDWALLA', '1');

INSERT INTO ref_service_provider (SERVICE_PROVIDER_ID, SERVICE_BROKER_ID, SERVICE_PROVIDER_SHORT_NAME, SERVICE_PROVIDER_DISPLAY_NAME, SERVICE_PROVIDER_TYPE, CITY, SORT_ORDER, ACTIVE) VALUES ('5', '5', 'CARDWALLA', 'cardwalla', 'MOBILE', 'All', '1', '1');


INSERT INTO ref_service (SERVICE_ID, SERVICE_NAME, SERVICE_TYPE_ID, SERVICE_PROVIDER_ID, ACTIVE, SERVICE_CODE)
Select 200, 'Facebook [US]',(Select id from ref_service_type rst where rst.value = 'BUNDLE'), SERVICE_PROVIDER_ID, 1, '' from ref_service_provider
where SERVICE_PROVIDER_SHORT_NAME = 'CARDWALLA' and SERVICE_BROKER_ID =(select SERVICE_BROKER_ID from ref_service_broker where SERVICE_BROKER_NAME = 'CARDWALLA');

INSERT INTO ref_service (SERVICE_ID, SERVICE_NAME, SERVICE_TYPE_ID, SERVICE_PROVIDER_ID, ACTIVE, SERVICE_CODE)
Select 201, 'Amazon [US]',(Select id from ref_service_type rst where rst.value = 'BUNDLE'), SERVICE_PROVIDER_ID, 1, '' from ref_service_provider
where SERVICE_PROVIDER_SHORT_NAME = 'CARDWALLA' and SERVICE_BROKER_ID =(select SERVICE_BROKER_ID from ref_service_broker where SERVICE_BROKER_NAME = 'CARDWALLA');

INSERT INTO ref_service (SERVICE_ID, SERVICE_NAME, SERVICE_TYPE_ID, SERVICE_PROVIDER_ID, ACTIVE, SERVICE_CODE)
Select 202, 'iTunes [US]',(Select id from ref_service_type rst where rst.value = 'BUNDLE'), SERVICE_PROVIDER_ID, 1, '' from ref_service_provider
where SERVICE_PROVIDER_SHORT_NAME = 'CARDWALLA' and SERVICE_BROKER_ID =(select SERVICE_BROKER_ID from ref_service_broker where SERVICE_BROKER_NAME = 'CARDWALLA');

INSERT INTO ref_service (SERVICE_ID, SERVICE_NAME, SERVICE_TYPE_ID, SERVICE_PROVIDER_ID, ACTIVE, SERVICE_CODE)
Select 203, 'Netflix [US]',(Select id from ref_service_type rst where rst.value = 'BUNDLE'), SERVICE_PROVIDER_ID, 1, '' from ref_service_provider
where SERVICE_PROVIDER_SHORT_NAME = 'CARDWALLA' and SERVICE_BROKER_ID =(select SERVICE_BROKER_ID from ref_service_broker where SERVICE_BROKER_NAME = 'CARDWALLA');

INSERT INTO ref_service (SERVICE_ID, SERVICE_NAME, SERVICE_TYPE_ID, SERVICE_PROVIDER_ID, ACTIVE, SERVICE_CODE)
Select 204, 'Google Play [US]',(Select id from ref_service_type rst where rst.value = 'BUNDLE'), SERVICE_PROVIDER_ID, 1, '' from ref_service_provider
where SERVICE_PROVIDER_SHORT_NAME = 'CARDWALLA' and SERVICE_BROKER_ID =(select SERVICE_BROKER_ID from ref_service_broker where SERVICE_BROKER_NAME = 'CARDWALLA');

INSERT INTO ref_service (SERVICE_ID, SERVICE_NAME, SERVICE_TYPE_ID, SERVICE_PROVIDER_ID, ACTIVE, SERVICE_CODE)
Select 205, 'Amazon [US]',(Select id from ref_service_type rst where rst.value = 'BUNDLE'), SERVICE_PROVIDER_ID, 1, '' from ref_service_provider
where SERVICE_PROVIDER_SHORT_NAME = 'CARDWALLA' and SERVICE_BROKER_ID =(select SERVICE_BROKER_ID from ref_service_broker where SERVICE_BROKER_NAME = 'CARDWALLA');

INSERT INTO ref_service (SERVICE_ID, SERVICE_NAME, SERVICE_TYPE_ID, SERVICE_PROVIDER_ID, ACTIVE, SERVICE_CODE)
Select 206, 'Google Play [US]',(Select id from ref_service_type rst where rst.value = 'BUNDLE'), SERVICE_PROVIDER_ID, 1, '' from ref_service_provider
where SERVICE_PROVIDER_SHORT_NAME = 'CARDWALLA' and SERVICE_BROKER_ID =(select SERVICE_BROKER_ID from ref_service_broker where SERVICE_BROKER_NAME = 'CARDWALLA');

INSERT INTO ref_service (SERVICE_ID, SERVICE_NAME, SERVICE_TYPE_ID, SERVICE_PROVIDER_ID, ACTIVE, SERVICE_CODE)
Select 207, 'PlayStation [US]',(Select id from ref_service_type rst where rst.value = 'BUNDLE'), SERVICE_PROVIDER_ID, 1, '' from ref_service_provider
where SERVICE_PROVIDER_SHORT_NAME = 'CARDWALLA' and SERVICE_BROKER_ID =(select SERVICE_BROKER_ID from ref_service_broker where SERVICE_BROKER_NAME = 'CARDWALLA');

INSERT INTO fee_group (NAME, ACTIVE_IND) VALUES ('LOAD_CARDWALLA_DEFAULT', '1'), ('LOAD_CARDWALLA_ZINGPAY', '1'), ('BUNDLE_CARDWALLA_DEFAULT', '1'), ('BUNDLE_CARDWALLA_ZINGPAY', '1');

insert into service_fee_group (service_id, fee_group_id, ACTIVE_IND) select 200, fee_group_id, 1 from fee_group where name like 'BUNDLE_CARDWALLA%';
insert into service_fee_group (service_id, fee_group_id, ACTIVE_IND) select 201, fee_group_id, 1 from fee_group where name like 'BUNDLE_CARDWALLA%';
insert into service_fee_group (service_id, fee_group_id, ACTIVE_IND) select 202, fee_group_id, 1 from fee_group where name like 'BUNDLE_CARDWALLA%';
insert into service_fee_group (service_id, fee_group_id, ACTIVE_IND) select 203, fee_group_id, 1 from fee_group where name like 'BUNDLE_CARDWALLA%';
insert into service_fee_group (service_id, fee_group_id, ACTIVE_IND) select 204, fee_group_id, 1 from fee_group where name like 'BUNDLE_CARDWALLA%';
insert into service_fee_group (service_id, fee_group_id, ACTIVE_IND) select 205, fee_group_id, 1 from fee_group where name like 'BUNDLE_CARDWALLA%';
insert into service_fee_group (service_id, fee_group_id, ACTIVE_IND) select 206, fee_group_id, 1 from fee_group where name like 'BUNDLE_CARDWALLA%';
insert into service_fee_group (service_id, fee_group_id, ACTIVE_IND) select 207, fee_group_id, 1 from fee_group where name like 'BUNDLE_CARDWALLA%';

insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select (SELECT USER_GROUP_ID from user_group where NAME = 'DEFAULT'), service_fee_group_id, 1 from service_fee_group where service_id = 200 and fee_group_id in (select fee_group_id from fee_group where name like 'BUNDLE_CARDWALLA_DEFAULT');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select (SELECT USER_GROUP_ID from user_group where NAME = 'ZINGPAY'), service_fee_group_id, 1 from service_fee_group where service_id = 200 and fee_group_id in (select fee_group_id from fee_group where name like 'BUNDLE_CARDWALLA_ZINGPAY');

insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select (SELECT USER_GROUP_ID from user_group where NAME = 'DEFAULT'), service_fee_group_id, 1 from service_fee_group where service_id = 201 and fee_group_id in (select fee_group_id from fee_group where name like 'BUNDLE_CARDWALLA_DEFAULT');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select (SELECT USER_GROUP_ID from user_group where NAME = 'ZINGPAY'), service_fee_group_id, 1 from service_fee_group where service_id = 201 and fee_group_id in (select fee_group_id from fee_group where name like 'BUNDLE_CARDWALLA_ZINGPAY');

insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select (SELECT USER_GROUP_ID from user_group where NAME = 'DEFAULT'), service_fee_group_id, 1 from service_fee_group where service_id = 202 and fee_group_id in (select fee_group_id from fee_group where name like 'BUNDLE_CARDWALLA_DEFAULT');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select (SELECT USER_GROUP_ID from user_group where NAME = 'ZINGPAY'), service_fee_group_id, 1 from service_fee_group where service_id = 202 and fee_group_id in (select fee_group_id from fee_group where name like 'BUNDLE_CARDWALLA_ZINGPAY');

insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select (SELECT USER_GROUP_ID from user_group where NAME = 'DEFAULT'), service_fee_group_id, 1 from service_fee_group where service_id = 203 and fee_group_id in (select fee_group_id from fee_group where name like 'BUNDLE_CARDWALLA_DEFAULT');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select (SELECT USER_GROUP_ID from user_group where NAME = 'ZINGPAY'), service_fee_group_id, 1 from service_fee_group where service_id = 203 and fee_group_id in (select fee_group_id from fee_group where name like 'BUNDLE_CARDWALLA_ZINGPAY');

insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select (SELECT USER_GROUP_ID from user_group where NAME = 'DEFAULT'), service_fee_group_id, 1 from service_fee_group where service_id = 204 and fee_group_id in (select fee_group_id from fee_group where name like 'BUNDLE_CARDWALLA_DEFAULT');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select (SELECT USER_GROUP_ID from user_group where NAME = 'ZINGPAY'), service_fee_group_id, 1 from service_fee_group where service_id = 204 and fee_group_id in (select fee_group_id from fee_group where name like 'BUNDLE_CARDWALLA_ZINGPAY');

insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select (SELECT USER_GROUP_ID from user_group where NAME = 'DEFAULT'), service_fee_group_id, 1 from service_fee_group where service_id = 205 and fee_group_id in (select fee_group_id from fee_group where name like 'BUNDLE_CARDWALLA_DEFAULT');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select (SELECT USER_GROUP_ID from user_group where NAME = 'ZINGPAY'), service_fee_group_id, 1 from service_fee_group where service_id = 205 and fee_group_id in (select fee_group_id from fee_group where name like 'BUNDLE_CARDWALLA_ZINGPAY');

insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select (SELECT USER_GROUP_ID from user_group where NAME = 'DEFAULT'), service_fee_group_id, 1 from service_fee_group where service_id = 206 and fee_group_id in (select fee_group_id from fee_group where name like 'BUNDLE_CARDWALLA_DEFAULT');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select (SELECT USER_GROUP_ID from user_group where NAME = 'ZINGPAY'), service_fee_group_id, 1 from service_fee_group where service_id = 206 and fee_group_id in (select fee_group_id from fee_group where name like 'BUNDLE_CARDWALLA_ZINGPAY');

insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select (SELECT USER_GROUP_ID from user_group where NAME = 'DEFAULT'), service_fee_group_id, 1 from service_fee_group where service_id = 207 and fee_group_id in (select fee_group_id from fee_group where name like 'BUNDLE_CARDWALLA_DEFAULT');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select (SELECT USER_GROUP_ID from user_group where NAME = 'ZINGPAY'), service_fee_group_id, 1 from service_fee_group where service_id = 207 and fee_group_id in (select fee_group_id from fee_group where name like 'BUNDLE_CARDWALLA_ZINGPAY');

insert into fee (fee_group_id, fee_type_id, type, fee_name, fee, active_ind) select fee_group_id, 2, 'TX_COMMISSION', 'COMMISSION', 5, 1 from fee_group where name like 'BUNDLE_CARDWALLA_DEFAULT';
insert into fee (fee_group_id, fee_type_id, type, fee_name, fee, active_ind) select fee_group_id, 2, 'TX_SERVICE_CHARGE', 'SERVICE CHARGE', 0, 1 from fee_group where name like 'BUNDLE_CARDWALLA_DEFAULT';

insert into fee (fee_group_id, fee_type_id, type, fee_name, fee, active_ind) select fee_group_id, 2, 'TX_COMMISSION', 'COMMISSION', 100, 1 from fee_group where name like 'BUNDLE_CARDWALLA_ZINGPAY';
insert into fee (fee_group_id, fee_type_id, type, fee_name, fee, active_ind) select fee_group_id, 2, 'TX_SERVICE_CHARGE', 'SERVICE CHARGE', 0, 1 from fee_group where name like 'BUNDLE_CARDWALLA_ZINGPAY';

insert into fee (fee_group_id, fee_type_id, type, fee_name, fee, active_ind) select fee_group_id, 2, 'TX_COMMISSION', 'COMMISSION', 5, 1 from fee_group where name like 'BUNDLE_CARDWALLA_DEFAULT';
insert into fee (fee_group_id, fee_type_id, type, fee_name, fee, active_ind) select fee_group_id, 2, 'TX_SERVICE_CHARGE', 'SERVICE CHARGE', 0, 1 from fee_group where name like 'BUNDLE_CARDWALLA_DEFAULT';

insert into fee (fee_group_id, fee_type_id, type, fee_name, fee, active_ind) select fee_group_id, 2, 'TX_COMMISSION', 'COMMISSION', 100, 1 from fee_group where name like 'BUNDLE_CARDWALLA_ZINGPAY';
insert into fee (fee_group_id, fee_type_id, type, fee_name, fee, active_ind) select fee_group_id, 2, 'TX_SERVICE_CHARGE', 'SERVICE CHARGE', 0, 1 from fee_group where name like 'BUNDLE_CARDWALLA_ZINGPAY';