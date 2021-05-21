/*
========================================================================
파    일    명 : KindcodeListController.java
========================================================================
작    성    자 : 강지호
작    성    일 : 2020.11.23
작  성  내  용 : 견종 코드 리스트 Controller
========================================================================
*/
package controller.admin.code.kind;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import petProject.service.pet.KindcodeListService;
import petProject.vo.dto.Kindcode;

@Controller
@RequestMapping("/admin/code/kindcode")
public class KindcodeListController {

	private static final Logger logger = LoggerFactory.getLogger(KindcodeListController.class);

	@Resource(name = "kindcodeListService")
	KindcodeListService kindcodeListService;

	@GetMapping("/list")
	public String listPet(HttpSession session, Model model) {
		try {
			List<Kindcode> kindcodeList = kindcodeListService.selectKindcodeList();
			model.addAttribute("kindcodeList", kindcodeList);
		} catch (Exception e) {
			e.printStackTrace();
			return "home/main";
		}
		return "admin/code/kind/list";
	}

}
