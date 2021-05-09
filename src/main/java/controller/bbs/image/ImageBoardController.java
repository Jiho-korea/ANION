/*
========================================================================
파    일    명 : ImageBoardController.java
========================================================================
작    성    자 : 강지호
작    성    일 : 2021.05.06
작  성  내  용 : 반려견 사진 자랑 게시판 목록으로 이동하는 컨트롤러
========================================================================
*/
package controller.bbs.image;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import petProject.exception.NonExistentPageException;
import petProject.service.bbs.image.ImgpostListService;
import petProject.vo.ScriptWriter;
import petProject.vo.dto.Imgpost;
import petProject.vo.request.ImageBoardRequest;

@Controller
public class ImageBoardController {

	@Resource(name = "imgpostListService")
	ImgpostListService imgpostListService;

	// 반려견 자랑 게시물을 작성하는 페이지로 이동시키는 메소드
	@RequestMapping("/board/img")
	public String getImagePosting(@RequestParam(value = "pageNumber", required = false) Integer pageNumber,
			@RequestParam(value = "imgpostTitle", required = false) String imgpostTitle, HttpServletRequest request,
			HttpServletResponse response, HttpSession session, Model model) throws Exception {

		if (pageNumber == null) {
			pageNumber = 1;
		}

		boolean nextPage = false;

		nextPage = imgpostListService.nextPage(pageNumber);
		try {
			ImageBoardRequest imageBoardRequest = new ImageBoardRequest(pageNumber, imgpostTitle);
			List<Imgpost> imgpostList = imgpostListService.listImgpost(imageBoardRequest);
			request.setAttribute("pageNumber", pageNumber);
			request.setAttribute("nextPage", nextPage);
			request.setAttribute("imgpostList", imgpostList);
			return "bbs/img/board";
		} catch (NonExistentPageException e) {
			e.printStackTrace();
			ScriptWriter.write("존재하지 않는 페이지입니다.", "board/img", request, response);
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			ScriptWriter.write("알 수 없는 오류.", "board/img", request, response);
			return null;
		}

	}

}
