/*
========================================================================
파    일    명 : KindcodeListService.java
========================================================================
작    성    자 : 정세진
작    성    일 : 2020.11.13
작  성  내  용 : kindcode select메서드 작성
========================================================================
수    정    자 : 송찬영
수    정    일 : 2021.05.09
수  정  내  용 : Select List Page메소드, 다음 List Page있는지 확인하는 메소드 작성
========================================================================
*/
package petProject.service.pet;

import java.util.List;

import petProject.vo.dto.Kindcode;
import petProject.vo.request.PetSearchRequest;

public interface KindcodeListService {

	List<Kindcode> selectKindcodeList() throws Exception;

	List<Kindcode> searchPetKindList(PetSearchRequest petSearchRequest) throws Exception;

	boolean nextPage(PetSearchRequest petSearchRequest) throws Exception;

	List<String> selectCountryCodeList() throws Exception;
}
