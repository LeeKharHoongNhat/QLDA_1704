package com.ffse1704.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "nhan_cong")
public class NhanCong implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ma_cong_viec", unique = true, nullable = false, length = 30)
	@NotEmpty(message = "không được để trống!")
	private String maCongViec;

	@Column(name = "ma_nhan_vien", nullable = false, length = 255)
	@NotEmpty(message = "không được để trống!")
	public String maNhanVien;

	@Column(name = "ma_du_an", nullable = false, length = 255)
	@NotEmpty(message = "không được để trống!")
	public String maDuAn;

	public String getMaDuAn() {
		return maDuAn;
	}

	public void setMaDuAn(String maDuAn) {
		this.maDuAn = maDuAn;
	}

	public int getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}

	@Column(name = "is_delete")
	private int isDelete;

	public NhanCong() {

	}

	public String getMaCongViec() {
		return maCongViec;
	}

	public void setMaCongViec(String maCongViec) {
		this.maCongViec = maCongViec;
	}

	public String getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}

	public String getNoiDung() {
		return noiDung;
	}

	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}

	public Date getThoiGianBatDau() {
		return thoiGianBatDau;
	}

	public void setThoiGianBatDau(Date thoiGianBatDau) {
		this.thoiGianBatDau = thoiGianBatDau;
	}

	public Date getThoiGianKetThuc() {
		return thoiGianKetThuc;
	}

	public void setThoiGianKetThuc(Date thoiGianKetThuc) {
		this.thoiGianKetThuc = thoiGianKetThuc;
	}

	public Long getChiPhi() {
		return chiPhi;
	}

	public void setChiPhi(Long chiPhi) {
		this.chiPhi = chiPhi;
	}

	@Column(name = "noi_dung", nullable = false, length = 255)
	@NotEmpty(message = "không được để trống!")
	public String noiDung;

	@Column(name = "thoi_gian_bat_dau")
	@NotNull(message = "Vui Lòng Chọn Ngày")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date thoiGianBatDau;

	@Column(name = "thoi_gian_ket_thuc")
	@NotNull(message = "Vui Lòng Chọn Ngày")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date thoiGianKetThuc;

	@Column(name = "chi_phi", nullable = false, length = 255)
	@NotNull(message = "không được để trống!")
	public Long chiPhi;

}