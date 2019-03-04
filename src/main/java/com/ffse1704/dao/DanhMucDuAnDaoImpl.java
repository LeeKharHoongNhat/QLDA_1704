package com.ffse1704.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ffse1704.model.DanhMucDuAn;
@Repository
@Transactional
public class DanhMucDuAnDaoImpl extends ResponsitoryDaoImpl<DanhMucDuAn, String> implements DanhMucDuAnDao {
	@Autowired
	SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	@SuppressWarnings("unchecked")
	public List<DanhMucDuAn> getAll() {
		Session session = sessionFactory.getCurrentSession();
		List<DanhMucDuAn> list = session.createQuery("from DanhMucDuAn ").getResultList();
		return list;
	}
}
