/**
 * 
 */
package com.ffse1704.service;

import java.util.List;

import com.ffse1704.model.TieuThuc;

/**
 * @author QuangDai
 *
 */
public interface TieuThucService {
	
	public void addNew(TieuThuc tt);

	public void update(TieuThuc tt);

	public void delete(int id);

	public TieuThuc getTieuThucByIdTieuThuc(String id);

	public List<TieuThuc> listTieuThuc(int iDisplayStart, int iDisplayLength);

	public int getRecordsTotalMaChaNull();

	public int getRecordsByIdTieuThuc(String id);
}
