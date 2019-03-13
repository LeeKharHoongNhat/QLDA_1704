package com.ffse1704.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "nhat_ky_cong_viec")
public class NhatKyCongViec implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "ma_du_an")
	@NotNull(message ="không được để trống!")
	private String maDuAn;

	@Column(name = "ma_nhan_vien")
	@NotNull(message ="không được để trống!")
	private String maNhanVien;


	@Column(name = "noi_dung")
	@NotNull(message ="không được để trống!")
	private String noiDung;

	@Column(name = "thoi_gian_dang_tai")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message ="Vui Lòng Chọn Ngày!")
	private String thoiGianDangTai;
	
	@Column(name = "IsActive")
	private int isActive = 1;
	
	@ManyToOne
    @JoinColumn(name = "ma_nhan_vien", referencedColumnName = "ma_nhan_vien", nullable = false, insertable = false, updatable = false)
    private NhanVien nhanVien;
	
	@ManyToOne
    @JoinColumn(name = "ma_du_an", referencedColumnName = "ma_du_an", nullable = false, insertable = false, updatable = false)
    private ThongTinDuAn thongTinDuAn;

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

	public String getThoiGianDangTai() {
		return thoiGianDangTai;
	}

	public void setThoiGianDangTai(String thoiGianDangTai) {
		this.thoiGianDangTai = thoiGianDangTai;
	}

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}

	public ThongTinDuAn getThongTinDuAn() {
		return thongTinDuAn;
	}

	public void setThongTinDuAn(ThongTinDuAn thongTinDuAn) {
		this.thongTinDuAn = thongTinDuAn;
	}




}
