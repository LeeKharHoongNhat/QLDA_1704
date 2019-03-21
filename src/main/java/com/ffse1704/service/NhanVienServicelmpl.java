package com.ffse1704.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ffse1704.dao.NhanVienDao;
import com.ffse1704.model.NhanVien;
@Service
public class NhanVienServicelmpl implements NhanVienService {
	private NhanVienDao nhanVienDao;

	
	public NhanVienDao getNhanVienDao() {
		return nhanVienDao;
	}
	
	@Autowired
	public void setNhanVienDao(NhanVienDao nhanVienDao) {
		this.nhanVienDao = nhanVienDao;
	}

	@Override
	@Transactional
	public boolean addNew(NhanVien nv) {
		boolean flag = false;
		try {
			this.nhanVienDao.save(nv);
			flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}

	@Override
	@Transactional
	public boolean update(NhanVien nv) {
		boolean flag = false;
		try {
			this.nhanVienDao.update(nv);
			flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;

	}

	@Override
	@Transactional
	public boolean delete(NhanVien maPhongBan) {
		boolean flag = false;
		try {
			this.nhanVienDao.delete(maPhongBan);
			flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;

	}

	@Override
	@Transactional
	public NhanVien getOneNhanVien(String maNhanVien) {
		return this.nhanVienDao.getOneNhanVien(maNhanVien);
	}

	@Override
	@Transactional
	public List<NhanVien> listNhanVien(int iDisPlayStart, int iDinPlayLength) {
		return this.nhanVienDao.listNhanVien(iDisPlayStart, iDinPlayLength);
	}

	@Override
	@Transactional
	public int getRecordsTotal() {
		return this.nhanVienDao.getRecordsTotal();
	}

	@Override
	@Transactional
	public int getRecordsByIdNhanVien(String maNhanVien) {
		return this.nhanVienDao.getRecordsByIdNhanVien(maNhanVien);
	}


}
