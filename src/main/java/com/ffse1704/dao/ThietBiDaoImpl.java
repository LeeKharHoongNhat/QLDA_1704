package com.ffse1704.dao;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.ffse1704.model.ThietBi;

@Repository
public class ThietBiDaoImpl extends ResponsitoryDaoImpl<ThietBi, Integer> implements ThietBiDao {

	@Override
	public List<ThietBi> viewOne(String maCV) {
		@SuppressWarnings("rawtypes")
		Query query = createQuery("from ThietBi where ma_cong_viec = :ma_cong_viec and isActive = :active");
		query.setParameter("ma_cong_viec", maCV);
		query.setParameter("active", 1);
		@SuppressWarnings("unchecked")
		List<ThietBi> viewOne = query.list();
		return viewOne;
	}

	@Override
	public ThietBi getThietBiById(Integer id) {
		return  findById(id); 
	}

	@Override
	public void removeThietBi(Integer id) {
		Query query = createQuery("update ThietBi set isActive = :active where id = :id");
		query.setParameter("active", 0);
		query.setParameter("id", id);
		@SuppressWarnings("unused")
		int result = query.executeUpdate();
	}

}
