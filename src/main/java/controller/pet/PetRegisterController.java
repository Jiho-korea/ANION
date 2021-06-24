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
========================================================================
수    정    자 : 정세진
수    정    일 : 2020.11.20
수  정  내  용 : 애완동물 유효성 생일 추가
========================================================================
수    정    자 : 송찬영
수    정    일 : 2021.05.15
수  정  내  용 : 팝업창용 쿠키 생성
=============================== 함  수  설  명  ===============================
수    정    자 : 강지호
수    정    일 : 2021.06.24
수  정  내  용 : double submit 방지 코드 추가
=============================== 함  수  설  명  ===============================
uploadFile : 파일 업로드 방식 설정하는 함수
*/
package controller.pet;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import petProject.exception.PetRegisterException;
import petProject.service.ScriptWriter;
import petProject.service.image.ImageUploadService;
import petProject.service.pet.GetCurrvalService;
import petProject.service.pet.PetRegisterService;
import petProject.vo.AuthInfo;
import petProject.vo.dto.Kindcode;
import petProject.vo.request.PetRegisterRequest;

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

	List<Kindcode> kindcodeList = null;

	@RequestMapping("/step1")
	public String registerStep1(PetRegisterRequest petRegisterRequest, Model model, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			Cookie cookie_popup01 = new Cookie("popup01", "true");
			cookie_popup01.setPath("/");
			cookie_popup01.setMaxAge(0);
			response.addCookie(cookie_popup01);

			Cookie petKind = new Cookie("petKind", "true");
			petKind.setPath(request.getContextPath() + "/popup/petKind");
			petKind.setMaxAge(60 * 60 * 24 * 1);
			response.addCookie(petKind);

			String pattern = "yyyy-MM-dd";
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

			String today = simpleDateFormat.format(new Date());
			model.addAttribute("today", today);

			/*
			 * kindcodeList = kindcodeListService.selectKindcodeList();
			 * model.addAttribute("kindcodeList", kindcodeList);
			 */
			// System.out.print(kindcodeList.get(0).getPetKind());
			return "pet/register/registerStep1";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "redirect:/register/step1";
		}

	}

	@GetMapping("/step2")
	public String registerStep2(
			@CookieValue(value = "successPetRegistration", required = false) Cookie cookie_success_pet_registration,
			Model model, HttpServletResponse response, HttpServletRequest request) throws Exception {
		// 반려견 등록과정 step1을 안거치고 get방식으로 요청 한경우 (= 반려견 등록 완료 페이지에서 새로고침 한 경우)
		if (cookie_success_pet_registration == null) {
			ScriptWriter.write("잘못된 접근입니다.", "pet/list", request, response);
			return null;
		}

		Cookie cookie_delete_success_pet_registration = new Cookie("successPetRegistration",
				cookie_success_pet_registration.getValue());
		cookie_delete_success_pet_registration.setPath("/");
		cookie_delete_success_pet_registration.setMaxAge(0);
		response.addCookie(cookie_delete_success_pet_registration);

		model.addAttribute("petName", cookie_success_pet_registration.getValue());
		return "pet/register/registerStep2";
	}

	@PostMapping("/step2")
	public String registerStep2(@Valid @ModelAttribute("petRegisterRequest") PetRegisterRequest petRegisterRequest,
			Errors errors, HttpSession session, MultipartHttpServletRequest request, HttpServletResponse response,
			Model model) {
		AuthInfo authInfo = (AuthInfo) session.getAttribute("login");
		petRegisterRequest.setMemberNumber(authInfo.getMemberNumber());

		if (errors.hasErrors()) {
			try {
				String pattern = "yyyy-MM-dd";
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

				String today = simpleDateFormat.format(new Date());
				model.addAttribute("today", today);

				/*
				 * kindcodeList = kindcodeListService.selectKindcodeList();
				 * model.addAttribute("kindcodeList", kindcodeList);
				 */
				return "pet/register/registerStep1";
			} catch (Exception e) {
				e.printStackTrace();
				return "redirect:/home";
			}
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

			Cookie cookie_success_pet_registration = new Cookie("successPetRegistration",
					petRegisterRequest.getPetName());
			cookie_success_pet_registration.setPath("/");
			cookie_success_pet_registration.setMaxAge(60 * 60 * 24 * 1);

			response.addCookie(cookie_success_pet_registration);
			// int currval = getCurrvalService.selectCurrval();

			// ImageUploadRequest imageUploadRequest = new
			// ImageUploadRequest(member.getMemberId(), currval, savedName);
			// imageUploadService.insertImage(imageUploadRequest);

			return "redirect:/register/step2";
		} catch (PetRegisterException e) {
			e.printStackTrace();
			return "pet/register/registerStep1";
		} catch (Exception e) {
			e.printStackTrace();
			return "pet/register/registerStep1";
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
