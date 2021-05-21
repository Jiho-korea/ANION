package petProject.service.pet;

import petProject.vo.dto.Kindcode;

public interface SelectKindcodeService {

	Kindcode selectKindcode(String petKindcode) throws Exception;
}
