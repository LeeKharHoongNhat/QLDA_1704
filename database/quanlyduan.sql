-- phpMyAdmin SQL Dump
-- version 4.0.4.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Mar 01, 2019 at 03:44 AM
-- Server version: 5.6.11
-- PHP Version: 5.5.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `quanlyduan`
--
CREATE DATABASE IF NOT EXISTS `quanlyduan` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE `quanlyduan`;

-- --------------------------------------------------------

--
-- Table structure for table `cong_viec_du_an`
--

CREATE TABLE IF NOT EXISTS `cong_viec_du_an` (
  `ma_du_an` varchar(11) COLLATE utf8mb4_unicode_ci NOT NULL,
  `ma_cong_viec` varchar(11) COLLATE utf8mb4_unicode_ci NOT NULL,
  `noi_dung` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `ma_cha` varchar(11) COLLATE utf8mb4_unicode_ci NOT NULL,
  `ma_nhan_vien` varchar(11) COLLATE utf8mb4_unicode_ci NOT NULL,
  `ngay_bat_dau_du_kien` date NOT NULL,
  `ngay_ket_thuc_du_kien` date NOT NULL,
  `ngay_bat_dau_thuc_te` date NOT NULL,
  `ngay_ket_thuc_thuc_te` date NOT NULL,
  `ma_trang_thai` varchar(11) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `cong_viec_du_an`
--

INSERT INTO `cong_viec_du_an` (`ma_du_an`, `ma_cong_viec`, `noi_dung`, `ma_cha`, `ma_nhan_vien`, `ngay_bat_dau_du_kien`, `ngay_ket_thuc_du_kien`, `ngay_bat_dau_thuc_te`, `ngay_ket_thuc_thuc_te`, `ma_trang_thai`) VALUES
('DA001', 'CV1', 'Xây dựng database', '0', 'NV001', '2019-03-01', '2019-03-10', '2019-03-01', '2019-03-10', 'TTCV1'),
('DA001', 'CV1A', 'Lên database khách hàng', 'CV1', 'NV001', '2019-03-01', '2019-03-01', '2019-03-01', '2019-03-01', 'TTCV1');

-- --------------------------------------------------------

--
-- Table structure for table `danh_muc_du_an`
--

CREATE TABLE IF NOT EXISTS `danh_muc_du_an` (
  `ma_du_an` varchar(11) COLLATE utf8_unicode_ci NOT NULL,
  `ma_tieu_thuc` varchar(11) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `danh_muc_tieu_thuc`
--

CREATE TABLE IF NOT EXISTS `danh_muc_tieu_thuc` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ma_tieu_thuc` varchar(11) COLLATE utf8_unicode_ci NOT NULL,
  `ten_tieu_thuc` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `ma_cha` varchar(11) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=16 ;

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

CREATE TABLE IF NOT EXISTS `khach_hang` (
  `ma_khach_hang` varchar(11) COLLATE utf8_unicode_ci NOT NULL,
  `ten_khach_hang` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `dia_chi` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `sdt_khach_hang` int(10) NOT NULL,
  `email` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `ma_so_thue` varchar(13) COLLATE utf8_unicode_ci NOT NULL,
  `so_tai_khoan` int(13) NOT NULL,
  `ghi_chu` varchar(500) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `khach_hang`
--

INSERT INTO `khach_hang` (`ma_khach_hang`, `ten_khach_hang`, `dia_chi`, `sdt_khach_hang`, `email`, `ma_so_thue`, `so_tai_khoan`, `ghi_chu`) VALUES
('KH001', 'Lê Khả Duy', 'Mỹ Đình, Hà Nội', 397804698, 'lekhaduaT31@gmail.com', '', 2147483647, ''),
('KH002', 'Cty Fomosa ', 'Nha Trang, Khánh Hòa', 975661206, 'Fomosavn@gmail.com', '12345678', 2147483647, 'Đại diện: Nguyễn Minh Khoa');

-- --------------------------------------------------------

--
-- Table structure for table `nhan_vien`
--

CREATE TABLE IF NOT EXISTS `nhan_vien` (
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
  `pass_word` varchar(16) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`ma_nhan_vien`)
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

CREATE TABLE IF NOT EXISTS `phong_ban` (
  `ma_phong_ban` varchar(11) COLLATE utf8_unicode_ci NOT NULL,
  `ten_phong_ban` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`ma_phong_ban`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `phong_ban`
--

INSERT INTO `phong_ban` (`ma_phong_ban`, `ten_phong_ban`) VALUES
('PDA1', 'Phòng Dự Án số 1'),
('PDA2', 'Phòng Dự Án số 2'),
('PDA3', 'Phòng Dự Án số 3'),
('PGD', 'Phòng Giám Đốc'),
('PKT', 'Phòng Kế Toán'),
('PNS', 'Phòng Nhân Sự');

-- --------------------------------------------------------

--
-- Table structure for table `thong_tin_du_an`
--

CREATE TABLE IF NOT EXISTS `thong_tin_du_an` (
  `ma_du_an` varchar(11) COLLATE utf8mb4_unicode_ci NOT NULL,
  `ten_du_an` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `ma_khach_hang` varchar(11) COLLATE utf8mb4_unicode_ci NOT NULL,
  `ma_phong_ban` varchar(11) COLLATE utf8mb4_unicode_ci NOT NULL,
  `ma_nhan_vien_pm` varchar(11) COLLATE utf8mb4_unicode_ci NOT NULL,
  `ngay_bat_dau` date NOT NULL,
  `ngay_ket_thuc` date NOT NULL,
  `ngay_ban_giao` date NOT NULL,
  `gia_tri_hop_dong` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `da_thanh_toan` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `ma_trang_thai` varchar(11) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `thong_tin_du_an`
--

INSERT INTO `thong_tin_du_an` (`ma_du_an`, `ten_du_an`, `ma_khach_hang`, `ma_phong_ban`, `ma_nhan_vien_pm`, `ngay_bat_dau`, `ngay_ket_thuc`, `ngay_ban_giao`, `gia_tri_hop_dong`, `da_thanh_toan`, `ma_trang_thai`) VALUES
('DA001', 'Quản lý hệ thống công ty phần mềm VCL', 'KH001', 'PDA1', 'NV001', '2019-03-01', '2019-03-31', '2019-04-10', '1 000 000 USD', '250 000 USD', 'TTDA1');

-- --------------------------------------------------------

--
-- Table structure for table `tien_do_du_an`
--

CREATE TABLE IF NOT EXISTS `tien_do_du_an` (
  `ma_cong_viec` varchar(11) COLLATE utf8mb4_unicode_ci NOT NULL,
  `ma_nhan_vien` varchar(11) COLLATE utf8mb4_unicode_ci NOT NULL,
  `noi_dung` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `danh_gia_nhan_vien` int(3) NOT NULL,
  `danh_gia_pm` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `tien_do_du_an`
--

INSERT INTO `tien_do_du_an` (`ma_cong_viec`, `ma_nhan_vien`, `noi_dung`, `danh_gia_nhan_vien`, `danh_gia_pm`) VALUES
('CV1', 'NV001', 'Xây dựng toàn bộ database dự án. tiến độ đúng hạn', 10, 5),
('CV1A', 'NV001', 'xây dựng database khách hàng hoàn thành', 100, 100);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;