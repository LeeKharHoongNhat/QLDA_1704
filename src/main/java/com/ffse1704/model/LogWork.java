package com.ffse1704.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "task_logwork")
public class LogWork {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "ma_du_an", unique = true, nullable = false)
	@NotEmpty(message = "không được để trống!")
	private String maDuAn;

	@Column(name = "ma_cong_viec", unique = true, nullable = false)
	@NotEmpty(message = "không được để trống!")
	private String maCongViec;

	@Column(name = "noi_dung", nullable = false)
	@NotEmpty(message = "không được để trống!")
	private String noiDung;

	@Column(name = "ma_nhan_vien", nullable = false)
	@NotEmpty(message = "không được để trống!")
	private String maNhanVien;

	@Column(name = "thoi_gian")
	@NotEmpty(message = "không được để trống!")
	private Integer thoiGian;

	@Transient
	private ThongTinDuAn duAn;

	@Transient
	private CongViecDuAn congViec;

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

	public Integer getThoiGian() {
		return thoiGian;
	}

	public void setThoiGian(Integer thoiGian) {
		this.thoiGian = thoiGian;
	}

	public ThongTinDuAn getDuAn() {
		return duAn;
	}

	public void setDuAn(ThongTinDuAn duAn) {
		this.duAn = duAn;
	}

	public CongViecDuAn getCongViec() {
		return congViec;
	}

	public void setCongViec(CongViecDuAn congViec) {
		this.congViec = congViec;
	}

	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}

}
