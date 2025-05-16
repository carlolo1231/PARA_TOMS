-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 16, 2025 at 04:59 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `supplytracker_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `logs`
--

CREATE TABLE `logs` (
  `log_id` int(11) NOT NULL,
  `u_id` int(11) DEFAULT NULL,
  `activity` varchar(255) NOT NULL,
  `log_time` datetime DEFAULT current_timestamp(),
  `user_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `logs`
--

INSERT INTO `logs` (`log_id`, `u_id`, `activity`, `log_time`, `user_id`) VALUES
(1, NULL, 'A new user registered', '2025-05-05 12:41:58', 9),
(2, NULL, 'Admin Registered a user', '2025-05-05 13:06:33', 9),
(3, NULL, 'Admin logged in', '2025-05-05 13:13:32', 9),
(4, NULL, 'Admin updated a user', '2025-05-05 13:14:15', 9),
(5, NULL, 'User reset their password.', '2025-05-05 14:08:24', 9),
(6, NULL, 'Admin logged in', '2025-05-05 14:09:19', 9),
(7, NULL, 'Admin logged in', '2025-05-05 14:12:35', 9),
(8, NULL, 'Admin updated a user', '2025-05-05 14:14:15', 9),
(9, NULL, 'Admin logged in', '2025-05-05 14:16:28', 9),
(10, NULL, 'Admin logged in', '2025-05-05 14:17:49', 9),
(11, NULL, 'Admin logged in', '2025-05-05 14:18:12', 9),
(12, NULL, 'A new user registered', '2025-05-12 15:36:26', 11),
(13, NULL, 'User logged in', '2025-05-12 15:38:00', 11),
(14, NULL, 'User logged in', '2025-05-12 15:47:17', 11),
(15, NULL, 'Admin logged in', '2025-05-12 15:48:11', 11),
(16, NULL, 'Admin updated a user', '2025-05-12 15:50:51', 11),
(17, NULL, 'Admin logged in', '2025-05-12 15:54:19', 11),
(18, NULL, 'Admin logged in', '2025-05-12 20:14:55', 11),
(19, NULL, 'Admin logged in', '2025-05-12 20:56:32', 11),
(20, NULL, 'Admin logged in', '2025-05-12 20:57:17', 11),
(21, NULL, 'A new user registered', '2025-05-16 19:10:57', 12),
(22, NULL, 'Admin logged in', '2025-05-16 19:11:25', 12),
(23, NULL, 'Admin logged in', '2025-05-16 19:16:56', 12),
(24, NULL, 'Admin logged in', '2025-05-16 20:24:18', 12),
(25, NULL, 'Admin logged in', '2025-05-16 20:31:11', 12),
(26, NULL, 'Admin logged in', '2025-05-16 20:35:47', 12),
(27, NULL, 'Admin logged in', '2025-05-16 20:59:02', 12),
(28, NULL, 'User logged in', '2025-05-16 21:35:48', 12),
(29, NULL, 'User logged in', '2025-05-16 21:36:17', 12),
(30, NULL, 'User logged in', '2025-05-16 21:40:17', 12),
(31, NULL, 'User logged in', '2025-05-16 21:40:47', 12),
(32, NULL, 'User logged in', '2025-05-16 21:53:55', 12),
(33, NULL, 'User logged in', '2025-05-16 21:55:00', 12),
(34, NULL, 'User logged in', '2025-05-16 22:01:43', 12),
(35, NULL, 'Admin logged in', '2025-05-16 22:06:11', 12),
(36, NULL, 'Admin logged in', '2025-05-16 22:07:10', 12),
(37, NULL, 'Admin logged in', '2025-05-16 22:15:41', 12),
(38, NULL, 'Admin logged in', '2025-05-16 22:16:48', 12),
(39, NULL, 'Admin logged in', '2025-05-16 22:17:16', 12),
(40, NULL, 'Admin logged in', '2025-05-16 22:17:37', 12),
(41, NULL, 'Admin logged in', '2025-05-16 22:20:52', 12),
(42, NULL, 'Admin logged in', '2025-05-16 22:23:14', 12),
(43, NULL, 'User logged in', '2025-05-16 22:23:55', 12),
(44, NULL, 'User logged in', '2025-05-16 22:29:28', 12),
(45, NULL, 'User logged in', '2025-05-16 22:31:21', 12),
(46, NULL, 'User logged in', '2025-05-16 22:33:25', 12),
(47, NULL, 'User logged in', '2025-05-16 22:37:51', 12),
(48, NULL, 'User logged in', '2025-05-16 22:39:40', 12),
(49, NULL, 'User logged in', '2025-05-16 22:45:46', 12),
(50, NULL, 'User logged in', '2025-05-16 22:51:01', 12),
(51, NULL, 'User logged in', '2025-05-16 22:52:52', 12),
(52, NULL, 'User logged in', '2025-05-16 22:54:24', 12);

-- --------------------------------------------------------

--
-- Table structure for table `requestedsuppliesuser`
--

CREATE TABLE `requestedsuppliesuser` (
  `request_id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `supply_id` int(11) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `request_date` datetime DEFAULT current_timestamp(),
  `status` enum('pending','approved','rejected') DEFAULT 'pending'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `requestedsuppliesuser`
--

INSERT INTO `requestedsuppliesuser` (`request_id`, `user_id`, `supply_id`, `quantity`, `request_date`, `status`) VALUES
(1, 12, 2, 50, '2025-05-16 21:36:29', 'pending'),
(2, 12, 2, 50, '2025-05-16 21:40:53', 'approved');

-- --------------------------------------------------------

--
-- Table structure for table `supplies`
--

CREATE TABLE `supplies` (
  `supply_id` int(11) NOT NULL,
  `supply_name` varchar(100) NOT NULL,
  `description` text DEFAULT NULL,
  `quantity` int(11) DEFAULT 0,
  `unit` varchar(50) DEFAULT NULL,
  `supplier_name` varchar(100) DEFAULT NULL,
  `purchase_date` date DEFAULT NULL,
  `status` enum('available','low stock','out of stock') DEFAULT 'available',
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `supplies`
--

INSERT INTO `supplies` (`supply_id`, `supply_name`, `description`, `quantity`, `unit`, `supplier_name`, `purchase_date`, `status`, `created_at`, `updated_at`) VALUES
(1, 'Soap', 'Safe Guard Branded Strawberry pink Flavor', 50, 'pcs', 'James Sven Ansali', '2025-05-17', 'low stock', '2025-05-16 12:31:54', '2025-05-16 12:31:54'),
(2, 'Woods', 'Plank Woods fresh cutted', 50, 'Pcs', 'James Sven Ansali', '2025-05-16', 'available', '2025-05-16 13:00:17', '2025-05-16 13:40:53');

-- --------------------------------------------------------

--
-- Table structure for table `transactions`
--

CREATE TABLE `transactions` (
  `transaction_id` int(11) NOT NULL,
  `request_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `action_type` enum('supply_checkout') NOT NULL,
  `action_description` text DEFAULT NULL,
  `action_time` datetime DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `transactions`
--

INSERT INTO `transactions` (`transaction_id`, `request_id`, `user_id`, `action_type`, `action_description`, `action_time`) VALUES
(1, 2, 12, 'supply_checkout', 'User checked out approved supply request ID: 2', '2025-05-16 22:24:05');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `u_id` int(11) NOT NULL,
  `fn` varchar(255) NOT NULL,
  `ln` varchar(255) NOT NULL,
  `cn` varchar(255) NOT NULL,
  `em` varchar(255) NOT NULL,
  `us` varchar(255) NOT NULL,
  `ps` varchar(255) NOT NULL,
  `type` varchar(255) NOT NULL,
  `status` varchar(255) NOT NULL,
  `image` varchar(255) NOT NULL,
  `sq` varchar(255) DEFAULT NULL,
  `ans` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`u_id`, `fn`, `ln`, `cn`, `em`, `us`, `ps`, `type`, `status`, `image`, `sq`, `ans`) VALUES
(6, 'carlo', 'ababan', '0932435545', 'carlo123@gmail.com', 'carlo123', '16a6664ddc1bd19770f67d6f2b86634843e86a3cf93026d474e79b82c33b960f', 'Admin', 'Active', '', '', ''),
(7, 'james', 'ansali', '0932443545', 'james@gmail.com', 'james123', '7eff7d4d55e14f49975eeb4606d6cfeeea091671505b2d6c67deb22b548b8ba7', 'Admin', 'Active', '', '', ''),
(8, 'nameq', 'nameq', '01212112', 'nameless@gmail.com', 'BULOK', '72990959f2cb269eba43dce67e84649cabc9735bf2206f8808e99d10e708d23a', 'CLient', 'Active', '', '', ''),
(9, 'carlo', 'pumped', '09324343', 'carlo@gmail.com', 'carlo123456', '16a6664ddc1bd19770f67d6f2b86634843e86a3cf93026d474e79b82c33b960f', 'Admin', 'Active', 'src/Images/6.PNG', 'Are you gay?', 'yes'),
(10, 'konssss', 'kons', '0934343434', 'kons@gmail.com', 'kons123', 'd926ddf1855415fc11afffc07faa16f82d7794600067490aa30626bb99418e09', 'Admin', 'Active', 'src/Images/2.PNG', NULL, NULL),
(11, 'carlo', 'ababan', '090912425325', 'carloababan@gmail.com', 'carlos', '2b084d6b919bd25b275897839e5889af25a6dee99a4bce4b3dd8a0c4f944107e', 'Admin', 'Active', '', 'Are you gay?', 'yes'),
(12, 'Carlolo', 'Ababa', '09234343434', 'carlolo@gmail.com', 'carlolo123', '16a6664ddc1bd19770f67d6f2b86634843e86a3cf93026d474e79b82c33b960f', 'Client', 'Active', '', 'What is your favorite food?', 'Jennifer');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `logs`
--
ALTER TABLE `logs`
  ADD PRIMARY KEY (`log_id`),
  ADD KEY `fk_logs_user_id` (`user_id`),
  ADD KEY `fk_logs_u_id` (`u_id`);

--
-- Indexes for table `requestedsuppliesuser`
--
ALTER TABLE `requestedsuppliesuser`
  ADD PRIMARY KEY (`request_id`),
  ADD KEY `user_id` (`user_id`);

--
-- Indexes for table `supplies`
--
ALTER TABLE `supplies`
  ADD PRIMARY KEY (`supply_id`);

--
-- Indexes for table `transactions`
--
ALTER TABLE `transactions`
  ADD PRIMARY KEY (`transaction_id`),
  ADD KEY `request_id` (`request_id`),
  ADD KEY `user_id` (`user_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`u_id`),
  ADD UNIQUE KEY `u_id` (`u_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `logs`
--
ALTER TABLE `logs`
  MODIFY `log_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=53;

--
-- AUTO_INCREMENT for table `requestedsuppliesuser`
--
ALTER TABLE `requestedsuppliesuser`
  MODIFY `request_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `supplies`
--
ALTER TABLE `supplies`
  MODIFY `supply_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `transactions`
--
ALTER TABLE `transactions`
  MODIFY `transaction_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `u_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `logs`
--
ALTER TABLE `logs`
  ADD CONSTRAINT `fk_logs_u_id` FOREIGN KEY (`u_id`) REFERENCES `users` (`u_id`) ON DELETE SET NULL ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_logs_user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`u_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `requestedsuppliesuser`
--
ALTER TABLE `requestedsuppliesuser`
  ADD CONSTRAINT `requestedsuppliesuser_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`u_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `transactions`
--
ALTER TABLE `transactions`
  ADD CONSTRAINT `transactions_ibfk_1` FOREIGN KEY (`request_id`) REFERENCES `requestedsuppliesuser` (`request_id`) ON DELETE CASCADE,
  ADD CONSTRAINT `transactions_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `users` (`u_id`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
