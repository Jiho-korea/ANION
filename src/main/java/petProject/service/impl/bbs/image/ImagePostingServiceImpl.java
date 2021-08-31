/*
========================================================================
파    일    명 : ImagePostingServiceImpl.java
========================================================================
작    성    자 : 강지호
작    성    일 : 2021.05.06
작  성  내  용 : ImgpostDAO의 insertImgpost메서드를 이용하는 서비스
========================================================================
*/
package petProject.service.impl.bbs.image;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import petProject.dao.ImgpostAndImageDAO;
import petProject.dao.ImgpostDAO;
import petProject.exception.ImagePostingException;
import petProject.service.bbs.image.ImagePostingService;
import petProject.vo.dto.ImgpostAndImage;
import petProject.vo.request.ImagePostingRequest;

@Service("imagePostingService")
@Transactional(rollbackFor = SQLException.class)
public class ImagePostingServiceImpl implements ImagePostingService {
	@Autowired
	private ImgpostDAO imgpostDAO;

	@Autowired
	private ImgpostAndImageDAO imgpostAndImageDAO;

	@Override
	public int postingImage(ImagePostingRequest imagePostingRequest) throws Exception {
		int result1 = imgpostDAO.insertImgpost(imagePostingRequest);
		if (result1 != 1) {
			throw new ImagePostingException("ImagePostingException: insertImgpost Error");
		}

		ImgpostAndImage imgpostAndImage = new ImgpostAndImage();
		imgpostAndImage.setImgpostNo(imagePostingRequest.getImgpostNo());
		imgpostAndImage.setImageNumber(imagePostingRequest.getImageNumber());

		int result2 = imgpostAndImageDAO.insertImgpostAndImage(imgpostAndImage);
		if (result2 != 1) {
			throw new ImagePostingException("ImagePostingException: insertImgpostAndImage Error");
		}
		return imagePostingRequest.getImgpostNo();
	}

}
