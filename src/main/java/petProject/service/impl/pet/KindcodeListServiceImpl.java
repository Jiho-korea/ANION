/*
========================================================================
파    일    명 : KindcodeListServiceImpl.java
========================================================================
작    성    자 : 정세진
작    성    일 : 2020.11.13
작  성  내  용 : kindcode select메서드 작성
========================================================================
수    정    자 : 송찬영
수    정    일 : 2021.05.09
수  정  내  용 : Select박스 페이징 메소드, 다음 페이지 있는지 확인하는 메소드 추가
========================================================================
*/
package petProject.service.impl.pet;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import petProject.dao.KindcodeDAO;
import petProject.exception.NonExistentPageException;
import petProject.service.pet.KindcodeListService;
import petProject.vo.dto.Kindcode;
import petProject.vo.request.PetSearchRequest;

@Service("kindcodeListService")
@Transactional
public class KindcodeListServiceImpl implements KindcodeListService {

	@Autowired
	private KindcodeDAO kindcodeDAO;

	@Override
	public List<Kindcode> selectKindcodeList() throws Exception {
		List<Kindcode> kindcodeList = kindcodeDAO.selectKindcodeList();
		return kindcodeList;
	}

	@Override
	public List<Kindcode> searchPetKindList(PetSearchRequest petSearchRequest) throws Exception {
		if (petSearchRequest.getPageNumber() == 0) {
			throw new NonExistentPageException("non-existent page of list" + petSearchRequest.getPageNumber());
		}
		List<Kindcode> kindcodeList = kindcodeDAO.searchPetKindList(petSearchRequest);
		return kindcodeList;
	}

	@Override
	public boolean nextPage(PetSearchRequest petSearchRequest) throws Exception {
		List<Kindcode> kindcodeList = null;
		kindcodeList = kindcodeDAO.searchPetKindList(petSearchRequest);
		if (!kindcodeList.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

}
