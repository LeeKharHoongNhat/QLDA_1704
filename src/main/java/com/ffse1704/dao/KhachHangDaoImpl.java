/**
 * 
 */
package com.ffse1704.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ffse1704.model.KhachHang;

/**
 * @author QuangDai
 *
 */
@Repository
public class KhachHangDaoImpl extends ResponsitoryDaoImpl<KhachHang, String> implements KhachHangDao {


	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ffse1704.dao.KhachHangDao#addNew(com.ffse1704.model.KhachHang)
	 */
	@Override
	public void addNew(KhachHang kh) {
		

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ffse1704.dao.KhachHangDao#getKhachHangbyIdKhachHang(java.lang.String)
	 */
	@Override
	public KhachHang getKhachHangbyIdKhachHang(String maKhachHang) {
		List<KhachHang> listKhachHang = createQuery("from KhachHang where maKhachHang = '" + maKhachHang + "'").list();
		KhachHang kh = listKhachHang.get(0);
		return kh;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ffse1704.dao.KhachHangDao#listKhachHang(int, int)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<KhachHang> listKhachHang(int iDisplayStart, int iDisplayLength) {
	
		List<KhachHang> KhachHangList = createQuery("from KhachHang").setFirstResult(iDisplayStart)
				.setMaxResults(iDisplayLength).list();
		return KhachHangList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ffse1704.dao.KhachHangDao#getRecordsTotal()
	 */
	@Override
	public int getRecordsTotal() {
		int rowCount = createQuery("from KhachHang").list().size();
		return rowCount;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ffse1704.dao.KhachHangDao#getRecordsByIdPKhachHang(java.lang.String)
	 */
	@Override
	public int getRecordsByIdPKhachHang(String maKhachHang) {
		int rowCount = createQuery("from KhachHang where maKhachHang='" + maKhachHang + "'").list().size();
		return rowCount;
	}

}
