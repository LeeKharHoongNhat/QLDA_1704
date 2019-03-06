package com.ffse1704.service;

import java.util.List;

import com.ffse1704.model.NhanVien;

public interface NhanVienService {

	boolean addNew(NhanVien nv);

	boolean update(NhanVien nv);

	boolean delete(NhanVien maNhanVien);

	public NhanVien getNhanVienbyIdNhanVien(String maNhanVien);

	public List<NhanVien> listNhanVien(int iDisplayStart, int iDisplayLength);

	public int getRecordsTotal();

	public int getRecordsByIdNhanVien(String maNhanVien);
}
