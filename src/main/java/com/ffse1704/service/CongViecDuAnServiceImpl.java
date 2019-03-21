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
	public List<CongViecDuAn> listCongViecDuAnByMaCha(String maDuAn, int iDisplayStart,
			int iDisplayLength) {
		return this.congViecDuAnDao.listCongViecDuAnByMaCha(maDuAn,  iDisplayStart, iDisplayLength);
	}

	@Override
	@Transactional
	public void addNew(CongViecDuAn cvda) {
		this.congViecDuAnDao.save(cvda);
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
	public CongViecDuAn getCongViecDuAnById(int id) {
		return this.congViecDuAnDao.getCongViecDuAnById(id);
	}

	@Override
	@Transactional
	public int getRecordsTotalByMaCha(String maDuAn) {
		return this.congViecDuAnDao.getRecordsTotalByMaCha(maDuAn);
	}

}
