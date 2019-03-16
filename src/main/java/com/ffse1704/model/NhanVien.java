package com.ffse1704.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "nhan_vien")
public class NhanVien implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ma_nhan_vien", unique = true, nullable = false, length = 30)
	@NotEmpty(message = "không được để trống!")
	private String maNhanVien;

	@NotEmpty(message = "Vui Lòng Nhập họ tên của nhân viên")
	@Column(name = "ho_ten", nullable = false)
	private String hoTenNhanVien;

	@Column(name = "gioi_tinh")
	@NotEmpty(message = "Vui Lòng Nhập giới tính")
	private String gioiTinh;

	@Column(name = "so_chung_minh_thu")
	@NotEmpty(message = "Vui Lòng Nhập số chứng minh thư nhan viên")
	private Integer soChungMinhThu;

	@Column(name = "so_dien_thoai")
	@Pattern(regexp = "(^$|[0-9]{11})", message = "Số diện thoại không đúng")
	private String soDienThoai;

	@Column(name = "email")
	@Pattern(regexp = ".+@.+\\..+", message = "Định dạng email không đúng")
	private String email;

	@Column(name = "dia_chi")
	@NotEmpty(message = "Vui Lòng Nhập địa chỉ nhân viên")
	private String diaChi;

	@Column(name = "hinh_anh")
	@NotEmpty(message = "Vui Lòng chọn ảnh")
	private String hinhAnh;

	@Column(name = "ma_phong_ban")
	private String maPhongBan;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "ma_phong_ban", referencedColumnName = "ma_phong_ban", insertable = false, updatable = false, nullable = false)
	private PhongBan phongBan;

	@Column(name = "ma_chuc_danh")
	private String maChucDanh;

	@Column(name = "ma_loai_hop_dong")
	private String maLoaiHopDong;

	@Column(name = "ma_trang_thai")
	private String maTrangThai;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "ngay_bat_dau_hop_dong")
	@NotNull(message = "Vui Lòng Nhập ngày")
	private Date ngayBatDauHopDong;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "ngay_ket_thuc_hop_dong")
	@NotNull(message = "Vui Lòng Nhập ngày")
	private Date ngayKetThucHopDong;

	@Column(name = "pass_word")
	@NotEmpty(message = "Vui Lòng Nhập mật khẩu")
	private String passWord;

	@Transient
	private TieuThuc ttChucDanh;

	@Transient
	private TieuThuc ttLoaiHD;

	@Transient
	private TieuThuc ttTrangThai;

	@OneToMany(mappedBy = "nhanVien", fetch = FetchType.LAZY)
    private List<NhatKyCongViec> nhatKiCongViecs;
	
	
	public String getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}

	public String getHoTenNhanVien() {
		return hoTenNhanVien;
	}

	public void setHoTenNhanVien(String hoTenNhanVien) {
		this.hoTenNhanVien = hoTenNhanVien;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public Integer getSoChungMinhThu() {
		return soChungMinhThu;
	}

	public void setSoChungMinhThu(Integer soChungMinhThu) {
		this.soChungMinhThu = soChungMinhThu;
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

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getHinhAnh() {
		return hinhAnh;
	}

	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}

	public String getMaPhongBan() {
		return maPhongBan;
	}

	public void setMaPhongBan(String maPhongBan) {
		this.maPhongBan = maPhongBan;
	}

	public PhongBan getPhongBan() {
		return phongBan;
	}

	public void setPhongBan(PhongBan phongBan) {
		this.phongBan = phongBan;
	}

	public String getMaChucDanh() {
		return maChucDanh;
	}

	public void setMaChucDanh(String maChucDanh) {
		this.maChucDanh = maChucDanh;
	}

	public String getMaLoaiHopDong() {
		return maLoaiHopDong;
	}

	public void setMaLoaiHopDong(String maLoaiHopDong) {
		this.maLoaiHopDong = maLoaiHopDong;
	}

	public Date getNgayBatDauHopDong() {
		return ngayBatDauHopDong;
	}

	public void setNgayBatDauHopDong(Date ngayBatDauHopDong) {
		this.ngayBatDauHopDong = ngayBatDauHopDong;
	}

	public Date getNgayKetThucHopDong() {
		return ngayKetThucHopDong;
	}

	public void setNgayKetThucHopDong(Date ngayKetThucHopDong) {
		this.ngayKetThucHopDong = ngayKetThucHopDong;
	}

	public String getMaTrangThai() {
		return maTrangThai;
	}

	public void setMaTrangThai(String maTrangThai) {
		this.maTrangThai = maTrangThai;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public TieuThuc getTtChucDanh() {
		return ttChucDanh;
	}

	public void setTtChucDanh(TieuThuc ttChucDanh) {
		this.ttChucDanh = ttChucDanh;
	}

	public TieuThuc getTtLoaiHD() {
		return ttLoaiHD;
	}

	public void setTtLoaiHD(TieuThuc ttLoaiHD) {
		this.ttLoaiHD = ttLoaiHD;
	}

	public TieuThuc getTtTrangThai() {
		return ttTrangThai;
	}

	public void setTtTrangThai(TieuThuc ttTrangThai) {
		this.ttTrangThai = ttTrangThai;
	}

	public List<NhatKyCongViec> getNhatKiCongViecs() {
		return nhatKiCongViecs;
	}

	public void setNhatKiCongViecs(List<NhatKyCongViec> nhatKiCongViecs) {
		this.nhatKiCongViecs = nhatKiCongViecs;
	}

}
