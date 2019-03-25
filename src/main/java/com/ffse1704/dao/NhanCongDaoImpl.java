package com.ffse1704.dao;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ffse1704.model.NhanCong;
import com.ffse1704.model.NhanVien;

@Repository
public class NhanCongDaoImpl extends ResponsitoryDaoImpl<NhanCong, String> implements NhanCongDao {

	
	@Autowired
	NhanVienDao nhanVienDao;

	@Override
	public List<NhanCong> view(int iDisplayStart, int iDisplayLength, String order) {

		Query<NhanCong> query = createQuery("FROM NhanCong nc WHERE isDelete=0 ORDER BY nc.maCongViec " + order );

		query.setFirstResult(iDisplayStart).setMaxResults(iDisplayLength);
		
		return query.list();
	}

	@Override
	public int getRecordsTotal() {

		List<NhanCong> List = (List<NhanCong>) createQuery("FROM NhanCong where isDelete = 0").list();
		return List.size();
	}

	@Override
	public List<NhanVien> ListChoiceNV() {
		// TODO Auto-generated method stub

		 Query<NhanVien>	query = nhanVienDao.createQuery("SELECT nv FROM NhanVien nv WHERE nv.maNhanVien NOT IN (SELECT nc.maNhanVien FROM NhanCong nc)");
	
		return query.list(); 
	}


	
	

}
