/*
========================================================================
파    일    명 : KindcodeDeleteController.java
========================================================================
작    성    자 : 강지호
작    성    일 : 2021.01.05
작  성  내  용 : 견종 코드 삭제 Controller
========================================================================
*/
package controller.admin;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import petProject.exception.KindcodeDeleteException;
import petProject.service.admin.KindcodeDeleteService;

@Controller
@RequestMapping("/admin/code/kindcode")
public class KindcodeDeleteController {

	private static final Logger logger = LoggerFactory.getLogger(KindcodeDeleteController.class);

	@Resource(name = "kindcodeDeleteService")
	KindcodeDeleteService kindcodeDeleteService;

	@GetMapping("/delete")
	public String getKindCodeDelete(@RequestParam(value = "petKindcode") String petKindcode, HttpSession session,
			Model model) {
		try {
			kindcodeDeleteService.deleteKindcode(petKindcode);
			return "redirect:/admin/code/kindcode/list";
		} catch (KindcodeDeleteException e) {
			return "redirect:/admin/code/kindcode/list";
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/admin/code/kindcode/list";
		}

	}
}
