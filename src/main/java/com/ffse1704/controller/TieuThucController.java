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

import com.ffse1704.model.TieuThuc;
import com.ffse1704.service.TieuThucService;


/**
 * @author QuangDai
 *
 */

@Controller
@RequestMapping("/tieuthuc")
public class TieuThucController {
	@Autowired
	private TieuThucService tieuThucService;

	/* list tieu thuc */
	@RequestMapping("/{page}")
	public String list(@PathVariable int page, Model model) throws SQLException {
		int allItem = tieuThucService.getRecordsTotalMaChaNull();
		int reCordInPage = 5;
		double pageTotal = allItem / reCordInPage + ((allItem % reCordInPage) == 0 ? 0 : 1);
		int total = (int) pageTotal;
		int start = (page * (int) reCordInPage) - (int) reCordInPage;
		List<TieuThuc> list = tieuThucService.listTieuThuc(start, reCordInPage);
		model.addAttribute("list", list);
		model.addAttribute("indexPage", page);
		model.addAttribute("allPage", total);
		return "tieuthuc/list";
	}
	
	/* add new TieuThuc */
	@RequestMapping("/addtieuthuc")
	public ModelAndView viewAddDatabase() {
		return new ModelAndView("tieuthuc/add", "command", new TieuThuc());
	}
	
	@RequestMapping(value = "/savetieuthuc", method = RequestMethod.POST)
	public String addNewTieuThuc(@ModelAttribute("command") @Valid TieuThuc tieuThuc, BindingResult result,
			HttpSession session, Model model) {
		if (result.hasErrors()) {
			return "tieuthuc/add";
		} else {
			int searchTieuThuc = tieuThucService.getRecordsByIdTieuThuc(tieuThuc.getMaTieuThuc());
			if (searchTieuThuc == 0) {
				tieuThucService.addNew(tieuThuc);
			} else {
				String mess = "Mã tiêu thức đã tồn tại";
				model.addAttribute("mess", mess);
				return "tieuthuc/add";
			}
		}
		return "redirect:/tieuthuc/1";
	}
	
	/*
	 * edit TieuThuc# 
	 * get TieuThuc by id# 
	 * update TieuThuc by id
	 */
	@RequestMapping(value = "/edittieuthuc/{idTieuThuc}")
	public String viewEditTieuThuc(@PathVariable String idTieuThuc, Model model) {
		TieuThuc tieuThuc = tieuThucService.getTieuThucByIdTieuThuc(idTieuThuc);
		model.addAttribute("command", tieuThuc);
		return "tieuthuc/edit";
	}
	@RequestMapping(value = "/editsavetieuthuc", method = RequestMethod.POST)
	public String editSaveTieuThuc(@ModelAttribute("command") @Valid TieuThuc tieuThuc, BindingResult result,
			HttpSession session) {
		if (result.hasErrors()) {
			return "tieuthuc/edit";
		} else {
			tieuThucService.addNew(tieuThuc);
		}

		return "redirect:/tieuthuc/1";
	}
	
	/*
	 * delete TieuThuc# 
	 * get TieuThuc by id# 
	 * delete TieuThuc by id
	 */
	@RequestMapping(value = "/deletetieuthuc/{idTieuThuc}")
	public String viewDeleteTieuThuc(@PathVariable String idTieuThuc, Model model) {
		TieuThuc tieuThuc = tieuThucService.getTieuThucByIdTieuThuc(idTieuThuc); 
		model.addAttribute("command", tieuThuc);
		return "tieuthuc/delete";
	}

	@RequestMapping(value = "/submitdeletetieuthuc", method = RequestMethod.POST)
	public String deleteTieuThuc(@ModelAttribute("command") TieuThuc tieuThuc) {
		tieuThucService.delete(tieuThuc.getId());;
		return "redirect:/tieuthuc/1";
	}
	
	@RequestMapping(value = "/")
	public String listTieuThucCha(Model model) {
		List<TieuThuc> listTieuThucCha = tieuThucService.getListTieuThucByMaChaNull();
		for (int i = 0; i < listTieuThucCha.size(); i++) {
			System.out.println(listTieuThucCha.get(i).getTenTieuThuc());
		}
		model.addAttribute("listTieuThucCha", listTieuThucCha);
		return "templates/header";
	}
}
