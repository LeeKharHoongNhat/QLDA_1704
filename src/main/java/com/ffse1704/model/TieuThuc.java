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
@Table(name = "danh_muc_tieu_thuc")
public class TieuThuc implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ma_tieu_thuc", nullable = false, length = 11)
	@NotEmpty(message="không được để trống!")
	private String maTieuThuc;
	
	@OneToMany(mappedBy = "tieuThuc", fetch = FetchType.EAGER)
	private List<DanhMucDuAn> listDanhMucDuAn;
	
	public List<DanhMucDuAn> getListDanhMucDuAn() {
		return listDanhMucDuAn;
	}

	public void setListDanhMucDuAn(List<DanhMucDuAn> listDanhMucDuAn) {
		this.listDanhMucDuAn = listDanhMucDuAn;
	}

	@Column(name = "ten_tieu_thuc", nullable = false, length = 50)
	@NotEmpty(message="không được để trống!")
	private String tenTieuThuc;
	
	@Column(name = "ma_cha", nullable = false, length = 11)
	private String maCha;
	
	
	public TieuThuc() {
	}

	

	public String getMaTieuThuc() {
		return maTieuThuc;
	}

	public void setMaTieuThuc(String maTieuThuc) {
		this.maTieuThuc = maTieuThuc;
	}

	public String getTenTieuThuc() {
		return tenTieuThuc;
	}

	public void setTenTieuThuc(String tenTieuThuc) {
		this.tenTieuThuc = tenTieuThuc;
	}

	public String getMaCha() {
		return maCha;
	}

	public void setMaCha(String maCha) {
		this.maCha = maCha;
	}

}
