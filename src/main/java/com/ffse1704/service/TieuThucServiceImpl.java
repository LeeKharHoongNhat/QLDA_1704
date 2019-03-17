/**
 * 
 */
package com.ffse1704.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ffse1704.dao.TieuThucDao;
import com.ffse1704.model.TieuThuc;

/**
 * @author QuangDai
 *
 */

@Service
public class TieuThucServiceImpl implements TieuThucService {
	@Autowired
	private TieuThucDao tieuThucDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see ffse1704.dao.tieuthuc.TieuThucDao#addNew(ffse1704.entity.tieuthuc.
	 * TieuThuc)
	 */
	@Override
	@Transactional
	public void addNew(TieuThuc tt) {
		this.tieuThucDao.save(tt);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ffse1704.dao.tieuthuc.TieuThucDao#update(ffse1704.entity.tieuthuc.
	 * TieuThuc)
	 */
	@Override
	@Transactional
	public void update(TieuThuc tt) {
		this.tieuThucDao.update(tt);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ffse1704.dao.tieuthuc.TieuThucDao#delete(java.lang.String)
	 */
	@Override
	@Transactional
	public void delete(String maTieuThuc) {
		TieuThuc tt = this.tieuThucDao.findById(maTieuThuc);
		this.tieuThucDao.delete(tt);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ffse1704.dao.tieuthuc.TieuThucDao#getTieuThucByIdTieuThuc(java.lang.
	 * String)
	 */
	@Override
	@Transactional
	public TieuThuc getTieuThucByIdTieuThuc(String maTieuThuc) {
		return this.tieuThucDao.findById(maTieuThuc);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ffse1704.dao.tieuthuc.TieuThucDao#listTieuThuc(int, int)
	 */
	@Override
	@Transactional
	public List<TieuThuc> listTieuThuc(int iDisplayStart, int iDisplayLength) {
		return this.tieuThucDao.listTieuThuc(iDisplayStart, iDisplayLength);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ffse1704.dao.tieuthuc.TieuThucDao#getRecordsTotal()
	 */
	@Override
	@Transactional
	public int getRecordsTotalMaChaNull() {
		return this.tieuThucDao.getRecordsTotalMaChaNull();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ffse1704.dao.tieuthuc.TieuThucDao#getRecordsByIdTieuThuc(java.lang.
	 * String)
	 */
	/*
	 * @Override
	 * 
	 * @Transactional public int getRecordsByIdTieuThuc(String id) { return
	 * this.tieuThucDao.getRecordsByIdTieuThuc(id); }
	 */
	@Override
	@Transactional
	public List<TieuThuc> getListTieuThucByMaCha(String maCha) {
		return this.tieuThucDao.getListTieuThucByMaCha(maCha);
	}

	@Override
	@Transactional
	public List<TieuThuc> getListTieuThucByMaChaNull() {
		return this.tieuThucDao.getListTieuThucByMaChaNull();
	}

}
