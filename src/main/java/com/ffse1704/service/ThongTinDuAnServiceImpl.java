package com.ffse1704.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ffse1704.dao.ThongTinDuAnDao;
import com.ffse1704.model.ThongTinDuAn;

@Service
public class ThongTinDuAnServiceImpl implements ThongTinDuAnService {

	private ThongTinDuAnDao thongTinDuAnDao;

	public ThongTinDuAnDao getThongTinDuAnDao() {
		return thongTinDuAnDao;
	}

	@Autowired
	public void setThongTinDuAnDao(ThongTinDuAnDao thongTinDuAnDao) {
		this.thongTinDuAnDao = thongTinDuAnDao;
	}

	@Override
	@Transactional
	public boolean addNew(ThongTinDuAn da) {
		boolean flag = false;
		try {
			this.thongTinDuAnDao.save(da);
			flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}

	@Override
	@Transactional
	public boolean update(ThongTinDuAn da) {
		boolean flag = false;
		try {
			this.thongTinDuAnDao.update(da);
			flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;

	}

	@Override
	@Transactional
	public boolean delete(ThongTinDuAn maDuAn) {
		boolean flag = false;
		try {
			this.thongTinDuAnDao.delete(maDuAn);
			flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;

	}

	@Override
	@Transactional
	public ThongTinDuAn getDuAnIdDuAn(String maPhongBan) {
		return this.thongTinDuAnDao.findById(maPhongBan);
	}

	@Override
	@Transactional
	public List<ThongTinDuAn> listDuAn(String maTrangThai,int iDisPlayStart, int iDinPlayLength) {
		return this.thongTinDuAnDao.listDuAn(maTrangThai,iDisPlayStart, iDinPlayLength);
	}

	@Override
	@Transactional
	public int getRecordsTotal(String maTrangThai) {
		return this.thongTinDuAnDao.getRecordsTotal(maTrangThai);
	}

	@Override
	@Transactional
	public int getRecordsByIdDuAn(String maDuAn) {
		return this.thongTinDuAnDao.getRecordsByIdDuAn(maDuAn);
	}

}
