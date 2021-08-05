/*
========================================================================
파    일    명 : NoseprintImageDownloadController.java
========================================================================
작    성    자 : 강지호
작    성    일 : 2021.07.04
작  성  내  용 : 비문 이미지 다운로드 컨트롤러
========================================================================
*/
package controller.admin.event.noseprint.image;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import controller.admin.image.ImageDownloadController;
import petProject.exception.PetNotFoundException;
import petProject.service.ScriptWriter;
import petProject.service.event.noseprint.NoseprintImageDownloadService;

@Controller
@RequestMapping("/info/list")
public class NoseprintImageDownloadController {

	@Resource(name = "noseprintImageDownloadService")
	NoseprintImageDownloadService noseprintImageDownloadService;

	@Autowired
	private MessageSourceAccessor messageSourceAccessor;
	
	private static final Logger logger = LoggerFactory.getLogger(ImageDownloadController.class);

	@GetMapping("/npimage/download")
	public String imageListDownload(
			@RequestParam(value = "petRegistrationNumber", required = true) int petRegistrationNumber,
			HttpSession session, HttpServletRequest request, HttpServletResponse response, Model model)
			throws Exception {

		String rootPath = request.getSession().getServletContext().getRealPath("/upload/noseprint");
		try {
			noseprintImageDownloadService.downloadNoseprintImage(petRegistrationNumber, rootPath, model, response);
		} catch (PetNotFoundException e) {
			e.printStackTrace();
			ScriptWriter.write(messageSourceAccessor.getMessage("auth.fail"), "pet/list/npevent", request, response);
			return null;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			ScriptWriter.write(messageSourceAccessor.getMessage("null.file"), "pet/list/npevent", request, response);
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			ScriptWriter.write(messageSourceAccessor.getMessage("failed.download"), "pet/list/npevent", request, response);
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			ScriptWriter.write(messageSourceAccessor.getMessage("failed.download"), "pet/list/npevent", request, response);
			return null;
		}
		model.addAttribute("petRegistrationNumber", petRegistrationNumber);
		return null;
	}
}