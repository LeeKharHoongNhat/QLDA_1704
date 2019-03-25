package com.ffse1704.dao;

import java.util.List;

import com.ffse1704.model.VatLieu;

public interface VatLieuDao extends RepositoryDao<VatLieu, String>  {
	
	
	public List<VatLieu> view(int iDisplayStart, int iDisplayLength, String order);
	

	public int getRecordsTotal();



}
