package controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import petProject.service.ImageListService;
import petProject.service.ImageUploadService;
import petProject.vo.Image;
import petProject.vo.ImageUploadRequest;
import petProject.vo.Owner;

@Controller
@RequestMapping("/list")
public class ImageListController {

	@Resource(name = "imageUploadService")
	ImageUploadService imageUploadService;

	@Resource(name = "imageListService")
	ImageListService imageListService;

	private static final Logger logger = LoggerFactory.getLogger(ImageListController.class);

	@GetMapping("/image")
	public String listImage(@RequestParam(value = "petRegistrationNumber", required = true) int petRegistrationNumber,
			HttpSession session, Model model) {
		Owner owner = (Owner) session.getAttribute("login");
		System.out.println("ownerId = " + owner.getOwnerId() + "\npetRegistrationNumber = " + petRegistrationNumber);
		try {
			List<Image> imageList = imageListService.selectImageList(petRegistrationNumber);
			System.out.println(imageList.isEmpty());
			model.addAttribute("imageList", imageList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("petRegistrationNumber", petRegistrationNumber);
		return "/list/image";
	}

	@PostMapping("/image")
	public String listImageInsert(
			@RequestParam(value = "petRegistrationNumber", required = true) int petRegistrationNumber,
			HttpSession session, Model model, MultipartHttpServletRequest request) {

		try {
			Owner owner = (Owner) session.getAttribute("login");
			String OwnerId = owner.getOwnerId();

			System.out.println("ownerId 검색 = " + OwnerId);
			System.out.println("petRegistragionNumber = " + petRegistrationNumber);

			MultipartFile file = request.getFile("file");
			logger.info("originalName: " + file.getOriginalFilename());
			logger.info("size: " + file.getSize());
			logger.info("contentType: " + file.getContentType());

			String rootPath = request.getSession().getServletContext().getRealPath("/upload");

			String savedName;
			savedName = uploadFile(file.getOriginalFilename(), file.getBytes(), rootPath);

			// model.addAttribute("savedName", savedName);
			String absPath = rootPath + "\\" + savedName;
			System.out.println("absPath = " + absPath);

			ImageUploadRequest imageUploadRequest = new ImageUploadRequest(owner.getOwnerId(), petRegistrationNumber,
					savedName);
			imageUploadService.insertImage(imageUploadRequest);

			return "redirect:/list/image?petRegistrationNumber=" + petRegistrationNumber;

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			return "redirect:/list/image?petRegistrationNumber=" + petRegistrationNumber;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			return "redirect:/list/image?petRegistrationNumber=" + petRegistrationNumber;
		}

	}

	private String uploadFile(String originalName, byte[] fileData, String rootPath) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String rndName = sdf.format(new java.util.Date()) + System.currentTimeMillis();
		// UUID uid = UUID.randomUUID(); // uid.toString()
		String savedName = rndName + "." + originalName.substring(originalName.lastIndexOf(".") + 1);
		File target = new File(rootPath, savedName);
		// System.out.println(rootPath);
		FileCopyUtils.copy(fileData, target);
		return savedName;
	}
}
