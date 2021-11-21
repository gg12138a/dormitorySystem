/*
SQLyog Trial v13.1.5  (64 bit)
MySQL - 8.0.27 : Database - demo
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`demo` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `demo`;

/*Table structure for table `adminuser` */

DROP TABLE IF EXISTS `adminuser`;

CREATE TABLE `adminuser` (
  `id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `adminuser` */

insert  into `adminuser`(`id`,`email`,`password`,`username`) values 
(1,'abc@qq.com','abc','xiaoming');

/*Table structure for table `apply` */

DROP TABLE IF EXISTS `apply`;

CREATE TABLE `apply` (
  `aid` int NOT NULL AUTO_INCREMENT,
  `uid` varchar(50) NOT NULL,
  `fromLoc` char(4) DEFAULT NULL,
  `toLoc` char(4) NOT NULL,
  `reviewed` tinyint DEFAULT '0' COMMENT '是否审核过',
  `passed` tinyint(1) DEFAULT '0' COMMENT '是否通过',
  `generateTime` datetime DEFAULT NULL,
  `reviewedTime` datetime DEFAULT NULL,
  PRIMARY KEY (`aid`),
  KEY `toLoc` (`toLoc`),
  CONSTRAINT `apply_ibfk_1` FOREIGN KEY (`toLoc`) REFERENCES `dormitory` (`location`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `apply` */

insert  into `apply`(`aid`,`uid`,`fromLoc`,`toLoc`,`reviewed`,`passed`,`generateTime`,`reviewedTime`) values 
(1,'1312','r516','r517',1,1,NULL,NULL),
(2,'1312','r517','r516',1,1,NULL,NULL),
(3,'1312','r516','r517',1,0,NULL,NULL),
(6,'1312','r518','r516',1,1,NULL,NULL),
(7,'1312','r516','r517',1,1,'2021-11-16 22:44:27',NULL),
(8,'1312','r518','r518',1,1,'2021-11-17 22:04:41',NULL),
(9,'1312','r518','r518',1,1,'2021-11-17 22:05:23',NULL),
(10,'1312','r518','r518',1,1,'2021-11-17 22:06:18',NULL),
(11,'1312','r518','r517',1,0,'2021-11-17 22:06:45',NULL),
(12,'1312','r518','r518',1,1,'2021-11-17 22:09:25',NULL),
(13,'1312','r518','r518',1,1,'2021-11-17 22:10:44',NULL),
(14,'1312','r518','r518',1,1,'2021-11-17 22:11:42',NULL),
(15,'1312','r518','r518',1,1,'2021-11-17 22:12:28',NULL),
(16,'1312','r518','r518',1,1,'2021-11-17 22:14:02',NULL),
(17,'1312','r518','r518',1,1,'2021-11-17 22:16:15',NULL),
(18,'1312','r517','r518',1,1,'2021-11-17 22:55:47',NULL),
(19,'1312','r517','r518',1,1,'2021-11-17 22:58:08',NULL),
(20,'1312','r517','r518',1,1,'2021-11-17 23:00:54','2021-11-17 23:22:33'),
(21,'1312','r517','r518',1,1,'2021-11-17 23:22:59','2021-11-17 23:29:55'),
(22,'1312','r517','r518',1,1,'2021-11-17 23:30:22','2021-11-17 23:30:33'),
(23,'1312','r517','r518',1,1,'2021-11-17 23:34:10','2021-11-17 23:34:28'),
(24,'1312','r517','r518',1,1,'2021-11-17 23:38:11','2021-11-17 23:38:28'),
(25,'1312','r518','r518',1,1,'2021-11-17 23:38:48','2021-11-17 23:51:14'),
(26,'1312','r518','r517',1,1,'2021-11-17 23:51:18','2021-11-17 23:51:27'),
(27,'1312','r517','r518',1,1,'2021-11-17 23:53:07','2021-11-17 23:53:11'),
(28,'1312','r518','r517',1,1,'2021-11-18 00:02:21','2021-11-18 00:02:27');

/*Table structure for table `dormitory` */

DROP TABLE IF EXISTS `dormitory`;

CREATE TABLE `dormitory` (
  `location` char(4) NOT NULL COMMENT '门牌号',
  `num` int NOT NULL DEFAULT '0' COMMENT '入住人数',
  `charge` decimal(10,4) NOT NULL DEFAULT '0.0000' COMMENT '剩余电费',
  PRIMARY KEY (`location`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `dormitory` */

insert  into `dormitory`(`location`,`num`,`charge`) values 
('r516',3,-31.1230),
('r517',4,3.0000),
('r518',0,0.0000);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` varchar(50) NOT NULL COMMENT '学号',
  `username` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `location` char(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `location` (`location`),
  CONSTRAINT `user_ibfk_1` FOREIGN KEY (`location`) REFERENCES `dormitory` (`location`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `user` */

insert  into `user`(`id`,`username`,`email`,`password`,`location`) values 
('12345','asd','sad','sa','r518'),
('13','fasf','a@q.com','a','r516'),
('1312','safa','abc@qq.com','abc','r517'),
('1312213','sfa','saf','wqeq','r517'),
('2','小明','sadas@qqweqw.com','fsa','r517'),
('23','grwq','b@b,com','b','r518'),
('4','小红','f@fa.com','fsaf','r517');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
