/*
========================================================================
파    일    명 : ImageDownloadServiceImpl.java
========================================================================
작    성    자 : 강지호
작    성    일 : 2021.07.04
작  성  내  용 : 반려견의 이미지 전체를 다운로드 하는 서비스 메소드
========================================================================
*/
package petProject.service.impl.image;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import petProject.service.image.ImageDownloadService;
import petProject.service.image.ImageListService;
import petProject.service.pet.PetInfoService;
import petProject.vo.dto.Image;
import petProject.vo.dto.Pet;

@Service("imageDownloadService")
@Transactional
public class ImageDownloadServiceImpl implements ImageDownloadService {
	@Resource(name = "imageListService")
	ImageListService imageListService;

	@Resource(name = "petInfoService")
	PetInfoService petInfoService;

	@Override
	@Transactional
	public void downloadImage(int petRegistrationNumber, String rootPath, Model model, HttpServletResponse response)
			throws Exception {
		String zipFile = rootPath + "\\result.zip";

		Pet pet = petInfoService.selectPet(petRegistrationNumber);
		List<Image> imageList = imageListService.selectImageList(petRegistrationNumber);
		model.addAttribute("imageList", imageList);
		// ZipOutputStream을 FileOutputStream 으로 감쌈
		FileOutputStream fout = new FileOutputStream(zipFile);
		ZipOutputStream zout = new ZipOutputStream(fout);

		for (int i = 0; i < imageList.size(); i++) {

			// 본래 파일명 유지, 경로제외 파일압축을 위해 new File로
			ZipEntry zipEntry = new ZipEntry(new File(imageList.get(i).getImagePath()).getName());
			zout.putNextEntry(zipEntry);

			// 경로포함 압축
			// zout.putNextEntry(new ZipEntry(sourceFiles.get(i)));

			FileInputStream fin = new FileInputStream(rootPath + "\\" + imageList.get(i).getImagePath());
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
	}

}
