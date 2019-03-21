package com.ffse1704.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ffse1704.model.LogWork;

@Repository
public class LogWorkDaoImpl extends ResponsitoryDaoImpl<LogWork, Integer> implements LogWorkDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private ThongTinDuAnDao thongTinDuAnDao;

	@Autowired
	private CongViecDuAnDao congViecDuAnDao;

	@Autowired
	private NhanVienDao nhanVienDao;

	@Override
	public List<LogWork> listLogWork(String maDuAn, String maCongViec, int iDisplayStart, int iDisplayLength) {
		List<LogWork> listLogWork = createQuery(
				"from LogWork where maDuAn ='" + maDuAn + "'and maCongViec ='" + maCongViec + "'")
						.setFirstResult(iDisplayStart).setMaxResults(iDisplayLength).list();
		listLogWork.forEach(logWork -> {
			logWork.setDuAn(thongTinDuAnDao.findById(logWork.getMaDuAn()));
			logWork.setCongViec(congViecDuAnDao.findById(logWork.getMaCongViec()));
			logWork.setNhanVien(nhanVienDao.findById(logWork.getMaNhanVien()));
		});
		return listLogWork;
	}

	@Override
	public int getRecordsTotal(String maDuAn, String maCongViec) {
		int rowCount = createQuery("from LogWork where maDuAn ='" + maDuAn + "'and maCongViec ='" + maCongViec + "'")
				.list().size();
		return rowCount;
	}

	@SuppressWarnings({ "unchecked" })
	@Override
	public LogWork getOneLogWork(int id) {
		Session session = this.sessionFactory.openSession();
		List<LogWork> listLogWork = session.createQuery("from LogWork where id ='" + id + "'").list();
		LogWork logWork = listLogWork.get(0);
		return logWork;

	}
}
