INSERT INTO fee_group (NAME, ACTIVE_IND) VALUES ('BILLPAYMENT_NADRA_IMEDIA', '1'), ('BILLPAYMENT_NADRA_IMEDIA_HANDLERS', '1'), ('BILLPAYMENT_NADRA_IMEDIA_CABLE_OPERATOR', '1'), ('BILLPAYMENT_NADRA_IMEDIA_CABLE_OPERATOR_HANDLERS', '1'), ('BILLPAYMENT_NADRA_IMEDIA_CABLE_DISTRIBUTOR', '1'), ('BILLPAYMENT_NADRA_IMEDIA_CABLE_DISTRIBUTOR_HANDLERS', '1');

insert into service_fee_group (service_id, fee_group_id, ACTIVE_IND) select 100, fee_group_id, 1 from fee_group where name like 'BILLPAYMENT_NADRA_IMEDIA%';
insert into service_fee_group (service_id, fee_group_id, ACTIVE_IND) select 101, fee_group_id, 1 from fee_group where name like 'BILLPAYMENT_NADRA_IMEDIA%';
insert into service_fee_group (service_id, fee_group_id, ACTIVE_IND) select 102, fee_group_id, 1 from fee_group where name like 'BILLPAYMENT_NADRA_IMEDIA%';
insert into service_fee_group (service_id, fee_group_id, ACTIVE_IND) select 103, fee_group_id, 1 from fee_group where name like 'BILLPAYMENT_NADRA_IMEDIA%';
insert into service_fee_group (service_id, fee_group_id, ACTIVE_IND) select 104, fee_group_id, 1 from fee_group where name like 'BILLPAYMENT_NADRA_IMEDIA%';
insert into service_fee_group (service_id, fee_group_id, ACTIVE_IND) select 105, fee_group_id, 1 from fee_group where name like 'BILLPAYMENT_NADRA_IMEDIA%';
insert into service_fee_group (service_id, fee_group_id, ACTIVE_IND) select 106, fee_group_id, 1 from fee_group where name like 'BILLPAYMENT_NADRA_IMEDIA%';
insert into service_fee_group (service_id, fee_group_id, ACTIVE_IND) select 107, fee_group_id, 1 from fee_group where name like 'BILLPAYMENT_NADRA_IMEDIA%';
insert into service_fee_group (service_id, fee_group_id, ACTIVE_IND) select 108, fee_group_id, 1 from fee_group where name like 'BILLPAYMENT_NADRA_IMEDIA%';
insert into service_fee_group (service_id, fee_group_id, ACTIVE_IND) select 109, fee_group_id, 1 from fee_group where name like 'BILLPAYMENT_NADRA_IMEDIA%';
insert into service_fee_group (service_id, fee_group_id, ACTIVE_IND) select 110, fee_group_id, 1 from fee_group where name like 'BILLPAYMENT_NADRA_IMEDIA%';


insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select (SELECT USER_GROUP_ID from user_group where NAME = 'IMEDIA'), service_fee_group_id, 1 from service_fee_group where service_id = 100 and fee_group_id in (select fee_group_id from fee_group where name like 'BILLPAYMENT_NADRA_IMEDIA');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select (SELECT USER_GROUP_ID from user_group where NAME = 'IMEDIA_HANDLERS'), service_fee_group_id, 1 from service_fee_group where service_id = 100 and fee_group_id in (select fee_group_id from fee_group where name like 'BILLPAYMENT_NADRA_IMEDIA_HANDLERS');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select (SELECT USER_GROUP_ID from user_group where NAME = 'IMEDIA_CABLE_OPERATOR'), service_fee_group_id, 1 from service_fee_group where service_id = 100 and fee_group_id in (select fee_group_id from fee_group where name like 'BILLPAYMENT_NADRA_IMEDIA_CABLE_OPERATOR');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select (SELECT USER_GROUP_ID from user_group where NAME = 'IMEDIA_CABLE_OPERATOR_HANDLERS'), service_fee_group_id, 1 from service_fee_group where service_id = 100 and fee_group_id in (select fee_group_id from fee_group where name like 'BILLPAYMENT_NADRA_IMEDIA_CABLE_OPERATOR_HANDLERS');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select (SELECT USER_GROUP_ID from user_group where NAME = 'IMEDIA_CABLE_DISTRIBUTOR'), service_fee_group_id, 1 from service_fee_group where service_id = 100 and fee_group_id in (select fee_group_id from fee_group where name like 'BILLPAYMENT_NADRA_IMEDIA_CABLE_DISTRIBUTOR');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select (SELECT USER_GROUP_ID from user_group where NAME = 'IMEDIA_CABLE_DISTRIBUTOR_HANDLERS'), service_fee_group_id, 1 from service_fee_group where service_id = 100 and fee_group_id in (select fee_group_id from fee_group where name like 'BILLPAYMENT_NADRA_IMEDIA_CABLE_DISTRIBUTOR_HANDLERS');

insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select (SELECT USER_GROUP_ID from user_group where NAME = 'IMEDIA'), service_fee_group_id, 1 from service_fee_group where service_id = 101 and fee_group_id in (select fee_group_id from fee_group where name like 'BILLPAYMENT_NADRA_IMEDIA');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select (SELECT USER_GROUP_ID from user_group where NAME = 'IMEDIA_HANDLERS'), service_fee_group_id, 1 from service_fee_group where service_id = 101 and fee_group_id in (select fee_group_id from fee_group where name like 'BILLPAYMENT_NADRA_IMEDIA_HANDLERS');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select (SELECT USER_GROUP_ID from user_group where NAME = 'IMEDIA_CABLE_OPERATOR'), service_fee_group_id, 1 from service_fee_group where service_id = 101 and fee_group_id in (select fee_group_id from fee_group where name like 'BILLPAYMENT_NADRA_IMEDIA_CABLE_OPERATOR');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select (SELECT USER_GROUP_ID from user_group where NAME = 'IMEDIA_CABLE_OPERATOR_HANDLERS'), service_fee_group_id, 1 from service_fee_group where service_id = 101 and fee_group_id in (select fee_group_id from fee_group where name like 'BILLPAYMENT_NADRA_IMEDIA_CABLE_OPERATOR_HANDLERS');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select (SELECT USER_GROUP_ID from user_group where NAME = 'IMEDIA_CABLE_DISTRIBUTOR'), service_fee_group_id, 1 from service_fee_group where service_id = 101 and fee_group_id in (select fee_group_id from fee_group where name like 'BILLPAYMENT_NADRA_IMEDIA_CABLE_DISTRIBUTOR');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select (SELECT USER_GROUP_ID from user_group where NAME = 'IMEDIA_CABLE_DISTRIBUTOR_HANDLERS'), service_fee_group_id, 1 from service_fee_group where service_id = 101 and fee_group_id in (select fee_group_id from fee_group where name like 'BILLPAYMENT_NADRA_IMEDIA_CABLE_DISTRIBUTOR_HANDLERS');

insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select (SELECT USER_GROUP_ID from user_group where NAME = 'IMEDIA'), service_fee_group_id, 1 from service_fee_group where service_id = 102 and fee_group_id in (select fee_group_id from fee_group where name like 'BILLPAYMENT_NADRA_IMEDIA');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select (SELECT USER_GROUP_ID from user_group where NAME = 'IMEDIA_HANDLERS'), service_fee_group_id, 1 from service_fee_group where service_id = 102 and fee_group_id in (select fee_group_id from fee_group where name like 'BILLPAYMENT_NADRA_IMEDIA_HANDLERS');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select (SELECT USER_GROUP_ID from user_group where NAME = 'IMEDIA_CABLE_OPERATOR'), service_fee_group_id, 1 from service_fee_group where service_id = 102 and fee_group_id in (select fee_group_id from fee_group where name like 'BILLPAYMENT_NADRA_IMEDIA_CABLE_OPERATOR');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select (SELECT USER_GROUP_ID from user_group where NAME = 'IMEDIA_CABLE_OPERATOR_HANDLERS'), service_fee_group_id, 1 from service_fee_group where service_id = 102 and fee_group_id in (select fee_group_id from fee_group where name like 'BILLPAYMENT_NADRA_IMEDIA_CABLE_OPERATOR_HANDLERS');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select (SELECT USER_GROUP_ID from user_group where NAME = 'IMEDIA_CABLE_DISTRIBUTOR'), service_fee_group_id, 1 from service_fee_group where service_id = 102 and fee_group_id in (select fee_group_id from fee_group where name like 'BILLPAYMENT_NADRA_IMEDIA_CABLE_DISTRIBUTOR');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select (SELECT USER_GROUP_ID from user_group where NAME = 'IMEDIA_CABLE_DISTRIBUTOR_HANDLERS'), service_fee_group_id, 1 from service_fee_group where service_id = 102 and fee_group_id in (select fee_group_id from fee_group where name like 'BILLPAYMENT_NADRA_IMEDIA_CABLE_DISTRIBUTOR_HANDLERS');

insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select (SELECT USER_GROUP_ID from user_group where NAME = 'IMEDIA'), service_fee_group_id, 1 from service_fee_group where service_id = 103 and fee_group_id in (select fee_group_id from fee_group where name like 'BILLPAYMENT_NADRA_IMEDIA');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select (SELECT USER_GROUP_ID from user_group where NAME = 'IMEDIA_HANDLERS'), service_fee_group_id, 1 from service_fee_group where service_id = 103 and fee_group_id in (select fee_group_id from fee_group where name like 'BILLPAYMENT_NADRA_IMEDIA_HANDLERS');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select (SELECT USER_GROUP_ID from user_group where NAME = 'IMEDIA_CABLE_OPERATOR'), service_fee_group_id, 1 from service_fee_group where service_id = 103 and fee_group_id in (select fee_group_id from fee_group where name like 'BILLPAYMENT_NADRA_IMEDIA_CABLE_OPERATOR');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select (SELECT USER_GROUP_ID from user_group where NAME = 'IMEDIA_CABLE_OPERATOR_HANDLERS'), service_fee_group_id, 1 from service_fee_group where service_id = 103 and fee_group_id in (select fee_group_id from fee_group where name like 'BILLPAYMENT_NADRA_IMEDIA_CABLE_OPERATOR_HANDLERS');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select (SELECT USER_GROUP_ID from user_group where NAME = 'IMEDIA_CABLE_DISTRIBUTOR'), service_fee_group_id, 1 from service_fee_group where service_id = 103 and fee_group_id in (select fee_group_id from fee_group where name like 'BILLPAYMENT_NADRA_IMEDIA_CABLE_DISTRIBUTOR');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select (SELECT USER_GROUP_ID from user_group where NAME = 'IMEDIA_CABLE_DISTRIBUTOR_HANDLERS'), service_fee_group_id, 1 from service_fee_group where service_id = 103 and fee_group_id in (select fee_group_id from fee_group where name like 'BILLPAYMENT_NADRA_IMEDIA_CABLE_DISTRIBUTOR_HANDLERS');

insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select (SELECT USER_GROUP_ID from user_group where NAME = 'IMEDIA'), service_fee_group_id, 1 from service_fee_group where service_id = 104 and fee_group_id in (select fee_group_id from fee_group where name like 'BILLPAYMENT_NADRA_IMEDIA');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select (SELECT USER_GROUP_ID from user_group where NAME = 'IMEDIA_HANDLERS'), service_fee_group_id, 1 from service_fee_group where service_id = 104 and fee_group_id in (select fee_group_id from fee_group where name like 'BILLPAYMENT_NADRA_IMEDIA_HANDLERS');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select (SELECT USER_GROUP_ID from user_group where NAME = 'IMEDIA_CABLE_OPERATOR'), service_fee_group_id, 1 from service_fee_group where service_id = 104 and fee_group_id in (select fee_group_id from fee_group where name like 'BILLPAYMENT_NADRA_IMEDIA_CABLE_OPERATOR');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select (SELECT USER_GROUP_ID from user_group where NAME = 'IMEDIA_CABLE_OPERATOR_HANDLERS'), service_fee_group_id, 1 from service_fee_group where service_id = 104 and fee_group_id in (select fee_group_id from fee_group where name like 'BILLPAYMENT_NADRA_IMEDIA_CABLE_OPERATOR_HANDLERS');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select (SELECT USER_GROUP_ID from user_group where NAME = 'IMEDIA_CABLE_DISTRIBUTOR'), service_fee_group_id, 1 from service_fee_group where service_id = 104 and fee_group_id in (select fee_group_id from fee_group where name like 'BILLPAYMENT_NADRA_IMEDIA_CABLE_DISTRIBUTOR');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select (SELECT USER_GROUP_ID from user_group where NAME = 'IMEDIA_CABLE_DISTRIBUTOR_HANDLERS'), service_fee_group_id, 1 from service_fee_group where service_id = 104 and fee_group_id in (select fee_group_id from fee_group where name like 'BILLPAYMENT_NADRA_IMEDIA_CABLE_DISTRIBUTOR_HANDLERS');

insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select (SELECT USER_GROUP_ID from user_group where NAME = 'IMEDIA'), service_fee_group_id, 1 from service_fee_group where service_id = 105 and fee_group_id in (select fee_group_id from fee_group where name like 'BILLPAYMENT_NADRA_IMEDIA');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select (SELECT USER_GROUP_ID from user_group where NAME = 'IMEDIA_HANDLERS'), service_fee_group_id, 1 from service_fee_group where service_id = 105 and fee_group_id in (select fee_group_id from fee_group where name like 'BILLPAYMENT_NADRA_IMEDIA_HANDLERS');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select (SELECT USER_GROUP_ID from user_group where NAME = 'IMEDIA_CABLE_OPERATOR'), service_fee_group_id, 1 from service_fee_group where service_id = 105 and fee_group_id in (select fee_group_id from fee_group where name like 'BILLPAYMENT_NADRA_IMEDIA_CABLE_OPERATOR');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select (SELECT USER_GROUP_ID from user_group where NAME = 'IMEDIA_CABLE_OPERATOR_HANDLERS'), service_fee_group_id, 1 from service_fee_group where service_id = 105 and fee_group_id in (select fee_group_id from fee_group where name like 'BILLPAYMENT_NADRA_IMEDIA_CABLE_OPERATOR_HANDLERS');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select (SELECT USER_GROUP_ID from user_group where NAME = 'IMEDIA_CABLE_DISTRIBUTOR'), service_fee_group_id, 1 from service_fee_group where service_id = 105 and fee_group_id in (select fee_group_id from fee_group where name like 'BILLPAYMENT_NADRA_IMEDIA_CABLE_DISTRIBUTOR');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select (SELECT USER_GROUP_ID from user_group where NAME = 'IMEDIA_CABLE_DISTRIBUTOR_HANDLERS'), service_fee_group_id, 1 from service_fee_group where service_id = 105 and fee_group_id in (select fee_group_id from fee_group where name like 'BILLPAYMENT_NADRA_IMEDIA_CABLE_DISTRIBUTOR_HANDLERS');

insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select (SELECT USER_GROUP_ID from user_group where NAME = 'IMEDIA'), service_fee_group_id, 1 from service_fee_group where service_id = 106 and fee_group_id in (select fee_group_id from fee_group where name like 'BILLPAYMENT_NADRA_IMEDIA');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select (SELECT USER_GROUP_ID from user_group where NAME = 'IMEDIA_HANDLERS'), service_fee_group_id, 1 from service_fee_group where service_id = 106 and fee_group_id in (select fee_group_id from fee_group where name like 'BILLPAYMENT_NADRA_IMEDIA_HANDLERS');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select (SELECT USER_GROUP_ID from user_group where NAME = 'IMEDIA_CABLE_OPERATOR'), service_fee_group_id, 1 from service_fee_group where service_id = 106 and fee_group_id in (select fee_group_id from fee_group where name like 'BILLPAYMENT_NADRA_IMEDIA_CABLE_OPERATOR');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select (SELECT USER_GROUP_ID from user_group where NAME = 'IMEDIA_CABLE_OPERATOR_HANDLERS'), service_fee_group_id, 1 from service_fee_group where service_id = 106 and fee_group_id in (select fee_group_id from fee_group where name like 'BILLPAYMENT_NADRA_IMEDIA_CABLE_OPERATOR_HANDLERS');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select (SELECT USER_GROUP_ID from user_group where NAME = 'IMEDIA_CABLE_DISTRIBUTOR'), service_fee_group_id, 1 from service_fee_group where service_id = 106 and fee_group_id in (select fee_group_id from fee_group where name like 'BILLPAYMENT_NADRA_IMEDIA_CABLE_DISTRIBUTOR');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select (SELECT USER_GROUP_ID from user_group where NAME = 'IMEDIA_CABLE_DISTRIBUTOR_HANDLERS'), service_fee_group_id, 1 from service_fee_group where service_id = 106 and fee_group_id in (select fee_group_id from fee_group where name like 'BILLPAYMENT_NADRA_IMEDIA_CABLE_DISTRIBUTOR_HANDLERS');

insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select (SELECT USER_GROUP_ID from user_group where NAME = 'IMEDIA'), service_fee_group_id, 1 from service_fee_group where service_id = 107 and fee_group_id in (select fee_group_id from fee_group where name like 'BILLPAYMENT_NADRA_IMEDIA');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select (SELECT USER_GROUP_ID from user_group where NAME = 'IMEDIA_HANDLERS'), service_fee_group_id, 1 from service_fee_group where service_id = 107 and fee_group_id in (select fee_group_id from fee_group where name like 'BILLPAYMENT_NADRA_IMEDIA_HANDLERS');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select (SELECT USER_GROUP_ID from user_group where NAME = 'IMEDIA_CABLE_OPERATOR'), service_fee_group_id, 1 from service_fee_group where service_id = 107 and fee_group_id in (select fee_group_id from fee_group where name like 'BILLPAYMENT_NADRA_IMEDIA_CABLE_OPERATOR');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select (SELECT USER_GROUP_ID from user_group where NAME = 'IMEDIA_CABLE_OPERATOR_HANDLERS'), service_fee_group_id, 1 from service_fee_group where service_id = 107 and fee_group_id in (select fee_group_id from fee_group where name like 'BILLPAYMENT_NADRA_IMEDIA_CABLE_OPERATOR_HANDLERS');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select (SELECT USER_GROUP_ID from user_group where NAME = 'IMEDIA_CABLE_DISTRIBUTOR'), service_fee_group_id, 1 from service_fee_group where service_id = 107 and fee_group_id in (select fee_group_id from fee_group where name like 'BILLPAYMENT_NADRA_IMEDIA_CABLE_DISTRIBUTOR');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select (SELECT USER_GROUP_ID from user_group where NAME = 'IMEDIA_CABLE_DISTRIBUTOR_HANDLERS'), service_fee_group_id, 1 from service_fee_group where service_id = 107 and fee_group_id in (select fee_group_id from fee_group where name like 'BILLPAYMENT_NADRA_IMEDIA_CABLE_DISTRIBUTOR_HANDLERS');

insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select (SELECT USER_GROUP_ID from user_group where NAME = 'IMEDIA'), service_fee_group_id, 1 from service_fee_group where service_id = 108 and fee_group_id in (select fee_group_id from fee_group where name like 'BILLPAYMENT_NADRA_IMEDIA');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select (SELECT USER_GROUP_ID from user_group where NAME = 'IMEDIA_HANDLERS'), service_fee_group_id, 1 from service_fee_group where service_id = 108 and fee_group_id in (select fee_group_id from fee_group where name like 'BILLPAYMENT_NADRA_IMEDIA_HANDLERS');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select (SELECT USER_GROUP_ID from user_group where NAME = 'IMEDIA_CABLE_OPERATOR'), service_fee_group_id, 1 from service_fee_group where service_id = 108 and fee_group_id in (select fee_group_id from fee_group where name like 'BILLPAYMENT_NADRA_IMEDIA_CABLE_OPERATOR');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select (SELECT USER_GROUP_ID from user_group where NAME = 'IMEDIA_CABLE_OPERATOR_HANDLERS'), service_fee_group_id, 1 from service_fee_group where service_id = 108 and fee_group_id in (select fee_group_id from fee_group where name like 'BILLPAYMENT_NADRA_IMEDIA_CABLE_OPERATOR_HANDLERS');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select (SELECT USER_GROUP_ID from user_group where NAME = 'IMEDIA_CABLE_DISTRIBUTOR'), service_fee_group_id, 1 from service_fee_group where service_id = 108 and fee_group_id in (select fee_group_id from fee_group where name like 'BILLPAYMENT_NADRA_IMEDIA_CABLE_DISTRIBUTOR');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select (SELECT USER_GROUP_ID from user_group where NAME = 'IMEDIA_CABLE_DISTRIBUTOR_HANDLERS'), service_fee_group_id, 1 from service_fee_group where service_id = 108 and fee_group_id in (select fee_group_id from fee_group where name like 'BILLPAYMENT_NADRA_IMEDIA_CABLE_DISTRIBUTOR_HANDLERS');

insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select (SELECT USER_GROUP_ID from user_group where NAME = 'IMEDIA'), service_fee_group_id, 1 from service_fee_group where service_id = 109 and fee_group_id in (select fee_group_id from fee_group where name like 'BILLPAYMENT_NADRA_IMEDIA');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select (SELECT USER_GROUP_ID from user_group where NAME = 'IMEDIA_HANDLERS'), service_fee_group_id, 1 from service_fee_group where service_id = 109 and fee_group_id in (select fee_group_id from fee_group where name like 'BILLPAYMENT_NADRA_IMEDIA_HANDLERS');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select (SELECT USER_GROUP_ID from user_group where NAME = 'IMEDIA_CABLE_OPERATOR'), service_fee_group_id, 1 from service_fee_group where service_id = 109 and fee_group_id in (select fee_group_id from fee_group where name like 'BILLPAYMENT_NADRA_IMEDIA_CABLE_OPERATOR');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select (SELECT USER_GROUP_ID from user_group where NAME = 'IMEDIA_CABLE_OPERATOR_HANDLERS'), service_fee_group_id, 1 from service_fee_group where service_id = 109 and fee_group_id in (select fee_group_id from fee_group where name like 'BILLPAYMENT_NADRA_IMEDIA_CABLE_OPERATOR_HANDLERS');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select (SELECT USER_GROUP_ID from user_group where NAME = 'IMEDIA_CABLE_DISTRIBUTOR'), service_fee_group_id, 1 from service_fee_group where service_id = 109 and fee_group_id in (select fee_group_id from fee_group where name like 'BILLPAYMENT_NADRA_IMEDIA_CABLE_DISTRIBUTOR');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select (SELECT USER_GROUP_ID from user_group where NAME = 'IMEDIA_CABLE_DISTRIBUTOR_HANDLERS'), service_fee_group_id, 1 from service_fee_group where service_id = 109 and fee_group_id in (select fee_group_id from fee_group where name like 'BILLPAYMENT_NADRA_IMEDIA_CABLE_DISTRIBUTOR_HANDLERS');

insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select (SELECT USER_GROUP_ID from user_group where NAME = 'IMEDIA'), service_fee_group_id, 1 from service_fee_group where service_id = 110 and fee_group_id in (select fee_group_id from fee_group where name like 'BILLPAYMENT_NADRA_IMEDIA');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select (SELECT USER_GROUP_ID from user_group where NAME = 'IMEDIA_HANDLERS'), service_fee_group_id, 1 from service_fee_group where service_id = 110 and fee_group_id in (select fee_group_id from fee_group where name like 'BILLPAYMENT_NADRA_IMEDIA_HANDLERS');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select (SELECT USER_GROUP_ID from user_group where NAME = 'IMEDIA_CABLE_OPERATOR'), service_fee_group_id, 1 from service_fee_group where service_id = 110 and fee_group_id in (select fee_group_id from fee_group where name like 'BILLPAYMENT_NADRA_IMEDIA_CABLE_OPERATOR');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select (SELECT USER_GROUP_ID from user_group where NAME = 'IMEDIA_CABLE_OPERATOR_HANDLERS'), service_fee_group_id, 1 from service_fee_group where service_id = 110 and fee_group_id in (select fee_group_id from fee_group where name like 'BILLPAYMENT_NADRA_IMEDIA_CABLE_OPERATOR_HANDLERS');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select (SELECT USER_GROUP_ID from user_group where NAME = 'IMEDIA_CABLE_DISTRIBUTOR'), service_fee_group_id, 1 from service_fee_group where service_id = 110 and fee_group_id in (select fee_group_id from fee_group where name like 'BILLPAYMENT_NADRA_IMEDIA_CABLE_DISTRIBUTOR');
insert into user_group_service_fee_group (user_group_id, service_fee_group_id, ACTIVE_IND) select (SELECT USER_GROUP_ID from user_group where NAME = 'IMEDIA_CABLE_DISTRIBUTOR_HANDLERS'), service_fee_group_id, 1 from service_fee_group where service_id = 110 and fee_group_id in (select fee_group_id from fee_group where name like 'BILLPAYMENT_NADRA_IMEDIA_CABLE_DISTRIBUTOR_HANDLERS');


insert into fee (fee_group_id, fee_type_id, type, fee_name, fee, active_ind) select fee_group_id, 1, 'TX_COMMISSION', 'COMMISSION', 20, 1 from fee_group where name like 'BILLPAYMENT_NADRA_IMEDIA';
insert into fee (fee_group_id, fee_type_id, type, fee_name, fee, active_ind) select fee_group_id, 1, 'TX_SERVICE_CHARGE', 'SERVICE CHARGE', 0, 1 from fee_group where name like 'BILLPAYMENT_NADRA_IMEDIA';

insert into fee (fee_group_id, fee_type_id, type, fee_name, fee, active_ind) select fee_group_id, 1, 'TX_COMMISSION', 'COMMISSION', 5, 1 from fee_group where name like 'BILLPAYMENT_NADRA_IMEDIA_HANDLERS';
insert into fee (fee_group_id, fee_type_id, type, fee_name, fee, active_ind) select fee_group_id, 1, 'TX_SERVICE_CHARGE', 'SERVICE CHARGE', 0, 1 from fee_group where name like 'BILLPAYMENT_NADRA_IMEDIA_HANDLERS';

insert into fee (fee_group_id, fee_type_id, type, fee_name, fee, active_ind) select fee_group_id, 1, 'TX_COMMISSION', 'COMMISSION', 20, 1 from fee_group where name like 'BILLPAYMENT_NADRA_IMEDIA_CABLE_OPERATOR';
insert into fee (fee_group_id, fee_type_id, type, fee_name, fee, active_ind) select fee_group_id, 1, 'TX_SERVICE_CHARGE', 'SERVICE CHARGE', 0, 1 from fee_group where name like 'BILLPAYMENT_NADRA_IMEDIA_CABLE_OPERATOR';

insert into fee (fee_group_id, fee_type_id, type, fee_name, fee, active_ind) select fee_group_id, 1, 'TX_COMMISSION', 'COMMISSION', 5, 1 from fee_group where name like 'BILLPAYMENT_NADRA_IMEDIA_CABLE_OPERATOR_HANDLERS';
insert into fee (fee_group_id, fee_type_id, type, fee_name, fee, active_ind) select fee_group_id, 1, 'TX_SERVICE_CHARGE', 'SERVICE CHARGE', 0, 1 from fee_group where name like 'BILLPAYMENT_NADRA_IMEDIA_CABLE_OPERATOR_HANDLERS';

insert into fee (fee_group_id, fee_type_id, type, fee_name, fee, active_ind) select fee_group_id, 1, 'TX_COMMISSION', 'COMMISSION', 20, 1 from fee_group where name like 'BILLPAYMENT_NADRA_IMEDIA_CABLE_DISTRIBUTOR';
insert into fee (fee_group_id, fee_type_id, type, fee_name, fee, active_ind) select fee_group_id, 1, 'TX_SERVICE_CHARGE', 'SERVICE CHARGE', 0, 1 from fee_group where name like 'BILLPAYMENT_NADRA_IMEDIA_CABLE_DISTRIBUTOR';

insert into fee (fee_group_id, fee_type_id, type, fee_name, fee, active_ind) select fee_group_id, 1, 'TX_COMMISSION', 'COMMISSION', 5, 1 from fee_group where name like 'BILLPAYMENT_NADRA_IMEDIA_CABLE_DISTRIBUTOR_HANDLERS';
insert into fee (fee_group_id, fee_type_id, type, fee_name, fee, active_ind) select fee_group_id, 1, 'TX_SERVICE_CHARGE', 'SERVICE CHARGE', 0, 1 from fee_group where name like 'BILLPAYMENT_NADRA_IMEDIA_CABLE_DISTRIBUTOR_HANDLERS';