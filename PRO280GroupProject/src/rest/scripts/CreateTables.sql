delimiter $$
CREATE TABLE `app_properties_table` (
  `file_name` varchar(10) NOT NULL,
  `file_value` text NOT NULL,
  PRIMARY KEY (`file_name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1$$
delimiter $$
CREATE TABLE `cars` (
  `carId` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(45) NOT NULL,
  `high` int(11) NOT NULL,
  `middle` int(11) NOT NULL,
  `low` int(11) NOT NULL,
  PRIMARY KEY (`carId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1$$
delimiter $$
CREATE TABLE `groups` (
  `group_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) NOT NULL,
  PRIMARY KEY (`group_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1$$
delimiter $$
CREATE TABLE `mileage` (
  `mileageId` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(45) NOT NULL,
  `cost` int(11) NOT NULL,
  PRIMARY KEY (`mileageId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1$$
delimiter $$
CREATE TABLE `NuDegrees` (
  `Degree` varchar(10) NOT NULL,
  `quarters` int(11) DEFAULT NULL,
  PRIMARY KEY (`Degree`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1$$
delimiter $$
CREATE TABLE `Regions` (
  `regionName` varchar(18) NOT NULL,
  `rent` int(11) DEFAULT NULL,
  `mortgage` int(11) DEFAULT NULL,
  PRIMARY KEY (`regionName`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1$$
delimiter $$
CREATE TABLE `Salaries` (
  `degree` varchar(10) NOT NULL,
  `region` varchar(18) NOT NULL,
  `salary` int(11) NOT NULL,
  PRIMARY KEY (`degree`,`region`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1$$
delimiter $$
CREATE TABLE `selectGroup` (
  `groupId` smallint(6) NOT NULL DEFAULT '0',
  `description` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`groupId`),
  UNIQUE KEY `groupId` (`groupId`),
  UNIQUE KEY `description` (`description`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1$$
delimiter $$
CREATE TABLE `selectItem` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `itemName` varchar(40) NOT NULL,
  `groupId` smallint(6) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_selectGroupId` (`groupId`),
  CONSTRAINT `fk_selectGroupId` FOREIGN KEY (`groupId`) REFERENCES `selectGroup` (`groupId`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1$$
delimiter $$
CREATE TABLE `users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) NOT NULL,
  `password` varchar(64) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1$$
delimiter $$
CREATE TABLE `users_groups` (
  `user_id` int(11) NOT NULL,
  `group_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`group_id`),
  KEY `fk_users_groups_group_id` (`group_id`),
  CONSTRAINT `fk_users_groups_group_id` FOREIGN KEY (`group_id`) REFERENCES `groups` (`group_id`),
  CONSTRAINT `fk_users_groups_user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1$$
delimiter $$
-- Creates the view...
CREATE VIEW vlogin AS
    SELECT u.name AS username, u.password AS password, g.name AS groupname
    FROM users u JOIN users_groups ug ON u.user_id = ug.user_id
    JOIN groups g ON ug.group_id = g.group_id;
