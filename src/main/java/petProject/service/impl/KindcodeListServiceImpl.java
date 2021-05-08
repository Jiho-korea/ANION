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
import petProject.service.KindcodeListService;
import petProject.vo.Kindcode;

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
	public List<Kindcode> selectKindcodeListPage(Integer pageNumber) throws Exception {
		List<Kindcode> kindcodeList = kindcodeDAO.selectKindcodeListPage((pageNumber-1)*8);
		return kindcodeList;
	}

	@Override
	public boolean nextPage(Integer pageNumber) throws Exception {
		List<Kindcode> kindcodeList = null;
		kindcodeList = kindcodeDAO.selectKindcodeListPage(pageNumber * 8);
		if (!kindcodeList.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

}
