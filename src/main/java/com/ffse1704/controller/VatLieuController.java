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
import com.ffse1704.model.VatLieu;
import com.ffse1704.model.valid.VatLieuAddValidator;
import com.ffse1704.service.VatLieuService;

@Controller
@RequestMapping("/vatlieu")
public class VatLieuController {
	@Autowired
	private VatLieuService vatLieuService;

	@Autowired
	private VatLieuAddValidator vatLieuAddValidator;

	@InitBinder
	public void initValidVatLieu(WebDataBinder binder) {
		binder.addValidators(vatLieuAddValidator);
	}

	@RequestMapping("/list")
	public String list(@RequestParam(value = "page", required = true) Integer page,
			@RequestParam(value = "order", required = false) String order, Model model) throws SQLException {
		int allItem = vatLieuService.getRecordsTotal();
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

		List<VatLieu> list = vatLieuService.view(start, reCordInPage, ord);
		model.addAttribute("list", list);
		model.addAttribute("indexPage", page);
		model.addAttribute("allPage", total);
		return "VatLieu/list";
	}

	@RequestMapping(value = { "/add_form" })
	public String redirect(Model model) {
		model.addAttribute("vatlieu", new VatLieu());
		return "VatLieu/add_form";
	}

	@RequestMapping(value = { "/create" }, method = RequestMethod.POST)
	public String creat(@ModelAttribute("vatlieu") @Valid VatLieu vatLieu, BindingResult result,
			RedirectAttributes redirectAttributes, HttpSession session, Model model) {

		if (result.hasErrors()) {
			return "VatLieu/add_form";
		} else {

			boolean result1 = vatLieuService.addNew(vatLieu);
			String mess = null;
			if (result1) {
				mess = "Thành Công";
				redirectAttributes.addFlashAttribute("mess", mess);
				return "redirect:/vatlieu/list?page=1&order=desc";

			} else {
				mess = "Thất bại";
				model.addAttribute("mess", mess);
				return "VatLieu/add_form";

			}
		}

	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String delete(@RequestParam("maCongViec") String maCongViec, Model model,RedirectAttributes redirectAttributes)
			throws IllegalStateException, IOException {		
		VatLieu vl =vatLieuService.delete(maCongViec);
		String mess=null;
		if(vl!=null) {
			 mess="Xoá thành công";
			 
		}else {
			 mess="Xoá thất bại";

		}
		redirectAttributes.addFlashAttribute("mess", mess);
		
		return "redirect:/vatlieu/list?page=1&order=desc";

	}

	@RequestMapping("/edit/{maCongViec}")
	public String showFormUpdate(@PathVariable("maCongViec") String maCongViec, Model model)
			throws IllegalStateException, IOException {
		VatLieu vl = vatLieuService.getId(maCongViec);
		model.addAttribute("command", vl);
		model.addAttribute("maCongViec", vl.getMaCongViec());
		return "VatLieu/update";
	}

	@RequestMapping("/update")
	public String Update(@ModelAttribute("vatlieu") @Valid VatLieu vl, BindingResult result,
			RedirectAttributes redirectAttributes, Model model) {

		Boolean result1 = vatLieuService.update(vl);
		String mess = null;
		if (result1 == true) {
			mess = "Thành Công";
			redirectAttributes.addFlashAttribute("mess", mess);
			return "redirect:/vatlieu/list?page=1&order=desc";

		} else {
			mess = "Thất bại";
			model.addAttribute("mess", mess);
			return "VatLieu/add_form";

		}
	}

}
