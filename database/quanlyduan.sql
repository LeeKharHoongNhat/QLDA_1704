-- phpMyAdmin SQL Dump
-- version 4.0.4.1
-- http://www.phpmyadmin.net
--
-- Client: 127.0.0.1
-- Généré le: Jeu 28 Février 2019 à 13:52
-- Version du serveur: 5.6.11
-- Version de PHP: 5.5.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données: `quanlyduan`
--
CREATE DATABASE IF NOT EXISTS `quanlyduan` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE `quanlyduan`;

-- --------------------------------------------------------

--
-- Structure de la table `danh_muc_du_an`
--

CREATE TABLE IF NOT EXISTS `danh_muc_du_an` (
  `ma_du_an` varchar(11) COLLATE utf8_unicode_ci NOT NULL,
  `ma_tieu_thuc` varchar(11) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Structure de la table `danh_muc_tieu_thuc`
--

CREATE TABLE IF NOT EXISTS `danh_muc_tieu_thuc` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ma_tieu_thuc` varchar(11) COLLATE utf8_unicode_ci NOT NULL,
  `ten_tieu_thuc` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `ma_cha` varchar(11) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=16 ;

--
-- Contenu de la table `danh_muc_tieu_thuc`
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
-- Structure de la table `khach_hang`
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
-- Contenu de la table `khach_hang`
--

INSERT INTO `khach_hang` (`ma_khach_hang`, `ten_khach_hang`, `dia_chi`, `sdt_khach_hang`, `email`, `ma_so_thue`, `so_tai_khoan`, `ghi_chu`) VALUES
('KH001', 'Lê Khả Duy', 'Mỹ Đình, Hà Nội', 397804698, 'lekhaduaT31@gmail.com', '', 2147483647, ''),
('KH002', 'Cty Fomosa ', 'Nha Trang, Khánh Hòa', 975661206, 'Fomosavn@gmail.com', '12345678', 2147483647, 'Đại diện: Nguyễn Minh Khoa');

-- --------------------------------------------------------

--
-- Structure de la table `nhan_vien`
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
-- Contenu de la table `nhan_vien`
--

INSERT INTO `nhan_vien` (`ma_nhan_vien`, `ho_ten`, `gioi_tinh`, `so_chung_minh_thu`, `dia_chi`, `so_dien_thoai`, `email`, `hinh_anh`, `ma_phong_ban`, `ma_chuc_danh`, `ma_loai_hop_dong`, `ngay_bat_dau_hop_dong`, `ngay_ket_thuc_hop_dong`, `ma_trang_thai`, `pass_word`) VALUES
('NV001', 'Trần Chấn', 'Nam', 2147483647, '06/13 Nguyễn Trải', '0975661206', 'aawsde2345@gmail.com', '', 'PKT', 'CD05', 'LHD02', '0000-00-00', '0000-00-00', 'TTNV03', '');

-- --------------------------------------------------------

--
-- Structure de la table `phong_ban`
--

CREATE TABLE IF NOT EXISTS `phong_ban` (
  `ma_phong_ban` varchar(11) COLLATE utf8_unicode_ci NOT NULL,
  `ten_phong_ban` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`ma_phong_ban`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Contenu de la table `phong_ban`
--

INSERT INTO `phong_ban` (`ma_phong_ban`, `ten_phong_ban`) VALUES
('PDA1', 'Phòng Dự Án số 1'),
('PDA2', 'Phòng Dự Án số 2'),
('PDA3', 'Phòng Dự Án số 3'),
('PGD', 'Phòng Giám Đốc'),
('PKT', 'Phòng Kế Toán'),
('PNS', 'Phòng Nhân Sự');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
