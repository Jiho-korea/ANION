/*
========================================================================
파    일    명 : KindcodeSelectService.java
========================================================================
작    성    자 : 강지호
작    성    일 : 2021.01.05
작  성  내  용 : kindcode select메서드 작성
========================================================================
*/
package petProject.service.admin.code.kind;

import petProject.vo.dto.Kindcode;

public interface KindcodeUpdateService {
	Kindcode selectKindcode(String petKindcode) throws Exception;

	int updateKindcode(Kindcode kindcode) throws Exception;
}
