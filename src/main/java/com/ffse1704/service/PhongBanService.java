package com.ffse1704.service;

import java.util.List;

import com.ffse1704.model.PhongBan;


public interface PhongBanService {

	boolean addNew(PhongBan pb);

	boolean update(PhongBan pb);

	boolean delete(PhongBan maPhongBan);

	public PhongBan getPhongBanbyIdPhongBan(String maPhongBan);

	public List<PhongBan> listPhongBan(String maTrangThai, int iDisplayStart, int iDisplayLength);

	public int getRecordsTotal(String maTrangThai);

	public int getRecordsByIdPhongBan(String maPhongBan);

}