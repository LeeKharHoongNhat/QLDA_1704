package com.ffse1704.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ffse1704.dao.NhanVienDao;
import com.ffse1704.model.NhanVien;

@Controller
public class TestController {

	@Autowired
	private NhanVienDao nhanVienDao;
	
	@RequestMapping("/test")
	public String test( Model model){
		List<NhanVien> list = nhanVienDao.listNhanVien();
		model.addAttribute("list",list);
		return "test";
	}
}
