package com.ffse1704.dao;

import java.util.List;

import com.ffse1704.model.ThongTinDuAn;

public interface ThongTinDuAnDao extends RepositoryDao<ThongTinDuAn, String> {
	public List<ThongTinDuAn> listDuAn(String maTrangThai, int iDisplayStart, int iDisplayLength);

	public int getRecordsTotal(String maTrangThai);

	public int getRecordsByIdDuAn(String maDuAn);
}
