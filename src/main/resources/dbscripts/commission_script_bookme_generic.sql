INSERT INTO ref_service_broker (SERVICE_BROKER_ID, SERVICE_BROKER_NAME, SERVICE_BROKER_DESC, ACTIVE) VALUES ('6', 'BOOKME', 'BOOKME', '1');

INSERT INTO ref_service_provider (SERVICE_PROVIDER_ID, SERVICE_BROKER_ID, SERVICE_PROVIDER_SHORT_NAME, SERVICE_PROVIDER_DISPLAY_NAME, SERVICE_PROVIDER_TYPE, CITY, SORT_ORDER, ACTIVE) VALUES ('6', '6', 'BOOKME', 'bookme', 'BOOKING', 'All', '1', '1');

INSERT INTO ref_service (SERVICE_ID, SERVICE_NAME, SERVICE_TYPE_ID, SERVICE_PROVIDER_ID, ACTIVE, SERVICE_CODE)
Select 250, 'Events',(Select id from ref_service_type rst where rst.value = 'BUNDLE'), SERVICE_PROVIDER_ID, 1, '' from ref_service_provider
where SERVICE_PROVIDER_SHORT_NAME = 'BOOKME' and SERVICE_BROKER_ID =(select SERVICE_BROKER_ID from ref_service_broker where SERVICE_BROKER_NAME = 'BOOKME');

INSERT INTO ref_service (SERVICE_ID, SERVICE_NAME, SERVICE_TYPE_ID, SERVICE_PROVIDER_ID, ACTIVE, SERVICE_CODE)
Select 251, 'Airline',(Select id from ref_service_type rst where rst.value = 'BUNDLE'), SERVICE_PROVIDER_ID, 1, '' from ref_service_provider
where SERVICE_PROVIDER_SHORT_NAME = 'BOOKME' and SERVICE_BROKER_ID =(select SERVICE_BROKER_ID from ref_service_broker where SERVICE_BROKER_NAME = 'BOOKME');

INSERT INTO ref_service (SERVICE_ID, SERVICE_NAME, SERVICE_TYPE_ID, SERVICE_PROVIDER_ID, ACTIVE, SERVICE_CODE)
Select 252, 'Bus',(Select id from ref_service_type rst where rst.value = 'BUNDLE'), SERVICE_PROVIDER_ID, 1, '' from ref_service_provider
where SERVICE_PROVIDER_SHORT_NAME = 'BOOKME' and SERVICE_BROKER_ID =(select SERVICE_BROKER_ID from ref_service_broker where SERVICE_BROKER_NAME = 'BOOKME');

INSERT INTO ref_service (SERVICE_ID, SERVICE_NAME, SERVICE_TYPE_ID, SERVICE_PROVIDER_ID, ACTIVE, SERVICE_CODE)
Select 253, 'Cinema',(Select id from ref_service_type rst where rst.value = 'BUNDLE'), SERVICE_PROVIDER_ID, 1, '' from ref_service_provider
where SERVICE_PROVIDER_SHORT_NAME = 'BOOKME' and SERVICE_BROKER_ID =(select SERVICE_BROKER_ID from ref_service_broker where SERVICE_BROKER_NAME = 'BOOKME');

INSERT INTO fee_group (NAME, ACTIVE_IND) VALUES ('BUNDLE_BOOKME_EVENT_DEFAULT', '1'), ('BUNDLE_BOOKME_EVENT_ZINGPAY', '1');
INSERT INTO fee_group (NAME, ACTIVE_IND) VALUES ('BUNDLE_BOOKME_AIRLINE_DEFAULT', '1'), ('BUNDLE_BOOKME_AIRLINE_ZINGPAY', '1');
INSERT INTO fee_group (NAME, ACTIVE_IND) VALUES ('BUNDLE_BOOKME_BUS_DEFAULT', '1'), ('BUNDLE_BOOKME_BUS_ZINGPAY', '1');
INSERT INTO fee_group (NAME, ACTIVE_IND) VALUES ('BUNDLE_BOOKME_CINEMA_DEFAULT', '1'), ('BUNDLE_BOOKME_CINEMA_ZINGPAY', '1');

insert into service_fee_group (service_id, fee_group_id, ACTIVE_IND) select 250, fee_group_id, 1 from fee_group where name like 'BUNDLE_BOOKME_EVENT%';
insert into service_fee_group (service_id, fee_group_id, ACTIVE_IND) select 251, fee_group_id, 1 from fee_group where name like 'BUNDLE_BOOKME_AIRLINE%';
insert into service_fee_group (service_id, fee_group_id, ACTIVE_IND) select 252, fee_group_id, 1 from fee_group where name like 'BUNDLE_BOOKME_BUS%';
insert into service_fee_group (service_id, fee_group_id, ACTIVE_IND) select 253, fee_group_id, 1 from fee_group where name like 'BUNDLE_BOOKME_CINEMA%';

insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select (SELECT USER_GROUP_ID from user_group where NAME = 'DEFAULT'), service_fee_group_id, 1 from service_fee_group where service_id = 250 and fee_group_id in (select fee_group_id from fee_group where name like 'BUNDLE_BOOKME_EVENT_DEFAULT');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select (SELECT USER_GROUP_ID from user_group where NAME = 'ZINGPAY'), service_fee_group_id, 1 from service_fee_group where service_id = 250 and fee_group_id in (select fee_group_id from fee_group where name like 'BUNDLE_BOOKME_EVENT_ZINGPAY');

insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select (SELECT USER_GROUP_ID from user_group where NAME = 'DEFAULT'), service_fee_group_id, 1 from service_fee_group where service_id = 251 and fee_group_id in (select fee_group_id from fee_group where name like 'BUNDLE_BOOKME_AIRLINE_DEFAULT');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select (SELECT USER_GROUP_ID from user_group where NAME = 'ZINGPAY'), service_fee_group_id, 1 from service_fee_group where service_id = 251 and fee_group_id in (select fee_group_id from fee_group where name like 'BUNDLE_BOOKME_AIRLINE_ZINGPAY');

insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select (SELECT USER_GROUP_ID from user_group where NAME = 'DEFAULT'), service_fee_group_id, 1 from service_fee_group where service_id = 252 and fee_group_id in (select fee_group_id from fee_group where name like 'BUNDLE_BOOKME_BUS_DEFAULT');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select (SELECT USER_GROUP_ID from user_group where NAME = 'ZINGPAY'), service_fee_group_id, 1 from service_fee_group where service_id = 252 and fee_group_id in (select fee_group_id from fee_group where name like 'BUNDLE_BOOKME_BUS_ZINGPAY');

insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select (SELECT USER_GROUP_ID from user_group where NAME = 'DEFAULT'), service_fee_group_id, 1 from service_fee_group where service_id = 253 and fee_group_id in (select fee_group_id from fee_group where name like 'BUNDLE_BOOKME_CINEMA_DEFAULT');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select (SELECT USER_GROUP_ID from user_group where NAME = 'ZINGPAY'), service_fee_group_id, 1 from service_fee_group where service_id = 253 and fee_group_id in (select fee_group_id from fee_group where name like 'BUNDLE_BOOKME_CINEMA_ZINGPAY');


insert into fee (fee_group_id, fee_type_id, type, fee_name, fee, active_ind) select fee_group_id, 2, 'TX_COMMISSION', 'COMMISSION', 2.5, 1 from fee_group where name like 'BUNDLE_BOOKME_EVENT_DEFAULT';
insert into fee (fee_group_id, fee_type_id, type, fee_name, fee, active_ind) select fee_group_id, 2, 'TX_SERVICE_CHARGE', 'SERVICE CHARGE', 0, 1 from fee_group where name like 'BUNDLE_BOOKME_EVENT_DEFAULT';

insert into fee (fee_group_id, fee_type_id, type, fee_name, fee, active_ind) select fee_group_id, 2, 'TX_COMMISSION', 'COMMISSION', 100, 1 from fee_group where name like 'BUNDLE_BOOKME_EVENT_ZINGPAY';
insert into fee (fee_group_id, fee_type_id, type, fee_name, fee, active_ind) select fee_group_id, 2, 'TX_SERVICE_CHARGE', 'SERVICE CHARGE', 0, 1 from fee_group where name like 'BUNDLE_BOOKME_EVENT_ZINGPAY';


insert into fee (fee_group_id, fee_type_id, type, fee_name, fee, active_ind) select fee_group_id, 2, 'TX_COMMISSION', 'COMMISSION', 1, 1 from fee_group where name like 'BUNDLE_BOOKME_AIRLINE_DEFAULT';
insert into fee (fee_group_id, fee_type_id, type, fee_name, fee, active_ind) select fee_group_id, 2, 'TX_SERVICE_CHARGE', 'SERVICE CHARGE', 0, 1 from fee_group where name like 'BUNDLE_BOOKME_AIRLINE_DEFAULT';

insert into fee (fee_group_id, fee_type_id, type, fee_name, fee, active_ind) select fee_group_id, 2, 'TX_COMMISSION', 'COMMISSION', 100, 1 from fee_group where name like 'BUNDLE_BOOKME_AIRLINE_ZINGPAY';
insert into fee (fee_group_id, fee_type_id, type, fee_name, fee, active_ind) select fee_group_id, 2, 'TX_SERVICE_CHARGE', 'SERVICE CHARGE', 0, 1 from fee_group where name like 'BUNDLE_BOOKME_AIRLINE_ZINGPAY';


insert into fee (fee_group_id, fee_type_id, type, fee_name, fee, active_ind) select fee_group_id, 2, 'TX_COMMISSION', 'COMMISSION', 5, 1 from fee_group where name like 'BUNDLE_BOOKME_BUS_DEFAULT';
insert into fee (fee_group_id, fee_type_id, type, fee_name, fee, active_ind) select fee_group_id, 2, 'TX_SERVICE_CHARGE', 'SERVICE CHARGE', 0, 1 from fee_group where name like 'BUNDLE_BOOKME_BUS_DEFAULT';

insert into fee (fee_group_id, fee_type_id, type, fee_name, fee, active_ind) select fee_group_id, 2, 'TX_COMMISSION', 'COMMISSION', 100, 1 from fee_group where name like 'BUNDLE_BOOKME_BUS_ZINGPAY';
insert into fee (fee_group_id, fee_type_id, type, fee_name, fee, active_ind) select fee_group_id, 2, 'TX_SERVICE_CHARGE', 'SERVICE CHARGE', 0, 1 from fee_group where name like 'BUNDLE_BOOKME_BUS_ZINGPAY';


insert into fee (fee_group_id, fee_type_id, type, fee_name, fee, active_ind) select fee_group_id, 2, 'TX_COMMISSION', 'COMMISSION', 2.5, 1 from fee_group where name like 'BUNDLE_BOOKME_CINEMA_DEFAULT';
insert into fee (fee_group_id, fee_type_id, type, fee_name, fee, active_ind) select fee_group_id, 2, 'TX_SERVICE_CHARGE', 'SERVICE CHARGE', 0, 1 from fee_group where name like 'BUNDLE_BOOKME_CINEMA_DEFAULT';

insert into fee (fee_group_id, fee_type_id, type, fee_name, fee, active_ind) select fee_group_id, 2, 'TX_COMMISSION', 'COMMISSION', 100, 1 from fee_group where name like 'BUNDLE_BOOKME_CINEMA_ZINGPAY';
insert into fee (fee_group_id, fee_type_id, type, fee_name, fee, active_ind) select fee_group_id, 2, 'TX_SERVICE_CHARGE', 'SERVICE CHARGE', 0, 1 from fee_group where name like 'BUNDLE_BOOKME_CINEMA_ZINGPAY';