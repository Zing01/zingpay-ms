INSERT INTO organization(organization_name, description) values('IMEDIA', 'Distributer');

INSERT INTO user_group VALUES
(5, 'IMEDIA', null, null, null, 1), (6, 'IMEDIA_HANDLERS', null, null, null, 1),
(7, 'IMEDIA_CABLE_OPERATOR', null, null, null, 1), (8, 'IMEDIA_CABLE_OPERATOR_HANDLERS', null, null, null, 1),
(9, 'IMEDIA_CABLE_DISTRIBUTOR', null, null, null, 1), (10, 'IMEDIA_CABLE_DISTRIBUTOR_HANDLERS', null, null, null, 1);


 -- first insert into
INSERT INTO org_branch (ORGANIZATION_ID,BRANCH_NAME,DESCRIPTION,IS_DEFAULT,DEFAULT_RETAILER_GROUP_ID) VALUES
((SELECT ORGANIZATION_ID FROM organization WHERE ORGANIZATION_NAME ='IMEDIA') ,'IMEDIA HO','IMEDIA Distributer',1,null/*(SELECT USER_GROUP_ID FROM user_group WHERE NAME like '%IMEDIA%HANDLERS')*/);