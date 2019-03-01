package com.ffse1704.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
	
	/* list tieu thuc */
	@RequestMapping("/{maDuAn}&{maCha}&{page}")
	public String list(@PathVariable String maDuAn, @PathVariable String maCha, @PathVariable int page, Model model) throws SQLException {
		int allItem = congViecDuAnService.getRecordsTotalByMaCha(maDuAn, maCha);
		int reCordInPage = 2;
		double pageTotal = allItem / reCordInPage + ((allItem % reCordInPage) == 0 ? 0 : 1);
		int total = (int) pageTotal;
		int start = (page * (int) reCordInPage) - (int) reCordInPage;
		List<CongViecDuAn> list = congViecDuAnService.listCongViecDuAnByMaCha(maDuAn, maCha, start, reCordInPage);
		model.addAttribute("list", list);
		model.addAttribute("indexPage", page);
		model.addAttribute("allPage", total);
		return "congviecduan/list";
	}
}
