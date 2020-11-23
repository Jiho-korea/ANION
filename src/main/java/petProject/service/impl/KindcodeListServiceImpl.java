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

import petProject.service.KindcodeListService;
import petProject.vo.Kindcode;

@Service("kindcodeListService")
@Transactional
public class KindcodeListServiceImpl implements KindcodeListService {

	@Autowired
	private petProject.dao.KindcodeDAO KindcodeDAO;

	@Override
	public List<Kindcode> selectKindcodeList() throws Exception {
		List<Kindcode> kindcodeList = KindcodeDAO.selectKindcodeList();
		return kindcodeList;
	}
}
