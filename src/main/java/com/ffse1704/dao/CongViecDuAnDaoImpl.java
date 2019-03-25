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
public class CongViecDuAnDaoImpl extends ResponsitoryDaoImpl<CongViecDuAn, String>implements CongViecDuAnDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private ThongTinDuAnDao thongTinDuAnDao;
	
	@Autowired
	private NhanVienDao nhanVienDao;

	@Override
	public List<CongViecDuAn> listCongViecDuAnByMaCha(String maDuAn, int iDisplayStart,
			int iDisplayLength) {
		List<CongViecDuAn> listcvda = createQuery(
						"from CongViecDuAn tt where tt.maDuAn  = '" + maDuAn + "'")
				.setFirstResult(iDisplayStart).setMaxResults(iDisplayLength).list();
		listcvda.forEach(cvda ->{
			cvda.setDuAn(thongTinDuAnDao.findById(cvda.getMaDuAn()));
			cvda.setNhanVien(nhanVienDao.findById(cvda.getMaNhanVien()));
		});
		return listcvda;
	}

	@Override
	public void delete(int id) {
		Session session = this.sessionFactory.openSession();
		CongViecDuAn cvda = session.load(CongViecDuAn.class, id);
		session.delete(cvda);
		session.close();

	}

	@Override
	public CongViecDuAn getCongViecDuAnById(int id) {
		List<CongViecDuAn> listcvda = createQuery("from CongViecDuAn tt where tt.id  = '" + id+"'").list();
		listcvda.forEach(cvda ->{
			cvda.setDuAn(thongTinDuAnDao.findById(cvda.getMaDuAn()));
			cvda.setNhanVien(nhanVienDao.findById(cvda.getMaNhanVien()));
		});
		CongViecDuAn cvda = listcvda.get(0);
		return cvda;
	}

	@Override
	public int getRecordsTotalByMaCha(String maDuAn) {
		int rowCount =createQuery("from CongViecDuAn tt where tt.maDuAn = '" + maDuAn + "'")
				.list().size();
		return rowCount;
	}

}
