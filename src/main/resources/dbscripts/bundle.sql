CREATE TABLE bundle
(
	id int not null,
	network varchar(255) not null,
	name varchar(255) null,
	description varchar(255) null,
	offer_key1 varchar(20) null,
	offer_key2 varchar(20) null,
	resources varchar(255) null,
	price varchar(20) null,
	validity varchar(20) null,
	type varchar(255) null,
	constraint bundle_pk
		primary key (id)
);

INSERT INTO bundle VALUES
(51, 'ZONG', 'Internet SIM 8GB (Inc. 4GB - 4AM to 4PM)', 'Bundle includes 4 GB is usable from 4AM to 4PM', '91027117', '', '[{"resourceType":"GBs","resourceValue":"4"}]', '750', '30 Days', 'Data'),
(52, 'ZONG', 'Internet SIM 24GB (Inc. 12GB - 4AM to 4PM)', 'Bundle includes 12 GB is usable from 4AM to 4PM', '91027118', '', '[{"resourceType":"GBs","resourceValue":"24"}]', '1200', '30 Days', 'Data'),
(53, 'ZONG', 'Internet SIM - 30GB', '', '91029907', '', '[{"resourceType":"MBs","resourceValue":"30000"}]', '1500', '30 Days', 'Data'),
(54, 'ZONG', 'Prepaid MBB Monthly 60GB', '', '91026124', '91026200', '[{"resourceType":"GBs","resourceValue":"60"}]', '2000', '30 Days', 'Data'),
(55, 'ZONG', 'Prepaid MBB Monthly 200 GB (Inc. 100 GB - 4AM to 4PM)', 'Bundle includes 100 GB is usable from 4AM to 4PM', '91026125', '91026201', '[{"resourceType":"GBs","resourceValue":"200"}]', '3250', '30 Days', 'Data'),
(56, 'ZONG', 'Prepaid MBB 6 Months Bundle 100GB/Month', 'Bundle includes 25 GB is usable from 4AM to 4PM', '91020166', '', '[{"resourceType":"GBs","resourceValue":"100"}]', '12000', '180 Days', 'Data'),
(57, 'ZONG', 'Super Weekly Offer', '', '91000121', '', '[{"resourceType":"GBs","resourceValue":"2.5"}]', '165', '7 Days', 'Data'),
(58, 'ZONG', 'Super Weekly Plus', '', '91029911', '', '[{"resourceType":"GBs","resourceValue":"7"}]', '240', '7 Days', 'Data'),
(59, 'ZONG', 'Super Weekly Max', 'Bundle includes 5 GB is usable from 4AM to 4PM, 15 GB for Youtube', '95000646', '', '[{"resourceType":"GBs","resourceValue":"15"},{"resourceType":"Social GBs","resourceValue":"15"}]', '299', '7 Days', 'Data'),
(60, 'ZONG', 'Monthly Premium 15GB', '15 GB data is usable for YouTube & TikTok  only', '91020067', '', '[{"resourceType":"GBs","resourceValue":"15"},{"resourceType":"Social GBs","resourceValue":"15"}]', '1000', '30 Days', 'Data'),
(61, 'ZONG', 'Whatsapp Offer', 'Data is for WhatsApp only', '91020404', '', '[{"resourceType":"GBs","resourceValue":"4"}]', '50', '30 Days', 'Data'),
(62, 'ZONG', 'IMO Offer', 'Data is for IMO only', '91029937', '', '[{"resourceType":"GBs","resourceValue":"2"}]', '50', '30 Days', 'Data'),
(63, 'ZONG', 'All-In-One Monthly/ ZONG Super Card', 'Bundle also contains 2 GB for WhatsApp & 1 GB for YouTube', '91000182', '', '[{"resourceType":"GBs","resourceValue":"2.5"},{"resourceType":"On Net","resourceValue":"2500"},{"resourceType":"Off Net","resourceValue":"150"},{"resourceType":"SMS","resourceValue":"2500"},{"resourceType":"Social GBs","resourceValue":"3"}]', '650', '30 Days', 'Monthly Hybrid'),
(64, 'ZONG', 'Supreme Offer', 'Bundle also contains 4 GB for WhatsApp & 2 GB for YouTube', '91023604', '', '[{"resourceType":"GBs","resourceValue":"5"},{"resourceType":"On Net","resourceValue":"5000"},{"resourceType":"Off Net","resourceValue":"300"},{"resourceType":"SMS","resourceValue":"5000"},{"resourceType":"Social GBs","resourceValue":"6"}]', '1000', '30 Days', 'Monthly Hybrid'),
(65, 'ZONG', 'Supreme Plus Offer', 'Bundle also contains 4 GB for WhatsApp', '91000180', '', '[{"resourceType":"GBs","resourceValue":"10"},{"resourceType":"On Net","resourceValue":"10000"},{"resourceType":"Off Net","resourceValue":"600"},{"resourceType":"SMS","resourceValue":"10000"},{"resourceType":"Social GBs","resourceValue":"4"}]', '1732', '30 Days', 'Monthly Hybrid'),
(66, 'ZONG', 'Weekly Hybrid Bundle', '', '91020181', '', '[{"resourceType":"GBs","resourceValue":"1"},{"resourceType":"On Net","resourceValue":"1000"},{"resourceType":"Off Net","resourceValue":"40"},{"resourceType":"SMS","resourceValue":"1000"}]', '200', '7 Days', 'Weekly Hybrid'),
(67, 'ZONG', 'Weekly SMS', '', '91056273', '', '[{"resourceType":"SMS","resourceValue":"1500"}]', '29', '7 Days', 'SMS'),
(68, 'ZONG', 'Monthly SMS', '', '91056272', '', '[{"resourceType":"SMS","resourceValue":"500"}]', '68', '30 Days', 'SMS'),
(69, 'ZONG', 'Ilaqai Offer/Punjab', '', '91029939', '', '[{"resourceType":"GBs","resourceValue":"6"},{"resourceType":"All Network Minutes","resourceValue":"150"}]', '230', '7 Days', 'Weekly Hybrid'),
(70, 'ZONG', 'Monthly Facebook', 'Data is for Facebook only', '91900004', '', '[{"resourceType":"GBs","resourceValue":"6"}]', '100', '30 Days', 'Data'),
(71, 'ZONG', 'Weekly Youtube', 'Data is for YouTube only', '95000562', '', '[{"resourceType":"GBs","resourceValue":"8"}]', '135', '7 Days', 'Data'),
(72, 'ZONG', 'KSA Offer', 'International Roaming Bundle', '95000474', '', '[{"resourceType":"MBs","resourceValue":"512"},{"resourceType":"SMS","resourceValue":"60"},{"resourceType":"Minutes","resourceValue":"60"}]', '2689', '90 Days', 'IR Bundle'),
(73, 'ZONG', 'Weekly TIKTok Offer', 'Bundle includes 1.5 GB is usable for TikTok only', '95000882', '', '[{"resourceType":"MBs","resourceValue":"500"},{"resourceType":"Social MBs","resourceValue":"1500"}]', '50', '7 Days', 'Data'),
(74, 'ZONG', 'Haftawar Load Offer', '', '91024007', '', '[{"resourceType":"GBs","resourceValue":"5"},{"resourceType":"On Net","resourceValue":"5000"},{"resourceType":"SMS","resourceValue":"5000"},{"resourceType":"Off Net","resourceValue":"80"}]', '250', '7 Days', 'Weekly Hybrid'),
(75, 'ZONG', 'Mega Data Offer', 'Data can only be used between 1AM to 9AM', '95001185', '', '[{"resourceType":"GBs","resourceValue":"50"}]', '100', '7 Days', 'Data'),
(76, 'ZONG', 'Super Weekly Premium', 'Bundle includes 15 GB is usable YouTube & TikTok only', '95000966', '95001084', '[{"resourceType":"GBs","resourceValue":"15"},{"resourceType":"Social GBs","resourceValue":"15"},{"resourceType":"All Network Minutes","resourceValue":"100"}]', '330', '7 Days', 'Weekly Hybrid');

INSERT INTO bundle VALUES
(151, 'TELENOR', '3G Monthly Starter-ADC', 'Bundle includes 4 GB is usable from 1AM to 7AM', '501937', '', '[{"resourceType":"GBs","resourceValue":"8"}]', '400', '30 Days', 'Data'),
(152, 'TELENOR', 'Easycard 150 - replica for alternate channel', '', '501807', '', '[{"resourceType":"MBs","resourceValue":"1500"},{"resourceType":"On Net","resourceValue":"1000"},{"resourceType":"Off Net","resourceValue":"50"},{"resourceType":"SMS","resourceValue":"1000"}]', '150', '7 Days', 'Weekly Hybrid'),
(153, 'TELENOR', '4G Weekly Ultra- alternate channels', 'Bundle includes 1 GB is usable for Goonj & GameBox only', '501925', '', '[{"resourceType":"GBs","resourceValue":"8"},{"resourceType":"Social GBs","resourceValue":"1"}]', '210', '7 Days', 'Data'),
(154, 'TELENOR', 'Easy Card 450 AC', 'Bundle includes 2 GB is usable for WhatsApp only', '501773', '', '[{"resourceType":"GBs","resourceValue":"1"},{"resourceType":"Social GBs","resourceValue":"2"},{"resourceType":"SMS","resourceValue":"500"},{"resourceType":"Off Net","resourceValue":"50"},{"resourceType":"On Net+PTCL","resourceValue":"500"}]', '450', '30 Days', 'Monthly Hybrid'),
(155, 'TELENOR', 'Easy Card 800 AC', 'Bundle includes 9 GB is usable from 1AM to 11AM', '501946', '', '[{"resourceType":"GBs","resourceValue":"18"},{"resourceType":"SMS","resourceValue":"5000"},{"resourceType":"Off Net","resourceValue":"300"},{"resourceType":"On Net+PTCL","resourceValue":"5000"}]', '800', '30 Days', 'Monthly Hybrid'),
(156, 'TELENOR', 'Easy Card 600 Replica', 'Bundle includes 6 GB is usable from 1AM to 11AM', '502237', '', '[{"resourceType":"GBs","resourceValue":"12"},{"resourceType":"SMS","resourceValue":"3000"},{"resourceType":"Off Net","resourceValue":"150"},{"resourceType":"On Net+PTCL","resourceValue":"3000"},{"resourceType":"IDD Minutes","resourceValue":"25"}]', '600', '30 Days', 'Monthly Hybrid'),
(157, 'TELENOR', 'Monthly Ultra', 'Bundle includes 10 GB is usable from 12AM to 8AM', '502240', '', '[{"resourceType":"GBs","resourceValue":"20"}]', '599', '30 Days', 'Data'),
(158, 'TELENOR', 'CPO Offer', '', '502110', '', '[{"resourceType":"Social MBs","resourceValue":"350"},{"resourceType":"MBs","resourceValue":"70"},{"resourceType":"On Net","resourceValue":"Unlimited"}]', '140', '7 Days', 'Weekly Hybrid'),
(159, 'TELENOR', 'Sahulat Offer', '', '502092', '', '[{"resourceType":"Social MBs","resourceValue":"350"},{"resourceType":"MBs","resourceValue":"100"},{"resourceType":"On Net","resourceValue":"1000"},{"resourceType":"Off Net","resourceValue":"70"},{"resourceType":"SMS","resourceValue":"700"}]', '170', '7 Days', 'Weekly Hybrid'),
(160, 'TELENOR', 'Weekly Easy Card Mega', 'Bundle includes 5 GB is usable from 1AM to 11AM', '502099', '', '[{"resourceType":"GBs","resourceValue":"10"},{"resourceType":"On Net+PTCL","resourceValue":"2000"},{"resourceType":"Off Net","resourceValue":"70"},{"resourceType":"SMS","resourceValue":"2000"}]', '250', '7 Days', 'Weekly Hybrid'),
(161, 'TELENOR', 'Monthly Whatsapp & FB Offer', 'Data is for WhatsApp & facebook only', '502121', '', '[{"resourceType":"GBs","resourceValue":"3"}]', '50', '30 Days', 'Data'),
(162, 'TELENOR', 'Ticky Pack Offer', '', '500947', '', '[{"resourceType":"On Net","resourceValue":"50"}]', '11', '1 Days', 'Call'),
(163, 'TELENOR', 'Youtube Offer', 'Data is for YouTube only', '502146', '', '[{"resourceType":"Social MBs","resourceValue":"500"}]', '10', '1 Days', 'Data'),
(164, 'TELENOR', '4G Weekly Super', 'Bundle includes 2 GB is usable from 1AM to 11AM', '501721', '', '[{"resourceType":"SMS","resourceValue":"4000"}]', '130', '7 Days', 'Data'),
(165, 'TELENOR', '4 G Weekly Late Night Offer', 'Offer can only be used between 12AM to 9AM', '502134', '', '[{"resourceType":"GBs","resourceValue":"20"}]', '60', '7 Days', 'Data'),
(166, 'TELENOR', 'Easy Card - 200', 'Onnet minutes includes PTCL minutes also', '502174', '', '[{"resourceType":"GBs","resourceValue":"3"},{"resourceType":"On Net+PTCL","resourceValue":"1500"},{"resourceType":"Off Net","resourceValue":"60"},{"resourceType":"SMS","resourceValue":"1500"}]', '199', '7 Days', 'Weekly Hybrid');

INSERT INTO bundle VALUES
(200, 'CARDWALLA', 'Facebook [US]', 'Test Facebook $10', 'TESTFACEBOOK10', 'FB001', 'USD', '10', '', 'Facebook'),
(201, 'CARDWALLA', 'Amazon [US]', 'Test Amazon [USA Store] $15', 'TESTAMAZON15', 'AMZ001', 'USD', '15', '',	'Amazon'),
(202, 'CARDWALLA', 'iTunes [US]', 'Test iTunes $10', 'TESTITUNES10', 'ITU001', 'USD', '10', '',	'iTunes'),
(203, 'CARDWALLA', 'Netflix [US]', 'Test Netflix $15', 'TESTNETFLIX15', 'NF001', 'USD', '15', '', 'Netflix'),
(204, 'CARDWALLA', 'Google Play [US]', 'Test Google [US] $50', 'TESTGOOGLE50', 'GP001', 'USD', '50', '', 'Google'),
(205, 'CARDWALLA', 'Amazon [US]', 'Test Amazon [USA Store] $25', 'TESTPRODUCT01', 'AMZ001', 'USD', '25', '', 'Amazon'),
(206, 'CARDWALLA', 'Google Play [US]', 'Test Google [US] $5', 'TESTPRODUCT02', 'GP001', 'USD', '5', '',	'Google'),
(207, 'CARDWALLA', 'PlayStation [US]', 'Test PlayStation $20', 'TESTPRODUCT03', 'PSN001', 'USD', '20', '', 'PlayStation');