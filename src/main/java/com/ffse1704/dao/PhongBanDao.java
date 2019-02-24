package com.ffse1704.dao;

import java.util.List;

import com.ffse1704.model.PhongBan;


public interface PhongBanDao {
	public void addNew(PhongBan pb);

	public void update(PhongBan pb);

	public void delete(String maPhongBan);

	public PhongBan getPhongBanbyIdPhongBan(String maPhongBan);

	public List<PhongBan> listPhongBan(int iDisplayStart, int iDisplayLength);

	public int getRecordsTotal();

	public int getRecordsByIdPhongBan(String maPhongBan);
}
