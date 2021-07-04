/*
========================================================================
파    일    명 : NoseprintImageDownloadController.java
========================================================================
작    성    자 : 강지호
작    성    일 : 2021.07.04
작  성  내  용 : 비문 이미지 다운로드 컨트롤러
========================================================================
*/
package controller.admin.event.noseprint;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import controller.admin.image.ImageDownloadController;
import petProject.exception.PetNotFoundException;
import petProject.service.event.noseprint.NoseprintImageListService;
import petProject.service.pet.PetInfoService;
import petProject.vo.dto.NoseprintImage;
import petProject.vo.dto.Pet;

@Controller
@RequestMapping("/info/list")
public class NoseprintImageDownloadController {

	@Resource(name = "noseprintImageListService")
	NoseprintImageListService noseprintImageListService;

	@Resource(name = "petInfoService")
	PetInfoService petInfoService;

	private static final Logger logger = LoggerFactory.getLogger(ImageDownloadController.class);

	@GetMapping("/npimage/download")
	public String imageListDownload(
			@RequestParam(value = "petRegistrationNumber", required = true) int petRegistrationNumber,
			HttpSession session, HttpServletRequest request, HttpServletResponse response, Model model) {

		String rootPath = request.getSession().getServletContext().getRealPath("/upload/noseprint");
		String zipFile = rootPath + "\\result.zip";
		// String downloadFileName = "result";

		try {
			Pet pet = petInfoService.selectPet(petRegistrationNumber);
			List<NoseprintImage> noseprintImageList = noseprintImageListService
					.selectNoseprintImageList(petRegistrationNumber);
			model.addAttribute("noseprintImageList", noseprintImageList);
			// ZipOutputStream을 FileOutputStream 으로 감쌈
			FileOutputStream fout = new FileOutputStream(zipFile);
			ZipOutputStream zout = new ZipOutputStream(fout);

			for (int i = 0; i < noseprintImageList.size(); i++) {

				// 본래 파일명 유지, 경로제외 파일압축을 위해 new File로
				ZipEntry zipEntry = new ZipEntry(new File(noseprintImageList.get(i).getNoseprintImagePath()).getName());
				zout.putNextEntry(zipEntry);

				// 경로포함 압축
				// zout.putNextEntry(new ZipEntry(sourceFiles.get(i)));

				FileInputStream fin = new FileInputStream(
						rootPath + "\\" + noseprintImageList.get(i).getNoseprintImagePath());
				byte[] buffer = new byte[1024];
				int length;

				// input file을 1024바이트로 읽음, zip stream에 읽은 바이트를 씀
				while ((length = fin.read(buffer)) > 0) {
					zout.write(buffer, 0, length);
				}

				zout.closeEntry();
				fin.close();
			}

			zout.close();

			response.setContentType("application/zip");
			response.addHeader("Content-Disposition",
					"attachment; filename=" + new String(pet.getPetName().getBytes("UTF-8"), "ISO-8859-1") + ".zip");

			FileInputStream fis = new FileInputStream(zipFile);
			BufferedInputStream bis = new BufferedInputStream(fis);
			ServletOutputStream so = response.getOutputStream();
			BufferedOutputStream bos = new BufferedOutputStream(so);

			byte[] data = new byte[2048];
			int input = 0;

			while ((input = bis.read(data)) != -1) {
				bos.write(data, 0, input);
				bos.flush();
			}

			if (bos != null)
				bos.close();
			if (bis != null)
				bis.close();
			if (fis != null)
				fis.close();

		} catch (PetNotFoundException e) {
			return "pet/list/petList";
		} catch (IOException e) {
			e.printStackTrace();
			return "pet/list/petList";
		} catch (Exception e) {
			e.printStackTrace();
			return "pet/list/petList";
		}
		model.addAttribute("petRegistrationNumber", petRegistrationNumber);
		return null;
	}
}