/*
========================================================================
파    일    명 : ImgpostListService.java
========================================================================
작    성    자 : 강지호
작    성    일 : 2021.05.06
작  성  내  용 : 반려견 사진 자랑 게시판 목록 서비스 인터페이스
========================================================================
*/
package petProject.service.bbs.image;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import petProject.vo.dto.Imgpost;
import petProject.vo.request.ImageBoardRequest;

public interface ImgpostListService {
	List<Imgpost> listImgpost(@Param("imageBoardRequest") ImageBoardRequest imageBoardRequest) throws Exception;

	Boolean nextPage(Integer pageNumber) throws Exception;
}
