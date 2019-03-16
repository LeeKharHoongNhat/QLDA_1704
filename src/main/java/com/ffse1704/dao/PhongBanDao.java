package com.ffse1704.dao;

import java.util.List;

import com.ffse1704.model.PhongBan;


public interface PhongBanDao extends RepositoryDao<PhongBan, String>{

	public List<PhongBan> listPhongBan(String maTrangThai,int iDisplayStart, int iDisplayLength);

	public int getRecordsTotal(String maTrangThai);

	public int getRecordsByIdPhongBan(String maPhongBan);
}
