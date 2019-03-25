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
	public List<VatLieu> view(int iDisplayStart, int iDisplayLength, String order) {
		// TODO Auto-generated method stub
		return vatLieuDao.view(iDisplayStart, iDisplayLength, order);
	}

	@Override
	@Transactional
	public int getRecordsTotal() {
		// TODO Auto-generated method stub
		return vatLieuDao.getRecordsTotal();
	}

	@Override
	@Transactional
	public boolean addNew(VatLieu vl) {
		// TODO Auto-generated method stub
		String id = vatLieuDao.save(vl);
		if (id != null) {
			return true;
		}
		return false;
	}

	@Override
	@Transactional
	public boolean update(VatLieu vl) {
		boolean result = false;
		try {
			vatLieuDao.update(vl);
			result = true;
		} catch (Exception e) {
			result = false;
		}
		return result;
	}

	@Override
	@Transactional
	public VatLieu getId(String maCongViec) {
		// TODO Auto-generated method stub
		return vatLieuDao.findById(maCongViec);
	}

	@Override
	@Transactional
	public VatLieu checkExists(String mcv) {
		return vatLieuDao.findById(mcv);

	}

	@Override
	@Transactional
	public VatLieu delete(String maCongViec) {

		VatLieu vl = vatLieuDao.findById(maCongViec);
		vl.setIsDelete(1);

		return vl;
	}

}
