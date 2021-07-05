/*
========================================================================
파    일    명 : PetDeleteService
========================================================================
작    성    자 : 송찬영
작    성    일 : 2021.05.23
작  성  내  용 : Pet 삭제하는 인터페이스
========================================================================
*/

package petProject.service.pet;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;

public interface PetDeleteService {
	int deletePet(@Param("petRegistrationNumber") int petRegistrationNumber, HttpServletRequest request)
			throws Exception;

	void deleteImageList(@Param("petRegistrationNumber") int petRegistrationNumber, HttpServletRequest request)
			throws Exception;
}
