package com.ffse1704.service;

import java.util.List;

import com.ffse1704.model.PhongBan;


public interface PhongBanService {

	boolean addNew(PhongBan pb);

	boolean update(PhongBan pb);

	boolean delete(PhongBan maPhongBan);

	public PhongBan getPhongBanbyIdPhongBan(String maPhongBan);

	public List<PhongBan> listPhongBan(int iDisplayStart, int iDisplayLength);

	public int getRecordsTotal();

	public int getRecordsByIdPhongBan(String maPhongBan);

}