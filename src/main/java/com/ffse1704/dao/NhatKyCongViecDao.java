package com.ffse1704.dao;

import java.util.List;

import com.ffse1704.model.NhatKyCongViec;
import com.ffse1704.model.ThongTinDuAn;

public interface NhatKyCongViecDao extends RepositoryDao<NhatKyCongViec, Integer> {
	List<ThongTinDuAn> listDuAn(String maNv);
	List<NhatKyCongViec> listNhatKyCongViec(String maDuAn);
}
