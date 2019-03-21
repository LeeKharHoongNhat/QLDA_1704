package com.ffse1704.dao;

import java.util.List;

import com.ffse1704.model.TienDoDuAn;

public interface TienDoDuAnDao extends RepositoryDao<TienDoDuAn, String>{
	
	public List<TienDoDuAn> listTienDoDuAn(int iDisplayStart, int iDisplayLength);
	
	public TienDoDuAn getOne(String maDuAn, String maCongViec);
	
	public void delete(int id);

	public int getRecordsTotal();

	public int getRecordsByIdCongViec(String maDuAn, String maCOngViec);
}
