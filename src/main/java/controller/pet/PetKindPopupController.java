/*
========================================================================
파    일    명 : PetKindPopupController.java
========================================================================
작    성    자 : 송찬영
작    성    일 : 2021.05.05
작  성  내  용 : petKind를 선택하는 Controller
========================================================================
수    정    자 : 송찬영
수    정    일 : 2021.05.09
수  정  내  용 : Select박스 페이징 기능 추가
========================================================================
*/
package controller.pet;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import petProject.exception.NonExistentKindcodeException;
import petProject.exception.NonExistentPageException;
import petProject.service.ScriptWriter;
import petProject.service.pet.KindcodeListService;
import petProject.service.pet.SelectKindcodeService;
import petProject.vo.dto.Kindcode;

@Controller
@RequestMapping("/popup")
public class PetKindPopupController {

	@Resource(name = "kindcodeListService")
	KindcodeListService kindcodeListService;

	@Resource(name = "selectKindcodeService")
	SelectKindcodeService selectKindcodeService;

	// 대동견지도 클릭시 = "/petKind", 대동견지도에서 품종 클릭 후 = "/petKind/{petKindcode}"
	@GetMapping(value = { "/petKind/{petKindcode}", "/petKind" })
	public String popup2(@PathVariable(name = "petKindcode", required = false) String petKindcode,
			@RequestParam(value = "pageNumber", required = false) Integer pageNumber, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		if (pageNumber == null) {
			pageNumber = 1;
		}

		boolean nextPage = kindcodeListService.nextPage(pageNumber);

		try {
			List<Kindcode> kindcodeListPage = kindcodeListService.selectKindcodeListPage(pageNumber);
			List<Kindcode> kindcodeList = kindcodeListService.selectKindcodeList();

			request.setAttribute("pageNumber", pageNumber);
			request.setAttribute("nextPage", nextPage);
			request.setAttribute("kindcodeList", kindcodeList);
			request.setAttribute("kindcodeListPage", kindcodeListPage);

			// redirect 됬을경우, 사용자가 클릭한 petKind가 콤보박스에 채워짐
			if (petKindcode != null) {
				Kindcode kindcode = selectKindcodeService.selectKindcode(petKindcode);
				request.setAttribute("kindcode", kindcode);
			}

			return "popup/petKind/petKindPopup";
		} catch (NonExistentPageException e) {
			e.printStackTrace();
			ScriptWriter.write("잘못된 접근입니다.", "popup/petKind", request, response);
			return null;
		} catch (NonExistentKindcodeException e) {
			e.printStackTrace();
			ScriptWriter.write("없는 품종입니다.", "popup/petKind", request, response);
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			ScriptWriter.write("잘못된 접근입니다.", "popup/petKind", request, response);
			return null;
		}
	}

	// 대동견지도에서 품종 클릭시 petKindcode를 넘겨주면서 redirect
	@GetMapping("/petKind/click/{petKindcode}")
	public String popup2_click(@PathVariable("petKindcode") String petKindcode) throws Exception {

		return "redirect:/popup/petKind/" + petKindcode;
	}
}
