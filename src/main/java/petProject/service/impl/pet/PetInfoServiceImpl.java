/*
========================================================================
파    일    명 : PetInfoServiceImpl.java
========================================================================
작    성    자 : 강지호
작    성    일 : 2020.11.09
작  성  내  용 : 반려견 세부 정보 서비스 인터페이스 구현 클래스
========================================================================
*/

package petProject.service.impl.pet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import petProject.dao.PetDAO;
import petProject.exception.PetNotFoundException;
import petProject.service.pet.PetInfoService;
import petProject.vo.Pet;

@Service("petInfoService")
@Transactional
public class PetInfoServiceImpl implements PetInfoService {

	@Autowired
	private PetDAO petDAO;

	@Override
	public Pet selectPet(int petRegistrationNumber) throws Exception {
		Pet pet = petDAO.selectPet(petRegistrationNumber);
		if (pet == null) {
			throw new PetNotFoundException("not found");
		}
		return pet;
	}
}
