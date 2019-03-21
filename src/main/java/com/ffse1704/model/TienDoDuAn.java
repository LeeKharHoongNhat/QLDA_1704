package com.ffse1704.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "tien_do_du_an")
public class TienDoDuAn implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Id
	@Column(name = "ma_du_an", unique = true, nullable = false)
	@NotEmpty(message = "không được để trống!")
	private String maDuAn;

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

	
	@Transient
	private ThongTinDuAn thongTinDuAn;
	@Transient
	private CongViecDuAn congViecDuAn;
	@Transient
	private NhanVien nhanVien;
	
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

	public ThongTinDuAn getThongTinDuAn() {
		return thongTinDuAn;
	}

	public void setThongTinDuAn(ThongTinDuAn thongTinDuAn) {
		this.thongTinDuAn = thongTinDuAn;
	}

	public CongViecDuAn getCongViecDuAn() {
		return congViecDuAn;
	}

	public void setCongViecDuAn(CongViecDuAn congViecDuAn) {
		this.congViecDuAn = congViecDuAn;
	}

	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}
}
