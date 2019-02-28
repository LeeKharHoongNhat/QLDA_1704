package com.ffse1704.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ffse1704.model.NhanVien;
@Repository
public class NhanVienDaolmpl implements NhanVienDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public List<NhanVien> listNhanVien() {
		Session session = this.sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<NhanVien> nhanVienList = session.createQuery("from NhanVien").list();
		return nhanVienList;
	}

}
