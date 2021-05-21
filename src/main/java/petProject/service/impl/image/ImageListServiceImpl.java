/*
========================================================================
파    일    명 : ImageListServiceImpl.java
========================================================================
작    성    자 : 강지호
작    성    일 : 2020.xx.xx
작  성  내  용 : imageDao의 selectImagelist메서드를 이용하는 서비스
========================================================================
*/
package petProject.service.impl.image;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import petProject.dao.ImageDAO;
import petProject.service.image.ImageListService;
import petProject.vo.dto.Image;

@Service("imageListService")
@Transactional
public class ImageListServiceImpl implements ImageListService {
	@Autowired
	private ImageDAO imageDAO;

	public List<Image> selectImageList(int petRegistrationNumber) throws Exception {
		List<Image> imageList = imageDAO.selectImageList(petRegistrationNumber);
		return imageList;
	}

}
