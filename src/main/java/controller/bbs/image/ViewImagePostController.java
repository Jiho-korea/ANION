/*
========================================================================
파    일    명 : ViewImagePostController.java
========================================================================
작    성    자 : 강지호
작    성    일 : 2021.05.08
작  성  내  용 : 반려견 사진 자랑 게시글 상세보기 컨트롤러
========================================================================
*/
package controller.bbs.image;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import petProject.exception.ImgpostNotExistException;
import petProject.service.ScriptWriter;
import petProject.service.bbs.image.ViewImgpostService;

@Controller
public class ViewImagePostController {

	@Resource(name = "viewImgpostService")
	ViewImgpostService viewImgpostService;

	@Autowired
	private MessageSourceAccessor messageSourceAccessor;
	
	// 반려견 자랑 게시글 상세보기 하는 메소드
	@RequestMapping("/board/img/view")
	public String viewImagePost(@RequestParam(value = "imgpostNo", required = false) int imgpostNo,
			HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model)
			throws Exception {
		try {
			model.addAttribute("imgpost", viewImgpostService.viewImgpostInfo(imgpostNo));
			return "bbs/img/post";
		} catch (ImgpostNotExistException e) {
			e.printStackTrace();
			ScriptWriter.write(messageSourceAccessor.getMessage("null.post"), "board/img", request, response);
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			ScriptWriter.write(messageSourceAccessor.getMessage("bug"), "board/img", request, response);
			return null;
		}

	}

}
