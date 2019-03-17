package com.ffse1704.service;

import java.util.List;

import com.ffse1704.model.ThongTinDuAn;

public interface ThongTinDuAnService {
	boolean addNew(ThongTinDuAn da);

	boolean update(ThongTinDuAn da);

	boolean delete(ThongTinDuAn maDuAn);

	public ThongTinDuAn getDuAnIdDuAn(String maDuAn);

	public List<ThongTinDuAn> listDuAn(String maTrangThai, int iDisplayStart, int iDisplayLength);
	
	public ThongTinDuAn viewOneDuAn(String maDuAn);

	public int getRecordsTotal(String maTrangThai);

	public int getRecordsByIdDuAn(String maDuAn);
}
