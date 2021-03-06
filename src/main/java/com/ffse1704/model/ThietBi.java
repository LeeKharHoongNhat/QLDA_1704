package com.ffse1704.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "thiet_bi")
public class ThietBi implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "ma_du_an")
	private String maDuAn;

	@Column(name = "ten_thiet_bi")
	@NotEmpty(message = "không được để trống!")
	private String tenThietBi;

	@Column(name = "thoi_gian_bat_dau_thue_muon")
	@NotNull(message = "Vui Lòng Chọn Ngày")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date thoiGianBatDauThueMuon;

	@Column(name = "thoi_gian_ket_thuc_thue_muon")
	@NotNull(message = "Vui Lòng Chọn Ngày")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date thoiGianKetThucThueMuon;

	@Column(name = "ghi_chu")
	@NotEmpty(message = "không được để trống!")
	private String ghiChu;

	@Column(name = "don_gia")
	@NotNull(message = "không được để trống!")
	private Double donGia;

	@Column(name = "chi_phi")
	@NotNull(message = "không được để trống!")
	private Double chiPhi;

	@Column(name = "IsActive")
	private int isActive = 1;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMaDuAn() {
		return maDuAn;
	}

	public void setMaDuAn(String maDuAn) {
		this.maDuAn = maDuAn;
	}

	public String getTenThietBi() {
		return tenThietBi;
	}

	public void setTenThietBi(String tenThietBi) {
		this.tenThietBi = tenThietBi;
	}

	public Date getThoiGianBatDauThueMuon() {
		return thoiGianBatDauThueMuon;
	}

	public void setThoiGianBatDauThueMuon(Date thoiGianBatDauThueMuon) {
		this.thoiGianBatDauThueMuon = thoiGianBatDauThueMuon;
	}

	public Date getThoiGianKetThucThueMuon() {
		return thoiGianKetThucThueMuon;
	}

	public void setThoiGianKetThucThueMuon(Date thoiGianKetThucThueMuon) {
		this.thoiGianKetThucThueMuon = thoiGianKetThucThueMuon;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	public Double getDonGia() {
		return donGia;
	}

	public void setDonGia(Double donGia) {
		this.donGia = donGia;
	}

	public Double getChiPhi() {
		return chiPhi;
	}

	public void setChiPhi(Double chiPhi) {
		this.chiPhi = chiPhi;
	}

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}
}
