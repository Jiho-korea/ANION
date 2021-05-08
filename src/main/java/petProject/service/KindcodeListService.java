/*
========================================================================
파    일    명 : KindcodeListService.java
========================================================================
작    성    자 : 정세진
작    성    일 : 2020.11.13
작  성  내  용 : kindcode select메서드 작성
========================================================================
*/
package petProject.service;

import java.util.List;

import petProject.vo.Kindcode;

public interface KindcodeListService {

	List<Kindcode> selectKindcodeList() throws Exception;

	List<Kindcode> selectKindcodeListPage(Integer pageNumber) throws Exception;

	boolean nextPage(Integer pageNuber) throws Exception;
}
