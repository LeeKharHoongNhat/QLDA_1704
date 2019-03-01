package com.ffse1704.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ffse1704.dao.ThietBiDao;
import com.ffse1704.model.ThietBi;

@Service

public class ThietBiServiceImpl implements ThietBiService {
	@Autowired
	private ThietBiDao thietBiDao;

	public void setThietBiDao(ThietBiDao thietBiDao) {
		this.thietBiDao = thietBiDao;
	}

	@Override
	@Transactional
	public List<ThietBi> viewOne(String maCv) {
		// TODO Auto-generated method stub
		return this.thietBiDao.viewOne(maCv);
	}
	@Override
	@Transactional
	public void addThietBi(ThietBi tb) {
		this.thietBiDao.addThietBi(tb);
		
	}
	@Override
	@Transactional
	public ThietBi getThietBiById(int id) {
		// TODO Auto-generated method stub
		return this.thietBiDao.getThietBiById(id);
	}
	@Override
	@Transactional
	public void updateThietBi(ThietBi tb) {
		this.thietBiDao.updateThietBi(tb);
		
	}
	@Override
	@Transactional
	public void removeThietBi(int id) {
		this.thietBiDao.removeThietBi(id);
		
	}
}
