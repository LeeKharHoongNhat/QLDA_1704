package com.ffse1704.dao;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ffse1704.model.PhongBan;
import com.ffse1704.model.ThongTinDuAn;
@Repository
public class ThongTinDuAnDaoImpl extends ResponsitoryDaoImpl<ThongTinDuAn, String> implements ThongTinDuAnDao {

	@Autowired
	private TieuThucDao tieuThucDao;
	@Autowired
	private NhanVienDao nhanVienDao;
	@Autowired
	private KhachHangDao khachHangDao;
	@Autowired
	private PhongBanDao phongBanDao;
	
	@Override
	public List<ThongTinDuAn> listDuAn(String maTrangThai, int iDisplayStart, int iDisplayLength) {
		List<ThongTinDuAn> duAnList = createQuery("from ThongTinDuAn where maTrangThai ='"+maTrangThai+"'").setFirstResult(iDisplayStart)
				.setMaxResults(iDisplayLength).list();
		duAnList.forEach(da ->{
			da.setPhongBan(phongBanDao.findById(da.getMaPhongBan()));
			da.setNhanVienPm(nhanVienDao.findById(da.getMaNhanVienPM()));
			da.setTrangThai(tieuThucDao.findById(da.getMaTrangThai()));
			da.setKhachHang(khachHangDao.findById(da.getMaKhachHang()));
		});
		return duAnList;
	}

	@Override
	public int getRecordsTotal(String maTrangThai) {
		int rowCount = createQuery("from ThongTinDuAn where maTrangThai ='"+maTrangThai+"'").list().size();
		return rowCount;
	}

	@Override
	public int getRecordsByIdDuAn(String maDuAn) {
		int rowCount = createQuery("from ThongTinDuAn where maDuAn='" + maDuAn + "'").list().size();
		return rowCount;
	}

}
