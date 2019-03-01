package com.ffse1704.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ffse1704.model.ThietBi;

@Repository
public class ThietBiDaoImpl implements ThietBiDao {
	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<ThietBi> viewOne(String maCV) {
		Session session = this.sessionFactory.openSession();
		@SuppressWarnings("rawtypes")
		Query query = session.createQuery("from ThietBi where ma_cong_viec = :ma_cong_viec and isActive = :active");
		query.setParameter("ma_cong_viec", maCV);
		query.setParameter("active", 0);
		@SuppressWarnings("unchecked")
		List<ThietBi> viewOne = query.list();
		return viewOne;
	}

	@Override
	public void addThietBi(ThietBi tb) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(tb);
	}

	@Override
	public ThietBi getThietBiById(int id) {
		Session session = this.sessionFactory.openSession();
		ThietBi tb = (ThietBi) session.load(ThietBi.class, new Integer(id));
		return tb;
	}

	@Override
	public void updateThietBi(ThietBi tb) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(tb);
	}
	@Override
	public void removeThietBi(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		@SuppressWarnings("rawtypes")
		Query query = session.createQuery("update ThietBi set isActive = :active" + " where id = :id");
		query.setParameter("active", 1);
		query.setParameter("id", id);
		@SuppressWarnings("unused")
		int result = query.executeUpdate();
	}

}
