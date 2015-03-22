-- MySQL dump 10.13  Distrib 5.5.40, for Win64 (x86)
--
-- Host: localhost    Database: test
-- ------------------------------------------------------
-- Server version	5.5.40

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `board`
--

DROP TABLE IF EXISTS `board`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `board` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(20) NOT NULL,
  `message` varchar(255) NOT NULL,
  `posttime` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `board`
--

LOCK TABLES `board` WRITE;
/*!40000 ALTER TABLE `board` DISABLE KEYS */;
/*!40000 ALTER TABLE `board` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `compileinfo`
--

DROP TABLE IF EXISTS `compileinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `compileinfo` (
  `solution_id` int(11) NOT NULL AUTO_INCREMENT,
  `error` longtext,
  `user_id` int(11) NOT NULL,
  `problem_id` int(11) NOT NULL,
  `language` varchar(45) NOT NULL,
  `submit_time` datetime NOT NULL,
  `code_length` int(11) NOT NULL,
  `time` int(11) NOT NULL,
  `result` int(11) NOT NULL,
  PRIMARY KEY (`solution_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `compileinfo`
--

LOCK TABLES `compileinfo` WRITE;
/*!40000 ALTER TABLE `compileinfo` DISABLE KEYS */;
INSERT INTO `compileinfo` VALUES (1,'',1,3,'gcc','2015-03-12 20:52:10',62,1664,3),(2,'',1,3,'gcc','2015-03-12 20:57:38',63,181,1),(3,'',1,4,'gcc','2015-03-12 21:09:30',174,2779,3),(4,'',1,4,'gcc','2015-03-12 21:19:04',187,591,2),(5,'',1,4,'gcc','2015-03-12 21:20:05',187,1088,2),(6,'',1,4,'gcc','2015-03-12 21:21:42',187,3415,2);
/*!40000 ALTER TABLE `compileinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `problem`
--

DROP TABLE IF EXISTS `problem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `problem` (
  `problem_id` int(11) NOT NULL,
  `title` varchar(200) NOT NULL,
  `description` longtext,
  `input` longtext,
  `output` longtext,
  `input_path` varchar(255) DEFAULT NULL,
  `output_path` varchar(255) DEFAULT NULL,
  `sample_input` longtext,
  `sample_output` longtext,
  `hint` longtext,
  `in_date` datetime DEFAULT NULL,
  `time_limit` int(11) NOT NULL,
  `memory_limit` int(11) NOT NULL,
  `accepted` int(11) DEFAULT NULL,
  `submit` int(11) DEFAULT NULL,
  `ratio` smallint(6) NOT NULL,
  `error` int(11) DEFAULT NULL,
  `difficulty` smallint(6) NOT NULL,
  `submit_user` int(11) DEFAULT NULL,
  `solved` int(11) DEFAULT NULL,
  `test1_input` longtext,
  `test1_output` longtext,
  `test2_input` longtext,
  `test2_output` longtext,
  `test3_input` longtext,
  `test3_output` longtext,
  PRIMARY KEY (`problem_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `problem`
--

LOCK TABLES `problem` WRITE;
/*!40000 ALTER TABLE `problem` DISABLE KEYS */;
INSERT INTO `problem` VALUES (2,'A+B Problem','Calculate a+b','Two integer a,b (0<=a,b<=10)','Output a+b','D:/data/temp','D:/data/temp','1 2','3','Q: Where are the input and the output? \r\n\r\nA: Your program shall always read input from stdin (Standard Input) and write output to stdout (Standard Output). For example, you can use \'scanf\' in C or \'cin\' in C++ to read from stdin, and use \'printf\' in C or \'cout\' in C++ to write to stdout. \r\n\r\nYou shall not output any extra data to standard output other than that required by the problem, otherwise you will get a \"Wrong Answer\". \r\n\r\nUser programs are not allowed to open and read from/write to files. You will get a \"Runtime Error\" or a \"Wrong Answer\" if you try to do so. \r\n\r\nHere is a sample solution for problem 1000 using C++/G++: \r\n\r\n\r\n#include \r\n\r\nusing namespace std;\r\n\r\nint  main()\r\n\r\n{\r\n\r\n    int a,b;\r\n\r\n    cin >> a >> b;\r\n\r\n    cout << a+b << endl;\r\n\r\n    return 0;\r\n\r\n}\r\n\r\nIt\'s important that the return type of main() must be int when you use G++/GCC,or you may get compile error. \r\n\r\nHere is a sample solution for problem 1000 using C/GCC: \r\n','2015-03-12 20:37:09',1000,65536,0,0,0,NULL,0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL),(3,'3问题','输出3','','','D:/data/temp','D:/data/temp','','3','输出3','2015-03-12 20:54:51',10000,65536,0,0,0,NULL,0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL),(4,'Sum Problem','Hey, welcome to HDOJ(Hangzhou Dianzi University Online Judge).\r\nIn this problem, your task is to calculate SUM(n) = 1 + 2 + 3 + ... + n.','The input will consist of a series of integers n, one integer per line.','For each case, output SUM(n) in one line, followed by a blank line. You may assume the result\r\nwill be in the range of 32-bit signed integer. ','D:/data/temp','D:/data/temp','1\r\n100','1\r\n\r\n5050','','2015-03-12 21:11:24',10000,65536,0,0,0,NULL,0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL),(44,'测试','dada','dga','gda','D:/data/temp','D:/data/temp','da','da','dddd','2015-03-18 14:57:18',1000,65536,0,0,0,NULL,0,NULL,0,'6','5','4','3','2','1');
/*!40000 ALTER TABLE `problem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `user_id` varchar(20) NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  `submit` int(11) DEFAULT NULL,
  `solved` int(11) DEFAULT NULL,
  `accesstime` datetime DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `reg_time` datetime DEFAULT NULL,
  `nick` varchar(100) NOT NULL,
  `school` varchar(100) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES ('1','164608373@qq.com',0,0,'2015-03-12 14:22:16','1',NULL,'擦擦','华软');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-03-18 14:59:37
