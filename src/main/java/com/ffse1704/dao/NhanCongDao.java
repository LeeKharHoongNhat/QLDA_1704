package com.ffse1704.dao;

import java.util.List;

import com.ffse1704.model.NhanCong;
import com.ffse1704.model.NhanVien;

public interface NhanCongDao extends RepositoryDao<NhanCong, String> {
	
	
	public List<NhanCong> view(int iDisplayStart, int iDisplayLength, String order);
	

	public int getRecordsTotal();




	public List<NhanVien> ListChoiceNV();


	


}
