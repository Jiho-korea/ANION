/*
========================================================================
파    일    명 : KindcodeInsertController.java
========================================================================
작    성    자 : 강지호, 임원석
작    성    일 : 2020.11.28
작  성  내  용 : 견종 코드 신규 등록 Controller
========================================================================
*/
package controller.admin;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import petProject.service.KindcodeListService;
import petProject.vo.Kindcode;

@Controller
@RequestMapping("/admin/code/kindcode")
public class KindcodeInsertController {

	private static final Logger logger = LoggerFactory.getLogger(KindcodeInsertController.class);

	@Resource(name = "kindcodeListService")
	KindcodeListService kindcodeListService;

	@GetMapping("/insert")
	public String getKindCodeInsert(HttpSession session, Model model) {
//		try {
//			List<Kindcode> kindcodeList = kindcodeListService.selectKindcodeList();
//			model.addAttribute("kindcodeList", kindcodeList);
//		} catch (Exception e) {
//			e.printStackTrace();
//			return "/home/main";
//		}
		return "/admin/code/kind/insert";
	}

	@PostMapping("/insert")
	public String postKindCodeInsert(Kindcode kindcode, HttpSession session, Model model) {
		try {
			List<Kindcode> kindcodeList = kindcodeListService.selectKindcodeList();
			model.addAttribute("kindcodeList", kindcodeList);
		} catch (Exception e) {
			e.printStackTrace();
			return "/home/main";
		}
		return "/admin/code/kind/list";
	}

}
