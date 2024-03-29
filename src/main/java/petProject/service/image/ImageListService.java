/*
========================================================================
파    일    명 : ImageListService.java
========================================================================
작    성    자 : 강지호
작    성    일 : 2020.xx.xx
작  성  내  용 : 이미지 리스트를 불러오는 메서드 선언 인터페이스
========================================================================
*/
package petProject.service.image;

import java.util.List;

import petProject.vo.dto.Image;

public interface ImageListService {
	List<Image> selectImageList(int petRegistrationNumber) throws Exception;

}
