package com.ffse1704.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ffse1704.dao.NhanCongDao;
import com.ffse1704.model.NhanCong;

@Service
public class NhanCongServiceImpl implements NhanCongService {

	
	@Autowired
	private NhanCongDao nhanCongDao;

	public void setNhanCongDao(NhanCongDao nhanCongDao) {
		this.nhanCongDao = nhanCongDao;
	}
	@Override
	@Transactional
	public List<NhanCong> view(int iDisplayStart, int iDisplayLength) {
		// TODO Auto-generated method stub
		return nhanCongDao.view(iDisplayStart, iDisplayLength);
		
	}
	@Override
	@Transactional
	public int getRecordsTotal() {
		// TODO Auto-generated method stub
		return nhanCongDao.getRecordsTotal();
	}
	@Override
	@Transactional
	public void addNew(NhanCong nc) {
		// TODO Auto-generated method stub
		nhanCongDao.addNew(nc);
	}
	@Override
	@Transactional
	public void update(NhanCong nc) {
		// TODO Auto-generated method stub
		nhanCongDao.update(nc);
		
	}
	@Override
	@Transactional
	public void delete(String nc) {
		// TODO Auto-generated method stub
		nhanCongDao.delete(nc);
		
	}
	@Override
	@Transactional
	public NhanCong getId(String maCongViec) {
		// TODO Auto-generated method stub
		return nhanCongDao.getId(maCongViec);
	}

}
