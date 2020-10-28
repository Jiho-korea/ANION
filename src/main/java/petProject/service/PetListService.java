package petProject.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import petProject.vo.Pet;

public interface PetListService {
	List<Pet> selectPetList(@Param("ownerId") String ownerId) throws Exception;
}
