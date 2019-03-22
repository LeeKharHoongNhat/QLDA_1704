package com.ffse1704.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ffse1704.dao.NhatKyCongViecDao;
import com.ffse1704.model.NhatKyCongViec;
import com.ffse1704.model.ThongTinDuAn;

@Service
public class NhatKyCongViecServiceImpl implements NhatKyCongViecService {
	@Autowired
	private NhatKyCongViecDao nhatKyCongViecDao;

	@Override
	@Transactional
	public List<NhatKyCongViec> listNhatKyCongViec(String maDuAn) {
		return nhatKyCongViecDao.listNhatKyCongViec(maDuAn);
	}

	@Override
	@Transactional
	public List<ThongTinDuAn> listDuAn(String maNv) {
		return nhatKyCongViecDao.listDuAn(maNv);
	}

	@Override
	@Transactional
	public void add(NhatKyCongViec nkcv) {
		this.nhatKyCongViecDao.save(nkcv);

	}
}
