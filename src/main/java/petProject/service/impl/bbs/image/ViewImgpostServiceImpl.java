/*
========================================================================
파    일    명 : ViewImgpostService.java
========================================================================
작    성    자 : 강지호
작    성    일 : 2021.05.08
작  성  내  용 : ImgpostDAO의 selectImgpost메서드를 이용하는 서비스
========================================================================
*/
package petProject.service.impl.bbs.image;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import petProject.dao.ImgpostDAO;
import petProject.exception.ImgpostNotExistException;
import petProject.service.bbs.image.ViewImgpostService;
import petProject.vo.dto.Imgpost;

@Service("viewImgpostService")
@Transactional(rollbackFor = SQLException.class)
public class ViewImgpostServiceImpl implements ViewImgpostService {
	@Autowired
	private ImgpostDAO imgpostDAO;

	@Override
	public Imgpost viewImgpostInfo(int imgpostNo) throws Exception {
		imgpostDAO.updateImgpostViewcnt(imgpostNo);
		Imgpost imgpost = imgpostDAO.selectImgpost(imgpostNo);
		if (imgpost == null || imgpost.getImgpostAvailable() == 0) {
			throw new ImgpostNotExistException("삭제되거나 존재하지 않는 게시글");
		}
		return imgpost;
	}
}
