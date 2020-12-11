CREATE TABLE `ref_request_status` (
`REQUEST_STATUS_ID` int(11) NOT NULL AUTO_INCREMENT,
`REQUEST_STATUS_VALUE` varchar(45) DEFAULT NULL,
`DESCRIPTION` varchar(45) DEFAULT NULL,
PRIMARY KEY (`REQUEST_STATUS_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

CREATE TABLE `ref_request_types` (
 `REQUEST_TYPE_ID` int(11) NOT NULL AUTO_INCREMENT,
 `VALUE` varchar(64) DEFAULT NULL COMMENT 'Defines the request types\n\nInbound\nOutbound\nInbound Ibft\nOutbound Ibft\n',
 `EFFECTIVE_DATE` date DEFAULT NULL,
 `END_DATE` date DEFAULT NULL,
 `ACTIVE_IND` tinyint(1) DEFAULT NULL,
 PRIMARY KEY (`REQUEST_TYPE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

CREATE TABLE `service` (
`SERVICE_ID` int(11) NOT NULL,
`SERVICE_NAME` varchar(20) DEFAULT NULL,
`PRICE` double(21,2) DEFAULT NULL,
`RETAIL_PRICE` double(21,2) DEFAULT NULL,
`SERVICE_TYPE_ID` int(11) DEFAULT NULL,
`SERVICE_PROVIDER_ID` int(11) DEFAULT NULL,
`ACTIVE` tinyint(1) DEFAULT NULL,
PRIMARY KEY (`SERVICE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `service_provider` (
`SERVICE_PROVIDER_ID` int(11) NOT NULL AUTO_INCREMENT,
`SERVICE_BROKER_ID` int(11) NOT NULL,
`SERVICE_PROVIDER_SHORT_NAME` varchar(20) DEFAULT NULL,
`SERVICE_PROVIDER_DISPLAY_NAME` varchar(80) DEFAULT NULL,
`SERVICE_PROVIDER_TYPE` varchar(45) DEFAULT NULL,
`CITY` varchar(45) DEFAULT NULL,
`SORT_ORDER` int(11) DEFAULT NULL,
`ACTIVE` tinyint(1) DEFAULT NULL,
PRIMARY KEY (`SERVICE_PROVIDER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=216 DEFAULT CHARSET=utf8;


CREATE TABLE `service_type` (
`id` int(11) DEFAULT NULL,
`value` varchar(255) DEFAULT NULL,
`description` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `buyticket_request` (
 `buyticket_request_id` int(11) NOT NULL AUTO_INCREMENT,
 `service_id` int(11) DEFAULT NULL,
 `number_of_seats` int(11) DEFAULT NULL,
 `time_id` int(11) DEFAULT NULL,
 `date` varchar(255) DEFAULT NULL,
 `booking_type` varchar(15) DEFAULT NULL,
 `name` varchar(255) DEFAULT NULL,
 `email` varchar(255) DEFAULT NULL,
 `phone` varchar(15) DEFAULT NULL,
 `cnic` varchar(15) DEFAULT NULL,
 `city` varchar(255) DEFAULT NULL,
 `address` varchar(255) DEFAULT NULL,
 `origin_city_id` int(11) DEFAULT NULL,
 `arrival_city_id` int(11) DEFAULT NULL,
 `deptime` varchar(15) DEFAULT NULL,
 `schedule_id` int(11) DEFAULT NULL,
 `ticket_price` varchar(255) DEFAULT NULL,
 `total_price` varchar(255) DEFAULT NULL,
 `route_id` int(11) DEFAULT NULL,
 `seat_numbers_male` varchar(255) DEFAULT NULL,
 `seat_numbers_female` varchar(255) DEFAULT NULL,
 `request_status_id` int(11) DEFAULT NULL,
 `zingpay_transaction_type_id` int(11) DEFAULT NULL,
 `transaction_reference` varchar(255) DEFAULT NULL,
 `provider_reference` varchar(255) DEFAULT NULL,
 `description` text,
 `create_datetime` datetime DEFAULT NULL,
 `modified_datetime` datetime DEFAULT NULL,
 `created_by` int(11) DEFAULT NULL,
 PRIMARY KEY (`buyticket_request_id`),
 KEY `request_status_id` (`request_status_id`),
 KEY `zingpay_transaction_type_id` (`zingpay_transaction_type_id`),
 CONSTRAINT `buyticket_request_ibfk_1` FOREIGN KEY (`request_status_id`) REFERENCES `transaction_status` (`id`),
 CONSTRAINT `buyticket_request_ibfk_2` FOREIGN KEY (`zingpay_transaction_type_id`) REFERENCES `zingpay_transaction_type` (`zingpay_transaction_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

CREATE TABLE `buyticket_request_state` (
`buyticket_request_state_id` int(11) NOT NULL AUTO_INCREMENT,
`buyticket_request_id` int(11) DEFAULT NULL,
`request_status_id` int(11) DEFAULT NULL,
`description` text,
`active_ind` int(1) DEFAULT '0',
`create_datetime` datetime DEFAULT NULL,
PRIMARY KEY (`buyticket_request_state_id`),
KEY `buyticket_request_id` (`buyticket_request_id`),
KEY `request_status_id` (`request_status_id`),
CONSTRAINT `buyticket_request_state_ibfk_1` FOREIGN KEY (`buyticket_request_id`) REFERENCES `buyticket_request` (`buyticket_request_id`),
CONSTRAINT `buyticket_request_state_ibfk_2` FOREIGN KEY (`request_status_id`) REFERENCES `ref_request_status` (`REQUEST_STATUS_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;