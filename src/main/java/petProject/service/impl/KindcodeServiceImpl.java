/*
========================================================================
파    일    명 : KindcodeListServiceImpl.java
========================================================================
작    성    자 : 정세진
작    성    일 : 2020.11.13
작  성  내  용 : kindcode select메서드 작성
========================================================================
*/
package petProject.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import petProject.dao.KindcodeDAO;
import petProject.service.KindcodeService;
import petProject.vo.Kindcode;

@Service("kindcodeListService")
@Transactional
public class KindcodeServiceImpl implements KindcodeService {

	@Autowired
	private KindcodeDAO kindcodeDAO;

	@Override
	public List<Kindcode> selectKindcodeList() throws Exception {
		List<Kindcode> kindcodeList = kindcodeDAO.selectKindcodeList();
		return kindcodeList;
	}

	@Override
	public Kindcode selectKindcode(String petKindcode) throws Exception {
		Kindcode kindcode = kindcodeDAO.selectKindcode(petKindcode);
		
		return kindcode;
	}
}
