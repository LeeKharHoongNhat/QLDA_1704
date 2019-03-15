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
	public List<NhanCong> view(int iDisplayStart, int iDisplayLength, String order) {
		// TODO Auto-generated method stub
		return nhanCongDao.view(iDisplayStart, iDisplayLength, order);
		
	}
	@Override
	@Transactional
	public int getRecordsTotal() {
		// TODO Auto-generated method stub
		return nhanCongDao.getRecordsTotal();
	}
	@Override
	@Transactional
	public boolean addNew(NhanCong nc) {
		// TODO Auto-generated method stub
		String id = nhanCongDao.save(nc);
		if (id !=  null) {
			return true;
		}
		return false;
		
	}
	@Override
	@Transactional
	public boolean update(NhanCong nc) {
		boolean result = false;
		try {
			nhanCongDao.update(nc);
			result = true;
		} catch (Exception e) {
			result = false;
		}
		return result;
	}
	@Override
	@Transactional
	public void delete(NhanCong nc) {
		// TODO Auto-generated method stub
		nhanCongDao.delete(nc);
		
	}
	@Override
	@Transactional
	public NhanCong getId(String maCongViec) {
		// TODO Auto-generated method stub
		return nhanCongDao.findById(maCongViec);
	}
	@Override
	@Transactional
	public NhanCong checkExists(String mcv) {
		return nhanCongDao.findById(mcv);
	}

}
