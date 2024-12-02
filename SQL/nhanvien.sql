-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th12 01, 2024 lúc 09:26 PM
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
-- Cơ sở dữ liệu: `dulieu`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhanvien`
--

CREATE TABLE `nhanvien` (
  `IDNV` varchar(50) NOT NULL,
  `Hoten` text NOT NULL,
  `IDPB` text NOT NULL,
  `Diachi` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `nhanvien`
--

INSERT INTO `nhanvien` (`IDNV`, `Hoten`, `IDPB`, `Diachi`) VALUES
('W0017', 'thu hang', 'PB01', 'Hue'),
('W002', 'thu hang', 'PB01', 'Hue'),
('W003', 'thu hang', 'PB01', 'Hue'),
('W0030', 'thu hang', 'PB01', 'Hue'),
('W0034', 'thu hang', 'PB02', 'Hue'),
('W0035', 'thu hang', 'PB02', 'Hue'),
('W0036', 'thu hang', 'PB02', 'Hue'),
('W0037', 'thu hang', 'PB02', 'Hue'),
('W0038', 'thu hang', 'PB02', 'Hue'),
('W0039', 'thu hang', 'PB02', 'Hue'),
('W004', 'thu hang', 'PB01', 'Hue'),
('W005', 'thu hang', 'PB01', 'Hue'),
('W006', 'thu hang', 'PB01', 'Hue'),
('W007', 'thu hang', 'PB01', 'Hue'),
('W008', 'thu hang', 'PB01', 'Hue'),
('W009', 'thu hang', 'PB01', 'Hue');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD PRIMARY KEY (`IDNV`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
