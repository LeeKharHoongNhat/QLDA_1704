package com.ffse1704.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "cong_viec_du_an")
public class CongViecDuAn implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	
	@Column(name = "ma_du_an", unique = true, nullable = false)
	@NotEmpty(message = "không được để trống!")
	private String maDuAn;
	
	@Id
	@Column(name = "ma_cong_viec", unique = true, nullable = false)
	@NotEmpty(message = "không được để trống!")
	private String maCongViec;
	
	@Column(name = "noi_dung", nullable = false)
	@NotEmpty(message = "không được để trống!")
	private String noiDung;
	

	
	@Column(name = "ma_nhan_vien", nullable = false)
	@NotEmpty(message = "không được để trống!")
	private String maNhanVien;
	
	@Column(name = "thoi_gian_mo")
	@NotNull(message = "Vui Lòng Nhập ngày")
	private Timestamp thoiGianMo;

	@Column(name = "thoi_gian_dong")
	@NotNull(message = "Vui Lòng Nhập ngày")
	private Timestamp thoiGianDong;
	
	@Column(name = "ma_trang_thai", nullable = false)
	private String maTrangThai;

	@Transient
	private ThongTinDuAn duAn;
	
	@Transient
	private NhanVien nhanVien;
	
	
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


	public String getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}


	

	public Timestamp getThoiGianMo() {
		return thoiGianMo;
	}

	public void setThoiGianMo(Timestamp thoiGianMo) {
		this.thoiGianMo = thoiGianMo;
	}

	public Timestamp getThoiGianDong() {
		return thoiGianDong;
	}

	public void setThoiGianDong(Timestamp thoiGianDong) {
		this.thoiGianDong = thoiGianDong;
	}

	public String getMaTrangThai() {
		return maTrangThai;
	}

	public void setMaTrangThai(String maTrangThai) {
		this.maTrangThai = maTrangThai;
	}
	
	public ThongTinDuAn getDuAn() {
		return duAn;
	}

	public void setDuAn(ThongTinDuAn duAn) {
		this.duAn = duAn;
	}

	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}

	public enum TrangThai{
		Open,Inprocess,Pending,Close;
	}
}
