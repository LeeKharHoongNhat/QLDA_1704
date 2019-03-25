package com.ffse1704.dao;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.ffse1704.model.NhanCong;
import com.ffse1704.model.VatLieu;

@Repository
public class VatLieuDaoImpl extends ResponsitoryDaoImpl<VatLieu, String> implements VatLieuDao {

	@Override
	public List<VatLieu> view(int iDisplayStart, int iDisplayLength, String order) {
		Query<VatLieu> query = createQuery("FROM VatLieu vl  WHERE isDelete=0 ORDER BY vl.maCongViec " + order);

		query.setFirstResult(iDisplayStart).setMaxResults(iDisplayLength);

		return query.list();
	}

	@Override
	public int getRecordsTotal() {
		List<VatLieu> List = (List<VatLieu>) createQuery("FROM VatLieu").list();
		return List.size();
	}

}
