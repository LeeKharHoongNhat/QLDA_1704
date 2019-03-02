/**
 * 
 */
package com.ffse1704.controller;

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
import org.springframework.web.servlet.ModelAndView;

import com.ffse1704.model.KhachHang;
import com.ffse1704.service.KhachHangService;

/**
 * @author QuangDai
 *
 */
@Controller
@RequestMapping("/khachhang")
public class KhachHangController {

	@Autowired
	private KhachHangService khachHangService;

	/* list KhachHang */
	@RequestMapping("/{page}")
	public String list(@PathVariable int page, Model model) throws SQLException {
		int allItem = khachHangService.getRecordsTotal();
		int reCordInPage = 2;
		double pageTotal = allItem / reCordInPage + ((allItem % reCordInPage) == 0 ? 0 : 1);
		int total = (int) pageTotal;
		int start = (page * (int) reCordInPage) - (int) reCordInPage;
		List<KhachHang> list = khachHangService.listKhachHang(start, reCordInPage);
		model.addAttribute("listKhachHang", list);
		model.addAttribute("indexPage", page);
		model.addAttribute("allPage", total);
		return "khachhang/list";
	}

	/* add new KhachHang */
	@RequestMapping("/addkhachhang")
	public ModelAndView viewAddDatabase() {
		return new ModelAndView("khachhang/add", "command", new KhachHang());
	}

	@RequestMapping(value = "/savekhachhang", method = RequestMethod.POST)
	public String addNewKhachHang(@ModelAttribute("command") @Valid KhachHang khachHang, BindingResult result,
			HttpSession session, Model model) {
		if (result.hasErrors()) {
			return "khachhang/add";
		} else {
			int searchKhachHang = khachHangService.getRecordsByIdPKhachHang(khachHang.getMaKhachHang());
			if (searchKhachHang == 0) {
				khachHangService.addNew(khachHang);
			} else {
				String mess = "Mã khách hàng tồi tại";
				model.addAttribute("mess", mess);
				return "khachhang/add";
			}
		}
		return "redirect:/khachhang/1";
	}

	/*
	 * edit KhachHang# get KhachHang by id# update KhachHang by id
	 */
	@RequestMapping(value = "/editkhachhang/{idKhachHang}")
	public String viewEditKhachHang(@PathVariable String idKhachHang, Model model) {
		KhachHang khachHang = khachHangService.getKhachHangbyIdKhachHang(idKhachHang);
		model.addAttribute("command", khachHang);
		return "khachhang/edit";
	}

	@RequestMapping(value = "/editsavekhachhang", method = RequestMethod.POST)
	public String editSaveKhachHang(@ModelAttribute("command") @Valid KhachHang khachHang, BindingResult result,
			HttpSession session) {
		if (result.hasErrors()) {
			return "khachhang/edit";
		} else {
			khachHangService.addNew(khachHang);
		}

		return "redirect:/khachhang/1";
	}

	/*
	 * delete KhachHang# get KhachHang by id# delete KhachHang by id
	 */
	@RequestMapping(value = "/deletekhachhang/{idKhachHang}")
	public String viewDeleteKhachHang(@PathVariable String idKhachHang, Model model) {
		KhachHang khachHang = khachHangService.getKhachHangbyIdKhachHang(idKhachHang);
		model.addAttribute("command", khachHang);
		return "khachhang/delete";
	}

	@RequestMapping(value = "/submitdeletekhachhang", method = RequestMethod.POST)
	public String deleteKhachHang(@ModelAttribute("command") KhachHang khachHang) {
		khachHangService.delete(khachHang);
		return "redirect:/khachhang/1";
	}

}
