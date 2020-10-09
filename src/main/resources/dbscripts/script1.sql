alter table app_user
	add house_type_id int null;

alter table app_user
	add deposit_type_id int null;

alter table app_user
	add bussiness_name varchar(255) null;

alter table app_user
	add mobile_location varchar(255) null;

alter table app_user
	add cnic_issue_date mediumtext null;

alter table app_user
	add cnic_front blob null;

alter table app_user
	add cnic_back blob null;

alter table app_user
	add other_attachment blob null;

