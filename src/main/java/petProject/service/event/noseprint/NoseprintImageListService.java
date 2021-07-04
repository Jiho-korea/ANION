/*
========================================================================
파    일    명 : NoseprintImageListService.java
========================================================================
작    성    자 : 강지호
작    성    일 : 2021.07.03
작  성  내  용 : 비문 이미지 리스트를 불러오는 메서드 선언 인터페이스
========================================================================
*/
package petProject.service.event.noseprint;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import petProject.vo.dto.NoseprintImage;

public interface NoseprintImageListService {
	List<NoseprintImage> selectNoseprintImageList(@Param("petRegistrationNumber") int petRegistrationNumber)
			throws Exception;

}
