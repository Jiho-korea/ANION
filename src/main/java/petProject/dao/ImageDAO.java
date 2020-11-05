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
}
