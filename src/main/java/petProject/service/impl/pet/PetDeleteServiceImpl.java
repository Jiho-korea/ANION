/*
========================================================================
파    일    명 : PetDeleteServiceImpl.java
========================================================================
작    성    자 : 송찬영
작    성    일 : 2021.05.23
작  성  내  용 : Pet 삭제하는 서비스
========================================================================
*/

package petProject.service.impl.pet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import petProject.dao.PetDAO;
import petProject.exception.PetDeleteException;
import petProject.service.pet.PetDeleteService;

@Service("petDeleteService")
@Transactional
public class PetDeleteServiceImpl implements PetDeleteService {

	@Autowired
	private PetDAO petDAO;

	@Override
	public int deletePet(int petRegistrationNumber) throws Exception {
		int result = petDAO.deletePet(petRegistrationNumber);
		if (result < 0) {
			throw new PetDeleteException("petDeleteException");
		}
		return result;
	}


}
