package com.ffse1704.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ffse1704.dao.NhanVienDao;
import com.ffse1704.model.NhanVien;

@Controller
public class HomeController {
	private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);
	
	
	@RequestMapping("/")
	public String viewHome() {
		return "home";
	}
	
}
