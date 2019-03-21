package com.ffse1704.dao;

import java.util.List;

import com.ffse1704.model.CongViecDuAn;

public interface CongViecDuAnDao extends RepositoryDao<CongViecDuAn, String>{
	public List<CongViecDuAn> listCongViecDuAnByMaCha(String maDuAn, int iDisplayStart,
			int iDisplayLength);

	public void delete(int id);

	public CongViecDuAn getCongViecDuAnById(int id);

	public int getRecordsTotalByMaCha(String maDuAn);
}
