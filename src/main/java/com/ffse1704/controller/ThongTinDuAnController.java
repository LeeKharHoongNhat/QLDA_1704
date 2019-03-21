package com.ffse1704.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ffse1704.model.ThongTinDuAn;
import com.ffse1704.service.ThongTinDuAnService;

@Controller
@RequestMapping("/duan")
public class ThongTinDuAnController {

	@Autowired
	private ThongTinDuAnService thongTinDuAnService;
	
	@RequestMapping("/{trangThai}&{page}")
	public String list(@PathVariable String trangThai, @PathVariable int page, Model model) throws SQLException {
		int allItem = thongTinDuAnService.getRecordsTotal(trangThai);
		int reCordInPage = 2;
		double pageTotal = allItem / reCordInPage + ((allItem % reCordInPage) == 0 ? 0 : 1);
		int total = (int) pageTotal;
		int start = (page * (int) reCordInPage) - (int) reCordInPage;
		List<ThongTinDuAn> list = thongTinDuAnService.listDuAn(trangThai, start, reCordInPage);
		model.addAttribute("list", list);
		model.addAttribute("indexPage", page);
		model.addAttribute("allPage", total);
		return "thongtinduan/list";
	}
	
	@RequestMapping(value = "/view/{idDuAn}")
	public String viewEditPhongBan(@PathVariable String idDuAn, Model model) {
		//List<TieuThuc> listTieuThuc = tieuThucService.getListTieuThucByMaCha("TTPB");
		ThongTinDuAn duAn = thongTinDuAnService.viewOneDuAn(idDuAn);
		model.addAttribute("command", duAn);
		//model.addAttribute("list", listTieuThuc);
		return "thongtinduan/view";
	}

}
