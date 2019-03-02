package com.ffse1704.service;

import java.util.List;

import com.ffse1704.model.VatLieu;

public interface VatLieuService {

	public void addNew(VatLieu vl);

	public void update(VatLieu vl);

	public void delete(String vl);

	public VatLieu getId(String maVatLieu);

	public List<VatLieu> listVL(int iDisplayStart, int iDisplayLength);

	public int getRecordsTotal();

	public int getRecordsByIdVatLieu(String maVatLieu);

}
