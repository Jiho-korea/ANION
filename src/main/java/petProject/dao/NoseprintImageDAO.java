/*
========================================================================
파    일    명 : NoseprintImageDAO.java
========================================================================
작    성    자 : 강지호
작    성    일 : 2021.07.03
작  성  내  용 : noseprint_image 등록, 리스트 불러오는 메소드 선언 인터페이스
========================================================================
*/
package petProject.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import petProject.vo.dto.NoseprintImage;
import petProject.vo.request.NoseprintImageUploadRequest;

// DB noseprint_image 테이블에 접근하는 DAO
@Mapper
public interface NoseprintImageDAO {

	int insertNoseprintImage(
			@Param("noseprintImageUploadRequest") NoseprintImageUploadRequest noseprintImageUploadRequest)
			throws Exception;

	List<NoseprintImage> selectNoseprintImageList(@Param("petRegistrationNumber") int petRegistrationNumber)
			throws Exception;

	int deleteNoseprintImage(@Param("noseprintImagePath") String noseprintImagePath) throws Exception;
}
