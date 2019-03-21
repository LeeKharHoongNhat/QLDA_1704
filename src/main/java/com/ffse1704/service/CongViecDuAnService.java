package com.ffse1704.service;

import java.util.List;

import com.ffse1704.model.CongViecDuAn;

public interface CongViecDuAnService {

	public List<CongViecDuAn> listCongViecDuAnByMaCha(String maDuAn, int iDisplayStart,
			int iDisplayLength);

	public void addNew(CongViecDuAn cvda);

	public void update(CongViecDuAn cvda);

	public void delete(int id);

	public CongViecDuAn getCongViecDuAnById(int id);

	public int getRecordsTotalByMaCha(String maDuAn);
}
