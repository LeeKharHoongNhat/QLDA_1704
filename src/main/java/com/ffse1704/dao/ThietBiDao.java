package com.ffse1704.dao;

import java.util.List;

import com.ffse1704.model.ThietBi;

public interface ThietBiDao {

	public List<ThietBi> viewOne(String maNV);

	public void addThietBi(ThietBi tb);

	public ThietBi getThietBiById(int id);

	public void updateThietBi(ThietBi tb);

	public void removeThietBi(int id);

}
