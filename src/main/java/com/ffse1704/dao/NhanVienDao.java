package com.ffse1704.dao;

import java.util.List;

import com.ffse1704.model.NhanVien;

public interface NhanVienDao  extends RepositoryDao<NhanVien, String>{
	
	public List<NhanVien> listNhanVien(int iDisplayStart, int iDisplayLength);

	public int getRecordsTotal();

	public int getRecordsByIdNhanVien(String maNhanVien);
}
