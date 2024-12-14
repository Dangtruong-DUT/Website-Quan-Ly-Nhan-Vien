-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th12 14, 2024 lúc 04:35 PM
-- Phiên bản máy phục vụ: 10.4.32-MariaDB
-- Phiên bản PHP: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `gioithieutruong`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `account`
--

CREATE TABLE `account` (
  `username` varchar(50) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `idNV` varchar(255) DEFAULT NULL,
  `role` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `account`
--

INSERT INTO `account` (`username`, `password`, `idNV`, `role`) VALUES
('admin', 'admin01', 'NV01', 'ADMIN'),
('user01', 'user00', 'NV02', 'USER'),
('user02', 'user02', 'NV03', 'USER');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `department`
--

CREATE TABLE `department` (
  `idPB` varchar(50) NOT NULL,
  `tenPB` varchar(100) DEFAULT NULL,
  `moTa` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `department`
--

INSERT INTO `department` (`idPB`, `tenPB`, `moTa`) VALUES
('PB01', 'Công tác sinh viên', 'Phòng công tác sinh viên'),
('PB02', 'Cơ sở vật chất', 'Phòng cơ sở vật chất'),
('PB03', 'Đào tạo', 'Phòng đào tạo'),
('PB04', 'Kế hoạch - Tài chính', 'Phòng kế hoạch tài chính'),
('PB05', 'Tổ chức - Hành chính', 'Phòng tổ chức hành chính ');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `employee`
--

CREATE TABLE `employee` (
  `idNV` varchar(50) NOT NULL,
  `idPB` varchar(50) DEFAULT NULL,
  `tenNV` varchar(100) DEFAULT NULL,
  `ngaySinh` date DEFAULT NULL,
  `diaChi` varchar(255) DEFAULT NULL,
  `soDienThoai` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `employee`
--

INSERT INTO `employee` (`idNV`, `idPB`, `tenNV`, `ngaySinh`, `diaChi`, `soDienThoai`) VALUES
('NV01', 'PB01', 'Nguyen Thanh Nam', '2004-01-31', 'Da Nang', '0123456789'),
('NV02', 'PB02', 'hoang hai ly', '2004-02-18', 'Da Nang', '0987654321'),
('NV03', 'PB03', 'Nguyen Le Nhat Tuan', '2024-12-07', 'Hue', '0999999999');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`username`),
  ADD KEY `FK_account_employee` (`idNV`);

--
-- Chỉ mục cho bảng `department`
--
ALTER TABLE `department`
  ADD PRIMARY KEY (`idPB`);

--
-- Chỉ mục cho bảng `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`idNV`),
  ADD KEY `FK_employee_department` (`idPB`);

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `account`
--
ALTER TABLE `account`
  ADD CONSTRAINT `FK_account_employee` FOREIGN KEY (`idNV`) REFERENCES `employee` (`idNV`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `employee`
--
ALTER TABLE `employee`
  ADD CONSTRAINT `FK_employee_department` FOREIGN KEY (`idPB`) REFERENCES `department` (`idPB`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
