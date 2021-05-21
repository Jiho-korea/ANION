package petProject.service.pet;

import petProject.vo.Kindcode;

public interface SelectKindcodeService {

	Kindcode selectKindcode(String petKindcode) throws Exception;
}
