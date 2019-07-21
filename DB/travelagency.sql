-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 21, 2019 at 07:05 PM
-- Server version: 10.1.37-MariaDB
-- PHP Version: 7.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `travelagency`
--

-- --------------------------------------------------------

--
-- Table structure for table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf16;

--
-- Dumping data for table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(11),
(11),
(11),
(11);

-- --------------------------------------------------------

--
-- Table structure for table `location`
--

CREATE TABLE `location` (
  `location_id` int(11) NOT NULL,
  `location_name` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf16;

--
-- Dumping data for table `location`
--

INSERT INTO `location` (`location_id`, `location_name`) VALUES
(1, 'Dhaka'),
(2, 'Chittagong'),
(3, 'Cox\'s Bazar'),
(4, 'Feni');

-- --------------------------------------------------------

--
-- Table structure for table `roles`
--

CREATE TABLE `roles` (
  `role_id` int(11) NOT NULL,
  `role_name` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf16;

--
-- Dumping data for table `roles`
--

INSERT INTO `roles` (`role_id`, `role_name`) VALUES
(1, 'ADMIN');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `user_id` int(11) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf16;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`user_id`, `email`, `name`, `password`) VALUES
(1, 'shahed@gmail.com', 'shahed', '$2a$10$v.cqABkayRIHfxAEeTizMO.71DUNjm9ZPj1krSHrsqnkdj6dEfjVC'),
(4, 'tanvir@gmail.com', 'Tanvir', '$2a$10$pfy/QbzpuEINyj85cuEWg.a7ifNOZCaMp3XYqzu0.y/37dyyZamIm'),
(7, 'rashed@gmail.com', 'rashed', '$2a$10$tZxOOcQFaptToazdZ6PpieyAXM6mlvzCT4tRjWH1/H35E8v1.vDrW'),
(10, 'aftab@gmail.com', 'Aftab Uddin', '$2a$10$L3i3CiTpMHizcsxf7WYMsO/8KVUGXkRPL8jUixEuneDDTg9W/Hmh6');

-- --------------------------------------------------------

--
-- Table structure for table `user_roles`
--

CREATE TABLE `user_roles` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf16;

--
-- Dumping data for table `user_roles`
--

INSERT INTO `user_roles` (`user_id`, `role_id`) VALUES
(1, 1),
(4, 1),
(7, 1),
(10, 1);

-- --------------------------------------------------------

--
-- Table structure for table `user_status`
--

CREATE TABLE `user_status` (
  `status_id` int(11) NOT NULL,
  `user_status` varchar(255) DEFAULT NULL,
  `status_privacy` int(11) DEFAULT NULL,
  `posted_at` datetime DEFAULT NULL,
  `location_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf16;

--
-- Dumping data for table `user_status`
--

INSERT INTO `user_status` (`status_id`, `user_status`, `status_privacy`, `posted_at`, `location_id`, `user_id`) VALUES
(2, 'test post test update V1', 1, '2019-07-20 23:03:10', 1, 1),
(3, 'test post 2 update 2 2 2', 0, '2019-07-20 23:05:32', 3, 1),
(5, 'tanvir new post', 1, '2019-07-20 23:14:08', 1, 4),
(6, 'my new post', 0, '2019-07-21 22:46:13', 2, 1),
(8, 'Need a desperate nap!!!', 1, '2019-07-21 22:55:48', 1, 7),
(9, 'rashed private post', 0, '2019-07-21 22:56:24', 3, 7);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `location`
--
ALTER TABLE `location`
  ADD PRIMARY KEY (`location_id`);

--
-- Indexes for table `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`role_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`);

--
-- Indexes for table `user_roles`
--
ALTER TABLE `user_roles`
  ADD PRIMARY KEY (`user_id`,`role_id`),
  ADD KEY `FKh8ciramu9cc9q3qcqiv4ue8a6` (`role_id`);

--
-- Indexes for table `user_status`
--
ALTER TABLE `user_status`
  ADD PRIMARY KEY (`status_id`),
  ADD KEY `FK68xa1ratw3y6jb7nhjjjc7g5f` (`location_id`),
  ADD KEY `FKfs3p2l9uw8wycw403qpr5la1l` (`user_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
