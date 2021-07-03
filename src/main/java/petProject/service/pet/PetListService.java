/*
========================================================================
파    일    명 : PetListService.java
========================================================================
작    성    자 : 강지호
작    성    일 : 2020.xx.xx
작  성  내  용 : 사용자 Id를 통해 등록한 pet list를 불러오는 메서드 선언 인터페이스
========================================================================
수    정    자 : 강지호
수    정    일 : 2021.07.02
수  정  내  용 : 비문 등록 이벤트 반려견 목록 조회 메서드 추가
========================================================================
*/
package petProject.service.pet;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import petProject.vo.dto.Pet;

public interface PetListService {
	List<Pet> selectPetList(@Param("memberNumber") int memberNumber) throws Exception;

	List<Pet> selectNoseprintPetList(@Param("memberNumber") int memberNumber) throws Exception;
}
