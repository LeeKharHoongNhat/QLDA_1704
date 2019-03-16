package com.ffse1704.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ffse1704.model.PhongBan;


@Repository
public class PhongBanDaoImpl extends ResponsitoryDaoImpl<PhongBan, String> implements PhongBanDao {
	
	
	@Autowired
	private TieuThucDao tieuThucDao;

	

	@Override
	public List<PhongBan> listPhongBan(String maTrangThai,int iDisPlayStart, int iDinPlayLength) {
		List<PhongBan> phongBanList = createQuery("from PhongBan where trangThai ='"+maTrangThai+"'").setFirstResult(iDisPlayStart)
				.setMaxResults(iDinPlayLength).list();
		phongBanList.forEach(pb ->{
			pb.setTtTrangThai(tieuThucDao.findById(pb.getTrangThai()));
		});
		return phongBanList;
	}

	@Override
	public int getRecordsTotal(String maTrangThai) {
		int rowCount = createQuery("from PhongBan where trangThai ='"+maTrangThai+"'").list().size();
		return rowCount;
	}

	@Override
	public int getRecordsByIdPhongBan(String maPhongBan) {
		int rowCount = createQuery("from PhongBan where maPhongBan='" + maPhongBan + "'").list().size();
		return rowCount;
	}
}
