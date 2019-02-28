package com.ffse1704.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ffse1704.model.PhongBan;


@Repository
public class PhongBanDaoImpl implements PhongBanDao {
	
	
	private final SessionFactory sessionFactory;

	@Autowired
	public PhongBanDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addNew(PhongBan pb) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(pb);

	}

	@Override
	public void update(PhongBan pb) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(pb);
	}

	@Override
	public void delete(String maPhongBan) {
		Session session = this.sessionFactory.openSession();
		Transaction pd = session.beginTransaction();
		session.update(session.get(PhongBan.class, maPhongBan));
		pd.commit();
		session.close();

	}

	@Override
	public PhongBan getPhongBanbyIdPhongBan(String maPhongBan) {
		Session session = this.sessionFactory.getCurrentSession();
		List<PhongBan> listPhongBan = session.createQuery("from PhongBan where maPhongBan = '" + maPhongBan + "'", PhongBan.class)
				.list();
		PhongBan PhongBan = listPhongBan.get(0);
		return PhongBan;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PhongBan> listPhongBan(int iDisPlayStart, int iDinPlayLength) {
		Session session = this.sessionFactory.getCurrentSession();
		List<PhongBan> PhongBanList = session.createQuery("from PhongBan").setFirstResult(iDisPlayStart)
				.setMaxResults(iDinPlayLength).list();
		return PhongBanList;
	}

	@Override
	public int getRecordsTotal() {
		Session session = sessionFactory.getCurrentSession();
		int rowCount = session.createQuery("from PhongBan").list().size();
		return rowCount;
	}

	@Override
	public int getRecordsByIdPhongBan(String maPhongBan) {
		Session session = sessionFactory.getCurrentSession();
		int rowCount = session.createQuery("from PhongBan where maPhongBan='" + maPhongBan + "'").list().size();
		return rowCount;
	}
}
