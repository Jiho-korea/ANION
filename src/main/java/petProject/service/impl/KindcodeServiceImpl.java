/*
========================================================================
파    일    명 : KindcodeServiceImpl.java
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

import petProject.exception.KindcodeNotFoundException;
import petProject.service.KindcodeService;
import petProject.vo.Kindcode;

@Service("KindcodeService")
@Transactional
public class KindcodeServiceImpl implements KindcodeService {

	@Autowired
	private petProject.dao.KindcodeDAO KindcodeDAO;


	@Override
	public List<Kindcode> selectPetKindList() throws Exception {
		List<Kindcode> kindcodeList = KindcodeDAO.selectPetKindList();
		if (kindcodeList.isEmpty()) {
			throw new KindcodeNotFoundException("not found");
		}
		// TODO Auto-generated method stub
		return kindcodeList;
	}
}
