package petProject.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import petProject.dao.PetDAO;
import petProject.exception.PetRegisterException;
import petProject.service.PetRegisterService;
import petProject.vo.PetRegisterRequest;

@Service("petRegisterService")
@Transactional
public class PetRegisterServiceImpl implements PetRegisterService {
	@Autowired
	private PetDAO petDAO;

	@Override
	public int insertPet(PetRegisterRequest petRegisterRequest) throws Exception {
		int result = petDAO.insertPet(petRegisterRequest);
		if (result != 1) {
			throw new PetRegisterException("petRegisterException");
		}
		return result;
	}

}
