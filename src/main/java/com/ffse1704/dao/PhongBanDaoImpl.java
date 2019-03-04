package com.ffse1704.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ffse1704.model.PhongBan;


@Repository
public class PhongBanDaoImpl extends ResponsitoryDaoImpl<PhongBan, String> implements PhongBanDao {
	
	
	private final SessionFactory sessionFactory;

	@Autowired
	public PhongBanDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
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
