package petProject.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import petProject.vo.Pet;
import petProject.vo.PetRegisterRequest;

// DB PET 테이블에 접근하는  DAO
@Mapper
public interface PetDAO {
	int insertPet(@Param("petRegisterRequest") PetRegisterRequest petRegisterRequest) throws Exception;

	int selectCurrval() throws Exception;

	List<Pet> selectPetList(@Param("ownerId") String ownerId) throws Exception;

	Pet selectPet(@Param("petRegistrationNumber") int petRegistrationNumber) throws Exception;
}
