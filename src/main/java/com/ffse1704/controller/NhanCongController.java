package com.ffse1704.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ffse1704.model.NhanCong;
import com.ffse1704.model.ThietBi;
import com.ffse1704.model.VatLieu;
import com.ffse1704.service.NhanCongService;

@Controller
@RequestMapping("/nhancong")
public class NhanCongController {
	@Autowired
	private NhanCongService nhanCongService;

	public void setNhanCongService(NhanCongService nhanCongService) {
		this.nhanCongService = nhanCongService;
	}

	@RequestMapping("/{page}")
	public String list(@PathVariable int page, Model model) throws SQLException {
		int allItem = nhanCongService.getRecordsTotal();
		int reCordInPage = 2;
		double pageTotal = allItem / reCordInPage + ((allItem % reCordInPage) == 0 ? 0 : 1);
		int total = (int) pageTotal;
		int start = (page * (int) reCordInPage) - (int) reCordInPage;
		List<NhanCong> list = nhanCongService.view(start, reCordInPage);
		model.addAttribute("list", list);
		model.addAttribute("indexPage", page);
		model.addAttribute("allPage", total);
		return "NhanCong/list";
	}

	@RequestMapping(value = { "/add_form" })
	public String redirect(Model model) {
		model.addAttribute("nhancong", new NhanCong());
		return "NhanCong/add_form";
	}

	@RequestMapping(value = { "/creat" }, method = RequestMethod.POST)
	public String creat(@ModelAttribute("nhancong") @Valid NhanCong nhancong, BindingResult result,
			RedirectAttributes redirectAttributes, HttpSession session, Model model) {

		if (result.hasErrors()) {
			return "NhanCong/add_form";
		} else {

			nhanCongService.addNew(nhancong);

			return "NhanCong/list/1";

		}

	}

	@RequestMapping("/edit/{maCongViec}")
	public String showFormUpdate(@PathVariable("maCongViec") String maCongViec, Model model, NhanCong nc)
			throws IllegalStateException, IOException {
		nc = nhanCongService.getId(maCongViec);
		model.addAttribute("command", nc);
		model.addAttribute("maCongViec", nc.getMaCongViec());
		return "NhanCong/update";
	}

}
