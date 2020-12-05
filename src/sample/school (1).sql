-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 30, 2020 at 08:51 AM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.2.34

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `school`
--

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `username` varchar(25) NOT NULL,
  `password` varchar(25) NOT NULL,
  `divison` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`username`, `password`, `divison`) VALUES
('abba', '8220', 'staff'),
('bashir', '1248', 'student');

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `matric` text NOT NULL,
  `fname` text NOT NULL,
  `lname` text NOT NULL,
  `email` text NOT NULL,
  `dob` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`matric`, `fname`, `lname`, `email`, `dob`) VALUES
('1072', 'abba', 'bashir', 'abbabashir@abba.com', '11/06/2000'),
('1071', 'aliu', 'uthman', 'aliuuthman@gmail.com', '12/02/2001'),
('1034', 'abdullahi', 'usman', 'usmanabdul@yahoo.com', '11/5/2020'),
('1023', 'faruq', 'umar', 'umar02@yahoo.com', '11/18/2020'),
('1026', 'sadiq', 'abubakar', 'abusadiq@gmail.com', '11/19/2020'),
('1015', 'isah', 'musa', 'musa22@gmail.com', '11/20/2020'),
('1002', 'maryam', 'nazir', 'nazmar@gmail.com', '12/9/2020'),
('1011', 'sadiya', 'umar', 'umarsadiya@yahoo.com', '1/2/2021'),
('1091', 'salim', 'uregi', 'uregilistic@yahoo.com', '12/27/2020'),
('1067', 'zahradeen', 'yusuf', 'yusufzah@gmail.com', '12/19/2020'),
('1062', 'zahradeen', 'musa', 'yusufmusa@gmail.com', '12/5/2008'),
('1029', 'yahaya', 'ibrahim', 'yahaya@gmail.com', '12/10/2009'),
('1030', 'ahmad', 'bawa', 'ahmadbawa@gmail.com', '12/15/2011'),
('1020', 'Hajara', 'AbubakarSadiq', 'hajjobukar@gmail.com', '11/22/2018');

-- --------------------------------------------------------

--
-- Table structure for table `timetable`
--

CREATE TABLE `timetable` (
  `monday` text NOT NULL,
  `tuesday` text NOT NULL,
  `wednesday` text NOT NULL,
  `thursday` text NOT NULL,
  `friday` text NOT NULL,
  `saturday` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `timetable`
--

INSERT INTO `timetable` (`monday`, `tuesday`, `wednesday`, `thursday`, `friday`, `saturday`) VALUES
('csc201', 'csc304', 'pub304', 'bus201', 'pol101', 'math301'),
('phy102', 'chm301', 'bch201', 'bio202', 'mcb304', 'csc401'),
('mth401', 'bch302', 'mcb201', 'pol406', 'csc301', 'chm304'),
('eng302', 'gst201', 'csc406', 'mth305', 'edu302', 'soc304');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
