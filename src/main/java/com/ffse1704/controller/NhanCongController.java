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
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ffse1704.model.NhanCong;
import com.ffse1704.model.valid.NhanCongAddValidator;
import com.ffse1704.service.NhanCongService;
import com.ffse1704.service.NhanVienService;

@Controller
@RequestMapping("/nhancong")
public class NhanCongController {
	@Autowired
	private NhanCongService nhanCongService;
	@Autowired
	private NhanVienService nhanVienService;

	public void setNhanCongService(NhanCongService nhanCongService) {
		this.nhanCongService = nhanCongService;
	}

	@Autowired
	private NhanCongAddValidator nhanCongAddValidator;

	@InitBinder
	public void initValidNhanCong(WebDataBinder binder) {
		binder.addValidators(nhanCongAddValidator);
	}

	@RequestMapping("/list")
	public String list(@RequestParam(value = "page", required = true) Integer page,
			@RequestParam(value = "order", required = false) String order, Model model) throws SQLException {
		int allItem = nhanCongService.getRecordsTotal();
		int reCordInPage = 2;
		double pageTotal = allItem / reCordInPage + ((allItem % reCordInPage) == 0 ? 0 : 1);
		int total = (int) pageTotal;
		int start = (page * (int) reCordInPage) - (int) reCordInPage;
		String ord = null;
		if (order != null && order.equals("desc")) {
			ord = "desc";
		} else {
			ord = "asc";

		}

		List<NhanCong> list = nhanCongService.view(start, reCordInPage, ord);
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

	@RequestMapping(value = { "/create" }, method = RequestMethod.POST)
	public String creat(@ModelAttribute("nhancong") @Valid NhanCong nhancong, BindingResult result,
			RedirectAttributes redirectAttributes, HttpSession session, Model model) {
		//NhanVien listNhanVien=nhanVienService.
		if (result.hasErrors()) {
			return "NhanCong/add_form";
		} else {

			boolean result1 = nhanCongService.addNew(nhancong);
			String mess = null;
			if (result1) {
				mess = "Thành Công";
				redirectAttributes.addFlashAttribute("mess", mess);
				return "redirect:/nhancong/list?page=1&order=desc";

			} else {
				mess = "Thất bại";
				model.addAttribute("mess", mess);
				return "NhanCong/add_form";

			}
		}

	}

	@RequestMapping("/edit/{maCongViec}")
	public String showFormUpdate(@PathVariable("maCongViec") String maCongViec, Model model)
			throws IllegalStateException, IOException {
		NhanCong nc = nhanCongService.getId(maCongViec);
		model.addAttribute("command", nc);
		model.addAttribute("maCongViec", nc.getMaCongViec());
		return "NhanCong/update";
	}

	@RequestMapping("/update")
	public String Update(@ModelAttribute("nhancong") @Valid NhanCong nc, BindingResult result,
			RedirectAttributes redirectAttributes, Model model) {

		Boolean result1 = nhanCongService.update(nc);
		String mess = null;
		if (result1 == true) {
			mess = "Thành Công";
			redirectAttributes.addFlashAttribute("mess", mess);
			return "redirect:/nhancong/list?page=1&order=desc";

		} else {
			mess = "Thất bại";
			model.addAttribute("mess", mess);
			return "NhanCong/add_form";

		}
	}
	@RequestMapping(value="/delete", method = RequestMethod.POST)
	public String delete(@RequestParam("maCongViec") String maCongViec, Model model)
			throws IllegalStateException, IOException {
		NhanCong nc = nhanCongService.getId(maCongViec);
			nhanCongService.delete(nc);
	
		return "redirect:/nhancong/list?page=1&order=desc";

	
	}

}
