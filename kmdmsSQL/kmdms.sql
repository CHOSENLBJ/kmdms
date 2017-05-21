/*
SQLyog Ultimate v8.32 
MySQL - 5.5.36 : Database - kmdms
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`kmdms` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `kmdms`;

/*Table structure for table `building` */

DROP TABLE IF EXISTS `building`;

CREATE TABLE `building` (
  `building_id` varchar(32) NOT NULL,
  `building_name` varchar(32) NOT NULL,
  `floorCount` int(11) NOT NULL,
  `dCount` int(11) NOT NULL,
  `totalDCount` int(11) NOT NULL,
  PRIMARY KEY (`building_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `building` */

/*Table structure for table `college` */

DROP TABLE IF EXISTS `college`;

CREATE TABLE `college` (
  `college_id` varchar(32) NOT NULL,
  `college_name` varchar(32) NOT NULL,
  PRIMARY KEY (`college_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `college` */

/*Table structure for table `department` */

DROP TABLE IF EXISTS `department`;

CREATE TABLE `department` (
  `department_id` varchar(32) NOT NULL,
  `department_name` varchar(32) NOT NULL,
  `college_id` varchar(32) NOT NULL,
  PRIMARY KEY (`department_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `department` */

/*Table structure for table `dormitory` */

DROP TABLE IF EXISTS `dormitory`;

CREATE TABLE `dormitory` (
  `dormitory_id` varchar(32) NOT NULL,
  `roomNum` varchar(16) NOT NULL,
  `bedCount` int(11) NOT NULL,
  `dormitory_sort` int(11) NOT NULL,
  `building_id` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`dormitory_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `dormitory` */

/*Table structure for table `label` */

DROP TABLE IF EXISTS `label`;

CREATE TABLE `label` (
  `label_id` varchar(32) NOT NULL,
  `content` varchar(64) NOT NULL,
  PRIMARY KEY (`label_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `label` */

/*Table structure for table `message` */

DROP TABLE IF EXISTS `message`;

CREATE TABLE `message` (
  `message_id` varchar(32) NOT NULL,
  `content` varchar(256) NOT NULL,
  `isRead` tinyint(1) DEFAULT NULL,
  `message_date` date DEFAULT NULL,
  `stu_id` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`message_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `message` */

/*Table structure for table `stu_lab` */

DROP TABLE IF EXISTS `stu_lab`;

CREATE TABLE `stu_lab` (
  `stu_id` varchar(32) NOT NULL,
  `label_id` varchar(32) NOT NULL,
  `weight` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `stu_lab` */

/*Table structure for table `student` */

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `stu_id` varchar(32) NOT NULL,
  `stu_name` varchar(16) NOT NULL,
  `password` varchar(16) NOT NULL,
  `stu_college` varchar(32) NOT NULL,
  `stu_department` varchar(32) NOT NULL,
  `stu_class` varchar(16) NOT NULL,
  `stu_sex` varchar(8) NOT NULL,
  `bedNum` int(11) DEFAULT NULL,
  `dormitory_id` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`stu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `student` */

insert  into `student`(`stu_id`,`stu_name`,`password`,`stu_college`,`stu_department`,`stu_class`,`stu_sex`,`bedNum`,`dormitory_id`) values ('sss','','','','','','',NULL,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
