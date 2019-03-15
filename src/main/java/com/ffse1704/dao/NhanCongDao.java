package com.ffse1704.dao;

import java.util.List;

import com.ffse1704.model.NhanCong;

public interface NhanCongDao extends RepositoryDao<NhanCong, String> {
	
	
	public List<NhanCong> view(int iDisplayStart, int iDisplayLength, String order);
	

	public int getRecordsTotal();
	


}
