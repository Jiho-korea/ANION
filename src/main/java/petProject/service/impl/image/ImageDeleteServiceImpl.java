/*
========================================================================
파    일    명 : ImageDeleteServiceImpl.java
========================================================================
작    성    자 : 임원석
작    성    일 : 2020.03.21
작  성  내  용 : imageDao의 DeleteImage메서드를 이용하는 서비스
========================================================================
*/
package petProject.service.impl.image;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import petProject.dao.ImageDAO;
import petProject.exception.ImageDeleteException;
import petProject.service.image.ImageDeleteService;

@Service("imageDeleteService")
@Transactional
public class ImageDeleteServiceImpl implements ImageDeleteService {
	@Autowired
	private ImageDAO imageDAO;

	public int deleteImage(String imagePath) throws Exception {
		int result = imageDAO.deleteImage(imagePath);
		if (result < 0) {
			throw new ImageDeleteException("imageDeleteException");
		}
		return result;
	}

}
