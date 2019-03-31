package com.ffse1704.dao;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ffse1704.model.NhatKyCongViec;
import com.ffse1704.model.ThongTinDuAn;

@Repository
public class NhatKyCongViecDaoImpl extends ResponsitoryDaoImpl<NhatKyCongViec, Integer> implements NhatKyCongViecDao {
	@Autowired
	private ThongTinDuAnDao thongTinDuAn;
	
	@Override
	public List<ThongTinDuAn> listDuAn(String maNv) {
		StringBuilder hql= new StringBuilder();
		hql.append("SELECT ttda FROM ThongTinDuAn ttda ");
		hql.append("INNER JOIN NhanCong nc ");
		hql.append("ON ttda.maDuAn = nc.maDuAn ");
		hql.append("INNER JOIN NhanVien nv ");
		hql.append("ON nv.maNhanVien = nc.maNhanVien ");
		hql.append("WHERE nc.maNhanVien = :maNv");
		
		Query query = thongTinDuAn.createQuery(hql.toString());
		query.setParameter("maNv", maNv);
		return query.list();
	}
	@Override
	public List<NhatKyCongViec> listNhatKyCongViec(String maDuAn) {
		StringBuilder hql= new StringBuilder();
		hql.append("SELECT nkcv FROM NhatKyCongViec nkcv ");	
		hql.append("WHERE nkcv.maDuAn = :maDuAn");
		
		Query query = createQuery(hql.toString());
		query.setParameter("maDuAn", maDuAn);
		return query.list();
	}
}
