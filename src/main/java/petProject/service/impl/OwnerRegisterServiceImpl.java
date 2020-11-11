/*
========================================================================
파    일    명 : OwnerRegisterServiceImpl
========================================================================
작    성    자 : 임원석, 정세진, 송찬영
작    성    일 : 2020.11.09
작  성  내  용 : 회원가입 메소드 작성
========================================================================
========================================================================
수    정    자 : 정세진, 송찬영
수    정    일 : 2020.11.11
수  정  내  용 : 아이디 중복확인 메소드 추가
========================================================================
*/

package petProject.service.impl;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import petProject.dao.OwnerDAO;
import petProject.exception.OwnerInsertException;
import petProject.service.OwnerRegisterService;
import petProject.vo.Owner;
import petProject.vo.OwnerRegisterRequest;

@Service("ownerRegisterService")
@Transactional
public class OwnerRegisterServiceImpl implements OwnerRegisterService {

	@Autowired
	private OwnerDAO ownerDAO;

	@Override
	public int insertOwner(OwnerRegisterRequest ownerRegisterRequest) throws Exception {
		int cnt = ownerDAO.insertOwner(ownerRegisterRequest);
		if (cnt == 0) {
			throw new OwnerInsertException("Insert failed");
		}
		// TODO Auto-generated method stub
		return cnt;
	}
	
	public int selectById(OwnerRegisterRequest ownerRegisterRequest) throws Exception{
		int cnt = ownerDAO.selectById(ownerRegisterRequest);
		return cnt;
	}
}
