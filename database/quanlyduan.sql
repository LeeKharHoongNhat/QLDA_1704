-- phpMyAdmin SQL Dump
-- version 4.0.4.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Mar 21, 2019 at 02:08 PM
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
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ma_du_an` varchar(11) COLLATE utf8mb4_unicode_ci NOT NULL,
  `ma_cong_viec` varchar(11) COLLATE utf8mb4_unicode_ci NOT NULL,
  `noi_dung` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `ma_nhan_vien` varchar(11) COLLATE utf8mb4_unicode_ci NOT NULL,
  `thoi_gian_mo` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `thoi_gian_dong` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `ma_trang_thai` varchar(11) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci AUTO_INCREMENT=2 ;

--
-- Dumping data for table `cong_viec_du_an`
--

INSERT INTO `cong_viec_du_an` (`id`, `ma_du_an`, `ma_cong_viec`, `noi_dung`, `ma_nhan_vien`, `thoi_gian_mo`, `thoi_gian_dong`, `ma_trang_thai`) VALUES
(1, 'DA001', 'CV1', 'Xây dựng database', 'NV001', '2019-02-28 19:00:00', '2019-03-01 05:00:00', 'Open');

-- --------------------------------------------------------

--
-- Table structure for table `danh_muc_du_an`
--

CREATE TABLE IF NOT EXISTS `danh_muc_du_an` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ma_du_an` varchar(11) COLLATE utf8mb4_unicode_ci NOT NULL,
  `ma_tieu_thuc` varchar(11) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci AUTO_INCREMENT=3 ;

--
-- Dumping data for table `danh_muc_du_an`
--

INSERT INTO `danh_muc_du_an` (`id`, `ma_du_an`, `ma_tieu_thuc`) VALUES
(1, 'DA001', 'CD'),
(2, 'DA001', 'CD1');

-- --------------------------------------------------------

--
-- Table structure for table `danh_muc_tieu_thuc`
--

CREATE TABLE IF NOT EXISTS `danh_muc_tieu_thuc` (
  `ma_tieu_thuc` varchar(11) COLLATE utf8_unicode_ci NOT NULL,
  `ten_tieu_thuc` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `ma_cha` varchar(11) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`ma_tieu_thuc`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `danh_muc_tieu_thuc`
--

INSERT INTO `danh_muc_tieu_thuc` (`ma_tieu_thuc`, `ten_tieu_thuc`, `ma_cha`) VALUES
('CD', 'Chức Danh', ''),
('CD1', 'Giám Đốc', 'CD'),
('CD2', 'Phó Giám Đốc', 'CD'),
('CD3', 'Trưởng Phòng', 'CD'),
('CD4', 'Phó Phòng', 'CD'),
('CD5', 'Nhân Viên', 'CD'),
('LHD', 'Hợp đồng lao động', ''),
('LHD1', 'Hợp đồng lao động không xác định thời hạn', 'LHD'),
('LHD2', 'Hợp đồng lao động có thời hạn', 'LHD'),
('LHD3', 'Hợp đồng lao động thời vụ', 'LHD'),
('TTDA', 'Trạng thái dự án', ''),
('TTDA1', 'Đang triển khai', 'TTDA'),
('TTDA2', 'Test', 'TTDA'),
('TTDA3', 'Chờ bàn giao', 'TTDA'),
('TTDA4', 'Đã bàn giao', 'TTDA'),
('TTNV', 'Trạng thái nhân viên', ''),
('TTNV1', 'Đang làm việc', 'TTNV'),
('TTNV2', 'Đi công tác', 'TTNV'),
('TTNV3', 'Nghỉ phép', 'TTNV'),
('TTNV4', 'Nghỉ', 'TTNV'),
('TTPB', 'Trạng thái phòng ban', ''),
('TTPB1', 'Hoạt động', 'TTPB'),
('TTPB2', 'Nghỉ', 'TTPB');

-- --------------------------------------------------------

--
-- Table structure for table `khach_hang`
--

CREATE TABLE IF NOT EXISTS `khach_hang` (
  `ma_khach_hang` varchar(11) COLLATE utf8_unicode_ci NOT NULL,
  `ten_khach_hang` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `dia_chi` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `so_dien_thoai` int(10) NOT NULL,
  `email` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `ma_so_thue` varchar(13) COLLATE utf8_unicode_ci NOT NULL,
  `so_tai_khoan` int(13) NOT NULL,
  `ghi_chu` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `khach_hang`
--

INSERT INTO `khach_hang` (`ma_khach_hang`, `ten_khach_hang`, `dia_chi`, `so_dien_thoai`, `email`, `ma_so_thue`, `so_tai_khoan`, `ghi_chu`) VALUES
('KH001', 'Lê Khả Duy', 'Mỹ Đình, Hà Nội', 397804698, 'lekhaduaT31@gmail.com', '', 2147483647, ''),
('KH002', 'Cty Fomosa ', 'Nha Trang, Khánh Hòa', 975661206, 'Fomosavn@gmail.com', '12345678', 2147483647, 'Đại diện: Nguyễn Minh Khoa'),
('KH003', 'Lê Khả Hồng Nhật', 'Thanh Hóa', 978987678, 'lekhahongnhatzp1998@gmail.com', '343433444', 123423422, NULL);

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
('NV001', 'Trần Chấn', 'Nam', 2147483647, '06/13 Nguyễn Trải', '0975661206', 'aawsde2345@gmail.com', 'adsfh.jpg', 'PKT', 'CD5', 'LHD2', '2019-03-01', '2019-07-31', 'TTNV3', '123456'),
('NV002', 'Phan Phạm Quang Đại', 'Nam', 145879645, '113 Ngô Quyền, Đà Nẵng', '0975489562', 'ppqd1123@gmail.com', 'abcd.jpg', 'PDA1', 'CD5', 'LHD1', '2019-03-01', '2019-03-31', 'TTNV1', '123456');

-- --------------------------------------------------------

--
-- Table structure for table `nhan_vien_du_an`
--

CREATE TABLE IF NOT EXISTS `nhan_vien_du_an` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ma_du_an` varchar(11) COLLATE utf8mb4_unicode_ci NOT NULL,
  `ma_nhan_vien` varchar(11) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci AUTO_INCREMENT=3 ;

--
-- Dumping data for table `nhan_vien_du_an`
--

INSERT INTO `nhan_vien_du_an` (`id`, `ma_du_an`, `ma_nhan_vien`) VALUES
(1, 'DA001', 'NV001'),
(2, 'DA001', 'NV002');

-- --------------------------------------------------------

--
-- Table structure for table `nhat_ky_cong_viec`
--

CREATE TABLE IF NOT EXISTS `nhat_ky_cong_viec` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ma_du_an` varchar(11) COLLATE utf8mb4_unicode_ci NOT NULL,
  `ma_nhan_vien` varchar(11) COLLATE utf8mb4_unicode_ci NOT NULL,
  `noi_dung` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `thoi_gian_dang_tai` datetime NOT NULL,
  `IsActive` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci AUTO_INCREMENT=4 ;

--
-- Dumping data for table `nhat_ky_cong_viec`
--

INSERT INTO `nhat_ky_cong_viec` (`id`, `ma_du_an`, `ma_nhan_vien`, `noi_dung`, `thoi_gian_dang_tai`, `IsActive`) VALUES
(1, 'DA001', 'NV001', 'ADSA', '2019-03-13 00:00:00', 1),
(2, 'DA001', 'NV002', 'cccc', '2019-03-26 00:00:00', 1),
(3, 'DA001', 'NV002', 'aaaaa', '2019-03-13 00:00:00', 1);

-- --------------------------------------------------------

--
-- Table structure for table `phong_ban`
--

CREATE TABLE IF NOT EXISTS `phong_ban` (
  `ma_phong_ban` varchar(11) COLLATE utf8_unicode_ci NOT NULL,
  `ten_phong_ban` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `trang_thai` varchar(11) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`ma_phong_ban`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `phong_ban`
--

INSERT INTO `phong_ban` (`ma_phong_ban`, `ten_phong_ban`, `trang_thai`) VALUES
('PDA1', 'Phòng Dự Án số 1', 'TTPB1'),
('PDA2', 'Phòng Dự Án số 2', 'TTPB1'),
('PDA3', 'Phòng Dự Án số 3', 'TTPB1'),
('PGD', 'Phòng Giám Đốc', 'TTPB1'),
('PKT', 'Phòng Kế Toán', 'TTPB1'),
('PNS', 'Phòng Nhân Sự', 'TTPB1'),
('PT001', 'Test01', 'TTPB2');

-- --------------------------------------------------------

--
-- Table structure for table `task_logwork`
--

CREATE TABLE IF NOT EXISTS `task_logwork` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ma_du_an` varchar(11) COLLATE utf8mb4_unicode_ci NOT NULL,
  `ma_cong_viec` varchar(11) COLLATE utf8mb4_unicode_ci NOT NULL,
  `noi_dung` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `ma_nhan_vien` varchar(11) COLLATE utf8mb4_unicode_ci NOT NULL,
  `thoi_gian` int(2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci AUTO_INCREMENT=3 ;

--
-- Dumping data for table `task_logwork`
--

INSERT INTO `task_logwork` (`id`, `ma_du_an`, `ma_cong_viec`, `noi_dung`, `ma_nhan_vien`, `thoi_gian`) VALUES
(1, 'DA001', 'CV1', 'Xây dựng database khách hàng', 'NV001', 2),
(2, 'DA001', 'CV1', 'xây dựng database nhân viên', 'NV001', 2);

-- --------------------------------------------------------

--
-- Table structure for table `thiet_bi`
--

CREATE TABLE IF NOT EXISTS `thiet_bi` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ma_cong_viec` varchar(11) COLLATE utf8mb4_unicode_ci NOT NULL,
  `ten_thiet_bi` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `thoi_gian_bat_dau_thue_muon` datetime NOT NULL,
  `thoi_gian_ket_thuc_thue_muon` datetime NOT NULL,
  `ghi_chu` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `don_gia` double NOT NULL,
  `chi_phi` double NOT NULL,
  `IsActive` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci AUTO_INCREMENT=5 ;

--
-- Dumping data for table `thiet_bi`
--

INSERT INTO `thiet_bi` (`id`, `ma_cong_viec`, `ten_thiet_bi`, `thoi_gian_bat_dau_thue_muon`, `thoi_gian_ket_thuc_thue_muon`, `ghi_chu`, `don_gia`, `chi_phi`, `IsActive`) VALUES
(1, 'CV1', 'A', '2019-03-06 00:00:00', '2019-03-22 00:00:00', 'TESTTTTTTTTTT', 1000, 1000, 0),
(2, 'CV1', 'B', '2019-03-26 00:00:00', '2019-03-27 00:00:00', 'TESTTTTT', 2000, 2000, 1),
(3, 'CV1', 'C', '2019-03-27 00:00:00', '2019-03-14 00:00:00', 'TESTTTTTTTTT', 2000, 2000, 1),
(4, 'CV1', 'D', '2019-03-22 00:00:00', '2019-03-23 00:00:00', 'TESTTTTTTTTT', 2000, 2000, 1);

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
('DA001', 'Quản lý hệ thống công ty phần mềm VCL', 'KH001', 'PDA1', 'NV001', '2019-03-01', '2019-03-31', '2019-04-10', '1 000 000 USD', '250 000 USD', 'TTDA1'),
('DA002', 'Fasttrack SE', 'KH001', 'PDA2', 'NV001', '2019-03-01', '2019-03-15', '2019-03-30', '10', '1', 'TTDA2'),
('DA003', 'ABC Combat', 'KH001', 'PDA3', 'NV001', '2019-03-07', '2019-03-14', '2019-03-30', '100', '10', 'TTDA3'),
('DA004', 'Pubg Mobile', 'KH001', 'PDA1', 'NV001', '2019-03-01', '2019-03-27', '2019-03-31', '1000', '100', 'TTDA4');

-- --------------------------------------------------------

--
-- Table structure for table `tien_do_du_an`
--

CREATE TABLE IF NOT EXISTS `tien_do_du_an` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ma_du_an` varchar(11) COLLATE utf8mb4_unicode_ci NOT NULL,
  `ma_cong_viec` varchar(11) COLLATE utf8mb4_unicode_ci NOT NULL,
  `ma_nhan_vien` varchar(11) COLLATE utf8mb4_unicode_ci NOT NULL,
  `noi_dung` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `danh_gia_nhan_vien` int(3) NOT NULL,
  `danh_gia_pm` int(3) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci AUTO_INCREMENT=3 ;

--
-- Dumping data for table `tien_do_du_an`
--

INSERT INTO `tien_do_du_an` (`id`, `ma_du_an`, `ma_cong_viec`, `ma_nhan_vien`, `noi_dung`, `danh_gia_nhan_vien`, `danh_gia_pm`) VALUES
(1, 'DA001', 'CV1', 'NV001', 'Xây dựng toàn bộ database dự án. tiến độ đúng hạn', 10, 5),
(2, 'DA001', 'CV1A', 'NV001', 'xây dựng database khách hàng hoàn thành', 100, 100);

-- --------------------------------------------------------

--
-- Table structure for table `vat_lieu`
--

CREATE TABLE IF NOT EXISTS `vat_lieu` (
  `ma_cong_viec` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `so_luong` int(5) NOT NULL,
  `don_gia` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `chi_phi` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `ghi_chu` text COLLATE utf8_unicode_ci NOT NULL,
  `is_delete` tinyint(4) NOT NULL,
  PRIMARY KEY (`ma_cong_viec`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `vat_lieu`
--

INSERT INTO `vat_lieu` (`ma_cong_viec`, `so_luong`, `don_gia`, `chi_phi`, `ghi_chu`, `is_delete`) VALUES
('CV01', 10, '2555', '255000', '1 tuần', 1),
('CV02', 2, '200', '2000', 'JJJ', 0),
('CV03', 2, '2000', '20000', 'TEXT', 0),
('CV04', 2, '2000', '6000', 'ee', 0),
('CV05', 2, '2000', '4000', 'HHMM', 0);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
