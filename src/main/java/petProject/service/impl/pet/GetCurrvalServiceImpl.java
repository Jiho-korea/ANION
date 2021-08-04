/*
========================================================================
파    일    명 : GetCurrvalServiceImple.java
========================================================================
작    성    자 : 강지호
작    성    일 : 2020.xx.xx
작  성  내  용 : Dao의 selectCurrval메서드 이용 서비스
========================================================================
*/
package petProject.service.impl.pet;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import petProject.dao.PetDAO;
import petProject.service.pet.GetCurrvalService;

@Service("getCurrvalService")
@Transactional(rollbackFor = SQLException.class)
public class GetCurrvalServiceImpl implements GetCurrvalService {

	@Autowired
	private PetDAO petDAO;

	@Override
	public int selectCurrval() throws Exception {
		int currval = petDAO.selectCurrval();
		return currval;
	}
}
