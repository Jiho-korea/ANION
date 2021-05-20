/*
========================================================================
파    일    명 : ImgpostDAO.java
========================================================================
작    성    자 : 강지호
작    성    일 : 2021.05.06
작  성  내  용 : DB imgpost 테이블에 접근하여 CRUD 실행하는 매퍼 클래스
========================================================================
*/
package petProject.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import petProject.vo.dto.Imgpost;
import petProject.vo.request.ImageBoardRequest;
import petProject.vo.request.ImagePostingRequest;

@Mapper
public interface ImgpostDAO {
	int insertImgpost(@Param("imagePostingRequest") ImagePostingRequest imagePostingRequest) throws Exception;

	List<Imgpost> listImgpost(@Param("imageBoardRequest") ImageBoardRequest imageBoardRequest) throws Exception;

	int updateImgpostViewcnt(@Param("imgpostNo") int imgpostNo) throws Exception;

	Imgpost selectImgpost(@Param("imgpostNo") int imgpostNo) throws Exception;
}
