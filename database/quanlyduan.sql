-- phpMyAdmin SQL Dump
-- version 4.7.7
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 02, 2019 at 04:58 AM
-- Server version: 10.1.30-MariaDB
-- PHP Version: 7.2.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `quanlyduan`
--

-- --------------------------------------------------------

--
-- Table structure for table `danh_muc_du_an`
--

CREATE TABLE `danh_muc_du_an` (
  `ma_du_an` varchar(11) COLLATE utf8_unicode_ci NOT NULL,
  `ma_tieu_thuc` varchar(11) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `danh_muc_tieu_thuc`
--

CREATE TABLE `danh_muc_tieu_thuc` (
  `id` int(11) NOT NULL,
  `ma_tieu_thuc` varchar(11) COLLATE utf8_unicode_ci NOT NULL,
  `ten_tieu_thuc` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `ma_cha` varchar(11) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `danh_muc_tieu_thuc`
--

INSERT INTO `danh_muc_tieu_thuc` (`id`, `ma_tieu_thuc`, `ten_tieu_thuc`, `ma_cha`) VALUES
(1, 'CD', 'Chức Danh', ''),
(2, 'CD1', 'Giám Đốc', 'CD'),
(3, 'CD2', 'Phó Giám Đốc', 'CD'),
(4, 'CD3', 'Trưởng Phòng', 'CD'),
(5, 'CD4', 'Phó Phòng', 'CD'),
(6, 'CD5', 'Nhân Viên', 'CD'),
(7, 'LHD', 'Hợp đồng lao động', ''),
(8, 'LHD1', 'Hợp đồng lao động không xác định thời hạn', 'LHD'),
(9, 'LHD2', 'Hợp đồng lao động có thời hạn', 'LHD'),
(10, 'LHD3', 'Hợp đồng lao động thời vụ', 'LHD'),
(11, 'TTNV', 'Trạng thái nhân viên', ''),
(12, 'TTNV1', 'Đang làm việc', 'TTNV'),
(13, 'TTNV2', 'Đi công tác', 'TTNV'),
(14, 'TTNV3', 'Nghỉ phép', 'TTNV'),
(15, 'TTNV4', 'Nghỉ', 'TTNV');

-- --------------------------------------------------------

--
-- Table structure for table `khach_hang`
--

CREATE TABLE `khach_hang` (
  `ma_khach_hang` varchar(11) COLLATE utf8_unicode_ci NOT NULL,
  `ten_khach_hang` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `dia_chi` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `so_dien_thoai` int(10) NOT NULL,
  `email` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `ma_so_thue` varchar(13) COLLATE utf8_unicode_ci NOT NULL,
  `so_tai_khoan` int(13) NOT NULL,
  `ghi_chu` varchar(500) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `khach_hang`
--

INSERT INTO `khach_hang` (`ma_khach_hang`, `ten_khach_hang`, `dia_chi`, `so_dien_thoai`, `email`, `ma_so_thue`, `so_tai_khoan`, `ghi_chu`) VALUES
('KH001', 'Lê Khả Duy', 'Mỹ Đình, Hà Nội', 397804698, 'lekhaduaT31@gmail.com', '', 2147483647, ''),
('KH002', 'Cty Fomosa ', 'Nha Trang, Khánh Hòa', 975661206, 'Fomosavn@gmail.com', '12345678', 2147483647, 'Đại diện: Nguyễn Minh Khoa'),
('1', '1', '1', 1, '1', '1', 1, '1'),
('1', '1', '1', 1, '1', '1', 1, '1'),
('1', '1', '1', 1, '1', '1', 1, '1'),
('1', '1', '1', 1, '1', '1', 1, '1'),
('1', '1', '1', 1, '1', '1', 1, '1'),
('gfh2', 'rrty', 'ffhg', 1234567891, 'dsffgf@gmail.com', '12345678', 201598427, '');

-- --------------------------------------------------------

--
-- Table structure for table `nhan_vien`
--

CREATE TABLE `nhan_vien` (
  `ma_nhan_vien` varchar(11) COLLATE utf8_unicode_ci NOT NULL,
  `ho_ten` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `gioi_tinh` varchar(6) COLLATE utf8_unicode_ci NOT NULL,
  `so_chung_minh_thu` int(13) NOT NULL,
  `dia_chi` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `so_dien_thoai` varchar(11) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `hinh_anh` text COLLATE utf8_unicode_ci NOT NULL,
  `ma_phong_ban` varchar(11) COLLATE utf8_unicode_ci NOT NULL,
  `ma_chuc_danh` varchar(11) COLLATE utf8_unicode_ci NOT NULL,
  `ma_loai_hop_dong` varchar(11) COLLATE utf8_unicode_ci NOT NULL,
  `ngay_bat_dau_hop_dong` date NOT NULL,
  `ngay_ket_thuc_hop_dong` date NOT NULL,
  `ma_trang_thai` varchar(11) COLLATE utf8_unicode_ci NOT NULL,
  `pass_word` varchar(16) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `nhan_vien`
--

INSERT INTO `nhan_vien` (`ma_nhan_vien`, `ho_ten`, `gioi_tinh`, `so_chung_minh_thu`, `dia_chi`, `so_dien_thoai`, `email`, `hinh_anh`, `ma_phong_ban`, `ma_chuc_danh`, `ma_loai_hop_dong`, `ngay_bat_dau_hop_dong`, `ngay_ket_thuc_hop_dong`, `ma_trang_thai`, `pass_word`) VALUES
('NV001', 'Trần Chấn', 'Nam', 2147483647, '06/13 Nguyễn Trải', '0975661206', 'aawsde2345@gmail.com', '', 'PKT', 'CD05', 'LHD02', '0000-00-00', '0000-00-00', 'TTNV03', '');

-- --------------------------------------------------------

--
-- Table structure for table `phong_ban`
--

CREATE TABLE `phong_ban` (
  `ma_phong_ban` varchar(11) COLLATE utf8_unicode_ci NOT NULL,
  `ten_phong_ban` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `phong_ban`
--

INSERT INTO `phong_ban` (`ma_phong_ban`, `ten_phong_ban`) VALUES
('fgf121', 'xcv'),
('PDA1', 'Phòng Dự Án số 1'),
('PDA2', 'Phòng Dự Án số 2'),
('PDA3', 'Phòng Dự Án số 3'),
('PGD', 'Phòng Giám Đốc'),
('PKT', 'Phòng Kế Toán'),
('PNS', 'Phòng Nhân Sự');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `danh_muc_tieu_thuc`
--
ALTER TABLE `danh_muc_tieu_thuc`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `nhan_vien`
--
ALTER TABLE `nhan_vien`
  ADD PRIMARY KEY (`ma_nhan_vien`);

--
-- Indexes for table `phong_ban`
--
ALTER TABLE `phong_ban`
  ADD PRIMARY KEY (`ma_phong_ban`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `danh_muc_tieu_thuc`
--
ALTER TABLE `danh_muc_tieu_thuc`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
