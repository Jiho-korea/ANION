/*
========================================================================
파    일    명 : NoseprintImageDeleteController.java
========================================================================
작    성    자 : 강지호
작    성    일 : 2021.07.04
작  성  내  용 : 비문 이미지 삭제 요청 컨트롤러
========================================================================
*/
package controller.event.noseprint.image;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import controller.image.ImageListController;
import petProject.service.ScriptWriter;
import petProject.service.event.noseprint.NoseprintImageDeleteService;
import petProject.service.event.noseprint.NoseprintImageListService;
import petProject.vo.dto.NoseprintImage;

@Controller
@RequestMapping("/info/list")
public class NoseprintImageDeleteController {

	@Resource(name = "noseprintImageListService")
	NoseprintImageListService noseprintImageListService;

	@Resource(name = "noseprintImageDeleteService")
	NoseprintImageDeleteService noseprintImageDeleteService;

	private static final Logger logger = LoggerFactory.getLogger(ImageListController.class);

	@GetMapping("/npimageDelete")
	public String listDeleteNoseprintImage(
			@RequestParam(value = "petRegistrationNumber", required = true) int petRegistrationNumber,
			HttpSession session, Model model) {
		// AuthInfo authInfo = (AuthInfo) session.getAttribute("login");

		try {
			List<NoseprintImage> noseprintImageList = noseprintImageListService
					.selectNoseprintImageList(petRegistrationNumber);
			// System.out.println(imageList.isEmpty());
			model.addAttribute("noseprintImageList", noseprintImageList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("petRegistrationNumber", petRegistrationNumber);
		return "pet/image/imageList";
	}

	@PostMapping("/npimageDelete")
	public String listDeleteNoseprintImage(
			@RequestParam(value = "petRegistrationNumber", required = false) int petRegistrationNumber,
			@RequestParam(value = "chBox", required = false) String[] paths_id, HttpSession session,
			HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirect, Model model)
			throws Exception {
		String rootPath = request.getSession().getServletContext().getRealPath("/upload");
		try {
			for (int i = 0; i < paths_id.length; i++) {
				noseprintImageDeleteService.deleteNoseprintImage(paths_id[i]);
				File deleteFile = new File(rootPath + "/" + paths_id[i]);
				deleteFile.delete();
			}
			return "redirect:/info/list/image?petRegistrationNumber=" + petRegistrationNumber;

		} catch (NullPointerException e) {
			// e.printStackTrace();
			ScriptWriter.write("삭제할 사진을 선택해 주세요.", "info/list/image?petRegistrationNumber=" + petRegistrationNumber,
					request, response);
			return null;
		} catch (Exception e) {
			e.printStackTrace();

			return "redirect:/info/list/image?petRegistrationNumber=" + petRegistrationNumber;
		}
	}

}