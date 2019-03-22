package com.ffse1704.service;

import java.util.List;

import com.ffse1704.model.NhatKyCongViec;
import com.ffse1704.model.ThongTinDuAn;

public interface NhatKyCongViecService {
	List<NhatKyCongViec> listNhatKyCongViec(String maDuAn);

	List<ThongTinDuAn> listDuAn(String maNv);

	void add(NhatKyCongViec nkcv);
}
