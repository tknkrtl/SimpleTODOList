- Projede veritabanı olarak mysql kullanılmıştır. 
- Aşağıdaki scriptle mysql de program için gerekli tabloları oluşturup çalıştırabilirsiniz.

---------------------------------------------------------------------------

DROP SCHEMA IF EXISTS `TODOList-one-to-one-uni`;

CREATE SCHEMA `TODOList-one-to-one-uni`;

use `TODOList-one-to-one-uni`;

SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `login`;

CREATE TABLE `login` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(128) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `tasks`;

CREATE TABLE `tasks` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  `deadline` varchar(45) DEFAULT NULL,
  `status` varchar(45) NOT NULL DEFAULT 'Not Completed',
  `create_date` DATE DEFAULT NULL,
  `username_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_DETAIL_idx` (`username_id`),
  CONSTRAINT `FK_DETAIL` FOREIGN KEY (`username_id`) REFERENCES `login` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

SET FOREIGN_KEY_CHECKS = 1;

---------------------------------------------------------------------------

