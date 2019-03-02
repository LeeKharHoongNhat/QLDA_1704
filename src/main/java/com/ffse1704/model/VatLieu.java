package com.ffse1704.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "vat_lieu")
public class VatLieu implements Serializable {
	private static final long serialVersionUID = 1L;

	public VatLieu() {

	}

	@Id
	@Column(name = "ma_cong_viec", unique = true, nullable = false, length = 30)
	@NotEmpty(message = "không được để trống!")
	private String maCongViec;

	@Column(name = "so_luong", nullable = false)
	@NotEmpty(message = "không được để trống!")
	public String soLuong;

	@Column(name = "don_gia", nullable = false, length = 255)
	@NotEmpty(message = "không được để trống!")
	public String donGia;

	@Column(name = "chi_phi", nullable = false, length = 255)
	@NotEmpty(message = "không được để trống!")
	public String chiPhi;

	public String getMaCongViec() {
		return maCongViec;
	}

	public void setMaCongViec(String maCongViec) {
		this.maCongViec = maCongViec;
	}

	public String getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(String soLuong) {
		this.soLuong = soLuong;
	}

	public String getDonGia() {
		return donGia;
	}

	public void setDonGia(String donGia) {
		this.donGia = donGia;
	}

	public String getChiPhi() {
		return chiPhi;
	}

	public void setChiPhi(String chiPhi) {
		this.chiPhi = chiPhi;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	public int getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}

	@Column(name = "ghi_chu", nullable = false)
	@NotEmpty(message = "không được để trống!")
	public String ghiChu;

	@Column(name = "is_delete")
	private int isDelete;

}
