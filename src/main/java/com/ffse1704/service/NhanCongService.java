package com.ffse1704.service;

import java.util.List;

import com.ffse1704.model.NhanCong;

public interface NhanCongService {
	public List<NhanCong> view(int iDisplayStart, int iDisplayLength);

	public int getRecordsTotal();

	public void addNew(NhanCong nc);

	public void update(NhanCong nc);

	public void delete(String nc);
	
	public NhanCong getId(String maCongViec);
}
