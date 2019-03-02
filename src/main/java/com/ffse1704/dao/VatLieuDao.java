package com.ffse1704.dao;

import java.util.List;

import com.ffse1704.model.VatLieu;

public interface VatLieuDao  {
	
	public void addNew(VatLieu vl);

	public void update(VatLieu vl);

	public void delete(String vl);

	public VatLieu getId(String maVatLieu);

	public List<VatLieu> listVL(int iDisplayStart, int iDisplayLength);

	public int getRecordsTotal();

	public int getRecordsByIdVatLieu(String maVatLieu);

}
