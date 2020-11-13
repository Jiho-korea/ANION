/*
========================================================================
파    일    명 : PetListServiceImpl.java
========================================================================
작    성    자 : 강지호
작    성    일 : 2020.xx.xx
작  성  내  용 : petDAO의 selectPetList메서드를 이용하는 서비스
========================================================================
*/
package petProject.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import petProject.dao.OwnerDAO;
import petProject.service.OwnerListService;
import petProject.vo.Owner;

@Service("ownerListService")
@Transactional
public class OwnerListServiceImpl implements OwnerListService {
	@Autowired
	private OwnerDAO ownerDAO;

	@Override
	public List<Owner> selectOwnerList() throws Exception {
		List<Owner> ownerList = ownerDAO.selectOwnerList();
		return ownerList;
	}
}
