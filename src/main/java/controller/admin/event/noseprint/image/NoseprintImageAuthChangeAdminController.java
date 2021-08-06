/*
========================================================================
파    일    명 : NoseprintImageAuthChangeAdminController.java
========================================================================
작    성    자 : 임원석
작    성    일 : 2021.08.04
작  성  내  용 : 관리자가 비문 사진 등급 '양호'로 변경
========================================================================

*/
package controller.admin.event.noseprint.image;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import petProject.service.ScriptWriter;
import petProject.service.admin.event.noseprint.NoseprintAuthChangeService;

@Controller
@RequestMapping("/admin/pet/image/npevent/auth")
public class NoseprintImageAuthChangeAdminController {

	@Resource(name = "noseprintAuthChangeService")
	NoseprintAuthChangeService noseprintAuthChangeService;

	@GetMapping("/{memberNumber}/change")
	public String change(@PathVariable("memberNumber") int memberNumber,
			@RequestParam(value = "petRegistrationNumber", required = false) Integer petRegistrationNumber,
			@RequestParam(value = "chBox", required = false) String[] noseprintImagePath, HttpSession session,
			Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {

		// url로 접근 시 petRegistrationNumber 파라미터를 주지 않았을 때
		if (petRegistrationNumber == null) {
			ScriptWriter.write("잘못된 접근입니다.", "admin/pet/npevent/" + memberNumber, request, response);
			return null;
		}

		try {

			return "redirect:/admin/pet/image/npevent/" + memberNumber + "?petRegistrationNumber="
					+ petRegistrationNumber;
		} catch (Exception e) {
			e.printStackTrace();
			ScriptWriter.write("오류가 발생하였습니다.", "home", request, response);
			return null;
		}

	}

	@PostMapping("/{memberNumber}/change")
	public String change(@PathVariable("memberNumber") int memberNumber,
			@RequestParam(value = "petRegistrationNumber", required = true) Integer petRegistrationNumber,
			@RequestParam(value = "chBox", required = false) String[] noseprintImagePath, HttpSession session,
			RedirectAttributes redirect, MultipartHttpServletRequest request, HttpServletResponse response)
			throws Exception {

		if (petRegistrationNumber == null) {
			ScriptWriter.write("잘못된 접근입니다.", "admin/pet/npevent/" + memberNumber, request, response);
			return null;
		}

		try {
			noseprintAuthChangeService.updateNoseprintImageAuthStatus(noseprintImagePath);

			return "redirect:/admin/pet/image/npevent/" + memberNumber + "?petRegistrationNumber="
					+ petRegistrationNumber;
		} catch (Exception e) {
			e.printStackTrace();
			ScriptWriter.write("오류가 발생하였습니다.", "home", request, response);
			return null;
		}
	}
}