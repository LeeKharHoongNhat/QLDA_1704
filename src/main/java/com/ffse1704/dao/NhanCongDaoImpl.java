package com.ffse1704.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ffse1704.model.NhanCong;

@Repository
public class NhanCongDaoImpl implements NhanCongDao {

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")

	@Override
	public List<NhanCong> view(int iDisplayStart, int iDisplayLength) {
		Session session = this.sessionFactory.getCurrentSession();
		List<NhanCong> List = (List<NhanCong>) session.createQuery("FROM NhanCong").setFirstResult(iDisplayStart)
				.setMaxResults(iDisplayLength).list();
		return List;
	}

	@SuppressWarnings("unchecked")
	@Override
	public int getRecordsTotal() {
		Session session = this.sessionFactory.getCurrentSession();
		List<NhanCong> List = (List<NhanCong>) session.createQuery("FROM NhanCong").list();
		return List.size();
	}

	@Override
	public void addNew(NhanCong nc) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.save(nc);

	}

	@Override
	public void update(NhanCong nc) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.update(nc);
	}

	@Override
	public void delete(String nc) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.delete(nc);

	}

	@Override
	public NhanCong getId(String maCongViec) {
		Session session = sessionFactory.getCurrentSession();
		NhanCong nc = session.get(NhanCong.class, maCongViec);
		return nc;
	}

}
