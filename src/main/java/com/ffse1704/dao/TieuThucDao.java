/**
 * 
 */
package com.ffse1704.dao;

import java.util.List;

import com.ffse1704.model.TieuThuc;


/**
 * @author QuangDai
 *
 */
public interface TieuThucDao {
	
	public void addNew(TieuThuc tt);

	public void update(TieuThuc tt);

	public void delete(int id);

	public TieuThuc getTieuThucByIdTieuThuc(String id);

	public List<TieuThuc> listTieuThuc(int iDisplayStart, int iDisplayLength);

	public int getRecordsTotalMaChaNull();

	public int getRecordsByIdTieuThuc(String id);
}
