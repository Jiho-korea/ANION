/*
========================================================================
파    일    명 : NoseprintImageDeleteService.java
========================================================================
작    성    자 : 강지호
작    성    일 : 2021.07.03
작  성  내  용 : 비문 이미지 리스트를 삭제하는 메서드 선언 인터페이스
========================================================================
*/
package petProject.service.event.noseprint;

import org.apache.ibatis.annotations.Param;

public interface NoseprintImageDeleteService {

	void deleteNoseprintImage(@Param("noseprintImagePath") String[] paths_id, String rootPath) throws Exception;
}
