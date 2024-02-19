-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 19, 2024 at 09:59 AM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `niyonkuru_theoneste_productioncompanymanagementsystem`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `fname` varchar(50) DEFAULT NULL,
  `lname` varchar(50) DEFAULT NULL,
  `id_number` varchar(20) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `martial_status` varchar(20) DEFAULT NULL,
  `DoB` date DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`fname`, `lname`, `id_number`, `phone`, `gender`, `martial_status`, `DoB`, `email`, `password`) VALUES
('dfgh', 'wert', '123', '12345', 'Male', 'wert', '2020-09-08', 'werty', '4556'),
('niyonkuru', 'theoneste', '222001745', '0786762195', 'Male', 'single', '1989-09-08', 'niyoth250@gmail.com', '12345'),
('noble', 'man', '1234', '078978787', 'Male', 'singl', '3030-09-08', 'werfghdjsa', '123'),
('eeeeeeeee', 'dddddddddd', '22222', '111111', 'Male', 'ddddd', '1999-09-08', 'niyonkuru@gmail.com', '123456'),
('wwwww', 'dddddddd', '222222222', '1234', 'Male', '2345', '1999-09-08', 'noble@gmail.com', '1234'),
('a', 'b', '1', '2', 'Male', 'a', '1222-09-08', 'a', '2'),
('q', 'q', '1', '1', 'Male', 'q', '2000-09-08', 'q', '1'),
('q', 'q', '1', '1', 'Male', 'q', '2000-09-08', 'q', '1'),
('ee', 'ee', '11', '11', 'Male', 'ee', '2000-09-08', 'ee', '11'),
('ee', 'ee', '11', '11', 'Male', 'ee', '2000-09-08', 'ee', '11'),
('noble', 'man', '123', '123', 'Male', 'singk', '1999-09-01', 'noble', '123'),
('noble', 'man', '123', '123', 'Male', 'single', '1999-09-01', 'noble', '123'),
('noble', 'man', '123', '123', 'Male', 'single', '1999-09-01', 'noble', '123'),
('noble', 'man', '123', '123', 'Male', 'single', '1999-09-01', 'noble', '123'),
('noble', 'man', '123', '123', 'Male', 'single', '1999-09-01', 'noble', '123'),
('noble', 'man', '123', '123', 'Male', 'single', '1999-09-01', 'noble', '123'),
('noble', 'man', '123', '123', 'Male', 'single', '1999-09-01', 'noble', '123'),
('noble', 'man', '123', '123', 'Male', 'singk', '1999-09-01', 'noble', '123'),
('noble', 'man', '123', '123', 'Male', 'single', '1999-09-01', 'noble', '123'),
('noble', 'man', '123', '123', 'Male', 'single', '1999-09-01', 'noble', '123'),
('', '', '', '', 'Male', '', '2000-09-08', '', ''),
('', '', '', '', 'Male', '', '2000-09-08', '', ''),
('', '', '', '', 'Male', '', '2000-09-08', '', ''),
('', '', '', '', 'Male', '', '2000-09-08', '', ''),
('', '', '', '', 'Male', '', '1000-09-08', '', ''),
('', '', '', '', 'Male', '', '2000-09-08', '', ''),
('', '', '', '', 'Male', '', '2000-09-08', '', ''),
('', '', '', '', 'Male', '', '2000-09-08', '', '');

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `CustID` int(11) NOT NULL,
  `ProID` int(11) DEFAULT NULL,
  `CFname` varchar(255) DEFAULT NULL,
  `CLname` varchar(255) DEFAULT NULL,
  `CEmail` varchar(255) DEFAULT NULL,
  `Cphone` varchar(20) DEFAULT NULL,
  `Amountpaid` decimal(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`CustID`, `ProID`, `CFname`, `CLname`, `CEmail`, `Cphone`, `Amountpaid`) VALUES
(1, 1, 'Mark', 'Roberts', 'mark.roberts@example.com', '1112223333', 200000.00),
(3, 3, 'Tom', 'Wilson', 'tom.wilson@example.com', '7778889999', 180000.00),
(15, 13, 'noble', 'man', 'nobl#example.com', '078676219655', 20000.00);

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `EmpID` int(11) NOT NULL,
  `Fname` varchar(255) DEFAULT NULL,
  `Lname` varchar(255) DEFAULT NULL,
  `DOB` date DEFAULT NULL,
  `Email` varchar(255) DEFAULT NULL,
  `Contact` varchar(20) DEFAULT NULL,
  `Department` varchar(255) DEFAULT NULL,
  `Salary` decimal(10,2) DEFAULT NULL,
  `contract` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`EmpID`, `Fname`, `Lname`, `DOB`, `Email`, `Contact`, `Department`, `Salary`, `contract`) VALUES
(1, 'John', 'Doe', '1990-05-15', 'john.doe@example.com', '1234567890', 'HR', 50000.00, 'Permanent'),
(2, 'Jane', 'Smith', '1988-09-20', 'jane.smith@example.com', '9876543210', 'Finance', 60000.00, 'Permanent'),
(3, 'Alice', 'Johnson', '1995-02-10', 'alice.johnson@example.com', '5551234567', 'IT', 55000.00, 'Contractor'),
(9, 'ngabo', 'bonheur', '1999-09-08', 'ngabom10@gmail.com', '072134598', 'production', 10000.00, 'final'),
(18, 'umwiza', 'marry', '2001-10-23', 'umwizamarry300@gmail.com', '072134598', 'production', 300000.00, 'final'),
(20, 'niyonkuru', 'theoneste', '2000-09-08', 'niyoth250@gmail.com', '0786762195', 'it', 10000.00, 'final'),
(21, 'qw', 'qwe', '2000-09-08', 'niyothjdhd', '1233', 'asdfg', 10000.00, 'fggyh');

-- --------------------------------------------------------

--
-- Table structure for table `finance`
--

CREATE TABLE `finance` (
  `FinID` int(11) NOT NULL,
  `branch_name` varchar(255) DEFAULT NULL,
  `asset_value` decimal(10,2) DEFAULT NULL,
  `salary_amount` decimal(10,2) DEFAULT NULL,
  `amount_per_year` decimal(10,2) DEFAULT NULL,
  `EmpID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `finance`
--

INSERT INTO `finance` (`FinID`, `branch_name`, `asset_value`, `salary_amount`, `amount_per_year`, `EmpID`) VALUES
(5, 'gakenke', 12344.00, 3000.00, 3000.00, 3),
(26, 'nyamagabe', 12000.00, 12000.00, 20000000.00, 18),
(29, 'wq', 22222.00, 1000.00, 2000.00, 9);

-- --------------------------------------------------------

--
-- Table structure for table `market`
--

CREATE TABLE `market` (
  `MarkID` int(11) NOT NULL,
  `EmpID` int(11) DEFAULT NULL,
  `ProID` int(11) DEFAULT NULL,
  `Mprovince` varchar(255) DEFAULT NULL,
  `Mdistrict` varchar(255) DEFAULT NULL,
  `Msector` varchar(255) DEFAULT NULL,
  `supplydate` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `market`
--

INSERT INTO `market` (`MarkID`, `EmpID`, `ProID`, `Mprovince`, `Mdistrict`, `Msector`, `supplydate`) VALUES
(2, 1, 2, 'DEF Province', 'LMN District', 'STU Sector', '2023-02-25');

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `ProID` int(11) NOT NULL,
  `RmID` int(11) DEFAULT NULL,
  `Pname` varchar(255) DEFAULT NULL,
  `Amount` int(11) DEFAULT NULL,
  `Price` decimal(10,2) DEFAULT NULL,
  `Mnfdate` date DEFAULT NULL,
  `Expdate` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`ProID`, `RmID`, `Pname`, `Amount`, `Price`, `Mnfdate`, `Expdate`) VALUES
(10, 3, 'dfghj', 123, 1234.00, '1999-09-07', '2000-09-03'),
(11, 5, 'sass', 1900, 2000.00, '2000-09-08', '1999-09-08'),
(12, 6, 'ertyui', 32, 70.00, '1999-09-04', '2000-09-03'),
(13, 2, 'wert', 23, 12.00, '2000-09-08', '2001-09-08'),
(14, 2, 'qwertg', 12, 12.00, '2000-12-06', '2002-09-08'),
(15, 5, 'drtfyghj', 13546, 12345.00, '2000-09-08', '2002-09-09'),
(16, 4, 'sdrftyhj', 12, 234.00, '2020-09-08', '2013-09-06'),
(18, 5, 'sass', 1900, 2000.00, '2000-09-08', '1999-09-08');

-- --------------------------------------------------------

--
-- Table structure for table `property`
--

CREATE TABLE `property` (
  `PropID` int(11) NOT NULL,
  `EmpID` int(11) DEFAULT NULL,
  `Pname` varchar(255) DEFAULT NULL,
  `Province` varchar(255) DEFAULT NULL,
  `District` varchar(255) DEFAULT NULL,
  `Sector` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `property`
--

INSERT INTO `property` (`PropID`, `EmpID`, `Pname`, `Province`, `District`, `Sector`) VALUES
(1, 2, '', '', '', ''),
(2, 1, 'vine', 'west', 'nyarugenge', 'nyakaband'),
(3, 3, 'vine', 'west', 'nyarugenge', 'nyakaband'),
(13, 1, 'vine', 'west', 'nyarugenge', 'nyakaband'),
(15, 9, 'vine', 'west', 'nyarugenge', 'nyakaband'),
(16, 3, '', '', '', '');

-- --------------------------------------------------------

--
-- Table structure for table `raw_material`
--

CREATE TABLE `raw_material` (
  `RmID` int(11) NOT NULL,
  `Rtype` varchar(255) DEFAULT NULL,
  `Ramount` decimal(10,2) DEFAULT NULL,
  `stored_date` date DEFAULT NULL,
  `unstore_date` date DEFAULT NULL,
  `SupID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `raw_material`
--

INSERT INTO `raw_material` (`RmID`, `Rtype`, `Ramount`, `stored_date`, `unstore_date`, `SupID`) VALUES
(2, 'edr', 300.00, '2020-09-02', '2000-01-08', 5),
(3, 'wertyu', 1234.00, '2015-09-02', '1999-09-01', 2),
(4, 'wert', 21.00, '2012-09-08', '2014-09-09', 3),
(5, 'wertyu', 1234.00, '2015-09-02', '1999-09-01', 2),
(6, 'ewrrrr', 300.00, '2022-09-08', '2009-09-08', 3),
(12, 'ert', 22.00, '2222-09-08', '2223-07-09', 1),
(13, 'ert', 22.00, '2222-09-08', '2223-07-09', 1),
(14, 'wert', 21.00, '2012-09-08', '2014-09-09', 3),
(15, 'ewrrrr', 300.00, '2022-09-08', '2009-09-08', 3),
(17, 'wertyu', 12.00, '2020-09-03', '2013-09-04', 2),
(20, 'wertyu', 1234.00, '2015-09-02', '1999-09-01', 2),
(22, 'say', 12000.00, '2011-09-09', '2022-09-08', 3);

-- --------------------------------------------------------

--
-- Table structure for table `supplier`
--

CREATE TABLE `supplier` (
  `SupID` int(11) NOT NULL,
  `fname` varchar(255) DEFAULT NULL,
  `Lname` varchar(255) DEFAULT NULL,
  `Province` varchar(255) DEFAULT NULL,
  `District` varchar(255) DEFAULT NULL,
  `sector` varchar(255) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `amount_paid` decimal(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `supplier`
--

INSERT INTO `supplier` (`SupID`, `fname`, `Lname`, `Province`, `District`, `sector`, `phone`, `email`, `amount_paid`) VALUES
(1, 'karangwa', 'denis', 'western', 'rubuye', 'mugina', '250786762195', 'karadenis3@gmail.com', 50000.00),
(2, 'mugisha', 'nany', 'south', 'burera', 'mataba', '250798062195', 'mugisha06@gmail.com', 75000.00),
(3, 'Karake', 'Danny', 'south', 'Musanze', 'Gatwaro', '250798052300', 'KarakeDanny120@gmail.com', 60000.00),
(5, 'Mugisha', 'kevin', 'eastern', 'Bugesera', 'Mataba', '250788805230', 'kevinMugisha@gmail.com', 12.00),
(10, 'dfgh', 'dfgh', 'sdfghj', 'edrtyh', 'dfgh', '2345', 'dtyu', 234.00),
(11, 'sdfghj', 'wertyu', 'sdfghj', 'edrftyu', 'ertyu', '12345', 'ertyu', 12.00),
(14, 'shanny', 'inneza', 'buto', 'danmark', 'nyc', '078676543', 'inneza@gmail.com', 345.00),
(15, 'q', 'w', 'e', 'r', 't', '12', 'qweer', 129000.00);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`CustID`),
  ADD KEY `ProID` (`ProID`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`EmpID`);

--
-- Indexes for table `finance`
--
ALTER TABLE `finance`
  ADD PRIMARY KEY (`FinID`),
  ADD KEY `EmpID` (`EmpID`);

--
-- Indexes for table `market`
--
ALTER TABLE `market`
  ADD PRIMARY KEY (`MarkID`),
  ADD KEY `EmpID` (`EmpID`),
  ADD KEY `ProID` (`ProID`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`ProID`),
  ADD KEY `RmID` (`RmID`);

--
-- Indexes for table `property`
--
ALTER TABLE `property`
  ADD PRIMARY KEY (`PropID`),
  ADD KEY `EmpID` (`EmpID`);

--
-- Indexes for table `raw_material`
--
ALTER TABLE `raw_material`
  ADD PRIMARY KEY (`RmID`),
  ADD KEY `SupID` (`SupID`);

--
-- Indexes for table `supplier`
--
ALTER TABLE `supplier`
  ADD PRIMARY KEY (`SupID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `CustID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT for table `employee`
--
ALTER TABLE `employee`
  MODIFY `EmpID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT for table `finance`
--
ALTER TABLE `finance`
  MODIFY `FinID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;

--
-- AUTO_INCREMENT for table `market`
--
ALTER TABLE `market`
  MODIFY `MarkID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `ProID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT for table `property`
--
ALTER TABLE `property`
  MODIFY `PropID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `raw_material`
--
ALTER TABLE `raw_material`
  MODIFY `RmID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT for table `supplier`
--
ALTER TABLE `supplier`
  MODIFY `SupID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `customer`
--
ALTER TABLE `customer`
  ADD CONSTRAINT `customer_ibfk_1` FOREIGN KEY (`ProID`) REFERENCES `property` (`PropID`);

--
-- Constraints for table `finance`
--
ALTER TABLE `finance`
  ADD CONSTRAINT `finance_ibfk_1` FOREIGN KEY (`EmpID`) REFERENCES `employee` (`EmpID`);

--
-- Constraints for table `market`
--
ALTER TABLE `market`
  ADD CONSTRAINT `market_ibfk_1` FOREIGN KEY (`EmpID`) REFERENCES `employee` (`EmpID`),
  ADD CONSTRAINT `market_ibfk_2` FOREIGN KEY (`ProID`) REFERENCES `property` (`PropID`);

--
-- Constraints for table `product`
--
ALTER TABLE `product`
  ADD CONSTRAINT `product_ibfk_1` FOREIGN KEY (`RmID`) REFERENCES `raw_material` (`RmID`);

--
-- Constraints for table `property`
--
ALTER TABLE `property`
  ADD CONSTRAINT `property_ibfk_1` FOREIGN KEY (`EmpID`) REFERENCES `employee` (`EmpID`);

--
-- Constraints for table `raw_material`
--
ALTER TABLE `raw_material`
  ADD CONSTRAINT `raw_material_ibfk_1` FOREIGN KEY (`SupID`) REFERENCES `supplier` (`SupID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
