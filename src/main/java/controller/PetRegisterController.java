package controller;

import java.io.File;
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

import petProject.exception.PetRegisterException;
import petProject.service.GetCurrvalService;
import petProject.service.ImageUploadService;
import petProject.service.PetRegisterService;
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

	@RequestMapping("/step1")
	public String registerStep1(PetRegisterRequest petRegisterRequest) {
		return "register/registerStep1";
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
