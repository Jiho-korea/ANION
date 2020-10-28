package petProject.service;

import org.apache.ibatis.annotations.Param;

import petProject.vo.ImageUploadRequest;

public interface ImageUploadService {
	int insertImage(@Param("imageUploadRequest") ImageUploadRequest imageUploadRequest) throws Exception;
}
