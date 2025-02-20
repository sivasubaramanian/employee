-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 20, 2025 at 05:12 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `employee`
--

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `id` bigint(20) NOT NULL,
  `age` int(11) NOT NULL,
  `doj` date DEFAULT NULL,
  `emp_id` varchar(255) NOT NULL,
  `emp_name` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `delete_status` bit(1) NOT NULL,
  `dele` bit(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`id`, `age`, `doj`, `emp_id`, `emp_name`, `location`, `delete_status`, `dele`) VALUES
(1, 10, '2025-02-11', '001', 'test', 'chennai', b'1', NULL),
(4, 30, '2024-09-14', '002', 'Billa', 'Bengalore', b'0', NULL),
(5, 18, '2025-02-20', '003', 'Shiva', 'Cuddalore', b'0', NULL),
(7, 20, '2025-02-19', '005', 'raju', 'chennai', b'0', NULL),
(8, 25, '2024-06-30', '006', 'sherin', 'Pondy', b'0', NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UKp0qw73v7jwaff4dqc80hpfs9k` (`emp_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `employee`
--
ALTER TABLE `employee`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
