package com.ffse1704.model.valid;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.ffse1704.common.Utils;
import com.ffse1704.model.ThietBi;

@Component
public class ThietBiAddValidator implements Validator{

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return arg0.equals(ThietBi.class);
	}

	@Override
	public void validate(Object arg0, Errors errors) {
		ThietBi tb = (ThietBi)arg0;
		if(tb.getChiPhi()==null) {
			errors.rejectValue("chiPhi", "", "Vui lòng nhập kiểu tiền tệ");
		}
		if(tb.getDonGia()==null) {
			errors.rejectValue("donGia", "", "Vui lòng nhập kiểu tiền tệ");
		}
	}

}
