package com.ffse1704.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ffse1704.model.CongViecDuAn;

/**
 * @author KhaNhat
 *
 */
@Repository
public class CongViecDuAnDaoImpl implements CongViecDuAnDao {
	@Autowired
	private SessionFactory sessionFactory;


	@Override
	public List<CongViecDuAn> listCongViecDuAnByMaCha(String maDuAn, String maCha, int iDisplayStart,
			int iDisplayLength) {
		Session session = this.sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<CongViecDuAn> listcvda = session
				.createQuery(
						"from CongViecDuAn tt where tt.maDuAn  = '" + maDuAn + "' and tt.maCha ='" + maCha + "'")
				.setFirstResult(iDisplayStart).setMaxResults(iDisplayLength).list();
		return listcvda;
	}

	@Override
	public void addNew(CongViecDuAn cvda) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(cvda);
	}

	@Override
	public void update(CongViecDuAn cvda) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(cvda);
	}

	@Override
	public void delete(int id) {
		Session session = this.sessionFactory.openSession();
		CongViecDuAn cvda = session.load(CongViecDuAn.class, id);
		session.delete(cvda);
		session.close();

	}

	@Override
	public CongViecDuAn getCongViecDuAnByIdCongViecDuAn(String maDuAn, String maCongViec, String maCha) {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<CongViecDuAn> listcvda = session.createQuery("from CongViecDuAn tt where tt.maDuAn  = '" + maDuAn
				+ "' and tt.maCongViec ='" + maCongViec + "' and tt.maCha = '" + maCha + "'").list();
		CongViecDuAn cvda = listcvda.get(0);
		return cvda;
	}

	@Override
	public int getRecordsTotalByMaCha(String maDuAn, String maCha) {
		Session session = sessionFactory.getCurrentSession();
		int rowCount = session
				.createQuery("from CongViecDuAn tt where tt.maDuAn = '" + maDuAn + "' and tt.maCha ='" + maCha + "'")
				.list().size();
		return rowCount;
	}

}
