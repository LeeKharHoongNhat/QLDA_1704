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
	@NotEmpty(message = "khÃ´ng Ä‘Æ°á»£c Ä‘á»ƒ trá»‘ng!")
	private String maKhachHang;
	
	
	@NotEmpty(message = "Vui lÃ²ng nháº­p há»� tÃªn cá»§a khÃ¡ch hÃ ng")
	@Column(name = "ten_khach_hang", nullable = false, length = 50)
	private String tenKhachHang;
	
	@Column(name = "dia_chi")
	@NotEmpty(message = "Vui lÃ²ng nháº­p Ä‘á»‹a chá»‰ khÃ¡ch hÃ ng")
	private String diaChi;
	
	@Column(name = "so_dien_thoai")
	@Pattern(regexp = "(^$|[0-9]{10})", message = "Sá»‘ diá»‡n thoáº¡i khÃ´ng Ä‘Ãºng")
	private String soDienThoai;

	@Column(name = "email")
	@Pattern(regexp = ".+@.+\\..+", message = "Ä�á»‹nh dáº¡ng email khÃ´ng Ä‘Ãºng")
	private String email;
	
	@Column(name = "ma_so_thue")
	@NotEmpty(message = "Vui lÃ²ng nháº­p mÃ£ sá»‘ thuáº¿ khÃ¡ch hÃ ng")
	private String maSoThue;
	
	@Column(name = "so_tai_khoan")
	@NotEmpty(message = "Vui lÃ²ng nháº­p sá»‘ tÃ i khoáº£n khÃ¡ch hÃ ng")
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
