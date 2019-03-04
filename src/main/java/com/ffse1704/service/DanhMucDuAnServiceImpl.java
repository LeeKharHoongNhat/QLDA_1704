package com.ffse1704.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ffse1704.dao.DanhMucDuAnDao;
import com.ffse1704.model.DanhMucDuAn;

@Service
public class DanhMucDuAnServiceImpl implements  DanhMucDuAnService {
	@Autowired
	private DanhMucDuAnDao danhMucDuAnhDao;
	
	public List<DanhMucDuAn> getAll() {
		return this.danhMucDuAnhDao.getAll();
	}

}
