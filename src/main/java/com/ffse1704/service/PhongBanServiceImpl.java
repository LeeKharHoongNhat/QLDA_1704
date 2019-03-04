package com.ffse1704.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ffse1704.dao.PhongBanDao;
import com.ffse1704.model.PhongBan;


@Service
public class PhongBanServiceImpl implements PhongBanService {

	private PhongBanDao phongBanDao;

	public PhongBanDao getPhongBanDao() {
		return phongBanDao;
	}
	
	@Autowired
	public void setPhongBanDao(PhongBanDao phongBanDao) {
		this.phongBanDao = phongBanDao;
	}

	@Override
	@Transactional
	public boolean addNew(PhongBan pb) {
		boolean flag = false;
		try {
			this.phongBanDao.save(pb);
			flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}

	@Override
	@Transactional
	public boolean update(PhongBan pb) {
		boolean flag = false;
		try {
			this.phongBanDao.update(pb);
			flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;

	}

	@Override
	@Transactional
	public boolean delete(PhongBan maPhongBan) {
		boolean flag = false;
		try {
			this.phongBanDao.delete(maPhongBan);
			flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;

	}

	@Override
	@Transactional
	public PhongBan getPhongBanbyIdPhongBan(String maPhongBan) {
		return this.phongBanDao.findById(maPhongBan);
	}

	@Override
	@Transactional
	public List<PhongBan> listPhongBan(int iDisPlayStart, int iDinPlayLength) {
		return this.phongBanDao.listPhongBan(iDisPlayStart, iDinPlayLength);
	}

	@Override
	@Transactional
	public int getRecordsTotal() {
		return this.phongBanDao.getRecordsTotal();
	}

	@Override
	@Transactional
	public int getRecordsByIdPhongBan(String maPhongBan) {
		return this.phongBanDao.getRecordsByIdPhongBan(maPhongBan);
	}

}
