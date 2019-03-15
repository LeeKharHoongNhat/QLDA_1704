package com.ffse1704.model.valid;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.ffse1704.dao.NhanCongDao;
import com.ffse1704.model.NhanCong;

@Component
public class NhanCongAddValidator implements Validator{

	@Autowired
	private NhanCongDao nhanCongDao;

	
	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return arg0.equals(NhanCong.class);
	}

	@Override
	@Transactional
	public void validate(Object arg0, Errors errors) {
		NhanCong nc = (NhanCong)arg0;
		NhanCong data = nhanCongDao.findById(nc.getMaCongViec());
		if(data!=null) {
			errors.rejectValue("maCongViec", "", "Mã công việc đã tồn tại");
		}
	}

}
