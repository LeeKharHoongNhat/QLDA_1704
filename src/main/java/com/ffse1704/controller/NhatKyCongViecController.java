package com.ffse1704.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ffse1704.service.NhatKyCongViecService;

@Controller
public class NhatKyCongViecController {

	@Autowired
	private NhatKyCongViecService nhatKyCongViecService;

	@RequestMapping("/nhatkycongviec")
	public String list( Model model) {
		model.addAttribute("view", this.nhatKyCongViecService.list());
		model.addAttribute("maNv","NV001");
		return "nhatkycongviec/list";
	}
	@RequestMapping("/add")
	public String add(@RequestParam("maNv") String maNv, @RequestParam("maDuAn") String maDuAn,
			@RequestParam("noiDung") String noiDung) {
		return "nhatkycongviec/list";
	}
}
