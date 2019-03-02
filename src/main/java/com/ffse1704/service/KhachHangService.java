/**
 * 
 */
package com.ffse1704.service;

import java.util.List;

import com.ffse1704.model.KhachHang;

/**
 * @author QuangDai
 *
 */
public interface KhachHangService {
	
	public void addNew(KhachHang kh);

	public void update(KhachHang kh);

	void delete(KhachHang maKhachHang);

	public KhachHang getById(String maKhachHang);

	public List<KhachHang> listKhachHang(int iDisplayStart, int iDisplayLength);

	public int getRecordsTotal();

	public int getRecordsByIdPKhachHang(String maKhachHang);

}