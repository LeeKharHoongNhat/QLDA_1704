package com.ffse1704.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ffse1704.dao.VatLieuDao;
import com.ffse1704.model.VatLieu;

@Service
public class VatLieuServiceImpl implements VatLieuService {

	@Autowired
	private VatLieuDao vatLieuDao;

	public void setVatLieuDao(VatLieuDao vatLieuDao) {
		this.vatLieuDao = vatLieuDao;
	}

	@Override
	@Transactional
	public void addNew(VatLieu vl) {
		vatLieuDao.addNew(vl);

	}

	@Override
	@Transactional
	public void update(VatLieu vl) {
		vatLieuDao.update(vl);

	}

	@Override
	@Transactional
	public VatLieu getId(String maVatLieu) {
		// TODO Auto-generated method stub
		return vatLieuDao.getId(maVatLieu);

	}

	@Override
	@Transactional
	public List<VatLieu> listVL(int iDisplayStart, int iDisplayLength) {
		// TODO Auto-generated method stub
		return vatLieuDao.listVL(iDisplayStart, iDisplayLength);
	}

	@Override
	@Transactional
	public int getRecordsTotal() {
		return vatLieuDao.getRecordsTotal();
	}

	@Override
	@Transactional
	public int getRecordsByIdVatLieu(String maVatLieu) {
		// TODO Auto-generated method stub
		return vatLieuDao.getRecordsByIdVatLieu(maVatLieu);
	}

	@Override
	@Transactional
	public void delete(String vl) {
		vatLieuDao.delete(vl);
	}

}
