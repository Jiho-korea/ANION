/*
========================================================================
파    일    명 : ImgpostAndImageDAO.java
========================================================================
작    성    자 : 강지호
작    성    일 : 2021.05.06
작  성  내  용 : DB imgpost_and_image 교차 테이블에 접근하여 CRUD 실행하는 매퍼 클래스
========================================================================
*/
package petProject.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import petProject.vo.dto.ImgpostAndImage;

@Mapper
public interface ImgpostAndImageDAO {
	int insertImgpostAndImage(@Param("imgpostAndImage") ImgpostAndImage imgpostAndImage) throws Exception;
}
