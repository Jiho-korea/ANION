/*
========================================================================
파    일    명 : KindcodeDeleteService.java
========================================================================
작    성    자 : 강지호
작    성    일 : 2021.01.05
작  성  내  용 : kindcode delete 서비스
========================================================================
*/
package petProject.service.admin;

import org.apache.ibatis.annotations.Param;

public interface KindcodeDeleteService {
	int deleteKindcode(@Param("petKindcode") String petKindcode) throws Exception;
}
