package com.ffse1704.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "phong_ban")
public class PhongBan implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ma_phong_ban", unique = true, nullable = false, length = 30)
	@NotEmpty(message="không được để trống!")
	private String maPhongBan;

	@OneToMany(mappedBy = "phongBan", fetch = FetchType.EAGER)
	private List<NhanVien> listNhanVien;
	
	
	@Column(name = "ten_phong_ban", nullable = false, length = 255)
	@NotEmpty(message="không được để trống!")
	public String tenPhongBan;



	public PhongBan() {
	}

	public String getMaPhongBan() {
		return this.maPhongBan;
	}

	public void setMaPhongBan(String maPhongBan) {
		this.maPhongBan = maPhongBan;
	}

	public String getTenPhongBan() {
		return this.tenPhongBan;
	}

	public void setTenPhongBan(String tenPhongBan) {
		this.tenPhongBan = tenPhongBan;
	}

	public List<NhanVien> getListNhanVien() {
		return listNhanVien;
	}

	public void setListNhanVien(List<NhanVien> listNhanVien) {
		this.listNhanVien = listNhanVien;
	}


}