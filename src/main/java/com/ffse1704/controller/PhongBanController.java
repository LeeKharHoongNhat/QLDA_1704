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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ffse1704.model.PhongBan;
import com.ffse1704.service.PhongBanService;

/**
 * @author KhaNhat
 *
 */
@Controller
@RequestMapping("/phongban")
public class PhongBanController {
	
	@Autowired
	private PhongBanService phongBanService;


	@RequestMapping("/{page}")
	public String list(@PathVariable int page, Model model) throws SQLException {
		int allItem = phongBanService.getRecordsTotal();
		int reCordInPage = 2;
		double pageTotal = allItem / reCordInPage + ((allItem % reCordInPage) == 0 ? 0 : 1);
		int total = (int) pageTotal;
		int start = (page * (int) reCordInPage) - (int) reCordInPage;
		List<PhongBan> list = phongBanService.listPhongBan(start, reCordInPage);
		model.addAttribute("list", list);
		model.addAttribute("indexPage", page);
		model.addAttribute("allPage", total);
		return "phongban/list";
	}

	@RequestMapping("/addphongban")
	public ModelAndView viewAdd() {
		return new ModelAndView("phongban/add", "command", new PhongBan());
	}

	@RequestMapping(value = "/savephongban", method = RequestMethod.POST)
	public String addDomain(@ModelAttribute("command") @Valid PhongBan phongBan, BindingResult result,
			HttpSession session,Model model) {
		if (result.hasErrors()) {
			return "phongban/add";
		} else {
			int searchPhongBan = phongBanService.getRecordsByIdPhongBan(phongBan.getMaPhongBan());
			if(searchPhongBan==0) {
				phongBanService.addNew(phongBan);
			}else {
				String mess = "Mã phòng ban tồn tại";
				model.addAttribute("mess", mess);
				return "phongban/add";
			}
			
		}

		return "redirect:/phongban/1";// will redirect to viewemp request mapping
	}
	
	@RequestMapping(value = "/editphongban/{idPhongBan}")
	public String viewEditPhongBan(@PathVariable String idPhongBan, Model model) {
		PhongBan phongBan = phongBanService.getPhongBanbyIdPhongBan(idPhongBan);
		model.addAttribute("command", phongBan);
		return "phongban/edit";
	}
	
	@RequestMapping(value = "/editsavephongban", method = RequestMethod.POST)
	public String editSave(@ModelAttribute("command") @Valid PhongBan phongBan, BindingResult result,
			HttpSession session) {
		if (result.hasErrors()) {
			return "phongban/edit";
		} else {
			phongBanService.addNew(phongBan);
		}

		return "redirect:/phongban/1";// will redirect to viewemp request mapping
	}
	
	
	@RequestMapping(value = "/deletephongban/{idPhongBan}")
	public String viewDeletePhongBan(@PathVariable String idPhongBan, Model model) {
		PhongBan phongBan = phongBanService.getPhongBanbyIdPhongBan(idPhongBan);
		model.addAttribute("command", phongBan);
		return "phongban/delete";
	}
	
	@RequestMapping(value = "/submitdeletephongban", method = RequestMethod.POST)
	public String deletePhongBan(@RequestParam("maPhongBan") String maPB, RedirectAttributes redirect) {
		PhongBan phongBan = phongBanService.getPhongBanbyIdPhongBan(maPB);
		boolean result = phongBanService.delete(phongBan);
		String msg = null;
		if (result) {
			msg = "Đã xóa " + phongBan.getTenPhongBan() + " thành công!";
		} else {
			msg = "Đã xóa " + phongBan.getTenPhongBan() + " thất bại!";
		}
		redirect.addFlashAttribute("msg", msg);
		return "redirect:/phongban/1";
	}
}
