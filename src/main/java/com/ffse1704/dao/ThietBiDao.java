package com.ffse1704.dao;

import java.util.List;

import com.ffse1704.model.ThietBi;

public interface ThietBiDao extends RepositoryDao<ThietBi, Integer> {

	public List<ThietBi> viewOne(String maDA);

	public ThietBi getThietBiById(Integer id);


}
