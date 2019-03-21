package com.ffse1704.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ffse1704.model.NhanVien;

/**
 * @author KhaNhat
 *
 */
@Repository
public class NhanVienDaolmpl extends ResponsitoryDaoImpl<NhanVien, String> implements NhanVienDao {
	
	@Autowired
	private TieuThucDao tieuThucDao;
	

	@Override
	public List<NhanVien> listNhanVien(int iDisplayStart, int iDisplayLength) {
		List<NhanVien> nhanVienList = createQuery("from NhanVien").setFirstResult(iDisplayStart)
				.setMaxResults(iDisplayLength).list();
		nhanVienList.forEach(nv -> {
			nv.setTtChucDanh(tieuThucDao.findById(nv.getMaChucDanh()));
			nv.setTtLoaiHD(tieuThucDao.findById(nv.getMaLoaiHopDong()));
			nv.setTtTrangThai(tieuThucDao.findById(nv.getMaTrangThai()));
		});
		return nhanVienList;
	}

	@Override
	public int getRecordsTotal() {
		int rowCount = createQuery("from NhanVien").list().size();
		return rowCount;
	}

	@Override
	public int getRecordsByIdNhanVien(String maNhanVien) {
		int rowCount = createQuery("from NhanVien where maNhanVien='" + maNhanVien + "'").list().size();
		return rowCount;
	}

	@Override
	public NhanVien getOneNhanVien(String maNhanVien) {
		List<NhanVien> nhanVienList = createQuery("from NhanVien where maNhanVien='"+maNhanVien+"'").list();
		nhanVienList.forEach(nv -> {
			nv.setTtChucDanh(tieuThucDao.findById(nv.getMaChucDanh()));
			nv.setTtLoaiHD(tieuThucDao.findById(nv.getMaLoaiHopDong()));
			nv.setTtTrangThai(tieuThucDao.findById(nv.getMaTrangThai()));
		});
		NhanVien nhanVien = nhanVienList.get(0);
		return nhanVien;
	}


}
