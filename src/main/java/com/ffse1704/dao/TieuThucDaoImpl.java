/**
 * 
 */
package com.ffse1704.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ffse1704.model.TieuThuc;


/**
 * @author QuangDai
 *
 */

@Repository
public class TieuThucDaoImpl extends ResponsitoryDaoImpl<TieuThuc, String> implements TieuThucDao {
	

	
	/*
	 * (non-Javadoc)
	 * 
	 * @see ffse1704.dao.tieuthuc.TieuThucDao#listTieuThuc(int, int)
	 */
	
	@Override
	public List<TieuThuc> listTieuThuc(int iDisplayStart, int iDisplayLength) {
		List<TieuThuc> TieuThucList = createQuery("from TieuThuc tt where tt.maCha = '"+"'").setFirstResult(iDisplayStart)
				.setMaxResults(iDisplayLength).list();
		return TieuThucList;
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see ffse1704.dao.tieuthuc.TieuThucDao#getRecordsTotal()
	 */
	@Override
	public int getRecordsTotalMaChaNull() {

		int rowCount = createQuery("from TieuThuc tt where tt.maCha = '"+"'").list().size();
		return rowCount;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ffse1704.dao.tieuthuc.TieuThucDao#getRecordsByIdTieuThuc(java.lang.String)
	 */
	/*@Override
	public int getRecordsByIdTieuThuc(String id) {
		Session session = sessionFactory.getCurrentSession();
		int rowCount = session.createQuery("from TieuThuc tt where tt.id='" + id + "'").list().size();
		return rowCount;
	}*/

	@Override
	public List<TieuThuc> getListTieuThucByMaCha(String maCha) {
		List<TieuThuc> listTieuThucCon = createQuery("from TieuThuc  where maCha = '" + maCha + "'")
				.list();
		return listTieuThucCon;
	}

	@Override
	public List<TieuThuc> getListTieuThucByMaChaNull() {
		List<TieuThuc> listTieuThucMaChaNull = createQuery("from TieuThuc tt where tt.maCha = '"+"'")
				.list();
		return listTieuThucMaChaNull;
	}

}
