package com.ffse1704.controller;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ffse1704.model.CongViecDuAn;
import com.ffse1704.service.CongViecDuAnService;

/**
 * @author KhaNhat
 *
 */
@Controller
@RequestMapping("/congviecduan")
public class CongViecDuAnController {


	@Autowired
	private CongViecDuAnService congViecDuAnService;

	/* list Cong viec */
	@RequestMapping("/list")
	public String list(@RequestParam("maDuAn") String maDuAn, @RequestParam("page") Integer page, Model model)
			throws SQLException {
		int allItem = congViecDuAnService.getRecordsTotalByMaCha(maDuAn);
		int reCordInPage = 2;
		double pageTotal = allItem / reCordInPage + ((allItem % reCordInPage) == 0 ? 0 : 1);
		int total = (int) pageTotal;
		int start = (page * (int) reCordInPage) - (int) reCordInPage;
		List<CongViecDuAn> list = congViecDuAnService.listCongViecDuAnByMaCha(maDuAn, start, reCordInPage);
		model.addAttribute("tenDuAn", list.get(0));
		model.addAttribute("list", list);
		model.addAttribute("indexPage", page);
		model.addAttribute("allPage", total);
		/*
		 * CongViecDuAn.TrangThai test = CongViecDuAn.TrangThai.Open;
		 * model.addAttribute("test", test);
		 */
		return "congviecduan/list";
	}

	@RequestMapping("")
	public String getOne(@RequestParam("id") Integer id, Model model) throws ParseException {
		CongViecDuAn congViecDuAn = congViecDuAnService.getCongViecDuAnById(id);
		model.addAttribute("view", congViecDuAn);
		//in milliseconds
		long diff = congViecDuAn.getThoiGianDong().getTime() - congViecDuAn.getThoiGianMo().getTime();
		long diffHours = diff / (60 * 60 * 1000) % 24;
		model.addAttribute("timeAll", diffHours);
		return "congviecduan/viewone";
	}

}
