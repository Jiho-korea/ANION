/*
========================================================================
파    일    명 : PetRegisterServiceImpl.java
========================================================================
작    성    자 : 강지호
작    성    일 : 2020.xx.xx
작  성  내  용 : petDAO의 insertPet메서드를 이용하는 서비스
========================================================================
수    정    자 : 송찬영
수    정    일 : 2021.05.05
수  정  내  용 : findKindcode 메소드 추가
========================================================================
*/
package petProject.service.impl.pet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import petProject.dao.KindcodeDAO;
import petProject.dao.PetDAO;
import petProject.exception.PetRegisterException;
import petProject.service.pet.PetRegisterService;
import petProject.vo.PetRegisterRequest;

@Service("petRegisterService")
@Transactional
public class PetRegisterServiceImpl implements PetRegisterService {

	@Autowired
	private PetDAO petDAO;

	@Autowired
	private KindcodeDAO KindcodeDAO;

	@Override
	public int insertPet(PetRegisterRequest petRegisterRequest) throws Exception {
		// petKindcode를 찾기위한 메소드
		String petKindcode = KindcodeDAO.findKindcode(petRegisterRequest.getPetKind());
		petRegisterRequest.setPetKindcode(petKindcode);

		int result = petDAO.insertPet(petRegisterRequest);
		if (result != 1) {
			throw new PetRegisterException("petRegisterException");
		}
		return result;
	}

}
