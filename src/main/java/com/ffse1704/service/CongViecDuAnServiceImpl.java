package com.ffse1704.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ffse1704.dao.CongViecDuAnDao;
import com.ffse1704.model.CongViecDuAn;

/**
 * @author KhaNhat
 *
 */
@Service
public class CongViecDuAnServiceImpl implements CongViecDuAnService {

	@Autowired
	private CongViecDuAnDao congViecDuAnDao;

	@Override
	@Transactional
	public List<CongViecDuAn> listCongViecDuAnByMaCha(String maDuAn, String maCha, int iDisplayStart,
			int iDisplayLength) {
		return this.congViecDuAnDao.listCongViecDuAnByMaCha(maDuAn, maCha, iDisplayStart, iDisplayLength);
	}

	@Override
	@Transactional
	public void addNew(CongViecDuAn cvda) {
		this.congViecDuAnDao.addNew(cvda);
	}

	@Override
	@Transactional
	public void update(CongViecDuAn cvda) {
		this.congViecDuAnDao.update(cvda);
	}

	@Override
	@Transactional
	public void delete(int id) {
		this.congViecDuAnDao.delete(id);
	}

	@Override
	@Transactional
	public CongViecDuAn getCongViecDuAnByIdCongViecDuAn(String maDuAn, String maCongViec, String maCha) {
		return this.congViecDuAnDao.getCongViecDuAnByIdCongViecDuAn(maDuAn, maCongViec, maCha);
	}

	@Override
	@Transactional
	public int getRecordsTotalByMaCha(String maDuAn, String maCha) {
		return this.congViecDuAnDao.getRecordsTotalByMaCha(maDuAn, maCha);
	}

}
