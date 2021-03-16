package petProject.service;

import org.apache.ibatis.annotations.Param;

import petProject.vo.Emailcode;

public interface EmailValidService {

	String valid(@Param("emailcode") Emailcode emailcode) throws Exception;

	Emailcode validCode(@Param("emailcode") Emailcode emailcode) throws Exception;

	void updateEmail(@Param("emailcode") Emailcode emailcode) throws Exception;
}
