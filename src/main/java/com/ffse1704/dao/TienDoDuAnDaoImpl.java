package com.ffse1704.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ffse1704.model.TienDoDuAn;

@Repository
public class TienDoDuAnDaoImpl extends ResponsitoryDaoImpl<TienDoDuAn, String> implements TienDoDuAnDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private ThongTinDuAnDao thongTinDuAnDao;
	@Autowired
	private CongViecDuAnDao congViecDuAnDao;
	@Autowired
	private NhanVienDao nhanVienDao;

	@Override
	public List<TienDoDuAn> listTienDoDuAn(int iDisplayStart, int iDisplayLength) {
		List<TienDoDuAn> tienDoDuAnList = createQuery("from TienDoDuAn ").setFirstResult(iDisplayStart)
				.setMaxResults(iDisplayLength).list();
		tienDoDuAnList.forEach(tienDo -> {
			tienDo.setThongTinDuAn(thongTinDuAnDao.findById(tienDo.getMaDuAn()));
			tienDo.setCongViecDuAn(congViecDuAnDao.findById(tienDo.getMaCongViec()));
			tienDo.setNhanVien(nhanVienDao.findById(tienDo.getMaNhanVien()));
		});
		return tienDoDuAnList;
	}

	@Override
	public int getRecordsTotal() {
		int rowCount = createQuery("from TienDoDuAn").list().size();
		return rowCount;
	}

	@Override
	public int getRecordsByIdCongViec(String maDuAn, String maCOngViec) {
		int rowCount = createQuery("from TienDoDuAn where maDuAn='" + maDuAn + "'and maCongViec='" + maCOngViec + "'")
				.list().size();
		return rowCount;
	}

	@Override
	public TienDoDuAn getOne(String maDuAn, String maCongViec) {
		List<TienDoDuAn> tienDoDuAnList = createQuery(
				"from TienDoDuAn where maDuAn ='" + maDuAn + "' and maCongViec='" + maCongViec + "'").list();
		TienDoDuAn getOne = tienDoDuAnList.get(0);
		return getOne;
	}

	@Override
	public void delete(int id) {
		Session session = this.sessionFactory.openSession();
		TienDoDuAn tdda = session.load(TienDoDuAn.class, id);
		session.delete(tdda);
		session.close();
		
	}

}
