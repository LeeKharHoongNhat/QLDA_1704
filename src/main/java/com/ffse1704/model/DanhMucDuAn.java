package com.ffse1704.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "danh_muc_du_an")
public class DanhMucDuAn {
	public DanhMucDuAn() {
		super();

	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "ma_du_an")
	@NotEmpty
	private String maDuAn;
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "ma_du_an", referencedColumnName = "ma_du_an", insertable = false, updatable = false, nullable = false)
	private ThongTinDuAn thongTinDuAn;
	
	
	@Column(name = "ma_tieu_thuc")
	@NotEmpty
	private String maTieuThuc;
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "ma_tieu_thuc", referencedColumnName = "ma_tieu_thuc", insertable = false, updatable = false, nullable = false)
	private TieuThuc tieuThuc;
	
	
	
	
	public TieuThuc getTieuThuc() {
		return tieuThuc;
	}

	public void setTieuThuc(TieuThuc tieuThuc) {
		this.tieuThuc = tieuThuc;
	}

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

	public String getMaTieuThuc() {
		return maTieuThuc;
	}

	public void setMaTieuThuc(String maTieuThuc) {
		this.maTieuThuc = maTieuThuc;
	}

	public ThongTinDuAn getThongTinDuAn() {
		return thongTinDuAn;
	}

	public void setThongTinDuAn(ThongTinDuAn thongTinDuAn) {
		this.thongTinDuAn = thongTinDuAn;
	}
	
	
}
