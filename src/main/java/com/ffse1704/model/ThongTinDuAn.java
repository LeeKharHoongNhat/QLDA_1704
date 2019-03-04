package com.ffse1704.model;

import java.io.Serializable;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "thong_tin_du_an")
public class ThongTinDuAn implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ma_du_an", unique = true, nullable = false)
	@NotEmpty(message = "không được để trống!")
	private String maDuAn;
	
	@OneToMany(mappedBy = "thongTinDuAn", fetch = FetchType.EAGER)
	private List<DanhMucDuAn> listDanhMucDuAn;
	
	

	@NotEmpty(message = "Vui Lòng Nhập tên dự án")
	@Column(name = "ten_du_an", nullable = false)
	private String tenDuAn;

	@Column(name = "ma_khach_hang", nullable = false)
	private String maKhachHang;

	@Column(name = "ma_phong_ban", nullable = false)
	private String maPhongBan;
	

	@Column(name = "ma_nhan_vien_pm", nullable = false)
	private String maNhanVienPM;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "ngay_bat_dau")
	@NotNull(message = "Vui Lòng Nhập ngày")
	private Date ngayBatDau;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "ngay_ket_thuc")
	@NotNull(message = "Vui Lòng Nhập ngày")
	private Date ngayKetThuc;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "ngay_ban_giao")
	@NotNull(message = "Vui Lòng Nhập ngày")
	private Date ngayBanGiao;

	@Column(name = "gia_tri_hop_dong", nullable = false)
	private String giaTriHopDong;

	@Column(name = "da_thanh_toan", nullable = false)
	private String daThanhToan;

	@Column(name = "ma_trang_thai", nullable = false)
	private String maTrangThai;

	public String getMaDuAn() {
		return maDuAn;
	}

	public void setMaDuAn(String maDuAn) {
		this.maDuAn = maDuAn;
	}

	public String getTenDuAn() {
		return tenDuAn;
	}

	public void setTenDuAn(String tenDuAn) {
		this.tenDuAn = tenDuAn;
	}

	public String getMaKhachHang() {
		return maKhachHang;
	}

	public void setMaKhachHang(String maKhachHang) {
		this.maKhachHang = maKhachHang;
	}

	public String getMaPhongBan() {
		return maPhongBan;
	}

	public void setMaPhongBan(String maPhongBan) {
		this.maPhongBan = maPhongBan;
	}

	public String getMaNhanVienPM() {
		return maNhanVienPM;
	}

	public void setMaNhanVienPM(String maNhanVienPM) {
		this.maNhanVienPM = maNhanVienPM;
	}

	public Date getNgayBatDau() {
		return ngayBatDau;
	}

	public void setNgayBatDau(Date ngayBatDau) {
		this.ngayBatDau = ngayBatDau;
	}

	public Date getNgayKetThuc() {
		return ngayKetThuc;
	}

	public void setNgayKetThuc(Date ngayKetThuc) {
		this.ngayKetThuc = ngayKetThuc;
	}

	public Date getNgayBanGiao() {
		return ngayBanGiao;
	}

	public void setNgayBanGiao(Date ngayBanGiao) {
		this.ngayBanGiao = ngayBanGiao;
	}

	public String getGiaTriHopDong() {
		return giaTriHopDong;
	}

	public void setGiaTriHopDong(String giaTriHopDong) {
		this.giaTriHopDong = giaTriHopDong;
	}

	public String getDaThanhToan() {
		return daThanhToan;
	}

	public void setDaThanhToan(String daThanhToan) {
		this.daThanhToan = daThanhToan;
	}

	public String getMaTrangThai() {
		return maTrangThai;
	}

	public void setMaTrangThai(String maTrangThai) {
		this.maTrangThai = maTrangThai;
	}


	public List<DanhMucDuAn> getListDanhMucDuAn() {
		return listDanhMucDuAn;
	}

	public void setListDanhMucDuAn(List<DanhMucDuAn> listDanhMucDuAn) {
		this.listDanhMucDuAn = listDanhMucDuAn;
	}
}
