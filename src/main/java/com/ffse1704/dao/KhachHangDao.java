/**
 * 
 */
package com.ffse1704.dao;

import java.util.List;

import com.ffse1704.model.KhachHang;

/**
 * @author QuangDai
 *
 */
public interface KhachHangDao {
	
	public void addNew(KhachHang kh);

	public void update(KhachHang kh);

	public void delete(String maKhachHang);

	public KhachHang getKhachHangbyIdKhachHang(String maKhachHang);

	public List<KhachHang> listKhachHang(int iDisplayStart, int iDisplayLength);

	public int getRecordsTotal();

	public int getRecordsByIdPKhachHang(String maKhachHang);

}
