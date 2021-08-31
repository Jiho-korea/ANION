/*
========================================================================
파    일    명 : ImgpostListServiceImpl.java
========================================================================
작    성    자 : 강지호
작    성    일 : 2021.05.06
작  성  내  용 : ImgpostDAO의 listImgpost메서드를 이용하는 서비스
========================================================================
*/
package petProject.service.impl.bbs.image;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import petProject.dao.ImgpostDAO;
import petProject.exception.NonExistentPageException;
import petProject.service.bbs.image.ImgpostListService;
import petProject.vo.dto.Imgpost;
import petProject.vo.request.ImageBoardRequest;

@Service("imgpostListService")
@Transactional(rollbackFor = SQLException.class)
public class ImgpostListServiceImpl implements ImgpostListService {
	@Autowired
	private ImgpostDAO imgpostDAO;

	@Override
	public List<Imgpost> listImgpost(ImageBoardRequest imageBoardRequest) throws Exception {
		if (imageBoardRequest.getPageNumber() == 0) {
			throw new NonExistentPageException("non-existent page of image board" + imageBoardRequest.getPageNumber());
		}
		if (imageBoardRequest.getPageNumber() != 1 && nextPage(imageBoardRequest.getPageNumber() - 1) == false) {
			// 존재 하지 않는 페이지 일때 Exception 발생
			throw new NonExistentPageException("non-existent page of image board" + imageBoardRequest.getPageNumber());
		}

		imageBoardRequest.setPageNumber((imageBoardRequest.getPageNumber() - 1) * 10);
		List<Imgpost> imgpostList = imgpostDAO.listImgpost(imageBoardRequest);
		return imgpostList;
	}

	// 다음 페이지가 있는 지 체크하는 메소드
	@Override
	public Boolean nextPage(Integer pageNumber) throws Exception {
		List<Imgpost> imgpostList = null;
		imgpostList = imgpostDAO.listImgpost(new ImageBoardRequest(pageNumber * 10, null));
		if (!imgpostList.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

}
