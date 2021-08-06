/*
========================================================================
파    일    명 : PetListServiceImpl.java
========================================================================
작    성    자 : 강지호
작    성    일 : 2020.xx.xx
작  성  내  용 : petDAO의 selectPetList메서드를 이용하는 서비스
========================================================================
수    정    자 : 강지호
수    정    일 : 2021.07.02
수  정  내  용 : 비문 등록 이벤트 반려견 목록 조회 메서드 추가
========================================================================
*/
package petProject.service.impl.pet;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import petProject.dao.PetDAO;
import petProject.service.pet.PetListService;
import petProject.vo.dto.Pet;

@Service("petListService")
@Transactional(rollbackFor = SQLException.class)
public class PetListServiceImpl implements PetListService {
	@Autowired
	private PetDAO petDAO;

	@Override
	public List<Pet> selectPetList(int memberNumber) throws Exception {
		List<Pet> petList = petDAO.selectPetList(memberNumber);
		return petList;
	}

	// 비문 등록 이벤트 페이지의 반려견 목록
	@Override
	public List<Pet> selectNoseprintPetList(int memberNumber) throws Exception {
		List<Pet> noseprintPetList = petDAO.selectNoseprintPetList(memberNumber);
		return noseprintPetList;
	}
}
