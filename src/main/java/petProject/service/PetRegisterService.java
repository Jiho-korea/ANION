package petProject.service;

import org.apache.ibatis.annotations.Param;

import petProject.vo.PetRegisterRequest;

public interface PetRegisterService {
	int insertPet(@Param("petRegisterRequest") PetRegisterRequest petRegisterRequest) throws Exception;
}
