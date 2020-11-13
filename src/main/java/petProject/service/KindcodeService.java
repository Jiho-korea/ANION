/*
========================================================================
파    일    명 : KindcodeService.java
========================================================================
작    성    자 : 정세진
작    성    일 : 2020.11.13
작  성  내  용 : kindcode select메서드 작성
========================================================================
*/
package petProject.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import petProject.vo.Kindcode;
import petProject.vo.Pet;

public interface KindcodeService {
	List<Kindcode> selectPetKindList() throws Exception;
}
