/*
========================================================================
파    일    명 : PetInfoUpdateService.java
========================================================================
작    성    자 : 강지호
작    성    일 : 2021.01.28
작  성  내  용 : 반려견 정보 수정 서비스 객체
========================================================================
*/
package petProject.service.pet;

import petProject.vo.dto.Pet;
import petProject.vo.request.PetNameUpdateRequest;

public interface PetInfoUpdateService {
	int updatePetName(PetNameUpdateRequest petNameUpdateRequest) throws Exception;

	int updateLocation(Pet pet) throws Exception;
}
