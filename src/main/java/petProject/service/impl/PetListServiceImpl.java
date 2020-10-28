package petProject.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import petProject.dao.PetDAO;
import petProject.service.PetListService;
import petProject.vo.Pet;

@Service("petNameListService")
@Transactional
public class PetListServiceImpl implements PetListService {
	@Autowired
	private PetDAO petDAO;

	public List<Pet> selectPetList(String ownerId) throws Exception {
		List<Pet> petName = petDAO.selectPetList(ownerId);
		return petName;
	}
}
