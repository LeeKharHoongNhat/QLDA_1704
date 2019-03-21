package com.ffse1704.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ffse1704.dao.LogWorkDao;
import com.ffse1704.model.LogWork;

@Service
public class LogWorkServiceImpl implements LogWorkService {

	private LogWorkDao logWorkDao;

	public LogWorkDao getLogWorkDao() {
		return logWorkDao;
	}

	@Autowired
	public void setLogWorkDao(LogWorkDao logWorkDao) {
		this.logWorkDao = logWorkDao;
	}

	@Override
	@Transactional
	public boolean addNew(LogWork logwork) {
		boolean flag = false;
		try {
			this.logWorkDao.save(logwork);
			flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}

	@Override
	@Transactional
	public boolean update(LogWork logwork) {
		boolean flag = false;
		try {
			this.logWorkDao.update(logwork);
			flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}

	@Override
	@Transactional
	public LogWork getOneLogWork(int id) {
		return this.logWorkDao.getOneLogWork(id);
	}

	@Override
	@Transactional
	public List<LogWork> listLogWork(String maDuAn, String maCongViec, int iDisplayStart, int iDisplayLength) {
		return this.logWorkDao.listLogWork(maDuAn, maCongViec, iDisplayStart, iDisplayLength);
	}

	@Override
	@Transactional
	public int getRecordsTotal(String maDuAn, String maCongViec) {
		return this.logWorkDao.getRecordsTotal(maDuAn, maCongViec);
	}

}
