package com.ffse1704.service;

import java.util.List;

import com.ffse1704.model.NhanCong;
import com.ffse1704.model.NhanVien;

public interface NhanCongService {
	public List<NhanCong> view(int iDisplayStart, int iDisplayLength, String order);

	public int getRecordsTotal();

	public boolean addNew(NhanCong nc);

	public boolean update(NhanCong nc);


	public NhanCong delete(String maCongViec);
	
	public NhanCong getId(String maCongViec);


	public NhanCong checkExists(String mcv);

	public List<NhanVien> ListChoiceNV();

}
