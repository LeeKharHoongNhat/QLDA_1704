package com.ffse1704.controller;

import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ffse1704.model.CongViecDuAn;
import com.ffse1704.model.LogWork;
import com.ffse1704.service.CongViecDuAnService;
import com.ffse1704.service.LogWorkService;

/**
 * @author KhaNhat
 *
 */
@Controller
@RequestMapping("/logwork")
public class LogWorkController {
	@Autowired
	private LogWorkService logWorkService;
	@Autowired
	private CongViecDuAnService congViecDuAnService;

	@RequestMapping("/list")
	public String list(@RequestParam("maDuAn") String maDuAn, @RequestParam("maCongViec") String maCongViec,
			@RequestParam("checkTime") Integer checkTime, @RequestParam("page") Integer page, Model model)
			throws SQLException {
		double timeLogWork = 0;
		double timeRemainning = 0;
		double persentLogWork = 0;
		int allItem = logWorkService.getRecordsTotal(maDuAn, maCongViec);
		int reCordInPage = 5;
		double pageTotal = allItem / reCordInPage + ((allItem % reCordInPage) == 0 ? 0 : 1);
		int total = (int) pageTotal;
		int start = (page * (int) reCordInPage) - (int) reCordInPage;
		List<LogWork> list = logWorkService.listLogWorkPage(maDuAn, maCongViec, start, reCordInPage);
		List<LogWork> listAll = logWorkService.listLogWork(maDuAn, maCongViec);
		/* xử lý time logwork */
		CongViecDuAn congViecDuAn = congViecDuAnService.getCongViecDuAnById(checkTime);
		long diff = congViecDuAn.getThoiGianDong().getTime() - congViecDuAn.getThoiGianMo().getTime();
		long timeAll = diff / (60 * 60 * 1000) % 24;
		for (int i = 0; i < listAll.size(); i++) {
			timeLogWork += listAll.get(i).getThoiGian();
		}
		double a = timeLogWork / timeAll;
		timeRemainning = (timeAll - timeLogWork);

		DecimalFormat df = new DecimalFormat("0.0");
		String str = df.format(timeRemainning);
		double result = Double.valueOf(str);

		persentLogWork = (int) (a * 100);
		model.addAttribute("timeAll", timeAll);
		model.addAttribute("persentTime", persentLogWork);
		model.addAttribute("timeLogWork", timeLogWork);
		model.addAttribute("timeRemainning", result);
		/* end xử lý time logwork */
		model.addAttribute("checkOne", list.get(0));
		model.addAttribute("checkTime", checkTime);
		model.addAttribute("list", list);
		model.addAttribute("indexPage", page);
		model.addAttribute("allPage", total);
		return "logwork/list";
	}

	@RequestMapping("/newlogwork")
	public ModelAndView viewAdd(@RequestParam("maDuAn") String maDuAn, @RequestParam("maCongViec") String maCongViec,
			@RequestParam("checkTime") Integer checkTime, Model model) {
		double timeLogWork = 0;
		double timeRemainning = 0;
		double persentLogWork = 0;
		List<LogWork> listAll = logWorkService.listLogWork(maDuAn, maCongViec);
		CongViecDuAn congViecDuAn = congViecDuAnService.getCongViecDuAnById(checkTime);
		long diff = congViecDuAn.getThoiGianDong().getTime() - congViecDuAn.getThoiGianMo().getTime();
		long timeAll = diff / (60 * 60 * 1000) % 24;
		for (int i = 0; i < listAll.size(); i++) {
			timeLogWork += listAll.get(i).getThoiGian();
		}
		double a = timeLogWork / timeAll;
		timeRemainning = (timeAll - timeLogWork);
		DecimalFormat df = new DecimalFormat("0.0");
		String str = df.format(timeRemainning);
		double result = Double.valueOf(str);
		persentLogWork = (int) (a * 100);
		model.addAttribute("timeAll", timeAll);
		model.addAttribute("checkTime", checkTime);
		model.addAttribute("checkOne", listAll.get(0));
		model.addAttribute("persentTime", persentLogWork);
		model.addAttribute("timeLogWork", timeLogWork);
		model.addAttribute("timeRemainning", result);
		return new ModelAndView("logwork/add", "command", new LogWork());
	}

	@RequestMapping(value = "/savelogwork", method = RequestMethod.POST)
	public String submitAdd(@ModelAttribute("command") @Valid LogWork logWork, BindingResult result,
			HttpSession session, Model model) {
		if (result.hasErrors()) {
			double timeLogWork = 0;
			double timeRemainning = 0;
			double persentLogWork = 0;
			List<LogWork> listAll = logWorkService.listLogWork(logWork.getMaDuAn(), logWork.getMaCongViec());
			CongViecDuAn congViecDuAn = congViecDuAnService.getCongViecDuAnById(logWork.getCheckTime());
			long diff = congViecDuAn.getThoiGianDong().getTime() - congViecDuAn.getThoiGianMo().getTime();
			long timeAll = diff / (60 * 60 * 1000) % 24;
			for (int i = 0; i < listAll.size(); i++) {
				timeLogWork += listAll.get(i).getThoiGian();
			}
			double a = timeLogWork / timeAll;
			timeRemainning = (timeAll - timeLogWork);
			DecimalFormat df = new DecimalFormat("0.0");
			String str = df.format(timeRemainning);
			double end = Double.valueOf(str);
			persentLogWork = (int) (a * 100);
			model.addAttribute("timeAll", timeAll);
			model.addAttribute("checkTime", logWork.getCheckTime());
			model.addAttribute("checkOne", listAll.get(0));
			model.addAttribute("persentTime", persentLogWork);
			model.addAttribute("timeLogWork", timeLogWork);
			model.addAttribute("timeRemainning", end);
			return "logwork/add";
		} else {
			logWorkService.addNew(logWork);
		}
		return "redirect:/logwork/list?maDuAn=" + logWork.getMaDuAn() + "&maCongViec=" + logWork.getMaCongViec()
				+ "&checkTime=" + logWork.getCheckTime() + "&page=1";
	}

	@RequestMapping("/editlogwork")
	public String viewEdit(@RequestParam("id") Integer id,@RequestParam("maDuAn") String maDuAn, @RequestParam("maCongViec") String maCongViec,
			@RequestParam("checkTime") Integer checkTime, Model model) {
		double timeLogWork = 0;
		double timeRemainning = 0;
		double persentLogWork = 0;
		List<LogWork> listAll = logWorkService.listLogWork(maDuAn, maCongViec);
		LogWork getOneLogWork = logWorkService.getOneLogWork(id);
		CongViecDuAn congViecDuAn = congViecDuAnService.getCongViecDuAnById(checkTime);
		long diff = congViecDuAn.getThoiGianDong().getTime() - congViecDuAn.getThoiGianMo().getTime();
		long timeAll = diff / (60 * 60 * 1000) % 24;
		for (int i = 0; i < listAll.size(); i++) {
			timeLogWork += listAll.get(i).getThoiGian();
		}
		double a = timeLogWork / timeAll;
		timeRemainning = (timeAll - timeLogWork);
		DecimalFormat df = new DecimalFormat("0.0");
		String str = df.format(timeRemainning);
		double result = Double.valueOf(str);
		persentLogWork = (int) (a * 100);
		model.addAttribute("timeAll", timeAll);
		model.addAttribute("checkTime", checkTime);
		model.addAttribute("checkOne", listAll.get(0));
		model.addAttribute("persentTime", persentLogWork);
		model.addAttribute("timeLogWork", timeLogWork);
		model.addAttribute("timeRemainning", result);
		model.addAttribute("command", getOneLogWork);
		
		return "logwork/edit";
	}
}
