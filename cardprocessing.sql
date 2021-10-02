/*
SQLyog Community v13.1.6 (64 bit)
MySQL - 8.0.23 : Database - cardprocessing
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`cardprocessing` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `cardprocessing`;

/*Table structure for table `customer` */

DROP TABLE IF EXISTS `customer`;

CREATE TABLE `customer` (
  `id` int NOT NULL AUTO_INCREMENT,
  `customer_name` varchar(200) DEFAULT NULL,
  `address` varchar(250) DEFAULT NULL,
  `mobile` bigint DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `contact_person` varchar(100) DEFAULT NULL,
  `contact_mobile` bigint DEFAULT NULL,
  `active` tinyint DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_fd_key` (`user_id`),
  CONSTRAINT `user_fd_key` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=86 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `customer` */

insert  into `customer`(`id`,`customer_name`,`address`,`mobile`,`email`,`contact_person`,`contact_mobile`,`active`,`user_id`) values 
(82,'WbjGJToC0bRQBEdMAHvHHqaMNx3Er3UD','Ko2j/VDwWYFiNQm0Cd+qa5oiHTpzdq+ZPg+1yMj+gn8=',9617016789,'anandanandmca@gmail.com','jl/h3mPZem1eP/ZezNClXrOOajwxOxAf',9617016781,0,NULL),
(83,'6AptnpBA229GMsGK5egbB2ebfupwD93O','KsC//u0D89QdPt5X75H4rsXo6fZdj/kVVK32yAQApTs=',9617016782,'demo1@gmail.com','ZAzld9/NCbbx3oU3VsHxB1PdMO7obMjU',9617016781,1,NULL),
(84,'CNXmPKYNH0ZPBzr75Zio19qAZuKFifukjOBjCgPY3ZQ=','iVulinr+LuP6j6gf9ZS3sWDnArPmNdkLGH1J+EPjSkE=',9999999999,'tiwarijeedavidjee@gmail.com','xvTngj2aJbHMSygi2K0kCdlNomluXOG9',9617016781,1,NULL),
(85,'asJ6QDsCI7A/rTtE/bpkOkXdY63XH2No','ahyTCbWTs+tZMSxS4J7tHwYkh33eFU4s',9617016781,'demo@gmail.com','rYV4L3SLvNLxDA+E9vvj84oxU259vdh8',9617016781,1,78);

/*Table structure for table `customer_license` */

DROP TABLE IF EXISTS `customer_license`;

CREATE TABLE `customer_license` (
  `id` int NOT NULL AUTO_INCREMENT,
  `customer_id` int DEFAULT NULL,
  `customer_name` varchar(200) DEFAULT NULL,
  `days` int DEFAULT NULL,
  `start_date` varchar(30) DEFAULT NULL,
  `end_date` varchar(30) DEFAULT NULL,
  `host_ip` varchar(50) DEFAULT NULL,
  `active` tinyint DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `customer_id_fk` (`customer_id`),
  KEY `user_fd_fk` (`user_id`),
  CONSTRAINT `customer_id_fk` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`),
  CONSTRAINT `user_fd_fk` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=174 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `customer_license` */

insert  into `customer_license`(`id`,`customer_id`,`customer_name`,`days`,`start_date`,`end_date`,`host_ip`,`active`,`user_id`) values 
(171,82,'WbjGJToC0bRQBEdMAHvHHqaMNx3Er3UD',1,'2021-05-01','2021-05-08',NULL,1,27),
(172,83,'6AptnpBA229GMsGK5egbB2ebfupwD93O',1,'2021-05-01','2021-05-08',NULL,1,78),
(173,83,'6AptnpBA229GMsGK5egbB2ebfupwD93O',1,'2021-05-02','2021-05-02',NULL,1,81);

/*Table structure for table `customer_profile_join` */

DROP TABLE IF EXISTS `customer_profile_join`;

CREATE TABLE `customer_profile_join` (
  `id` int NOT NULL AUTO_INCREMENT,
  `customer_id` int DEFAULT NULL,
  `user_profile_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `customer_id` (`customer_id`),
  KEY `user_profile_id` (`user_profile_id`),
  CONSTRAINT `customer_id` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`),
  CONSTRAINT `user_profile_id` FOREIGN KEY (`user_profile_id`) REFERENCES `user_profile` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=109 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `customer_profile_join` */

insert  into `customer_profile_join`(`id`,`customer_id`,`user_profile_id`) values 
(103,82,118),
(105,83,118),
(107,84,118),
(108,85,120);

/*Table structure for table `license_type` */

DROP TABLE IF EXISTS `license_type`;

CREATE TABLE `license_type` (
  `id` int NOT NULL AUTO_INCREMENT,
  `days` int DEFAULT NULL,
  `date_wise` datetime DEFAULT NULL,
  `user_wise` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `license_type` */

/*Table structure for table `profile` */

DROP TABLE IF EXISTS `profile`;

CREATE TABLE `profile` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `desc` varchar(200) DEFAULT NULL,
  `active` tinyint DEFAULT NULL,
  `date` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `profile` */

insert  into `profile`(`id`,`name`,`desc`,`active`,`date`) values 
(1,'Scan','Card Scaning',1,'2021-03-26 22:58:27'),
(2,'OCR','Optical Character Recognition',1,'2021-03-26 22:59:44'),
(3,'Voice','Voice Recognition',1,'2021-03-26 22:59:48'),
(4,'All','All',1,'2021-04-06 15:59:06');

/*Table structure for table `user_profile` */

DROP TABLE IF EXISTS `user_profile`;

CREATE TABLE `user_profile` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(200) DEFAULT NULL,
  `date` timestamp NULL DEFAULT NULL,
  `isVoice` tinyint DEFAULT NULL,
  `isOCR` tinyint DEFAULT NULL,
  `isALL` tinyint DEFAULT NULL,
  `isScan` tinyint DEFAULT NULL,
  `active` tinyint DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=121 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `user_profile` */

insert  into `user_profile`(`id`,`name`,`date`,`isVoice`,`isOCR`,`isALL`,`isScan`,`active`) values 
(118,'/aVZq5Hb1vZ7zsFpATpxniJSbxEo8kcb',NULL,1,1,NULL,1,0),
(119,'PonXRUQd7gRhF4HEA87ZEw==',NULL,NULL,1,NULL,1,1),
(120,'fZj26Of0Aqhiih5U1kK6h2KuWofWZMWs',NULL,1,1,NULL,1,1);

/*Table structure for table `user_roles` */

DROP TABLE IF EXISTS `user_roles`;

CREATE TABLE `user_roles` (
  `user_role_id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `role` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`user_role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `user_roles` */

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(250) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `password` varchar(250) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `mobile` decimal(10,0) DEFAULT NULL,
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `user_type` int DEFAULT NULL,
  `active` tinyint DEFAULT NULL,
  `license_password` varchar(250) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=82 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `users` */

insert  into `users`(`id`,`username`,`password`,`mobile`,`name`,`user_type`,`active`,`license_password`) values 
(27,'admin@gmail.com','$2a$10$.avu0nFi8FkhOISFlls7TeFrnoiRsWxRF/0YuYa45uViQ/CwjhwZ.',999999999,NULL,1,1,'$2a$10$.avu0nFi8FkhOISFlls7TeFrnoiRsWxRF/0YuYa45uViQ/CwjhwZ.'),
(72,'atiwari31dec@gmail.com','$2a$10$4XXkY8Qt4S2ejL.sA60jPOrh1AV5Q16YMcbBf/XBMyjLd2A4Hh4rG',9617016781,NULL,0,1,'15Rew6z62Y6Zbd1ZVawiBg=='),
(78,'anandanandmca@gmail.com','$2a$10$0K1VMJwD15BWc93akI2OTOZYC3Kp7dvpmw2.8fWRjHwnnFr2gTqfq',9617016788,NULL,2,1,'tqChJjcjtarQuUVpQPv2RejdZdreBIqO'),
(79,'anandanandmca1@gmail.com','$2a$10$A9MCgXyniK8.io6FfwkP4OShUTfwxQg04oJxKz0KYjT3k32dxBtdy',9617016788,NULL,2,1,'+AnZKbKDTCQp9wle47A/Ng=='),
(81,'tiwarijeedavidjee@gmail.com','$2a$10$14ynpwqbzC68Vt2.Q3JnHOh1f0icCgz0lv.H6UXz55JCufL4KSnxG',9617016788,NULL,2,1,'S1+UHvO3nTHY4MBqlQ7+nA==');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
