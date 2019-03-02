package com.ffse1704.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ffse1704.model.VatLieu;

@Repository
public class VatLieuDaoImpl implements VatLieuDao {

	@Autowired
	private SessionFactory sessionFactory;

	public VatLieuDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addNew(VatLieu vl) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(vl);
	}

	@Override
	public void update(VatLieu vl) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(vl);
	}

	@Override
	public VatLieu getId(String maVatLieu) {
		Session session = sessionFactory.getCurrentSession();
		VatLieu vl = session.get(VatLieu.class, maVatLieu);
		return vl;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<VatLieu> listVL(int iDisplayStart, int iDisplayLength) {
		Session session = this.sessionFactory.getCurrentSession();
		List<VatLieu> List = (List<VatLieu>) session.createQuery("FROM VatLieu where is_delete = 0").setFirstResult(iDisplayStart)
				.setMaxResults(iDisplayLength).list();
		return List;
	}

	@Override
	public int getRecordsTotal() {
		Session session = sessionFactory.getCurrentSession();
		List<VatLieu> lt = session.createQuery("from VatLieu where is_delete = 0", VatLieu.class).list();
		return  lt.size();
	}

	@Override
	public int getRecordsByIdVatLieu(String maVatLieu) {
		Session session = sessionFactory.getCurrentSession();
		int rowCount = session.createQuery("from VatLieu where maCongViec='" + maVatLieu + "'").list().size();
		return rowCount;
	}

	@Override
	public void delete(String vl) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(vl);
	}

}
