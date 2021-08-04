/*
========================================================================
파    일    명 : ImagePostingService.java
========================================================================
작    성    자 : 강지호
작    성    일 : 2021.05.06
작  성  내  용 : 반려견 사진 자랑 게시물 등록 서비스 인터페이스
========================================================================
*/
package petProject.service.bbs.image;

import petProject.vo.request.ImagePostingRequest;

public interface ImagePostingService {
	int postingImage(ImagePostingRequest imagePostingRequest) throws Exception;
}
