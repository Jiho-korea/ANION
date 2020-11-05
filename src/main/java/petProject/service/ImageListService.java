package petProject.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import petProject.vo.Image;

public interface ImageListService {
	List<Image> selectImageList(@Param("petRegistrationNumber") int petRegistrationNumber) throws Exception;
}
