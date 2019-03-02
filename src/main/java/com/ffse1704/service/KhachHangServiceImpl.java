/**
 * 
 */
package com.ffse1704.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ffse1704.dao.KhachHangDao;
import com.ffse1704.model.KhachHang;

/**
 * @author QuangDai
 *
 */
@Service
public class KhachHangServiceImpl implements KhachHangService {

	private KhachHangDao khachHangDao;

	public KhachHangDao getKhachhangDao() {
		return khachHangDao;
	}

	@Autowired
	public void setKhachhangDao(KhachHangDao khachhangDao) {
		this.khachHangDao = khachhangDao;
	}

	/* (non-Javadoc)
	 * @see com.ffse1704.service.KhachHangService#addNew(com.ffse1704.model.KhachHang)
	 */
	@Override
	@Transactional
	public void addNew(KhachHang kh) {
		this.khachHangDao.addNew(kh);

	}

	/* (non-Javadoc)
	 * @see com.ffse1704.service.KhachHangService#update(com.ffse1704.model.KhachHang)
	 */
	@Override
	@Transactional
	public void update(KhachHang kh) {
		this.khachHangDao.update(kh);

	}

	/* (non-Javadoc)
	 * @see com.ffse1704.service.KhachHangService#delete(java.lang.String)
	 */
	@Override
	@Transactional
	public void delete(String maKhachHang) {
		this.khachHangDao.delete(maKhachHang);

	}

	/* (non-Javadoc)
	 * @see com.ffse1704.service.KhachHangService#getKhachHangbyIdKhachHang(java.lang.String)
	 */
	@Override
	@Transactional
	public KhachHang getKhachHangbyIdKhachHang(String maKhachHang) {
		return this.khachHangDao.getKhachHangbyIdKhachHang(maKhachHang);
	}

	/* (non-Javadoc)
	 * @see com.ffse1704.service.KhachHangService#listKhachHang(int, int)
	 */
	@Override
	@Transactional
	public List<KhachHang> listKhachHang(int iDisplayStart, int iDisplayLength) {
		return this.khachHangDao.listKhachHang(iDisplayStart, iDisplayLength);
	}

	/* (non-Javadoc)
	 * @see com.ffse1704.service.KhachHangService#getRecordsTotal()
	 */
	@Override
	@Transactional
	public int getRecordsTotal() {
		return this.khachHangDao.getRecordsTotal();
	}

	/* (non-Javadoc)
	 * @see com.ffse1704.service.KhachHangService#getRecordsByIdPKhachHang(java.lang.String)
	 */
	@Override
	@Transactional
	public int getRecordsByIdPKhachHang(String maKhachHang) {
		return this.khachHangDao.getRecordsByIdPKhachHang(maKhachHang);
	}

}
