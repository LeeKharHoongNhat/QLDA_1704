package com.ffse1704.dao;

import java.util.List;

import com.ffse1704.model.LogWork;

public interface LogWorkDao extends RepositoryDao<LogWork, Integer> {

	public List<LogWork> listLogWork(String maDuAn, String maCongViec, int iDisplayStart, int iDisplayLength);

	public int getRecordsTotal(String maDuAn, String maCongViec);

	public LogWork getOneLogWork(int id);

}
