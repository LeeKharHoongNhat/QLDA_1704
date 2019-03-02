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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ffse1704.model.VatLieu;
import com.ffse1704.service.VatLieuService;

@Controller
@RequestMapping("/vatlieu")
public class VatLieuController {
	@Autowired
	private VatLieuService vatLieuService;

	public void setVatLieuService(VatLieuService vatLieuService) {
		this.vatLieuService = vatLieuService;
	}

	@RequestMapping("/{page}")
	public String list(@PathVariable int page, Model model) throws SQLException {
		int allItem = vatLieuService.getRecordsTotal();
		int reCordInPage = 2;
		double pageTotal = allItem / reCordInPage + ((allItem % reCordInPage) == 0 ? 0 : 1);
		int total = (int) pageTotal;
		int start = (page * (int) reCordInPage) - (int) reCordInPage;
		List<VatLieu> list = vatLieuService.listVL(start, reCordInPage);
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

	@RequestMapping(value = { "/creat" }, method = RequestMethod.POST)
	public String creat(@ModelAttribute("vatlieu") @Valid VatLieu vatlieu, BindingResult result,
			RedirectAttributes redirectAttributes ,HttpSession session,Model model) {

		if (result.hasErrors()) {
			return "VatLieu/add_form";
		}
		else {
			int getMaVatLieu = vatLieuService.getRecordsByIdVatLieu(vatlieu.getMaCongViec());
			if(getMaVatLieu==0) {
				vatLieuService.addNew(vatlieu);
			}else {
				String mess = "Mã công việc tồn tại";
				model.addAttribute("mess", mess);
				
				return "VatLieu/add_form";
			}
			
		}

		return "redirect:/vatlieu/1";// will redirect to viewemp request mapping
	}
	}
