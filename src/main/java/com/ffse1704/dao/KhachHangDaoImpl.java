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
public class KhachHangDaoImpl implements KhachHangDao {
	
	private final SessionFactory sessionFactory;
	
	@Autowired
	public KhachHangDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ffse1704.dao.KhachHangDao#addNew(com.ffse1704.model.KhachHang)
	 */
	@Override
	public void addNew(KhachHang kh) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(kh);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ffse1704.dao.KhachHangDao#update(com.ffse1704.model.KhachHang)
	 */
	@Override
	public void update(KhachHang kh) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(kh);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ffse1704.dao.KhachHangDao#delete(java.lang.String)
	 */
	@Override
	public void delete(String maKhachHang) {
		Session session = this.sessionFactory.openSession();
		Transaction pd = session.beginTransaction();
		session.update(session.get(KhachHang.class, maKhachHang));
		pd.commit();
		session.close();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ffse1704.dao.KhachHangDao#getKhachHangbyIdKhachHang(java.lang.String)
	 */
	@Override
	public KhachHang getKhachHangbyIdKhachHang(String maKhachHang) {
		Session session = this.sessionFactory.getCurrentSession();
		List<KhachHang> listKhachHang = session
				.createQuery("from KhachHang where maKhachHang = '" + maKhachHang + "'", KhachHang.class).list();
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
		Session session = this.sessionFactory.getCurrentSession();
		List<KhachHang> KhachHangList = session.createQuery("from KhachHang").setFirstResult(iDisplayStart)
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
		Session session = sessionFactory.getCurrentSession();
		int rowCount = session.createQuery("from KhachHang").list().size();
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
		Session session = sessionFactory.getCurrentSession();
		int rowCount = session.createQuery("from KhachHang where maKhachHang='" + maKhachHang + "'").list().size();
		return rowCount;
	}

}
