package com.ffse1704.dao;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.ffse1704.model.NhanCong;

@Repository
public class NhanCongDaoImpl extends ResponsitoryDaoImpl<NhanCong, String> implements NhanCongDao {


	@Override
	public List<NhanCong> view(int iDisplayStart, int iDisplayLength, String order) {

		Query<NhanCong> query = createQuery("FROM NhanCong nc ORDER BY nc.maCongViec " + order );

		query.setFirstResult(iDisplayStart).setMaxResults(iDisplayLength);
		
		return query.list();
	}

	@Override
	public int getRecordsTotal() {

		List<NhanCong> List = (List<NhanCong>) createQuery("FROM NhanCong").list();
		return List.size();
	}
	
	

}
