/*
========================================================================
파    일    명 : 
========================================================================
작    성    자 : 송찬영
작    성    일 : 2021.05.23
작  성  내  용 : 
========================================================================
*/

package petProject.service.pet;

import org.apache.ibatis.annotations.Param;

public interface PetDeleteService {
	int deletePet(@Param("petRegistrationNumber") int petRegistrationNumber) throws Exception;
}
