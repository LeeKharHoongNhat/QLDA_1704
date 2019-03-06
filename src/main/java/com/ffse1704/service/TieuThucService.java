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

	public void delete(String maTieuThuc);

	public TieuThuc getTieuThucByIdTieuThuc(String maTieuThuc);
	
	public List<TieuThuc> getListTieuThucByMaCha(String maCha);
	
	public List<TieuThuc> getListTieuThucByMaChaNull();

	public List<TieuThuc> listTieuThuc(int iDisplayStart, int iDisplayLength);

	public int getRecordsTotalMaChaNull();

	/*public int getRecordsByIdTieuThuc(String maTieuThuc);*/
}
