/*
========================================================================
파    일    명 : PetRegisterController.java
========================================================================
작    성    자 : 강지호
작    성    일 : 2020.xx.xx
작  성  내  용 : 커맨드 객체를 register하는 클래스
========================================================================
수    정    자 : 정세진
수    정    일 : 2020.11.13
수  정  내  용 : 견종 콤보박스 출력 추가
=============================== 함  수  설  명  ===============================
uploadFile : 파일 업로드 방식 설정하는 함수
========================================================================
*/
package controller;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import petProject.exception.KindcodeNotFoundException;
import petProject.exception.PetRegisterException;
import petProject.service.GetCurrvalService;
import petProject.service.ImageUploadService;
import petProject.service.KindcodeService;
import petProject.service.PetRegisterService;
import petProject.vo.Kindcode;
import petProject.vo.Owner;
import petProject.vo.PetRegisterRequest;

@Controller
@RequestMapping("/register")
public class PetRegisterController {

	private static final Logger logger = LoggerFactory.getLogger(PetRegisterController.class);

	@Resource(name = "petRegisterService")
	PetRegisterService petRegisterService;

	@Resource(name = "getCurrvalService")
	GetCurrvalService getCurrvalService;

	@Resource(name = "imageUploadService")
	ImageUploadService imageUploadService;
	
	@Resource(name = "KindcodeService")
	KindcodeService kindcodeService;
	
	@RequestMapping("/step1")
	public String registerStep1(PetRegisterRequest petRegisterRequest, Model model) {
		try {
			List<Kindcode> kindcodeList = kindcodeService.selectPetKindList();
			model.addAttribute("kindcodeList", kindcodeList);
			System.out.print(kindcodeList.get(0).getPetKind());
			return "register/registerStep1";
		} catch (KindcodeNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return "redirect:/home";
		}catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return "redirect:/home";
		}
		
	}

	@GetMapping("/step2")
	public String registerStep2Get() {
		return "redirect:/register/step1";
	}

	@PostMapping("/step2")
	public String registerStep2(@Valid @ModelAttribute("petRegisterRequest") PetRegisterRequest petRegisterRequest,
			Errors errors, HttpSession session, MultipartHttpServletRequest request, Model model) {
		Owner owner = (Owner) session.getAttribute("login");
		petRegisterRequest.setOwnerId(owner.getOwnerId());
		
		if (errors.hasErrors()) {
			System.out.println(errors.toString()); //
			return "register/registerStep1";
		}
		try {
			/*
			 * MultipartFile file = request.getFile("file"); logger.info("originalName: " +
			 * file.getOriginalFilename()); logger.info("size: " + file.getSize());
			 * logger.info("contentType: " + file.getContentType());
			 * 
			 * String rootPath =
			 * request.getSession().getServletContext().getRealPath("/upload");
			 * 
			 * String savedName = uploadFile(file.getOriginalFilename(), file.getBytes(),
			 * rootPath);
			 * 
			 * model.addAttribute("savedName", savedName);
			 */
//			String absPath = rootPath + "\\" + savedName;
//			System.out.println("abs" + absPath);
			petRegisterService.insertPet(petRegisterRequest);
			int currval = getCurrvalService.selectCurrval();
			// ImageUploadRequest imageUploadRequest = new
			// ImageUploadRequest(owner.getOwnerId(), currval, savedName);
			// imageUploadService.insertImage(imageUploadRequest);
			return "register/registerStep2";
		} catch (PetRegisterException e) {
			e.printStackTrace();
			return "register/registerStep1";
		} catch (Exception e) {
			e.printStackTrace();
			return "register/registerStep1";
		}
	}

	private String uploadFile(String originalName, byte[] fileData, String rootPath) throws Exception {
		UUID uid = UUID.randomUUID();
		String savedName = uid.toString() + "." + originalName.substring(originalName.lastIndexOf(".") + 1);
		File target = new File(rootPath, savedName);
		// System.out.println(rootPath);
		FileCopyUtils.copy(fileData, target);
		return savedName;
	}

}
