package com.ffse1704.service;

import java.util.List;

import com.ffse1704.model.LogWork;

public interface LogWorkService {

	boolean addNew(LogWork logwork);

	boolean update(LogWork logwork);

	public LogWork getOneLogWork(int id);

	public List<LogWork> listLogWorkPage(String maDuAn, String maCongViec, int iDisplayStart, int iDisplayLength);
	
	public List<LogWork> listLogWork(String maDuAn, String maCongViec);

	public int getRecordsTotal(String maDuAn, String maCongViec);
}
