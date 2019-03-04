package com.ffse1704.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import com.ffse1704.model.DanhMucDuAn;
import com.ffse1704.service.DanhMucDuAnService;



@Controller
@RequestMapping("/danhmucduan")
public class DanhMucDuAnControler {
	
	@Autowired
	private DanhMucDuAnService danhMucDuAnservice;
	
	public void setDanhMucDuAnHService(DanhMucDuAnService danhMucDuAnservice) {
		this.danhMucDuAnservice = danhMucDuAnservice;
	}
	
	@RequestMapping("/list")
	public String ListAll(Model model) {
		List<DanhMucDuAn> listDmda = danhMucDuAnservice.getAll();
		model.addAttribute("list", listDmda);
		return "danhmucduan/list";
	}

}
