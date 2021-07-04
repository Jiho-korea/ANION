/*
========================================================================
파    일    명 : ImageUploadService.java
========================================================================
작    성    자 : 강지호
작    성    일 : 2020.xx.xx
작  성  내  용 : 이미지 Insert하는 메서드 선언 인터페이스
========================================================================
*/
package petProject.service.image;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.multipart.MultipartFile;

import petProject.vo.AuthInfo;
import petProject.vo.request.ImageUploadRequest;

public interface ImageUploadService {
	int insertImage(@Param("imageUploadRequest") ImageUploadRequest imageUploadRequest) throws Exception;

	void uploadImage(AuthInfo authInfo, List<MultipartFile> file, String rootPath, int petRegistrationNumber)
			throws Exception;
}
