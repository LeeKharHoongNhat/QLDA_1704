package com.ffse1704.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ffse1704.model.NhatKyCongViec;
import com.ffse1704.service.NhatKyCongViecService;

@Controller
public class NhatKyCongViecController {
	
	@Autowired 
	private NhatKyCongViecService nhatKyCongViecService;
	
	@RequestMapping("/nhatkycongviec")
	public String list(Model model) {
		model.addAttribute("view", this.nhatKyCongViecService.list());
		return "nhatkycongviec/list" ;
	}
}
