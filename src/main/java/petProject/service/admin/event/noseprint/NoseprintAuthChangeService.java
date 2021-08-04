/*
========================================================================
파    일    명 : NoseprintAuthChangeService.java
========================================================================
작    성    자 : 임원석
작    성    일 : 2021.08.04
작  성  내  용 : 비문 사진 등급 변경  서비스 인터페이스
========================================================================
*/
package petProject.service.admin.event.noseprint;

import org.apache.ibatis.annotations.Param;

public interface NoseprintAuthChangeService {
	void updateNoseprintImageAuthStatus(@Param("noseprintImagePath") String[] noseprintImagePath) throws Exception;
}
