/*
========================================================================
파    일    명 : PetInfoUpdateServiceImpl.java
========================================================================
작    성    자 : 강지호
작    성    일 : 2020.01.28
작  성  내  용 : 반려견 정보 수정 서비스 구현 객체
========================================================================
*/
package petProject.service.impl.pet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import petProject.dao.PetDAO;
import petProject.exception.PetInfoUpdateException;
import petProject.service.pet.PetInfoUpdateService;
import petProject.vo.dto.Pet;
import petProject.vo.request.PetNameUpdateRequest;

@Service("petInfoUpdateService")
@Transactional
public class PetInfoUpdateServiceImpl implements PetInfoUpdateService {
	@Autowired
	private PetDAO petDAO;

	@Override
	public int updatePetName(PetNameUpdateRequest petNameUpdateRequest) throws Exception {
		int result = petDAO.updatePetName(petNameUpdateRequest);
		if (result != 1) {
			throw new PetInfoUpdateException("pet information update faild");
		}
		return result;
	}

	@Override
	public int updateLocation(Pet pet) throws Exception {
		int result = petDAO.updateLocation(pet);
		if (result != 1) {
			throw new PetInfoUpdateException("pet information update faild");
		}
		return result;
	}

}
