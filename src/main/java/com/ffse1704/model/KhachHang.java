/**
 * 
 */
package com.ffse1704.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

/**
 * @author QuangDai
 *
 */
@Entity
@Table(name = "khach_hang")
public class KhachHang implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ma_khach_hang", unique = true, nullable = false, length = 11)
	@NotEmpty(message = "Không được để trống!")
	private String maKhachHang;
	
	
	@NotEmpty(message = "Vui lòng nhập tên khách hàng")
	@Column(name = "ten_khach_hang", nullable = false, length = 50)
	private String tenKhachHang;
	
	@Column(name = "dia_chi")
	@NotEmpty(message = "Vui lòng nhập địa chỉ khách hàng")
	private String diaChi;
	
	@Column(name = "so_dien_thoai")
	@Pattern(regexp = "(^$|[0-9]{10})", message = "sai số điện thoại")
	private String soDienThoai;

	@Column(name = "email")
	@Pattern(regexp = ".+@.+\\..+", message = "sai định dạng email")
	private String email;
	
	@Column(name = "ma_so_thue")
	@NotEmpty(message = "vui lòng nhập mã số thuế khách hàng")
	private String maSoThue;
	
	@Column(name = "so_tai_khoan")
	@NotEmpty(message = "Vui lòng nhập số tài khoản khách hàng")
	private String soTaiKhoan;
	
	@Column(name = "ghi_chu")
	private String ghiChu;

	public String getMaKhachHang() {
		return maKhachHang;
	}

	public void setMaKhachHang(String maKhachHang) {
		this.maKhachHang = maKhachHang;
	}

	public String getTenKhachHang() {
		return tenKhachHang;
	}

	public void setTenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMaSoThue() {
		return maSoThue;
	}

	public void setMaSoThue(String maSoThue) {
		this.maSoThue = maSoThue;
	}

	public String getSoTaiKhoan() {
		return soTaiKhoan;
	}

	public void setSoTaiKhoan(String soTaiKhoan) {
		this.soTaiKhoan = soTaiKhoan;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	
	/*public KhachHang update(KhachHang khachHang) {
		this.setTenKhachHang(khachHang.getTenKhachHang());
		this.setDiaChi(khachHang.getDiaChi());
		this.setSoDienThoai(khachHang.getSoDienThoai());
		this.setEmail(khachHang.getEmail());
		this.setMaSoThue(khachHang.getMaSoThue());
		this.setSoTaiKhoan(khachHang.getSoTaiKhoan());
		this.setGhiChu(khachHang.getGhiChu());
		return this;
	}*/

}
