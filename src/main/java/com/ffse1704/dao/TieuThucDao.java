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
public interface TieuThucDao extends RepositoryDao<TieuThuc, String>{
	
	
	public List<TieuThuc> getListTieuThucByMaCha(String maCha);
	
	public List<TieuThuc> getListTieuThucByMaChaNull();

	public List<TieuThuc> listTieuThuc(int iDisplayStart, int iDisplayLength);

	public int getRecordsTotalMaChaNull();

	/*public int getRecordsByIdTieuThuc(String id);*/
}
