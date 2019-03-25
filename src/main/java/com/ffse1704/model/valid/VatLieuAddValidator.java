package com.ffse1704.model.valid;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.ffse1704.dao.VatLieuDao;
import com.ffse1704.model.NhanCong;
import com.ffse1704.model.VatLieu;

@Component
public class VatLieuAddValidator implements Validator{

	@Autowired
	private VatLieuDao vatLieuDao;

	
	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return arg0.equals(VatLieu.class);
	}

	@Override
	@Transactional
	public void validate(Object arg0, Errors errors) {
		VatLieu vl = (VatLieu)arg0;
		VatLieu data = vatLieuDao.findById(vl.getMaCongViec());
		if(data!=null) {
			errors.rejectValue("maCongViec", "", "Mã công việc đã tồn tại");
		}
	}

}
