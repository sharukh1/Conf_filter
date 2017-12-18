-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.5.25a - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL Version:             9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for bankproject
CREATE DATABASE IF NOT EXISTS `bankproject` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `bankproject`;

-- Dumping structure for table bankproject.account
CREATE TABLE IF NOT EXISTS `account` (
  `emailid` varchar(50) NOT NULL,
  `balance` int(11) NOT NULL DEFAULT '0',
  `status` int(11) DEFAULT '0',
  UNIQUE KEY `emailid` (`emailid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table bankproject.account: ~7 rows (approximately)
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` (`emailid`, `balance`, `status`) VALUES
	('aby@sbi', 2000, 0),
	('akhil@new', 0, 10),
	('ee', 0, 1),
	('kai', 0, 0),
	('sdfds', 0, 0),
	('sharukh@sbi', 2000, 5),
	('zora@sbi', 4000, 8);
/*!40000 ALTER TABLE `account` ENABLE KEYS */;

-- Dumping structure for table bankproject.bankdb
CREATE TABLE IF NOT EXISTS `bankdb` (
  `idbank` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL DEFAULT '0',
  `key` varchar(50) NOT NULL DEFAULT '0',
  `status` int(11) DEFAULT '0',
  PRIMARY KEY (`idbank`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- Dumping data for table bankproject.bankdb: ~7 rows (approximately)
/*!40000 ALTER TABLE `bankdb` DISABLE KEYS */;
INSERT INTO `bankdb` (`idbank`, `name`, `key`, `status`) VALUES
	(1, 'jb', 'gv', 1),
	(2, 'aby', 'aby', 0),
	(5, 'sbi', 'sbi', 1),
	(6, 'sbt', 'sbt', 1),
	(7, 'hd', 'hd', 0),
	(8, 'icici', 'icici', 1),
	(10, 'muthoot', 'muthoot', 1);
/*!40000 ALTER TABLE `bankdb` ENABLE KEYS */;

-- Dumping structure for table bankproject.jointable
CREATE TABLE IF NOT EXISTS `jointable` (
  `bankname` varchar(50) DEFAULT NULL,
  `emailid` varchar(50) DEFAULT NULL,
  `idbank` int(11) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table bankproject.jointable: ~8 rows (approximately)
/*!40000 ALTER TABLE `jointable` DISABLE KEYS */;
INSERT INTO `jointable` (`bankname`, `emailid`, `idbank`) VALUES
	('aby', 'ee', NULL),
	('aby', 'ee', NULL),
	('sbt', 'ee', NULL),
	('sbi', 'sharukh@sbi', 5),
	('icici', 'zora@sbi', 8),
	('muthoot', 'akhil@new', 10),
	('sbi', 'sharukh@sbi', 0),
	('muthoot', 'sharukh@sbi', 0);
/*!40000 ALTER TABLE `jointable` ENABLE KEYS */;

-- Dumping structure for table bankproject.login
CREATE TABLE IF NOT EXISTS `login` (
  `idlogin` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idlogin`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- Dumping data for table bankproject.login: ~8 rows (approximately)
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` (`idlogin`, `username`, `password`) VALUES
	(8, 'zorausername', 'password'),
	(12, 'sharukhusername', 'password'),
	(13, 'q', 'q'),
	(14, 'aby', '1234'),
	(15, 'kai', ''),
	(16, 'ee', 'ee'),
	(17, 'akhil', '1234'),
	(18, 'sfsf', 'sfsf');
/*!40000 ALTER TABLE `login` ENABLE KEYS */;

-- Dumping structure for table bankproject.registration
CREATE TABLE IF NOT EXISTS `registration` (
  `emailid` varchar(50) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`emailid`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table bankproject.registration: ~6 rows (approximately)
/*!40000 ALTER TABLE `registration` DISABLE KEYS */;
INSERT INTO `registration` (`emailid`, `name`, `address`, `username`, `password`) VALUES
	('aby@sbi', 'aby', 'idduki', 'aby', '1234'),
	('akhil@new', 'akhil', '88/795', 'akhil', '1234'),
	('ee', 'ee', 'ee', 'ee', 'ee'),
	('sdfds', 'sdfsf', 'sfsf', 'sfsf', 'sfsf'),
	('sharukh@sbi', 'sharukh', '88/77', 'sharukhusername', 'password'),
	('zora@sbi', 'zora', '456/A v', 'zorausername', 'password');
/*!40000 ALTER TABLE `registration` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
