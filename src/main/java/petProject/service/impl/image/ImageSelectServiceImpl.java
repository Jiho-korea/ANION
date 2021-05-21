/*
========================================================================
파    일    명 : ImageSelectServiceImpl.java
========================================================================
작    성    자 : 강지호
작    성    일 : 2021.05.05
작  성  내  용 : imageDao의 selectImage메서드를 이용하여 이미지 번호에 해당하는 Image VO를 리턴하는 서비스 객체
========================================================================
*/
package petProject.service.impl.image;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import petProject.dao.ImageDAO;
import petProject.exception.ImageNotExistException;
import petProject.service.image.ImageSelectService;
import petProject.vo.Image;

@Service("imageSelectService")
@Transactional
public class ImageSelectServiceImpl implements ImageSelectService {
	@Autowired
	private ImageDAO imageDAO;

	@Override
	public Image selectImage(int imageNumber) throws Exception {
		Image image = imageDAO.selectImage(imageNumber);
		if (image == null) {
			throw new ImageNotExistException("image does not exist");
		}
		return image;
	}
}
