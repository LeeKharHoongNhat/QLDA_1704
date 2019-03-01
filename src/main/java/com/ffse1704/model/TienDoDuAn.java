package com.ffse1704.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "tien_do_du_an")
public class TienDoDuAn implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ma_cong_viec", unique = true, nullable = false)
	@NotEmpty(message = "không được để trống!")
	private String maCongViec;

	@Column(name = "ma_nhan_vien", nullable = false)
	private String maNhanVien;

	@Column(name = "noi_dung", nullable = false)
	private String noiDung;

	@Column(name = "danh_gia_nhan_vien", nullable = false)
	private String danhGiaNhanVien;

	@Column(name = "danh_gia_pm", nullable = false)
	private String danhGiaPM;

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

	public String getDanhGiaNhanVien() {
		return danhGiaNhanVien;
	}

	public void setDanhGiaNhanVien(String danhGiaNhanVien) {
		this.danhGiaNhanVien = danhGiaNhanVien;
	}

	public String getDanhGiaPM() {
		return danhGiaPM;
	}

	public void setDanhGiaPM(String danhGiaPM) {
		this.danhGiaPM = danhGiaPM;
	}
}
