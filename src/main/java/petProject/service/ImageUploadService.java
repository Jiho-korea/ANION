/*
========================================================================
파    일    명 : ImageUploadService.java
========================================================================
작    성    자 : 강지호
작    성    일 : 2020.xx.xx
작  성  내  용 : 이미지 Insert하는 메서드 선언 인터페이스
========================================================================
*/
package petProject.service;

import org.apache.ibatis.annotations.Param;

import petProject.vo.ImageUploadRequest;

public interface ImageUploadService {
	int insertImage(@Param("imageUploadRequest") ImageUploadRequest imageUploadRequest) throws Exception;
}
