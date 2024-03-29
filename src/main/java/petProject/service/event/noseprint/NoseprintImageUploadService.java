/*
========================================================================
파    일    명 : NoseprintImageUploadService.java
========================================================================
작    성    자 : 강지호
작    성    일 : 2021.07.03
작  성  내  용 : 비문 이미지 Insert하는 메서드 선언 인터페이스
========================================================================
*/
package petProject.service.event.noseprint;

import java.util.List;
import org.springframework.web.multipart.MultipartFile;

import petProject.vo.request.NoseprintImageUploadRequest;

public interface NoseprintImageUploadService {
	int insertNoseprintImage(NoseprintImageUploadRequest noseprintImageUploadRequest)
			throws Exception;

	void uploadNoseprintImage(int memberNumber, List<MultipartFile> file, String rootPath, int petRegistrationNumber)
			throws Exception;
}
