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

import com.ffse1704.model.TieuThuc;


/**
 * @author QuangDai
 *
 */

@Repository
public class TieuThucDaoImpl implements TieuThucDao {
	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ffse1704.dao.tieuthuc.TieuThucDao#addNew(ffse1704.entity.tieuthuc.TieuThuc)
	 */
	@Override
	public void addNew(TieuThuc tt) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(tt);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ffse1704.dao.tieuthuc.TieuThucDao#update(ffse1704.entity.tieuthuc.TieuThuc)
	 */
	@Override
	public void update(TieuThuc tt) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(tt);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ffse1704.dao.tieuthuc.TieuThucDao#delete(java.lang.String)
	 */
	@Override
	public void delete(int id) {
		Session session = this.sessionFactory.openSession();
		Transaction pd = session.beginTransaction();
		session.update(session.get(TieuThuc.class, id));
		pd.commit();
		session.close();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ffse1704.dao.tieuthuc.TieuThucDao#getTieuThucByIdTieuThuc(java.lang.String)
	 */
	@Override
	public TieuThuc getTieuThucByIdTieuThuc(String id) {
		Session session = this.sessionFactory.getCurrentSession();
		List<TieuThuc> listTieuThuc = session.createQuery("from TieuThuc tt where tt.id = '" + id + "'", TieuThuc.class)
				.list();
		TieuThuc TieuThuc = listTieuThuc.get(0);
		return TieuThuc;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ffse1704.dao.tieuthuc.TieuThucDao#listTieuThuc(int, int)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<TieuThuc> listTieuThuc(int iDisplayStart, int iDisplayLength) {
		Session session = this.sessionFactory.getCurrentSession();
		List<TieuThuc> TieuThucList = session.createQuery("from TieuThuc tt where tt.maCha = '"+"'").setFirstResult(iDisplayStart)
				.setMaxResults(iDisplayLength).list();
		return TieuThucList;
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see ffse1704.dao.tieuthuc.TieuThucDao#getRecordsTotal()
	 */
	@Override
	public int getRecordsTotalMaChaNull() {
		Session session = sessionFactory.getCurrentSession();
		int rowCount = session.createQuery("from TieuThuc tt where tt.maCha = '"+"'").list().size();
		return rowCount;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ffse1704.dao.tieuthuc.TieuThucDao#getRecordsByIdTieuThuc(java.lang.String)
	 */
	@Override
	public int getRecordsByIdTieuThuc(String id) {
		Session session = sessionFactory.getCurrentSession();
		int rowCount = session.createQuery("from TieuThuc tt where tt.id='" + id + "'").list().size();
		return rowCount;
	}

	@Override
	public List<TieuThuc> getListTieuThucByMaCha(String maCha) {
		Session session = sessionFactory.getCurrentSession();
		List<TieuThuc> listTieuThucCon = session.createQuery("from TieuThuc  where maCha = '" + maCha + "'", TieuThuc.class)
				.list();
		return listTieuThucCon;
	}

	@Override
	public List<TieuThuc> getListTieuThucByMaChaNull() {
		Session session = sessionFactory.getCurrentSession();
		List<TieuThuc> listTieuThucMaChaNull = session.createQuery("from TieuThuc tt where tt.maCha = '"+"'", TieuThuc.class)
				.list();
		return listTieuThucMaChaNull;
	}

}
