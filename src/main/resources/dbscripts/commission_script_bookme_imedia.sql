INSERT INTO fee_group (NAME, ACTIVE_IND) VALUES
('BUNDLE_BOOKME_EVENT_IMEDIA', '1'), ('BUNDLE_BOOKME_EVENT_IMEDIA_HANDLERS', '1'), ('BUNDLE_BOOKME_EVENT_IMEDIA_CABLE_OPERATOR', '1'), ('BUNDLE_BOOKME_EVENT_IMEDIA_CABLE_OPERATOR_HANDLERS', '1'), ('BUNDLE_BOOKME_EVENT_IMEDIA_CABLE_DISTRIBUTOR', '1'), ('BUNDLE_BOOKME_EVENT_IMEDIA_CABLE_DISTRIBUTOR_HANDLERS', '1'),
('BUNDLE_BOOKME_AIRLINE_IMEDIA', '1'), ('BUNDLE_BOOKME_AIRLINE_IMEDIA_HANDLERS', '1'), ('BUNDLE_BOOKME_AIRLINE_IMEDIA_CABLE_OPERATOR', '1'), ('BUNDLE_BOOKME_AIRLINE_IMEDIA_CABLE_OPERATOR_HANDLERS', '1'), ('BUNDLE_BOOKME_AIRLINE_IMEDIA_CABLE_DISTRIBUTOR', '1'), ('BUNDLE_BOOKME_AIRLINE_IMEDIA_CABLE_DISTRIBUTOR_HANDLERS', '1'),
('BUNDLE_BOOKME_BUS_IMEDIA', '1'), ('BUNDLE_BOOKME_BUS_IMEDIA_HANDLERS', '1'), ('BUNDLE_BOOKME_BUS_IMEDIA_CABLE_OPERATOR', '1'), ('BUNDLE_BOOKME_BUS_IMEDIA_CABLE_OPERATOR_HANDLERS', '1'), ('BUNDLE_BOOKME_BUS_IMEDIA_CABLE_DISTRIBUTOR', '1'), ('BUNDLE_BOOKME_BUS_IMEDIA_CABLE_DISTRIBUTOR_HANDLERS', '1'),
('BUNDLE_BOOKME_CINEMA_IMEDIA', '1'), ('BUNDLE_BOOKME_CINEMA_IMEDIA_HANDLERS', '1'), ('BUNDLE_BOOKME_CINEMA_IMEDIA_CABLE_OPERATOR', '1'), ('BUNDLE_BOOKME_CINEMA_IMEDIA_CABLE_OPERATOR_HANDLERS', '1'), ('BUNDLE_BOOKME_CINEMA_IMEDIA_CABLE_DISTRIBUTOR', '1'), ('BUNDLE_BOOKME_CINEMA_IMEDIA_CABLE_DISTRIBUTOR_HANDLERS', '1');

insert into service_fee_group (service_id, fee_group_id, ACTIVE_IND) select 250, fee_group_id, 1 from fee_group where name like 'BUNDLE_BOOKME_EVENT_IMEDIA%';
insert into service_fee_group (service_id, fee_group_id, ACTIVE_IND) select 251, fee_group_id, 1 from fee_group where name like 'BUNDLE_BOOKME_AIRLINE_IMEDIA%';
insert into service_fee_group (service_id, fee_group_id, ACTIVE_IND) select 252, fee_group_id, 1 from fee_group where name like 'BUNDLE_BOOKME_BUS_IMEDIA%';
insert into service_fee_group (service_id, fee_group_id, ACTIVE_IND) select 253, fee_group_id, 1 from fee_group where name like 'BUNDLE_BOOKME_CINEMA_IMEDIA%';

insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select (SELECT USER_GROUP_ID from user_group where NAME = 'IMEDIA'), service_fee_group_id, 1 from service_fee_group where service_id = 250 and fee_group_id in (select fee_group_id from fee_group where name like 'BUNDLE_BOOKME_EVENT_IMEDIA');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select (SELECT USER_GROUP_ID from user_group where NAME = 'IMEDIA_HANDLERS'), service_fee_group_id, 1 from service_fee_group where service_id = 250 and fee_group_id in (select fee_group_id from fee_group where name like 'BUNDLE_BOOKME_EVENT_IMEDIA_HANDLERS');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select (SELECT USER_GROUP_ID from user_group where NAME = 'IMEDIA_CABLE_OPERATOR'), service_fee_group_id, 1 from service_fee_group where service_id = 250 and fee_group_id in (select fee_group_id from fee_group where name like 'BUNDLE_BOOKME_EVENT_IMEDIA_CABLE_OPERATOR');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select (SELECT USER_GROUP_ID from user_group where NAME = 'IMEDIA_CABLE_OPERATOR_HANDLERS'), service_fee_group_id, 1 from service_fee_group where service_id = 250 and fee_group_id in (select fee_group_id from fee_group where name like 'BUNDLE_BOOKME_EVENT_IMEDIA_CABLE_OPERATOR_HANDLERS');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select (SELECT USER_GROUP_ID from user_group where NAME = 'IMEDIA_CABLE_DISTRIBUTOR'), service_fee_group_id, 1 from service_fee_group where service_id = 250 and fee_group_id in (select fee_group_id from fee_group where name like 'BUNDLE_BOOKME_EVENT_IMEDIA_CABLE_DISTRIBUTOR');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select (SELECT USER_GROUP_ID from user_group where NAME = 'IMEDIA_CABLE_DISTRIBUTOR_HANDLERS'), service_fee_group_id, 1 from service_fee_group where service_id = 250 and fee_group_id in (select fee_group_id from fee_group where name like 'BUNDLE_BOOKME_EVENT_IMEDIA_CABLE_DISTRIBUTOR_HANDLERS');

insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select (SELECT USER_GROUP_ID from user_group where NAME = 'IMEDIA'), service_fee_group_id, 1 from service_fee_group where service_id = 251 and fee_group_id in (select fee_group_id from fee_group where name like 'BUNDLE_BOOKME_AIRLINE_IMEDIA');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select (SELECT USER_GROUP_ID from user_group where NAME = 'IMEDIA_HANDLERS'), service_fee_group_id, 1 from service_fee_group where service_id = 251 and fee_group_id in (select fee_group_id from fee_group where name like 'BUNDLE_BOOKME_AIRLINE_IMEDIA_HANDLERS');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select (SELECT USER_GROUP_ID from user_group where NAME = 'IMEDIA_CABLE_OPERATOR'), service_fee_group_id, 1 from service_fee_group where service_id = 251 and fee_group_id in (select fee_group_id from fee_group where name like 'BUNDLE_BOOKME_AIRLINE_IMEDIA_CABLE_OPERATOR');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select (SELECT USER_GROUP_ID from user_group where NAME = 'IMEDIA_CABLE_OPERATOR_HANDLERS'), service_fee_group_id, 1 from service_fee_group where service_id = 251 and fee_group_id in (select fee_group_id from fee_group where name like 'BUNDLE_BOOKME_AIRLINE_IMEDIA_CABLE_OPERATOR_HANDLERS');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select (SELECT USER_GROUP_ID from user_group where NAME = 'IMEDIA_CABLE_DISTRIBUTOR'), service_fee_group_id, 1 from service_fee_group where service_id = 251 and fee_group_id in (select fee_group_id from fee_group where name like 'BUNDLE_BOOKME_AIRLINE_IMEDIA_CABLE_DISTRIBUTOR');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select (SELECT USER_GROUP_ID from user_group where NAME = 'IMEDIA_CABLE_DISTRIBUTOR_HANDLERS'), service_fee_group_id, 1 from service_fee_group where service_id = 251 and fee_group_id in (select fee_group_id from fee_group where name like 'BUNDLE_BOOKME_AIRLINE_IMEDIA_CABLE_DISTRIBUTOR_HANDLERS');

insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select (SELECT USER_GROUP_ID from user_group where NAME = 'IMEDIA'), service_fee_group_id, 1 from service_fee_group where service_id = 252 and fee_group_id in (select fee_group_id from fee_group where name like 'BUNDLE_BOOKME_BUS_IMEDIA');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select (SELECT USER_GROUP_ID from user_group where NAME = 'IMEDIA_HANDLERS'), service_fee_group_id, 1 from service_fee_group where service_id = 252 and fee_group_id in (select fee_group_id from fee_group where name like 'BUNDLE_BOOKME_BUS_IMEDIA_HANDLERS');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select (SELECT USER_GROUP_ID from user_group where NAME = 'IMEDIA_CABLE_OPERATOR'), service_fee_group_id, 1 from service_fee_group where service_id = 252 and fee_group_id in (select fee_group_id from fee_group where name like 'BUNDLE_BOOKME_BUS_IMEDIA_CABLE_OPERATOR');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select (SELECT USER_GROUP_ID from user_group where NAME = 'IMEDIA_CABLE_OPERATOR_HANDLERS'), service_fee_group_id, 1 from service_fee_group where service_id = 252 and fee_group_id in (select fee_group_id from fee_group where name like 'BUNDLE_BOOKME_BUS_IMEDIA_CABLE_OPERATOR_HANDLERS');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select (SELECT USER_GROUP_ID from user_group where NAME = 'IMEDIA_CABLE_DISTRIBUTOR'), service_fee_group_id, 1 from service_fee_group where service_id = 252 and fee_group_id in (select fee_group_id from fee_group where name like 'BUNDLE_BOOKME_BUS_IMEDIA_CABLE_DISTRIBUTOR');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select (SELECT USER_GROUP_ID from user_group where NAME = 'IMEDIA_CABLE_DISTRIBUTOR_HANDLERS'), service_fee_group_id, 1 from service_fee_group where service_id = 252 and fee_group_id in (select fee_group_id from fee_group where name like 'BUNDLE_BOOKME_BUS_IMEDIA_CABLE_DISTRIBUTOR_HANDLERS');

insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select (SELECT USER_GROUP_ID from user_group where NAME = 'IMEDIA'), service_fee_group_id, 1 from service_fee_group where service_id = 253 and fee_group_id in (select fee_group_id from fee_group where name like 'BUNDLE_BOOKME_CINEMA_IMEDIA');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select (SELECT USER_GROUP_ID from user_group where NAME = 'IMEDIA_HANDLERS'), service_fee_group_id, 1 from service_fee_group where service_id = 253 and fee_group_id in (select fee_group_id from fee_group where name like 'BUNDLE_BOOKME_CINEMA_IMEDIA_HANDLERS');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select (SELECT USER_GROUP_ID from user_group where NAME = 'IMEDIA_CABLE_OPERATOR'), service_fee_group_id, 1 from service_fee_group where service_id = 253 and fee_group_id in (select fee_group_id from fee_group where name like 'BUNDLE_BOOKME_CINEMA_IMEDIA_CABLE_OPERATOR');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select (SELECT USER_GROUP_ID from user_group where NAME = 'IMEDIA_CABLE_OPERATOR_HANDLERS'), service_fee_group_id, 1 from service_fee_group where service_id = 253 and fee_group_id in (select fee_group_id from fee_group where name like 'BUNDLE_BOOKME_CINEMA_IMEDIA_CABLE_OPERATOR_HANDLERS');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select (SELECT USER_GROUP_ID from user_group where NAME = 'IMEDIA_CABLE_DISTRIBUTOR'), service_fee_group_id, 1 from service_fee_group where service_id = 253 and fee_group_id in (select fee_group_id from fee_group where name like 'BUNDLE_BOOKME_CINEMA_IMEDIA_CABLE_DISTRIBUTOR');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select (SELECT USER_GROUP_ID from user_group where NAME = 'IMEDIA_CABLE_DISTRIBUTOR_HANDLERS'), service_fee_group_id, 1 from service_fee_group where service_id = 253 and fee_group_id in (select fee_group_id from fee_group where name like 'BUNDLE_BOOKME_CINEMA_IMEDIA_CABLE_DISTRIBUTOR_HANDLERS');


insert into fee (fee_group_id, fee_type_id, type, fee_name, fee, active_ind) select fee_group_id, 2, 'TX_COMMISSION', 'COMMISSION', 70, 1 from fee_group where name like 'BUNDLE_BOOKME_EVENT_IMEDIA';
insert into fee (fee_group_id, fee_type_id, type, fee_name, fee, active_ind) select fee_group_id, 2, 'TX_SERVICE_CHARGE', 'SERVICE CHARGE', 0, 1 from fee_group where name like 'BUNDLE_BOOKME_EVENT_IMEDIA';

insert into fee (fee_group_id, fee_type_id, type, fee_name, fee, active_ind) select fee_group_id, 2, 'TX_COMMISSION', 'COMMISSION', 0, 1 from fee_group where name like 'BUNDLE_BOOKME_EVENT_IMEDIA_HANDLERS';
insert into fee (fee_group_id, fee_type_id, type, fee_name, fee, active_ind) select fee_group_id, 2, 'TX_SERVICE_CHARGE', 'SERVICE CHARGE', 0, 1 from fee_group where name like 'BUNDLE_BOOKME_EVENT_IMEDIA_HANDLERS';

insert into fee (fee_group_id, fee_type_id, type, fee_name, fee, active_ind) select fee_group_id, 2, 'TX_COMMISSION', 'COMMISSION', 70, 1 from fee_group where name like 'BUNDLE_BOOKME_EVENT_IMEDIA_CABLE_OPERATOR';
insert into fee (fee_group_id, fee_type_id, type, fee_name, fee, active_ind) select fee_group_id, 2, 'TX_SERVICE_CHARGE', 'SERVICE CHARGE', 0, 1 from fee_group where name like 'BUNDLE_BOOKME_EVENT_IMEDIA_CABLE_OPERATOR';

insert into fee (fee_group_id, fee_type_id, type, fee_name, fee, active_ind) select fee_group_id, 2, 'TX_COMMISSION', 'COMMISSION', 0, 1 from fee_group where name like 'BUNDLE_BOOKME_EVENT_IMEDIA_CABLE_OPERATOR_HANDLERS';
insert into fee (fee_group_id, fee_type_id, type, fee_name, fee, active_ind) select fee_group_id, 2, 'TX_SERVICE_CHARGE', 'SERVICE CHARGE', 0, 1 from fee_group where name like 'BUNDLE_BOOKME_EVENT_IMEDIA_CABLE_OPERATOR_HANDLERS';

insert into fee (fee_group_id, fee_type_id, type, fee_name, fee, active_ind) select fee_group_id, 2, 'TX_COMMISSION', 'COMMISSION', 70, 1 from fee_group where name like 'BUNDLE_BOOKME_EVENT_IMEDIA_CABLE_DISTRIBUTOR';
insert into fee (fee_group_id, fee_type_id, type, fee_name, fee, active_ind) select fee_group_id, 2, 'TX_SERVICE_CHARGE', 'SERVICE CHARGE', 0, 1 from fee_group where name like 'BUNDLE_BOOKME_EVENT_IMEDIA_CABLE_DISTRIBUTOR';

insert into fee (fee_group_id, fee_type_id, type, fee_name, fee, active_ind) select fee_group_id, 2, 'TX_COMMISSION', 'COMMISSION', 0, 1 from fee_group where name like 'BUNDLE_BOOKME_EVENT_IMEDIA_CABLE_DISTRIBUTOR_HANDLERS';
insert into fee (fee_group_id, fee_type_id, type, fee_name, fee, active_ind) select fee_group_id, 2, 'TX_SERVICE_CHARGE', 'SERVICE CHARGE', 0, 1 from fee_group where name like 'BUNDLE_BOOKME_EVENT_IMEDIA_CABLE_DISTRIBUTOR_HANDLERS';


insert into fee (fee_group_id, fee_type_id, type, fee_name, fee, active_ind) select fee_group_id, 2, 'TX_COMMISSION', 'COMMISSION', 70, 1 from fee_group where name like 'BUNDLE_BOOKME_AIRLINE_IMEDIA';
insert into fee (fee_group_id, fee_type_id, type, fee_name, fee, active_ind) select fee_group_id, 2, 'TX_SERVICE_CHARGE', 'SERVICE CHARGE', 0, 1 from fee_group where name like 'BUNDLE_BOOKME_AIRLINE_IMEDIA';

insert into fee (fee_group_id, fee_type_id, type, fee_name, fee, active_ind) select fee_group_id, 2, 'TX_COMMISSION', 'COMMISSION', 0, 1 from fee_group where name like 'BUNDLE_BOOKME_AIRLINE_IMEDIA_HANDLERS';
insert into fee (fee_group_id, fee_type_id, type, fee_name, fee, active_ind) select fee_group_id, 2, 'TX_SERVICE_CHARGE', 'SERVICE CHARGE', 0, 1 from fee_group where name like 'BUNDLE_BOOKME_AIRLINE_IMEDIA_HANDLERS';

insert into fee (fee_group_id, fee_type_id, type, fee_name, fee, active_ind) select fee_group_id, 2, 'TX_COMMISSION', 'COMMISSION', 70, 1 from fee_group where name like 'BUNDLE_BOOKME_AIRLINE_IMEDIA_CABLE_OPERATOR';
insert into fee (fee_group_id, fee_type_id, type, fee_name, fee, active_ind) select fee_group_id, 2, 'TX_SERVICE_CHARGE', 'SERVICE CHARGE', 0, 1 from fee_group where name like 'BUNDLE_BOOKME_AIRLINE_IMEDIA_CABLE_OPERATOR';

insert into fee (fee_group_id, fee_type_id, type, fee_name, fee, active_ind) select fee_group_id, 2, 'TX_COMMISSION', 'COMMISSION', 0, 1 from fee_group where name like 'BUNDLE_BOOKME_AIRLINE_IMEDIA_CABLE_OPERATOR_HANDLERS';
insert into fee (fee_group_id, fee_type_id, type, fee_name, fee, active_ind) select fee_group_id, 2, 'TX_SERVICE_CHARGE', 'SERVICE CHARGE', 0, 1 from fee_group where name like 'BUNDLE_BOOKME_AIRLINE_IMEDIA_CABLE_OPERATOR_HANDLERS';

insert into fee (fee_group_id, fee_type_id, type, fee_name, fee, active_ind) select fee_group_id, 2, 'TX_COMMISSION', 'COMMISSION', 70, 1 from fee_group where name like 'BUNDLE_BOOKME_AIRLINE_IMEDIA_CABLE_DISTRIBUTOR';
insert into fee (fee_group_id, fee_type_id, type, fee_name, fee, active_ind) select fee_group_id, 2, 'TX_SERVICE_CHARGE', 'SERVICE CHARGE', 0, 1 from fee_group where name like 'BUNDLE_BOOKME_AIRLINE_IMEDIA_CABLE_DISTRIBUTOR';

insert into fee (fee_group_id, fee_type_id, type, fee_name, fee, active_ind) select fee_group_id, 2, 'TX_COMMISSION', 'COMMISSION', 0, 1 from fee_group where name like 'BUNDLE_BOOKME_AIRLINE_IMEDIA_CABLE_DISTRIBUTOR_HANDLERS';
insert into fee (fee_group_id, fee_type_id, type, fee_name, fee, active_ind) select fee_group_id, 2, 'TX_SERVICE_CHARGE', 'SERVICE CHARGE', 0, 1 from fee_group where name like 'BUNDLE_BOOKME_AIRLINE_IMEDIA_CABLE_DISTRIBUTOR_HANDLERS';


insert into fee (fee_group_id, fee_type_id, type, fee_name, fee, active_ind) select fee_group_id, 2, 'TX_COMMISSION', 'COMMISSION', 70, 1 from fee_group where name like 'BUNDLE_BOOKME_BUS_IMEDIA';
insert into fee (fee_group_id, fee_type_id, type, fee_name, fee, active_ind) select fee_group_id, 2, 'TX_SERVICE_CHARGE', 'SERVICE CHARGE', 0, 1 from fee_group where name like 'BUNDLE_BOOKME_BUS_IMEDIA';

insert into fee (fee_group_id, fee_type_id, type, fee_name, fee, active_ind) select fee_group_id, 2, 'TX_COMMISSION', 'COMMISSION', 0, 1 from fee_group where name like 'BUNDLE_BOOKME_BUS_IMEDIA_HANDLERS';
insert into fee (fee_group_id, fee_type_id, type, fee_name, fee, active_ind) select fee_group_id, 2, 'TX_SERVICE_CHARGE', 'SERVICE CHARGE', 0, 1 from fee_group where name like 'BUNDLE_BOOKME_BUS_IMEDIA_HANDLERS';

insert into fee (fee_group_id, fee_type_id, type, fee_name, fee, active_ind) select fee_group_id, 2, 'TX_COMMISSION', 'COMMISSION', 70, 1 from fee_group where name like 'BUNDLE_BOOKME_BUS_IMEDIA_CABLE_OPERATOR';
insert into fee (fee_group_id, fee_type_id, type, fee_name, fee, active_ind) select fee_group_id, 2, 'TX_SERVICE_CHARGE', 'SERVICE CHARGE', 0, 1 from fee_group where name like 'BUNDLE_BOOKME_BUS_IMEDIA_CABLE_OPERATOR';

insert into fee (fee_group_id, fee_type_id, type, fee_name, fee, active_ind) select fee_group_id, 2, 'TX_COMMISSION', 'COMMISSION', 0, 1 from fee_group where name like 'BUNDLE_BOOKME_BUS_IMEDIA_CABLE_OPERATOR_HANDLERS';
insert into fee (fee_group_id, fee_type_id, type, fee_name, fee, active_ind) select fee_group_id, 2, 'TX_SERVICE_CHARGE', 'SERVICE CHARGE', 0, 1 from fee_group where name like 'BUNDLE_BOOKME_BUS_IMEDIA_CABLE_OPERATOR_HANDLERS';

insert into fee (fee_group_id, fee_type_id, type, fee_name, fee, active_ind) select fee_group_id, 2, 'TX_COMMISSION', 'COMMISSION', 70, 1 from fee_group where name like 'BUNDLE_BOOKME_BUS_IMEDIA_CABLE_DISTRIBUTOR';
insert into fee (fee_group_id, fee_type_id, type, fee_name, fee, active_ind) select fee_group_id, 2, 'TX_SERVICE_CHARGE', 'SERVICE CHARGE', 0, 1 from fee_group where name like 'BUNDLE_BOOKME_BUS_IMEDIA_CABLE_DISTRIBUTOR';

insert into fee (fee_group_id, fee_type_id, type, fee_name, fee, active_ind) select fee_group_id, 2, 'TX_COMMISSION', 'COMMISSION', 0, 1 from fee_group where name like 'BUNDLE_BOOKME_BUS_IMEDIA_CABLE_DISTRIBUTOR_HANDLERS';
insert into fee (fee_group_id, fee_type_id, type, fee_name, fee, active_ind) select fee_group_id, 2, 'TX_SERVICE_CHARGE', 'SERVICE CHARGE', 0, 1 from fee_group where name like 'BUNDLE_BOOKME_BUS_IMEDIA_CABLE_DISTRIBUTOR_HANDLERS';


insert into fee (fee_group_id, fee_type_id, type, fee_name, fee, active_ind) select fee_group_id, 2, 'TX_COMMISSION', 'COMMISSION', 70, 1 from fee_group where name like 'BUNDLE_BOOKME_CINEMA_IMEDIA';
insert into fee (fee_group_id, fee_type_id, type, fee_name, fee, active_ind) select fee_group_id, 2, 'TX_SERVICE_CHARGE', 'SERVICE CHARGE', 0, 1 from fee_group where name like 'BUNDLE_BOOKME_CINEMA_IMEDIA';

insert into fee (fee_group_id, fee_type_id, type, fee_name, fee, active_ind) select fee_group_id, 2, 'TX_COMMISSION', 'COMMISSION', 0, 1 from fee_group where name like 'BUNDLE_BOOKME_CINEMA_IMEDIA_HANDLERS';
insert into fee (fee_group_id, fee_type_id, type, fee_name, fee, active_ind) select fee_group_id, 2, 'TX_SERVICE_CHARGE', 'SERVICE CHARGE', 0, 1 from fee_group where name like 'BUNDLE_BOOKME_CINEMA_IMEDIA_HANDLERS';

insert into fee (fee_group_id, fee_type_id, type, fee_name, fee, active_ind) select fee_group_id, 2, 'TX_COMMISSION', 'COMMISSION', 70, 1 from fee_group where name like 'BUNDLE_BOOKME_CINEMA_IMEDIA_CABLE_OPERATOR';
insert into fee (fee_group_id, fee_type_id, type, fee_name, fee, active_ind) select fee_group_id, 2, 'TX_SERVICE_CHARGE', 'SERVICE CHARGE', 0, 1 from fee_group where name like 'BUNDLE_BOOKME_CINEMA_IMEDIA_CABLE_OPERATOR';

insert into fee (fee_group_id, fee_type_id, type, fee_name, fee, active_ind) select fee_group_id, 2, 'TX_COMMISSION', 'COMMISSION', 0, 1 from fee_group where name like 'BUNDLE_BOOKME_CINEMA_IMEDIA_CABLE_OPERATOR_HANDLERS';
insert into fee (fee_group_id, fee_type_id, type, fee_name, fee, active_ind) select fee_group_id, 2, 'TX_SERVICE_CHARGE', 'SERVICE CHARGE', 0, 1 from fee_group where name like 'BUNDLE_BOOKME_CINEMA_IMEDIA_CABLE_OPERATOR_HANDLERS';

insert into fee (fee_group_id, fee_type_id, type, fee_name, fee, active_ind) select fee_group_id, 2, 'TX_COMMISSION', 'COMMISSION', 70, 1 from fee_group where name like 'BUNDLE_BOOKME_CINEMA_IMEDIA_CABLE_DISTRIBUTOR';
insert into fee (fee_group_id, fee_type_id, type, fee_name, fee, active_ind) select fee_group_id, 2, 'TX_SERVICE_CHARGE', 'SERVICE CHARGE', 0, 1 from fee_group where name like 'BUNDLE_BOOKME_CINEMA_IMEDIA_CABLE_DISTRIBUTOR';

insert into fee (fee_group_id, fee_type_id, type, fee_name, fee, active_ind) select fee_group_id, 2, 'TX_COMMISSION', 'COMMISSION', 0, 1 from fee_group where name like 'BUNDLE_BOOKME_CINEMA_IMEDIA_CABLE_DISTRIBUTOR_HANDLERS';
insert into fee (fee_group_id, fee_type_id, type, fee_name, fee, active_ind) select fee_group_id, 2, 'TX_SERVICE_CHARGE', 'SERVICE CHARGE', 0, 1 from fee_group where name like 'BUNDLE_BOOKME_CINEMA_IMEDIA_CABLE_DISTRIBUTOR_HANDLERS';