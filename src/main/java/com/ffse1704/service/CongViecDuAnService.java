package com.ffse1704.service;

import java.util.List;

import com.ffse1704.model.CongViecDuAn;

public interface CongViecDuAnService {

	public List<CongViecDuAn> listCongViecDuAnByMaCha(String maDuAn, String maCha, int iDisplayStart,
			int iDisplayLength);

	public void addNew(CongViecDuAn cvda);

	public void update(CongViecDuAn cvda);

	public void delete(int id);

	public CongViecDuAn getCongViecDuAnByIdCongViecDuAn(String maDuAn, String maCongViec, String maCha);

	public int getRecordsTotalByMaCha(String maDuAn, String maCha);
}
