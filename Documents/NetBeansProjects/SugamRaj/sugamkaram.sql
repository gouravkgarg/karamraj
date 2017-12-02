-- phpMyAdmin SQL Dump
-- version 3.1.3.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Dec 02, 2017 at 10:30 PM
-- Server version: 5.1.33
-- PHP Version: 5.2.9-2

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `sugamkaram`
--

-- --------------------------------------------------------

--
-- Table structure for table `empid`
--

CREATE TABLE IF NOT EXISTS `empid` (
  `empId` varchar(20) NOT NULL,
  `reqId` int(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `empid`
--


-- --------------------------------------------------------

--
-- Table structure for table `performance`
--

CREATE TABLE IF NOT EXISTS `performance` (
  `empId` int(20) NOT NULL AUTO_INCREMENT,
  `empName` varchar(20) NOT NULL,
  `points` int(20) NOT NULL,
  `Password` varchar(20) NOT NULL,
  PRIMARY KEY (`empId`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `performance`
--

INSERT INTO `performance` (`empId`, `empName`, `points`, `Password`) VALUES
(1, 'Ramesh', 2, 'password'),
(2, 'Suresh', 0, 'password');

-- --------------------------------------------------------

--
-- Table structure for table `pool`
--

CREATE TABLE IF NOT EXISTS `pool` (
  `reqId` int(11) NOT NULL DEFAULT '0',
  `status` varchar(30) DEFAULT NULL,
  `stage` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`reqId`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pool`
--

INSERT INTO `pool` (`reqId`, `status`, `stage`) VALUES
(1, 'approved', 'stage1');

-- --------------------------------------------------------

--
-- Table structure for table `stages`
--

CREATE TABLE IF NOT EXISTS `stages` (
  `reqId` int(20) NOT NULL,
  `stageId` varchar(25) NOT NULL,
  `empId` varchar(25) NOT NULL,
  `status` varchar(25) NOT NULL,
  PRIMARY KEY (`reqId`),
  UNIQUE KEY `reqId` (`reqId`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `stages`
--

INSERT INTO `stages` (`reqId`, `stageId`, `empId`, `status`) VALUES
(21, 'Address Verification', '2', 'accepted'),
(22, '2', '1', 'Address Verification');

-- --------------------------------------------------------

--
-- Table structure for table `userdetails`
--

CREATE TABLE IF NOT EXISTS `userdetails` (
  `reqId` int(20) NOT NULL AUTO_INCREMENT,
  `Name` varchar(20) NOT NULL,
  `aadhar` varchar(20) NOT NULL,
  PRIMARY KEY (`reqId`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=22 ;

--
-- Dumping data for table `userdetails`
--

INSERT INTO `userdetails` (`reqId`, `Name`, `aadhar`) VALUES
(21, 'Guru', '623947982'),
(20, 'hello', '234239749'),
(19, 'hello', '234239749'),
(18, 'TCS', '23849729384'),
(17, 'Rohit', '1234556'),
(16, 'Mohit', '239841298');
