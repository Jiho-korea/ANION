/*
========================================================================
파    일    명 : ImageSelectService.java
========================================================================
작    성    자 : 강지호
작    성    일 : 2021.05.05
작  성  내  용 : imageNumber에 해당하는 이미지 vo를 select하는 서비스 인터페이스
========================================================================
*/
package petProject.service;

import org.apache.ibatis.annotations.Param;

import petProject.vo.Image;

public interface ImageSelectService {
	Image selectImage(@Param("imageNumber") int imageNumber) throws Exception;

}
