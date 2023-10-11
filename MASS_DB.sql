-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.6.5-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for massupdated
DROP DATABASE IF EXISTS `massupdated`;
CREATE DATABASE IF NOT EXISTS `massupdated` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `massupdated`;

-- Dumping structure for table massupdated.ma_admin
DROP TABLE IF EXISTS `ma_admin`;
CREATE TABLE IF NOT EXISTS `ma_admin` (
  `first_name` varchar(50) NOT NULL,
  `middle_name` varchar(50) DEFAULT NULL,
  `last_name` varchar(50) NOT NULL,
  `email` varchar(320) NOT NULL,
  `username` varchar(11) NOT NULL,
  `password` varchar(50) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table massupdated.ma_admin: ~2 rows (approximately)
DELETE FROM `ma_admin`;
/*!40000 ALTER TABLE `ma_admin` DISABLE KEYS */;
INSERT INTO `ma_admin` (`first_name`, `middle_name`, `last_name`, `email`, `username`, `password`) VALUES
	('Adam', 'A', 'Admin', 'admin@gmail.com', '1', 'admin');
/*!40000 ALTER TABLE `ma_admin` ENABLE KEYS */;

-- Dumping structure for table massupdated.ma_announcement
DROP TABLE IF EXISTS `ma_announcement`;
CREATE TABLE IF NOT EXISTS `ma_announcement` (
  `announcement_id` int(11) NOT NULL AUTO_INCREMENT,
  `cohort_id` int(11) NOT NULL DEFAULT 0,
  `start_time` date NOT NULL,
  `end_time` date NOT NULL,
  `text` varchar(1000) NOT NULL,
  `is_visible` enum('Y','N') NOT NULL DEFAULT 'Y',
  PRIMARY KEY (`announcement_id`),
  KEY `FK_ma_announcement_ma_cohort` (`cohort_id`),
  CONSTRAINT `FK_ma_announcement_ma_cohort` FOREIGN KEY (`cohort_id`) REFERENCES `ma_cohort` (`cohort_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=latin1;

-- Dumping data for table massupdated.ma_announcement: ~16 rows (approximately)
DELETE FROM `ma_announcement`;
/*!40000 ALTER TABLE `ma_announcement` DISABLE KEYS */;
INSERT INTO `ma_announcement` (`announcement_id`, `cohort_id`, `start_time`, `end_time`, `text`, `is_visible`) VALUES
	(37, 9, '2022-04-12', '2022-04-12', 'Welcome to Winter 2022 students!', 'Y');
/*!40000 ALTER TABLE `ma_announcement` ENABLE KEYS */;

-- Dumping structure for table massupdated.ma_assignment
DROP TABLE IF EXISTS `ma_assignment`;
CREATE TABLE IF NOT EXISTS `ma_assignment` (
  `assignment_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `description` varchar(1000) DEFAULT NULL,
  `url` text DEFAULT NULL,
  `weight` double NOT NULL,
  PRIMARY KEY (`assignment_id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=latin1;

-- Dumping data for table massupdated.ma_assignment: ~7 rows (approximately)
DELETE FROM `ma_assignment`;
/*!40000 ALTER TABLE `ma_assignment` DISABLE KEYS */;
INSERT INTO `ma_assignment` (`assignment_id`, `name`, `description`, `url`, `weight`) VALUES
	(19, 'Readings, Mod 1', 'Please read chapter one of the health and safety manual. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc viverra neque ut cursus ullamcorper. Nullam sit amet tempor magna. Nulla lacinia neque at lectus varius, ac laoreet diam pulvinar. Cras eu massa orci. Morbi a ipsum non felis volutpat faucibus. Aenean sed rhoncus orci. Nunc non purus vel magna accumsan sollicitudin. Ut posuere nisl sit amet ex condimentum, feugiat sagittis mi rhoncus. Quisque vitae leo volutpat, fringilla urna vel, tempus purus. Phasellus molestie orci sit amet pulvinar consequat. Maecenas venenatis, augue sed posuere lobortis, nisi nibh elementum tellus, sagittis consequat lacus quam hendrerit libero. Sed eget magna quis tellus molestie molestie malesuada a arcu. Aliquam elementum, metus et pellentesque lobortis, ipsum orci aliquam leo, in lobortis nisi est sed quam. Integer eu ligula ut ligula semper hendrerit in vel eros. Quisque bibendum lacinia libero ac pharetra.', '', 1),
	(20, 'CPR Practice', 'Practice CPR on three of your friends and report back to your teacher what happens. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc viverra neque ut cursus ullamcorper. Nullam sit amet tempor magna. Nulla lacinia neque at lectus varius, ac laoreet diam pulvinar. Cras eu massa orci. Morbi a ipsum non felis volutpat faucibus. Aenean sed rhoncus orci. Nunc non purus vel magna accumsan sollicitudin. Ut posuere nisl sit amet ex condimentum, feugiat sagittis mi rhoncus. Quisque vitae leo volutpat, fringilla urna vel, tempus purus. Phasellus molestie orci sit amet pulvinar consequat. Maecenas venenatis, augue sed posuere lobortis, nisi nibh elementum tellus, sagittis consequat lacus quam hendrerit libero. Sed eget magna quis tellus molestie molestie malesuada a arcu. Aliquam elementum, metus et pellentesque lobortis, ipsum orci aliquam leo, in lobortis nisi est sed quam. Integer eu ligula ut ligula semper hendrerit in vel eros. Quisque bibendum lacinia libero ac pharetra.', '', 1);
/*!40000 ALTER TABLE `ma_assignment` ENABLE KEYS */;

-- Dumping structure for table massupdated.ma_attendance
DROP TABLE IF EXISTS `ma_attendance`;
CREATE TABLE IF NOT EXISTS `ma_attendance` (
  `attendance_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(11) NOT NULL,
  `present` enum('Y','N') NOT NULL DEFAULT 'Y',
  `date` date NOT NULL,
  PRIMARY KEY (`attendance_id`),
  KEY `FK_ma_attendance_ma_student` (`username`),
  CONSTRAINT `FK_ma_attendance_ma_student` FOREIGN KEY (`username`) REFERENCES `ma_student` (`username`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=89 DEFAULT CHARSET=latin1;

-- Dumping data for table massupdated.ma_attendance: ~16 rows (approximately)
DELETE FROM `ma_attendance`;
/*!40000 ALTER TABLE `ma_attendance` DISABLE KEYS */;
INSERT INTO `ma_attendance` (`attendance_id`, `username`, `present`, `date`) VALUES
	(88, 'cmc21-00001', 'Y', '2022-04-14');
/*!40000 ALTER TABLE `ma_attendance` ENABLE KEYS */;

-- Dumping structure for table massupdated.ma_cohort
DROP TABLE IF EXISTS `ma_cohort`;
CREATE TABLE IF NOT EXISTS `ma_cohort` (
  `cohort_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`cohort_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

-- Dumping data for table massupdated.ma_cohort: ~4 rows (approximately)
DELETE FROM `ma_cohort`;
/*!40000 ALTER TABLE `ma_cohort` DISABLE KEYS */;
INSERT INTO `ma_cohort` (`cohort_id`, `name`) VALUES
	(9, 'Winter 2022'),
	(10, 'Spring 2022'),
	(11, 'Summer 2022');
/*!40000 ALTER TABLE `ma_cohort` ENABLE KEYS */;

-- Dumping structure for table massupdated.ma_cohort_course
DROP TABLE IF EXISTS `ma_cohort_course`;
CREATE TABLE IF NOT EXISTS `ma_cohort_course` (
  `cohort_id` int(11) NOT NULL DEFAULT 0,
  `course_id` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`cohort_id`,`course_id`),
  KEY `FK_ma_cohort_course_ma_course` (`course_id`),
  CONSTRAINT `FK_ma_cohort_course_ma_cohort` FOREIGN KEY (`cohort_id`) REFERENCES `ma_cohort` (`cohort_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_ma_cohort_course_ma_course` FOREIGN KEY (`course_id`) REFERENCES `ma_course` (`course_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table massupdated.ma_cohort_course: ~12 rows (approximately)
DELETE FROM `ma_cohort_course`;
/*!40000 ALTER TABLE `ma_cohort_course` DISABLE KEYS */;
INSERT INTO `ma_cohort_course` (`cohort_id`, `course_id`) VALUES
	(9, 13),
	(9, 15),
	(9, 16);
/*!40000 ALTER TABLE `ma_cohort_course` ENABLE KEYS */;

-- Dumping structure for table massupdated.ma_cohort_faculty
DROP TABLE IF EXISTS `ma_cohort_faculty`;
CREATE TABLE IF NOT EXISTS `ma_cohort_faculty` (
  `cohort_id` int(11) NOT NULL DEFAULT 0,
  `username` varchar(10) NOT NULL,
  PRIMARY KEY (`cohort_id`,`username`),
  KEY `FK_ma_cohort_faculty_ma_faculty` (`username`),
  CONSTRAINT `FK_ma_cohort_faculty_ma_cohort` FOREIGN KEY (`cohort_id`) REFERENCES `ma_cohort` (`cohort_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_ma_cohort_faculty_ma_faculty` FOREIGN KEY (`username`) REFERENCES `ma_faculty` (`username`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table massupdated.ma_cohort_faculty: ~4 rows (approximately)
DELETE FROM `ma_cohort_faculty`;
/*!40000 ALTER TABLE `ma_cohort_faculty` DISABLE KEYS */;
INSERT INTO `ma_cohort_faculty` (`cohort_id`, `username`) VALUES
	(9, 'faculty');
/*!40000 ALTER TABLE `ma_cohort_faculty` ENABLE KEYS */;

-- Dumping structure for table massupdated.ma_course
DROP TABLE IF EXISTS `ma_course`;
CREATE TABLE IF NOT EXISTS `ma_course` (
  `course_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `description` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`course_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;

-- Dumping data for table massupdated.ma_course: ~8 rows (approximately)
DELETE FROM `ma_course`;
/*!40000 ALTER TABLE `ma_course` DISABLE KEYS */;
INSERT INTO `ma_course` (`course_id`, `name`, `description`) VALUES
	(13, 'Course 1: Health and Safety ', 'Change'),
	(15, 'Course 2: The Human Body, Health and Chronic Illness', ''),
	(16, 'Course 3: Communication and Documentation in the Health Care Environment', ''),
	(17, 'Course 4: Providing Person- Centred Care and Comfort', '');
/*!40000 ALTER TABLE `ma_course` ENABLE KEYS */;

-- Dumping structure for table massupdated.ma_course_announcement
DROP TABLE IF EXISTS `ma_course_announcement`;
CREATE TABLE IF NOT EXISTS `ma_course_announcement` (
  `annnouncement_id` int(11) NOT NULL AUTO_INCREMENT,
  `course_id` int(11) NOT NULL DEFAULT 0,
  `start_time` date NOT NULL,
  `end_time` date NOT NULL,
  `text` varchar(1000) NOT NULL,
  `is_visable` enum('Y','N') NOT NULL DEFAULT 'Y',
  PRIMARY KEY (`annnouncement_id`),
  KEY `FK_ma_course_announcement_ma_course` (`course_id`),
  CONSTRAINT `FK_ma_course_announcement_ma_course` FOREIGN KEY (`course_id`) REFERENCES `ma_course` (`course_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;

-- Dumping data for table massupdated.ma_course_announcement: ~8 rows (approximately)
DELETE FROM `ma_course_announcement`;
/*!40000 ALTER TABLE `ma_course_announcement` DISABLE KEYS */;
INSERT INTO `ma_course_announcement` (`annnouncement_id`, `course_id`, `start_time`, `end_time`, `text`, `is_visable`) VALUES
	(18, 13, '2022-04-13', '2022-04-13', 'Welcome to course 1 ! ', 'Y');
/*!40000 ALTER TABLE `ma_course_announcement` ENABLE KEYS */;

-- Dumping structure for table massupdated.ma_course_lesson
DROP TABLE IF EXISTS `ma_course_lesson`;
CREATE TABLE IF NOT EXISTS `ma_course_lesson` (
  `course_id` int(11) NOT NULL DEFAULT 0,
  `lesson_id` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`course_id`,`lesson_id`),
  KEY `FK_ma_course_lesson_ma_lesson` (`lesson_id`),
  CONSTRAINT `FK_ma_course_lesson_ma_course` FOREIGN KEY (`course_id`) REFERENCES `ma_course` (`course_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_ma_course_lesson_ma_lesson` FOREIGN KEY (`lesson_id`) REFERENCES `ma_lesson` (`lesson_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table massupdated.ma_course_lesson: ~9 rows (approximately)
DELETE FROM `ma_course_lesson`;
/*!40000 ALTER TABLE `ma_course_lesson` DISABLE KEYS */;
INSERT INTO `ma_course_lesson` (`course_id`, `lesson_id`) VALUES
	(13, 21);
/*!40000 ALTER TABLE `ma_course_lesson` ENABLE KEYS */;

-- Dumping structure for table massupdated.ma_document
DROP TABLE IF EXISTS `ma_document`;
CREATE TABLE IF NOT EXISTS `ma_document` (
  `document_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `description` varchar(1000) DEFAULT NULL,
  `url` text DEFAULT NULL,
  PRIMARY KEY (`document_id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=latin1;

-- Dumping data for table massupdated.ma_document: ~9 rows (approximately)
DELETE FROM `ma_document`;
/*!40000 ALTER TABLE `ma_document` DISABLE KEYS */;
INSERT INTO `ma_document` (`document_id`, `name`, `description`, `url`) VALUES
	(28, 'Health and Safety Manual', 'This document has everything you need to know about health and safety guidelines that will be used within this course. Please read it thoroughly! ', 'https://www.google.com/'),
	(30, 'CPR Manual', 'Cardiopulmonary resuscitation (CPR) is a lifesaving technique that\'s useful in many emergencies, such as a heart attack or near drowning, in which someone\'s breathing or heartbeat has stopped. The American Heart Association recommends starting CPR with hard and fast chest compressions. This hands-only CPR recommendation applies to both untrained bystanders and first responders.', 'https://www.mayoclinic.org/first-aid/first-aid-cpr/basics/art-20056600');
/*!40000 ALTER TABLE `ma_document` ENABLE KEYS */;

-- Dumping structure for table massupdated.ma_faculty
DROP TABLE IF EXISTS `ma_faculty`;
CREATE TABLE IF NOT EXISTS `ma_faculty` (
  `first_name` varchar(50) NOT NULL,
  `middle_name` varchar(50) DEFAULT NULL,
  `last_name` varchar(50) NOT NULL,
  `email` varchar(320) NOT NULL,
  `username` varchar(11) NOT NULL,
  `password` varchar(50) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table massupdated.ma_faculty: ~5 rows (approximately)
DELETE FROM `ma_faculty`;
/*!40000 ALTER TABLE `ma_faculty` DISABLE KEYS */;
INSERT INTO `ma_faculty` (`first_name`, `middle_name`, `last_name`, `email`, `username`, `password`) VALUES
	('Allan', 'A', 'Abraham', 'allan@gmail.com', 'faculty', 'pass');
/*!40000 ALTER TABLE `ma_faculty` ENABLE KEYS */;

-- Dumping structure for table massupdated.ma_grade
DROP TABLE IF EXISTS `ma_grade`;
CREATE TABLE IF NOT EXISTS `ma_grade` (
  `assignment_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(11) NOT NULL,
  `mark` double NOT NULL DEFAULT 0,
  `is_visible` enum('Y','N') NOT NULL DEFAULT 'Y',
  PRIMARY KEY (`assignment_id`,`username`),
  KEY `FK_ma_grade_ma_student` (`username`),
  CONSTRAINT `FK_ma_grade_ma_assignment` FOREIGN KEY (`assignment_id`) REFERENCES `ma_assignment` (`assignment_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_ma_grade_ma_student` FOREIGN KEY (`username`) REFERENCES `ma_student` (`username`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=latin1;

-- Dumping data for table massupdated.ma_grade: ~3 rows (approximately)
DELETE FROM `ma_grade`;
/*!40000 ALTER TABLE `ma_grade` DISABLE KEYS */;
INSERT INTO `ma_grade` (`assignment_id`, `username`, `mark`, `is_visible`) VALUES
	(19, 'cmc21-00001', 90, 'Y'),
	(20, 'cmc21-00001', 85, 'Y');
/*!40000 ALTER TABLE `ma_grade` ENABLE KEYS */;

-- Dumping structure for table massupdated.ma_lesson
DROP TABLE IF EXISTS `ma_lesson`;
CREATE TABLE IF NOT EXISTS `ma_lesson` (
  `lesson_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(70) NOT NULL,
  `description` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`lesson_id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=latin1;

-- Dumping data for table massupdated.ma_lesson: ~15 rows (approximately)
DELETE FROM `ma_lesson`;
/*!40000 ALTER TABLE `ma_lesson` DISABLE KEYS */;
INSERT INTO `ma_lesson` (`lesson_id`, `name`, `description`) VALUES
	(21, 'Module 1: Health and Safety', 'In this module we will cover everything you need to know about health and safety'),
	(22, 'Module 2: CPR Training', 'In this module we learn how to do CPR!'),
	(24, 'Module 3: Function Effectively as a Team Member', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc viverra neque ut cursus ullamcorper. Nullam sit amet tempor magna. Nulla lacinia neque at lectus varius, ac laoreet diam pulvinar. Cras eu massa orci. Morbi a ipsum non felis volutpat faucibus. Aenean sed rhoncus orci. Nunc non purus vel magna accumsan sollicitudin. Ut posuere nisl sit amet ex condimentum, feugiat sagittis mi rhoncus. Quisque vitae leo volutpat, fringilla urna vel, tempus purus. Phasellus molestie orci sit amet pulvinar consequat. Maecenas venenatis, augue sed posuere lobortis, nisi nibh elementum tellus, sagittis consequat lacus quam hendrerit libero. Sed eget magna quis tellus molestie molestie malesuada a arcu. Aliquam elementum, metus et pellentesque lobortis, ipsum orci aliquam leo, in lobortis nisi est sed quam. Integer eu ligula ut ligula semper hendrerit in vel eros. Quisque bibendum lacinia libero ac pharetra.'),
	(25, 'Module 4: Environmental Safety', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc viverra neque ut cursus ullamcorper. Nullam sit amet tempor magna. Nulla lacinia neque at lectus varius, ac laoreet diam pulvinar. Cras eu massa orci. Morbi a ipsum non felis volutpat faucibus. Aenean sed rhoncus orci. Nunc non purus vel magna accumsan sollicitudin. Ut posuere nisl sit amet ex condimentum, feugiat sagittis mi rhoncus. Quisque vitae leo volutpat, fringilla urna vel, tempus purus. Phasellus molestie orci sit amet pulvinar consequat. Maecenas venenatis, augue sed posuere lobortis, nisi nibh elementum tellus, sagittis consequat lacus quam hendrerit libero. Sed eget magna quis tellus molestie molestie malesuada a arcu. Aliquam elementum, metus et pellentesque lobortis, ipsum orci aliquam leo, in lobortis nisi est sed quam. Integer eu ligula ut ligula semper hendrerit in vel eros. Quisque bibendum lacinia libero ac pharetra.');
/*!40000 ALTER TABLE `ma_lesson` ENABLE KEYS */;

-- Dumping structure for table massupdated.ma_lesson_assignment
DROP TABLE IF EXISTS `ma_lesson_assignment`;
CREATE TABLE IF NOT EXISTS `ma_lesson_assignment` (
  `assignment_id` int(11) NOT NULL,
  `lesson_id` int(11) NOT NULL,
  PRIMARY KEY (`assignment_id`,`lesson_id`),
  KEY `FK_ma_lesson_assignment_ma_lesson` (`lesson_id`),
  CONSTRAINT `FK_ma_lesson_assignment_ma_assignment` FOREIGN KEY (`assignment_id`) REFERENCES `ma_assignment` (`assignment_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_ma_lesson_assignment_ma_lesson` FOREIGN KEY (`lesson_id`) REFERENCES `ma_lesson` (`lesson_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table massupdated.ma_lesson_assignment: ~4 rows (approximately)
DELETE FROM `ma_lesson_assignment`;
/*!40000 ALTER TABLE `ma_lesson_assignment` DISABLE KEYS */;
INSERT INTO `ma_lesson_assignment` (`assignment_id`, `lesson_id`) VALUES
	(19, 21),
	(20, 21);
/*!40000 ALTER TABLE `ma_lesson_assignment` ENABLE KEYS */;

-- Dumping structure for table massupdated.ma_lesson_document
DROP TABLE IF EXISTS `ma_lesson_document`;
CREATE TABLE IF NOT EXISTS `ma_lesson_document` (
  `document_id` int(11) NOT NULL,
  `lesson_id` int(11) NOT NULL,
  PRIMARY KEY (`document_id`,`lesson_id`),
  KEY `FK_ma_lesson_document_ma_lesson` (`lesson_id`),
  CONSTRAINT `FK_ma_lesson_document_ma_document` FOREIGN KEY (`document_id`) REFERENCES `ma_document` (`document_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_ma_lesson_document_ma_lesson` FOREIGN KEY (`lesson_id`) REFERENCES `ma_lesson` (`lesson_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table massupdated.ma_lesson_document: ~9 rows (approximately)
DELETE FROM `ma_lesson_document`;
/*!40000 ALTER TABLE `ma_lesson_document` DISABLE KEYS */;
INSERT INTO `ma_lesson_document` (`document_id`, `lesson_id`) VALUES
	(28, 21);
/*!40000 ALTER TABLE `ma_lesson_document` ENABLE KEYS */;

-- Dumping structure for table massupdated.ma_schedule
DROP TABLE IF EXISTS `ma_schedule`;
CREATE TABLE IF NOT EXISTS `ma_schedule` (
  `schedule_id` int(11) NOT NULL AUTO_INCREMENT,
  `cohort_id` int(11) NOT NULL DEFAULT 0,
  `url` text NOT NULL,
  PRIMARY KEY (`schedule_id`),
  KEY `FK_ma_schedule_ma_cohort` (`cohort_id`),
  CONSTRAINT `FK_ma_schedule_ma_cohort` FOREIGN KEY (`cohort_id`) REFERENCES `ma_cohort` (`cohort_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;

-- Dumping data for table massupdated.ma_schedule: ~4 rows (approximately)
DELETE FROM `ma_schedule`;
/*!40000 ALTER TABLE `ma_schedule` DISABLE KEYS */;
INSERT INTO `ma_schedule` (`schedule_id`, `cohort_id`, `url`) VALUES
	(14, 9, 'https://docs.google.com/document/d/1RbXjxZZJ9texLLYZkoC0Z-uEsLs1i5SoNdaFKP_8g2E/edit');
/*!40000 ALTER TABLE `ma_schedule` ENABLE KEYS */;

-- Dumping structure for table massupdated.ma_student
DROP TABLE IF EXISTS `ma_student`;
CREATE TABLE IF NOT EXISTS `ma_student` (
  `first_name` varchar(50) NOT NULL,
  `middle_name` varchar(50) DEFAULT NULL,
  `last_name` varchar(50) NOT NULL,
  `email` varchar(320) NOT NULL,
  `username` varchar(11) NOT NULL,
  `password` varchar(50) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table massupdated.ma_student: ~5 rows (approximately)
DELETE FROM `ma_student`;
/*!40000 ALTER TABLE `ma_student` DISABLE KEYS */;
INSERT INTO `ma_student` (`first_name`, `middle_name`, `last_name`, `email`, `username`, `password`) VALUES
	('Adam', 'A', 'Ascot', 'adamascot@gmail.com', 'cmc21-00001', 'pass');
/*!40000 ALTER TABLE `ma_student` ENABLE KEYS */;

-- Dumping structure for table massupdated.ma_student_cohort
DROP TABLE IF EXISTS `ma_student_cohort`;
CREATE TABLE IF NOT EXISTS `ma_student_cohort` (
  `cohort_id` int(11) NOT NULL DEFAULT 0,
  `username` varchar(11) NOT NULL,
  PRIMARY KEY (`cohort_id`,`username`),
  KEY `FK_ma_student_cohort_ma_student` (`username`),
  CONSTRAINT `FK_ma_student_cohort_ma_cohort` FOREIGN KEY (`cohort_id`) REFERENCES `ma_cohort` (`cohort_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_ma_student_cohort_ma_student` FOREIGN KEY (`username`) REFERENCES `ma_student` (`username`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table massupdated.ma_student_cohort: ~0 rows (approximately)
DELETE FROM `ma_student_cohort`;
/*!40000 ALTER TABLE `ma_student_cohort` DISABLE KEYS */;
INSERT INTO `ma_student_cohort` (`cohort_id`, `username`) VALUES
	(9, 'cmc21-00001');
/*!40000 ALTER TABLE `ma_student_cohort` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
