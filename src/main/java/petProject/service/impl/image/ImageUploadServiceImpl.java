/*
========================================================================
파    일    명 : ImageUploadService.java
========================================================================
작    성    자 : 강지호
작    성    일 : 2020.xx.xx
작  성  내  용 : imageDAO의 insertImage메서드를 이용하는 서비스
========================================================================
*/
package petProject.service.impl.image;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import petProject.dao.ImageDAO;
import petProject.exception.ImageUploadException;
import petProject.service.image.ImageUploadService;
import petProject.vo.request.ImageUploadRequest;

@Service("imageUploadService")
@Transactional
public class ImageUploadServiceImpl implements ImageUploadService {
	@Autowired
	private ImageDAO imageDAO;

	@Override
	@Transactional
	public void uploadImage(int memberNumber, List<MultipartFile> file, String rootPath, int petRegistrationNumber)
			throws Exception {
		String savedName;
		for (MultipartFile mf : file) {
			savedName = uploadFile(mf.getOriginalFilename(), mf.getBytes(), rootPath);

			// model.addAttribute("savedName", savedName);
			String absPath = rootPath + "\\" + savedName;
			System.out.println("absPath = " + absPath);

			ImageUploadRequest imageUploadRequest = new ImageUploadRequest(memberNumber, petRegistrationNumber,
					savedName);
			insertImage(imageUploadRequest);
		}
	}

	@Override
	public int insertImage(ImageUploadRequest imageUploadRequest) throws Exception {
		int result = imageDAO.insertImage(imageUploadRequest);
		if (result != 1) {
			throw new ImageUploadException("imageUploadException");
		}
		return result;
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
