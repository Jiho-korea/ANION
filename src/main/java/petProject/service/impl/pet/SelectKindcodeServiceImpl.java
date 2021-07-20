package petProject.service.impl.pet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import petProject.dao.KindcodeDAO;
import petProject.exception.NonExistentKindcodeException;
import petProject.service.pet.SelectKindcodeService;

@Service("selectKindcodeService")
@Component
public class SelectKindcodeServiceImpl implements SelectKindcodeService {

	@Autowired
	KindcodeDAO KindcodeDAO;

	@Override
	public String selectPetKind(String petKindcode) throws Exception {
		String petKind = KindcodeDAO.selectPetKind(petKindcode);
		if (petKind == null) {
			throw new NonExistentKindcodeException("non-existent petKindcode" + petKindcode);
		}
		return petKind;
	}

}
