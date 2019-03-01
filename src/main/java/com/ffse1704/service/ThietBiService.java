package com.ffse1704.service;

import java.util.List;

import com.ffse1704.model.ThietBi;

public interface ThietBiService {

	public List<ThietBi> viewOne(String maCv);

	public void addThietBi(ThietBi tb);

	public ThietBi getThietBiById(int id);

	public void updateThietBi(ThietBi tb);

	public void removeThietBi(int id);

}
