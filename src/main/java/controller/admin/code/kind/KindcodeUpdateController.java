/*
========================================================================
파    일    명 : KindcodeInsertController.java
========================================================================
작    성    자 : 강지호, 임원석
작    성    일 : 2020.11.28
작  성  내  용 : 견종 코드 신규 등록 Controller
========================================================================
*/
package controller.admin.code.kind;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import petProject.exception.KindcodeNotFoundException;
import petProject.exception.KindcodeUpdateException;
import petProject.service.admin.code.kind.KindcodeUpdateService;
import petProject.service.pet.KindcodeListService;
import petProject.vo.dto.Kindcode;

@Controller
@RequestMapping("/admin/code/kindcode")
public class KindcodeUpdateController {

	private static final Logger logger = LoggerFactory.getLogger(KindcodeUpdateController.class);

	@Resource(name = "kindcodeListService")
	KindcodeListService kindcodeListService;

	@Resource(name = "kindcodeUpdateService")
	KindcodeUpdateService kindcodeUpdateService;

	@GetMapping("/update")
	public String getKindCodeSelect(@RequestParam(value = "petKindcode") String petKindcode, HttpSession session,
			Model model) {
		try {
			List<String> countryCodeList = kindcodeListService.selectCountryCodeList();
			Kindcode kindcode = kindcodeUpdateService.selectKindcode(petKindcode);

			model.addAttribute("countryCodeList", countryCodeList);
			model.addAttribute("kindcode", kindcode);

			return "admin/code/kind/update";
		} catch (KindcodeNotFoundException e) {
			return "redirect:/admin/code/kindcode/list";
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/admin/code/kindcode/list";
		}

	}

	@PostMapping("/update")
	public String postKindCodeSelect(@Valid Kindcode kindcode, Errors errors, HttpSession session, Model model) {
		if (errors.hasErrors()) {
			return "admin/code/kind/update";
		}

		try {
			kindcodeUpdateService.updateKindcode(kindcode);

		} catch (KindcodeUpdateException e) {
			e.printStackTrace();
			return "admin/code/kind/update";
		} catch (Exception e) {
			e.printStackTrace();
			return "admin/code/kind/update";
		}
		return "redirect:/admin/code/kindcode/list";
	}

}
