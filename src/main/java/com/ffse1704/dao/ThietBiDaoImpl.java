package com.ffse1704.dao;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.ffse1704.model.ThietBi;

@Repository
public class ThietBiDaoImpl extends ResponsitoryDaoImpl<ThietBi, Integer> implements ThietBiDao {

	@Override
	public List<ThietBi> viewOne(String maDA) {
		@SuppressWarnings("rawtypes")
		Query query = createQuery("from ThietBi where ma_du_an = :ma_du_an and isActive = :active");
		query.setParameter("ma_du_an", maDA);
		query.setParameter("active", 1);
		@SuppressWarnings("unchecked")
		List<ThietBi> viewOne = query.list();
		return viewOne;
	}

	@Override
	public ThietBi getThietBiById(Integer id) {
		return  findById(id); 
	}



}
