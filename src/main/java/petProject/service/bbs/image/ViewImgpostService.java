/*
========================================================================
파    일    명 : ViewImgpostService.java
========================================================================
작    성    자 : 강지호
작    성    일 : 2021.05.06
작  성  내  용 : 반려견 사진 자랑 게시글 상세 내용을 보여주는 서비스 인터페이스
========================================================================
*/
package petProject.service.bbs.image;

import petProject.vo.dto.Imgpost;

public interface ViewImgpostService {
	Imgpost viewImgpostInfo(int imgpostNo) throws Exception;

}
