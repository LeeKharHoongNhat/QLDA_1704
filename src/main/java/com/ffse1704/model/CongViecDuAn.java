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
@Table(name = "cong_viec_du_an")
public class CongViecDuAn implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id")
	private int id;
	
	
	@Column(name = "ma_du_an", unique = true, nullable = false)
	@NotEmpty(message = "không được để trống!")
	private String maDuAn;
	
	
	@Column(name = "ma_cong_viec", unique = true, nullable = false)
	@NotEmpty(message = "không được để trống!")
	private String maCongViec;
	
	@Column(name = "noi_dung", nullable = false)
	private String noiDung;
	
	@Column(name = "ma_cha", nullable = false)
	private String maCha;
	
	@Column(name = "ma_nhan_vien", nullable = false)
	private String maNhanVien;
	
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "ngay_bat_dau_du_kien")
	@NotNull(message = "Vui Lòng Nhập ngày")
	private Date ngayBatDauDuKien;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "ngay_ket_thuc_du_kien")
	@NotNull(message = "Vui Lòng Nhập ngày")
	private Date ngayKetThucDuKien;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "ngay_bat_dau_thuc_te")
	@NotNull(message = "Vui Lòng Nhập ngày")
	private Date ngayBatDauThucTe;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "ngay_ket_thuc_thuc_te")
	@NotNull(message = "Vui Lòng Nhập ngày")
	private Date ngayKetThucThucTe;
	
	@Column(name = "ma_trang_thai", nullable = false)
	private String maTrangThai;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMaDuAn() {
		return maDuAn;
	}

	public void setMaDuAn(String maDuAn) {
		this.maDuAn = maDuAn;
	}

	public String getMaCongViec() {
		return maCongViec;
	}

	public void setMaCongViec(String maCongViec) {
		this.maCongViec = maCongViec;
	}

	public String getNoiDung() {
		return noiDung;
	}

	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}

	public String getMaCha() {
		return maCha;
	}

	public void setMaCha(String maCha) {
		this.maCha = maCha;
	}

	public String getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}

	public Date getNgayBatDauDuKien() {
		return ngayBatDauDuKien;
	}

	public void setNgayBatDauDuKien(Date ngayBatDauDuKien) {
		this.ngayBatDauDuKien = ngayBatDauDuKien;
	}

	public Date getNgayKetThucDuKien() {
		return ngayKetThucDuKien;
	}

	public void setNgayKetThucDuKien(Date ngayKetThucDuKien) {
		this.ngayKetThucDuKien = ngayKetThucDuKien;
	}

	public Date getNgayBatDauThucTe() {
		return ngayBatDauThucTe;
	}

	public void setNgayBatDauThucTe(Date ngayBatDauThucTe) {
		this.ngayBatDauThucTe = ngayBatDauThucTe;
	}

	public Date getNgayKetThucThucTe() {
		return ngayKetThucThucTe;
	}

	public void setNgayKetThucThucTe(Date ngayKetThucThucTe) {
		this.ngayKetThucThucTe = ngayKetThucThucTe;
	}

	public String getMaTrangThai() {
		return maTrangThai;
	}

	public void setMaTrangThai(String maTrangThai) {
		this.maTrangThai = maTrangThai;
	}
}
