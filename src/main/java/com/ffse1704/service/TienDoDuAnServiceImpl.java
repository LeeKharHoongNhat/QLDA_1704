package com.ffse1704.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ffse1704.dao.TienDoDuAnDao;
import com.ffse1704.model.TienDoDuAn;

@Service
public class TienDoDuAnServiceImpl implements TienDoDuAnService {
	private TienDoDuAnDao tienDoDuAnDao;

	public TienDoDuAnDao getTienDoDuAnDao() {
		return tienDoDuAnDao;
	}

	@Autowired
	public void setTienDoDuAnDao(TienDoDuAnDao tienDoDuAnDao) {
		this.tienDoDuAnDao = tienDoDuAnDao;
	}

	@Override
	@Transactional
	public boolean addNew(TienDoDuAn tdda) {
		boolean flag = false;
		try {
			this.tienDoDuAnDao.save(tdda);
			flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}

	@Override
	@Transactional
	public boolean update(TienDoDuAn tdda) {
		boolean flag = false;
		try {
			this.tienDoDuAnDao.update(tdda);
			flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}

	@Override
	@Transactional
	public boolean delete(int id) {
		boolean flag = false;
		try {
			this.tienDoDuAnDao.delete(id);
			flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}

	@Override
	@Transactional
	public TienDoDuAn getOne(String maDuAn, String maCongViec) {
		return this.tienDoDuAnDao.getOne(maDuAn, maCongViec);
	}

	@Override
	@Transactional
	public List<TienDoDuAn> listTienDoDuAn(int iDisplayStart, int iDisplayLength) {
		return this.tienDoDuAnDao.listTienDoDuAn(iDisplayStart, iDisplayLength);
	}

	@Override
	@Transactional
	public int getRecordsTotal() {
		return this.tienDoDuAnDao.getRecordsTotal();
	}

	@Override
	@Transactional
	public int getRecordsByIdCongViec(String maDuAn, String maCongViec) {
		return this.tienDoDuAnDao.getRecordsByIdCongViec(maDuAn, maCongViec);
	}

}
