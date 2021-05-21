package petProject.service.impl.pet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import petProject.dao.KindcodeDAO;
import petProject.exception.NonExistentKindcodeException;
import petProject.service.pet.SelectKindcodeService;
import petProject.vo.Kindcode;

@Service("selectKindcodeService")
@Component
public class SelectKindcodeServiceImpl implements SelectKindcodeService {

	@Autowired
	KindcodeDAO KindcodeDAO;

	@Override
	public Kindcode selectKindcode(String petKindcode) throws Exception {
		Kindcode kindcode = KindcodeDAO.selectKindcode(petKindcode);
		if (kindcode == null) {
			throw new NonExistentKindcodeException("non-existent petKindcode" + petKindcode);
		}
		return kindcode;
	}

}
