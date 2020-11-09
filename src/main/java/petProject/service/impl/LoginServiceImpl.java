/*
========================================================================
파    일    명 : LoginServiceImpl.java
========================================================================
작    성    자 : 강지호
작    성    일 : 2020.xx.xx
작  성  내  용 : OwnerDAO의 selectByIdPassword메서드를 이용하는 서비스
========================================================================
*/
package petProject.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import petProject.dao.OwnerDAO;
import petProject.exception.OwnerNotFoundException;
import petProject.service.LoginService;
import petProject.vo.LoginRequest;
import petProject.vo.Owner;

@Service("loginService")
@Transactional
public class LoginServiceImpl implements LoginService {

	@Autowired
	private OwnerDAO ownerDAO;

	@Override
	public Owner selectByIdPassword(LoginRequest loginRequest) throws Exception {
		Owner owner = ownerDAO.selectByIdPassword(loginRequest);
		if (owner == null) {
			throw new OwnerNotFoundException("not found");
		}
		// TODO Auto-generated method stub
		return owner;
	}
}
