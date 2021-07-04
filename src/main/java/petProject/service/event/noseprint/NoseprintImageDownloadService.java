/*
========================================================================
파    일    명 : NoseprintImageDownloadService.java
========================================================================
작    성    자 : 강지호
작    성    일 : 2021.07.04
작  성  내  용 : 비문 이미지 다운로드하는 메서드 선언 인터페이스
========================================================================
*/
package petProject.service.event.noseprint;

import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;

public interface NoseprintImageDownloadService {
	void downloadNoseprintImage(int petRegistrationNumber, String rootPath, Model model, HttpServletResponse response)
			throws Exception;
}
