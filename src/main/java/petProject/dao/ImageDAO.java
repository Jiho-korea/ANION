/*
========================================================================
파    일    명 : ImageDAO.java
========================================================================
작    성    자 : 강지호
작    성    일 : 2020.xx.xx
작  성  내  용 : Image 등록, 리스트 불러오는 메소드 선언 인터페이스
========================================================================
*/
package petProject.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import petProject.vo.Image;
import petProject.vo.ImageUploadRequest;

// DB image 테이블에 접근하는 DAO
@Mapper
public interface ImageDAO {

	int insertImage(@Param("imageUploadRequest") ImageUploadRequest imageUploadRequest) throws Exception;

	List<Image> selectImageList(@Param("petRegistrationNumber") int petRegistrationNumber) throws Exception;

	int selectImageCount() throws Exception;

	void deleteImage(@Param("imagePath") String imagePath) throws Exception;
}
