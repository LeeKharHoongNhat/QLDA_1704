package com.ffse1704.service;

import java.util.List;

import com.ffse1704.model.TienDoDuAn;

public interface TienDoDuAnService {
	boolean addNew(TienDoDuAn tdda);

	boolean update(TienDoDuAn tdda);

	boolean delete(int id);

	public TienDoDuAn getOne(String maDuAn, String maCongViec);

	public List<TienDoDuAn> listTienDoDuAn( int iDisplayStart, int iDisplayLength);

	public int getRecordsTotal();

	public int getRecordsByIdCongViec(String maDuAn, String maCongViec);
}
