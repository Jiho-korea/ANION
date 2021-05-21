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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import petProject.dao.ImageDAO;
import petProject.exception.ImageUploadException;
import petProject.service.image.ImageUploadService;
import petProject.vo.ImageUploadRequest;

@Service("imageUploadService")
@Transactional
public class ImageUploadServiceImpl implements ImageUploadService {
	@Autowired
	private ImageDAO imageDAO;

	@Override
	public int insertImage(ImageUploadRequest imageUploadRequest) throws Exception {
		int result = imageDAO.insertImage(imageUploadRequest);
		if (result != 1) {
			throw new ImageUploadException("imageUploadException");
		}
		return result;
	}

}
