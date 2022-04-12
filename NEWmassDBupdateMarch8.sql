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

-- Dumping data for table massupdated.ma_admin: ~3 rows (approximately)
DELETE FROM `ma_admin`;
/*!40000 ALTER TABLE `ma_admin` DISABLE KEYS */;
INSERT INTO `ma_admin` (`first_name`, `middle_name`, `last_name`, `email`, `username`, `password`) VALUES
	('adam', 'a', 'admin', 'admin@admin.com', '1', 'admin'),
	('betty', 'b', 'badmin', 'badmin@hotmail.com', '2', 'root'),
	('chuck', 'c', 'chuck', 'chuckkychheese@go.gov', '3', 'pass');
/*!40000 ALTER TABLE `ma_admin` ENABLE KEYS */;

-- Dumping structure for table massupdated.ma_announcement
DROP TABLE IF EXISTS `ma_announcement`;
CREATE TABLE IF NOT EXISTS `ma_announcement` (
  `announcement_id` varchar(10) NOT NULL,
  `cohort_id` varchar(10) NOT NULL,
  `start_time` date NOT NULL,
  `end_time` date NOT NULL,
  `text` varchar(1000) NOT NULL,
  `is_visible` enum('Y','N') NOT NULL DEFAULT 'Y',
  PRIMARY KEY (`announcement_id`),
  KEY `FK_ma_announcement_ma_cohort` (`cohort_id`),
  CONSTRAINT `FK_ma_announcement_ma_cohort` FOREIGN KEY (`cohort_id`) REFERENCES `ma_cohort` (`cohort_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table massupdated.ma_announcement: ~4 rows (approximately)
DELETE FROM `ma_announcement`;
/*!40000 ALTER TABLE `ma_announcement` DISABLE KEYS */;
INSERT INTO `ma_announcement` (`announcement_id`, `cohort_id`, `start_time`, `end_time`, `text`, `is_visible`) VALUES
	('1', '1', '2022-02-10', '2022-02-11', 'Welcome Winter 2022 Students!', 'Y'),
	('2', '2', '2022-04-10', '2022-04-11', 'Welcome Spring 2022 Students!', 'N'),
	('3', '3', '2022-07-10', '2022-07-11', 'Welcome Summer 2022 Students!', 'N'),
	('4', '4', '2022-09-10', '2022-09-11', 'Welcome Fall 2022 Students!', 'N');
/*!40000 ALTER TABLE `ma_announcement` ENABLE KEYS */;

-- Dumping structure for table massupdated.ma_assignment
DROP TABLE IF EXISTS `ma_assignment`;
CREATE TABLE IF NOT EXISTS `ma_assignment` (
  `assignment_id` varchar(10) NOT NULL,
  `name` varchar(50) NOT NULL,
  `description` varchar(1000) DEFAULT NULL,
  `url` text DEFAULT NULL,
  `weight` double NOT NULL,
  PRIMARY KEY (`assignment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table massupdated.ma_assignment: ~7 rows (approximately)
DELETE FROM `ma_assignment`;
/*!40000 ALTER TABLE `ma_assignment` DISABLE KEYS */;
INSERT INTO `ma_assignment` (`assignment_id`, `name`, `description`, `url`, `weight`) VALUES
	('1', 'CPR assignment', 'for this assignment we will be learning the basics of CPR', 'https://URLforCPRassignment.url', 10),
	('2', 'Bandaid application', 'they are sticky', 'https://URLforBandaid.url', 10),
	('3', 'Bedside Manner Coloring Book', 'stay within the lines for full marks', 'https://URLforColouringAssignment.url', 15),
	('4', 'WordAssociation', 'This is an individual assignment.', 'https://URLforWordAssosiation.url', 15),
	('5', 'Week1Quiz', '', NULL, 10),
	('6', 'Midterm', NULL, NULL, 20),
	('7', 'Final', '', NULL, 20);
/*!40000 ALTER TABLE `ma_assignment` ENABLE KEYS */;

-- Dumping structure for table massupdated.ma_attendance
DROP TABLE IF EXISTS `ma_attendance`;
CREATE TABLE IF NOT EXISTS `ma_attendance` (
  `username` varchar(11) NOT NULL,
  `attendance_record` varchar(365) NOT NULL,
  PRIMARY KEY (`username`),
  CONSTRAINT `FK_ma_attendance_ma_student` FOREIGN KEY (`username`) REFERENCES `ma_student` (`username`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table massupdated.ma_attendance: ~11 rows (approximately)
DELETE FROM `ma_attendance`;
/*!40000 ALTER TABLE `ma_attendance` DISABLE KEYS */;
INSERT INTO `ma_attendance` (`username`, `attendance_record`) VALUES
	('cmc21-00001', '11111'),
	('cmc21-00002', '11011'),
	('cmc21-00003', '11001'),
	('cmc21-00004', '11110'),
	('cmc21-00005', '01111'),
	('cmc21-00006', '11111'),
	('cmc21-00007', '11111'),
	('cmc21-00008', '00000'),
	('cmc21-00009', '11001'),
	('cmc21-00010', '10110'),
	('cmc21-00011', '11111');
/*!40000 ALTER TABLE `ma_attendance` ENABLE KEYS */;

-- Dumping structure for table massupdated.ma_cohort
DROP TABLE IF EXISTS `ma_cohort`;
CREATE TABLE IF NOT EXISTS `ma_cohort` (
  `cohort_id` varchar(10) NOT NULL,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`cohort_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table massupdated.ma_cohort: ~4 rows (approximately)
DELETE FROM `ma_cohort`;
/*!40000 ALTER TABLE `ma_cohort` DISABLE KEYS */;
INSERT INTO `ma_cohort` (`cohort_id`, `name`) VALUES
	('1', 'Winter 2022'),
	('2', 'Spring 2022'),
	('3', 'Summer 2022'),
	('4', 'Fall 2022');
/*!40000 ALTER TABLE `ma_cohort` ENABLE KEYS */;

-- Dumping structure for table massupdated.ma_cohort_course
DROP TABLE IF EXISTS `ma_cohort_course`;
CREATE TABLE IF NOT EXISTS `ma_cohort_course` (
  `cohort_id` varchar(10) NOT NULL,
  `course_id` varchar(10) NOT NULL,
  PRIMARY KEY (`cohort_id`,`course_id`),
  KEY `FK_ma_cohort_course_ma_course` (`course_id`),
  CONSTRAINT `FK_ma_cohort_course_ma_cohort` FOREIGN KEY (`cohort_id`) REFERENCES `ma_cohort` (`cohort_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_ma_cohort_course_ma_course` FOREIGN KEY (`course_id`) REFERENCES `ma_course` (`course_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table massupdated.ma_cohort_course: ~18 rows (approximately)
DELETE FROM `ma_cohort_course`;
/*!40000 ALTER TABLE `ma_cohort_course` DISABLE KEYS */;
INSERT INTO `ma_cohort_course` (`cohort_id`, `course_id`) VALUES
	('1', '1'),
	('1', '2'),
	('1', '3'),
	('1', '4'),
	('1', '5'),
	('1', '6'),
	('1', '7'),
	('1', '8'),
	('1', '9'),
	('2', '1'),
	('2', '2'),
	('2', '3'),
	('2', '4'),
	('2', '5'),
	('2', '6'),
	('2', '7'),
	('2', '8'),
	('2', '9');
/*!40000 ALTER TABLE `ma_cohort_course` ENABLE KEYS */;

-- Dumping structure for table massupdated.ma_cohort_faculty
DROP TABLE IF EXISTS `ma_cohort_faculty`;
CREATE TABLE IF NOT EXISTS `ma_cohort_faculty` (
  `cohort_id` varchar(10) NOT NULL,
  `username` varchar(10) NOT NULL,
  PRIMARY KEY (`cohort_id`,`username`),
  KEY `FK_ma_cohort_faculty_ma_faculty` (`username`),
  CONSTRAINT `FK_ma_cohort_faculty_ma_cohort` FOREIGN KEY (`cohort_id`) REFERENCES `ma_cohort` (`cohort_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_ma_cohort_faculty_ma_faculty` FOREIGN KEY (`username`) REFERENCES `ma_faculty` (`username`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table massupdated.ma_cohort_faculty: ~0 rows (approximately)
DELETE FROM `ma_cohort_faculty`;
/*!40000 ALTER TABLE `ma_cohort_faculty` DISABLE KEYS */;
INSERT INTO `ma_cohort_faculty` (`cohort_id`, `username`) VALUES
	('1', '1'),
	('2', '1'),
	('2', '2'),
	('3', '3'),
	('4', '4');
/*!40000 ALTER TABLE `ma_cohort_faculty` ENABLE KEYS */;

-- Dumping structure for table massupdated.ma_course
DROP TABLE IF EXISTS `ma_course`;
CREATE TABLE IF NOT EXISTS `ma_course` (
  `course_id` varchar(10) NOT NULL,
  `name` varchar(100) NOT NULL,
  `description` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table massupdated.ma_course: ~8 rows (approximately)
DELETE FROM `ma_course`;
/*!40000 ALTER TABLE `ma_course` DISABLE KEYS */;
INSERT INTO `ma_course` (`course_id`, `name`, `description`) VALUES
	('1', 'COURSE 1: Health Care Aide Role and Responsibility', NULL),
	('2', 'COURSE 2: The Human Body, Health and Chronic Illness', NULL),
	('3', 'COURSE 3: Communication and Documentation in the Health Care Environment ', NULL),
	('4', 'COURSE 4: Providing Person- Centred Care and Comfort', NULL),
	('5', 'COURSE 5: CLINICAL PLACEMENT 1 (80 HOURS)', NULL),
	('6', 'COURSE 6: Meeting Complex Care Needs', NULL),
	('7', 'COURSE 7: Special Activites for Clients with Various Health Conditions', NULL),
	('8', 'COURSE 8: CLINICAL EXPERIENCE 2 (Instructor-led)(160 hours)', NULL),
	('9', 'COURSE 9: CONSOLIDATED CLINICAL EXPERIENCE (80 hours)', NULL);
/*!40000 ALTER TABLE `ma_course` ENABLE KEYS */;

-- Dumping structure for table massupdated.ma_course_announcement
DROP TABLE IF EXISTS `ma_course_announcement`;
CREATE TABLE IF NOT EXISTS `ma_course_announcement` (
  `annnouncement_id` varchar(10) NOT NULL,
  `course_id` varchar(10) NOT NULL,
  `start_time` date NOT NULL,
  `end_time` date NOT NULL,
  `text` varchar(1000) NOT NULL,
  `is_visable` enum('Y','N') NOT NULL DEFAULT 'Y',
  PRIMARY KEY (`annnouncement_id`),
  KEY `FK_ma_course_announcement_ma_course` (`course_id`),
  CONSTRAINT `FK_ma_course_announcement_ma_course` FOREIGN KEY (`course_id`) REFERENCES `ma_course` (`course_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table massupdated.ma_course_announcement: ~3 rows (approximately)
DELETE FROM `ma_course_announcement`;
/*!40000 ALTER TABLE `ma_course_announcement` DISABLE KEYS */;
INSERT INTO `ma_course_announcement` (`annnouncement_id`, `course_id`, `start_time`, `end_time`, `text`, `is_visable`) VALUES
	('1', '1', '2022-03-08', '2022-03-08', 'this is a course announcement. welcome to course 1', 'Y'),
	('2', '2', '2022-03-08', '2022-03-08', 'this is a course announcement. welcome to course 2', 'Y'),
	('3', '3', '2022-03-08', '2022-03-08', 'this is a course announcement. welcome to course 3', 'Y');
/*!40000 ALTER TABLE `ma_course_announcement` ENABLE KEYS */;

-- Dumping structure for table massupdated.ma_course_lesson
DROP TABLE IF EXISTS `ma_course_lesson`;
CREATE TABLE IF NOT EXISTS `ma_course_lesson` (
  `course_id` varchar(10) NOT NULL,
  `lesson_id` varchar(10) NOT NULL,
  PRIMARY KEY (`course_id`,`lesson_id`),
  KEY `FK_ma_course_lesson_ma_lesson` (`lesson_id`),
  CONSTRAINT `FK_ma_course_lesson_ma_course` FOREIGN KEY (`course_id`) REFERENCES `ma_course` (`course_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_ma_course_lesson_ma_lesson` FOREIGN KEY (`lesson_id`) REFERENCES `ma_lesson` (`lesson_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table massupdated.ma_course_lesson: ~14 rows (approximately)
DELETE FROM `ma_course_lesson`;
/*!40000 ALTER TABLE `ma_course_lesson` DISABLE KEYS */;
INSERT INTO `ma_course_lesson` (`course_id`, `lesson_id`) VALUES
	('1', '1'),
	('1', '2'),
	('1', '3'),
	('1', '4'),
	('1', '5'),
	('1', '6'),
	('2', '10'),
	('2', '7'),
	('2', '8'),
	('2', '9'),
	('3', '11'),
	('3', '12'),
	('3', '13'),
	('3', '14'),
	('3', '15');
/*!40000 ALTER TABLE `ma_course_lesson` ENABLE KEYS */;

-- Dumping structure for table massupdated.ma_document
DROP TABLE IF EXISTS `ma_document`;
CREATE TABLE IF NOT EXISTS `ma_document` (
  `document_id` varchar(10) NOT NULL,
  `name` varchar(50) NOT NULL,
  `description` varchar(1000) DEFAULT NULL,
  `url` text DEFAULT NULL,
  PRIMARY KEY (`document_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table massupdated.ma_document: ~4 rows (approximately)
DELETE FROM `ma_document`;
/*!40000 ALTER TABLE `ma_document` DISABLE KEYS */;
INSERT INTO `ma_document` (`document_id`, `name`, `description`, `url`) VALUES
	('1', 'document 1', 'description', 'url'),
	('2', 'doc2', 'description', 'url'),
	('3', 'doc3', 'description', 'url'),
	('4', 'doc4', 'description', 'url');
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
	('andy', 'a', 'anderson', 'anders@cooper.com', '1', 'pass'),
	('brandon', 'b', 'billson', 'billb@hotmail.com', '2', 'passcode'),
	('cooper', 'c', 'crazylegs', 'crazyondafloor@gmail.ca', '3', 'crazylegs'),
	('dylan', 'd', 'donald', 'donaldy@seamail.com', '4', 'hello '),
	('evan', NULL, 'edwards', 'edwards@mtg.com', '5', 'pass');
/*!40000 ALTER TABLE `ma_faculty` ENABLE KEYS */;

-- Dumping structure for table massupdated.ma_grade
DROP TABLE IF EXISTS `ma_grade`;
CREATE TABLE IF NOT EXISTS `ma_grade` (
  `assignment_id` varchar(10) NOT NULL,
  `username` varchar(11) NOT NULL,
  `mark` double NOT NULL DEFAULT 0,
  `is_visible` enum('Y','N') NOT NULL DEFAULT 'N',
  PRIMARY KEY (`assignment_id`,`username`),
  KEY `FK_ma_grade_ma_student` (`username`),
  CONSTRAINT `FK_ma_grade_ma_assignment` FOREIGN KEY (`assignment_id`) REFERENCES `ma_assignment` (`assignment_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_ma_grade_ma_student` FOREIGN KEY (`username`) REFERENCES `ma_student` (`username`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table massupdated.ma_grade: ~22 rows (approximately)
DELETE FROM `ma_grade`;
/*!40000 ALTER TABLE `ma_grade` DISABLE KEYS */;
INSERT INTO `ma_grade` (`assignment_id`, `username`, `mark`, `is_visible`) VALUES
	('1', 'cmc21-00001', 90, 'Y'),
	('1', 'cmc21-00002', 50, 'Y'),
	('1', 'cmc21-00003', 87, 'Y'),
	('1', 'cmc21-00004', 66.78, 'Y'),
	('1', 'cmc21-00005', 12, 'Y'),
	('1', 'cmc21-00006', 77, 'Y'),
	('1', 'cmc21-00007', 98, 'Y'),
	('1', 'cmc21-00008', 0, 'Y'),
	('1', 'cmc21-00009', 100, 'Y'),
	('1', 'cmc21-00010', 67, 'Y'),
	('1', 'cmc21-00011', 74.4, 'Y'),
	('2', 'cmc21-00001', 74.4, 'Y'),
	('2', 'cmc21-00002', 99, 'Y'),
	('2', 'cmc21-00003', 32, 'Y'),
	('2', 'cmc21-00004', 80, 'Y'),
	('2', 'cmc21-00005', 70, 'Y'),
	('2', 'cmc21-00006', 60, 'Y'),
	('2', 'cmc21-00007', 78, 'Y'),
	('2', 'cmc21-00008', 54, 'Y'),
	('2', 'cmc21-00009', 76, 'Y'),
	('2', 'cmc21-00010', 77, 'Y'),
	('2', 'cmc21-00011', 33, 'Y');
/*!40000 ALTER TABLE `ma_grade` ENABLE KEYS */;

-- Dumping structure for table massupdated.ma_lesson
DROP TABLE IF EXISTS `ma_lesson`;
CREATE TABLE IF NOT EXISTS `ma_lesson` (
  `lesson_id` varchar(10) NOT NULL,
  `name` varchar(70) NOT NULL,
  `description` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`lesson_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table massupdated.ma_lesson: ~15 rows (approximately)
DELETE FROM `ma_lesson`;
/*!40000 ALTER TABLE `ma_lesson` DISABLE KEYS */;
INSERT INTO `ma_lesson` (`lesson_id`, `name`, `description`) VALUES
	('1', 'Module 1: Roles of Health Care Aide', 'In this lesson we will...placeholder'),
	('10', 'Module 4: Chronic Conditions', NULL),
	('11', 'Module 1: Comunication in a collaborative Team ', NULL),
	('12', 'Module 2: Dealing with Problems and the Conflict', NULL),
	('13', 'Module 3: Cultural Competence and the Diversity', NULL),
	('14', 'Module 4: Documentation', NULL),
	('15', 'Module 5: Comunication Impairments and Related Strategies', NULL),
	('2', 'Module 2: Legislation', 'In this lesson we will...placeholder'),
	('3', 'Module 3: Function Effectively as a team Member', 'In this lesson we will...placeholder'),
	('4', 'Module 4: Environmental Safety', NULL),
	('5', 'Module 5: Client Saftey', NULL),
	('6', 'Module 6: Self Care and Safety', NULL),
	('7', 'Module 1: Body Systems and Function', NULL),
	('8', 'Module 2: Human Growth Development and Death', NULL),
	('9', 'Module 3: Healthy Aging and Independance', NULL);
/*!40000 ALTER TABLE `ma_lesson` ENABLE KEYS */;

-- Dumping structure for table massupdated.ma_lesson_assignment
DROP TABLE IF EXISTS `ma_lesson_assignment`;
CREATE TABLE IF NOT EXISTS `ma_lesson_assignment` (
  `assignment_id` varchar(10) NOT NULL,
  `lesson_id` varchar(10) NOT NULL,
  PRIMARY KEY (`assignment_id`,`lesson_id`),
  KEY `FK_ma_lesson_assignment_ma_lesson` (`lesson_id`),
  CONSTRAINT `FK_ma_lesson_assignment_ma_assignment` FOREIGN KEY (`assignment_id`) REFERENCES `ma_assignment` (`assignment_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_ma_lesson_assignment_ma_lesson` FOREIGN KEY (`lesson_id`) REFERENCES `ma_lesson` (`lesson_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table massupdated.ma_lesson_assignment: ~7 rows (approximately)
DELETE FROM `ma_lesson_assignment`;
/*!40000 ALTER TABLE `ma_lesson_assignment` DISABLE KEYS */;
INSERT INTO `ma_lesson_assignment` (`assignment_id`, `lesson_id`) VALUES
	('1', '1'),
	('2', '2'),
	('3', '3'),
	('4', '4'),
	('5', '5'),
	('6', '6'),
	('7', '7');
/*!40000 ALTER TABLE `ma_lesson_assignment` ENABLE KEYS */;

-- Dumping structure for table massupdated.ma_lesson_document
DROP TABLE IF EXISTS `ma_lesson_document`;
CREATE TABLE IF NOT EXISTS `ma_lesson_document` (
  `document_id` varchar(10) NOT NULL,
  `lesson_id` varchar(10) NOT NULL,
  PRIMARY KEY (`document_id`,`lesson_id`),
  KEY `FK_ma_lesson_document_ma_lesson` (`lesson_id`),
  CONSTRAINT `FK_ma_lesson_document_ma_document` FOREIGN KEY (`document_id`) REFERENCES `ma_document` (`document_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_ma_lesson_document_ma_lesson` FOREIGN KEY (`lesson_id`) REFERENCES `ma_lesson` (`lesson_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table massupdated.ma_lesson_document: ~4 rows (approximately)
DELETE FROM `ma_lesson_document`;
/*!40000 ALTER TABLE `ma_lesson_document` DISABLE KEYS */;
INSERT INTO `ma_lesson_document` (`document_id`, `lesson_id`) VALUES
	('1', '1'),
	('2', '1'),
	('3', '1'),
	('4', '2');
/*!40000 ALTER TABLE `ma_lesson_document` ENABLE KEYS */;

-- Dumping structure for table massupdated.ma_schedule
DROP TABLE IF EXISTS `ma_schedule`;
CREATE TABLE IF NOT EXISTS `ma_schedule` (
  `schedule_id` varchar(10) NOT NULL,
  `cohort_id` varchar(10) NOT NULL,
  `url` text NOT NULL,
  PRIMARY KEY (`schedule_id`),
  KEY `FK_ma_schedule_ma_cohort` (`cohort_id`),
  CONSTRAINT `FK_ma_schedule_ma_cohort` FOREIGN KEY (`cohort_id`) REFERENCES `ma_cohort` (`cohort_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table massupdated.ma_schedule: ~4 rows (approximately)
DELETE FROM `ma_schedule`;
/*!40000 ALTER TABLE `ma_schedule` DISABLE KEYS */;
INSERT INTO `ma_schedule` (`schedule_id`, `cohort_id`, `url`) VALUES
	('1', '1', 'https://URLforWinterSemester.url'),
	('2', '2', 'https://URLforSpringSemester.url'),
	('3', '3', 'https://URLforSummerSemester.url'),
	('4', '4', 'https://URLforFallSemester.url');
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

-- Dumping data for table massupdated.ma_student: ~11 rows (approximately)
DELETE FROM `ma_student`;
/*!40000 ALTER TABLE `ma_student` DISABLE KEYS */;
INSERT INTO `ma_student` (`first_name`, `middle_name`, `last_name`, `email`, `username`, `password`) VALUES
	('adam', 'a', 'ascot', 'adama@gmail.com', 'cmc21-00001', 'pass'),
	('janice', 'j', 'jadmeyer', 'jmoney@google.com', 'cmc21-00002', 'jjkkllmm'),
	('bryan', 'b', 'barrow', 'bbarraow@hotmail.ca', 'cmc21-00003', '1234'),
	('craig', 'c', 'cranberry', 'cranberryjuice@email.ca', 'cmc21-00004', 'juice'),
	('dylan', 'd', 'duddley', 'fakeemail@123.com', 'cmc21-00005', 'helloworld123'),
	('eli', NULL, 'edwards', 'gmail@gmail.gmail', 'cmc21-00006', 'ggnore'),
	('fran', NULL, 'ferdinand', 'absdefghi@hotlink.stink', 'cmc21-00007', 'snorlax'),
	('gord', 'g', 'gabby', 'highland@hotmail.gov', 'cmc21-00008', 'fhdkjsa'),
	('hilda', 'h', 'humpty', 'dumpty@madeup.nz', 'cmc21-00009', 'password'),
	('ian', 'i', 'iceberg', 'titanic1@sinkmail.buz', 'cmc21-00010', 'itaplane'),
	('janice', 'j', 'joplin', 'jophop@123.usa', 'cmc21-00011', 'canada');
/*!40000 ALTER TABLE `ma_student` ENABLE KEYS */;

-- Dumping structure for table massupdated.ma_student_cohort
DROP TABLE IF EXISTS `ma_student_cohort`;
CREATE TABLE IF NOT EXISTS `ma_student_cohort` (
  `cohort_id` varchar(10) NOT NULL,
  `username` varchar(11) NOT NULL,
  PRIMARY KEY (`cohort_id`,`username`),
  KEY `FK_ma_student_cohort_ma_student` (`username`),
  CONSTRAINT `FK_ma_student_cohort_ma_cohort` FOREIGN KEY (`cohort_id`) REFERENCES `ma_cohort` (`cohort_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_ma_student_cohort_ma_student` FOREIGN KEY (`username`) REFERENCES `ma_student` (`username`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table massupdated.ma_student_cohort: ~11 rows (approximately)
DELETE FROM `ma_student_cohort`;
/*!40000 ALTER TABLE `ma_student_cohort` DISABLE KEYS */;
INSERT INTO `ma_student_cohort` (`cohort_id`, `username`) VALUES
	('1', 'cmc21-00001'),
	('1', 'cmc21-00002'),
	('1', 'cmc21-00003'),
	('1', 'cmc21-00004'),
	('2', 'cmc21-00005'),
	('2', 'cmc21-00006'),
	('3', 'cmc21-00007'),
	('3', 'cmc21-00008'),
	('4', 'cmc21-00009'),
	('4', 'cmc21-00010'),
	('4', 'cmc21-00011');
/*!40000 ALTER TABLE `ma_student_cohort` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
