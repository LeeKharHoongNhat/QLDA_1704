package com.ffse1704.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ffse1704.model.NhatKyCongViec;
import com.ffse1704.service.NhatKyCongViecService;
import com.ffse1704.service.ThongTinDuAnService;

@Controller
public class NhatKyCongViecController {
	String maNv="NV001";
	
	
	@Autowired
	private NhatKyCongViecService nhatKyCongViecService;

	@Autowired
	private ThongTinDuAnService thongTinDuAnService;

	@RequestMapping("/nhatkycongviec")
	public String list(Model model,@RequestParam(value = "MDA",required=false) String maDuAn) {
		//do vao selectbox
		model.addAttribute("listDuAn", this.nhatKyCongViecService.listDuAn(maNv));
		model.addAttribute("maNv", maNv);
		if(maDuAn != null) {
			model.addAttribute("MDA",maDuAn);
		}
		return "nhatkycongviec/list";
	}

	@RequestMapping("/add")
	public String add( @RequestParam("maDuAn") String maDuAn,
			@RequestParam("noiDung") String noiDung) {
		NhatKyCongViec nkcv = new NhatKyCongViec();
		nkcv.setMaDuAn(maDuAn);
		nkcv.setNoiDung(noiDung);
		nkcv.setIsActive(1);
		nkcv.setMaNhanVien(maNv);
		
		nhatKyCongViecService.add(nkcv);
		
		return "redirect:/nhatkycongviec?MDA="+nkcv.getMaDuAn();
	}
	@RequestMapping("/getDataTable")
	public String getMaDuAn(Model model,@RequestParam("maDuAn") String maDuAn) {
		model.addAttribute("nhatkys", this.nhatKyCongViecService.listNhatKyCongViec(maDuAn));
		return "nhatkycongviec/list-nkcv-fragment";
	}
	
}
