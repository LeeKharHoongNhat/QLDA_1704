package com.ffse1704.controller;

import java.io.IOException;

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

import com.ffse1704.model.ThietBi;
import com.ffse1704.model.valid.ThietBiAddValidator;
import com.ffse1704.service.ThietBiService;

@Controller
@RequestMapping("/thietbi")
public class ThietBiController {

	@Autowired
	private ThietBiService thietBiService;
	
	@Autowired
	private ThietBiAddValidator thietBiVaid;
	
	@InitBinder
	public void initValidThietBi(WebDataBinder binder) {
		binder.addValidators(thietBiVaid);
	}

	@RequestMapping("/{maCV}")
	public String list(@PathVariable String maCV, Model model) {
		model.addAttribute("viewOne", this.thietBiService.viewOne(maCV));
		model.addAttribute("maCV", maCV);
		return "thietbi/list";

	}

	@RequestMapping(value = "/add/{maCV}", method = RequestMethod.GET)
	public String showFormAdd(Model model, @PathVariable String maCV) {
		ThietBi tb = new ThietBi();
		tb.setMaCongViec(maCV);
		model.addAttribute("command", tb);
		return "thietbi/add";
	}

	@RequestMapping("/edit/{id}")
	public String showFormUpdate(@PathVariable("id") int id, Model model, ThietBi tb)
			throws IllegalStateException, IOException {
		tb = thietBiService.getThietBiById(id);
		model.addAttribute("command", tb);
		model.addAttribute("id", tb.getId());
		return "thietbi/update";
	}

	@RequestMapping("/save")
	public String saveThietBi(@ModelAttribute("command") @Valid ThietBi tb, BindingResult result) {
		if (result.hasErrors()) {
			return "thietbi/add";
		}
		thietBiService.addThietBi(tb);
		return "redirect:/thietbi/" + tb.getMaCongViec();
	}

	@RequestMapping("/update")
	public String updateThietBi(@ModelAttribute("command") @Valid ThietBi tb, BindingResult result) {
		if (result.hasErrors()) {
			return "thietbi/update";
		}
		thietBiService.updateThietBi(tb);
		return "redirect:/thietbi/" + tb.getMaCongViec();
	}

	@RequestMapping(value="/remove", method = RequestMethod.POST)
	public String removeThietBi(@RequestParam("id") Integer id) {
		ThietBi tb = thietBiService.getThietBiById(id);
		thietBiService.removeThietBi(tb);
		return "redirect:/thietbi/" + tb.getMaCongViec();
	}

}
