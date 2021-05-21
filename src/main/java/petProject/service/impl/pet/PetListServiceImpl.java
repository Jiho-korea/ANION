/*
========================================================================
파    일    명 : PetListServiceImpl.java
========================================================================
작    성    자 : 강지호
작    성    일 : 2020.xx.xx
작  성  내  용 : petDAO의 selectPetList메서드를 이용하는 서비스
========================================================================
*/
package petProject.service.impl.pet;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import petProject.dao.PetDAO;
import petProject.service.pet.PetListService;
import petProject.vo.Pet;

@Service("petNameListService")
@Transactional
public class PetListServiceImpl implements PetListService {
	@Autowired
	private PetDAO petDAO;

	public List<Pet> selectPetList(int memberNumber) throws Exception {
		List<Pet> petList = petDAO.selectPetList(memberNumber);
		return petList;
	}
}
