package petProject.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import petProject.dao.PetDAO;
import petProject.service.GetCurrvalService;

@Service("getCurrvalService")
@Transactional
public class GetCurrvalServiceImpl implements GetCurrvalService {

	@Autowired
	private PetDAO petDAO;

	@Override
	public int selectCurrval() throws Exception {
		int currval = petDAO.selectCurrval();
		return currval;
	}
}
