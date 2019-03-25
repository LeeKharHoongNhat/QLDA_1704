package com.ffse1704.service;

import java.util.List;

import com.ffse1704.model.VatLieu;

public interface VatLieuService {
	public List<VatLieu> view(int iDisplayStart, int iDisplayLength, String order);

	public int getRecordsTotal();

	public boolean addNew(VatLieu vl);

	public boolean update(VatLieu vl);

	public VatLieu delete(String maCongViec);


	public VatLieu getId(String maCongViec);

	public VatLieu checkExists(String mcv);

}
