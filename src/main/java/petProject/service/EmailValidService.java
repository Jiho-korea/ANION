package petProject.service;

import org.apache.ibatis.annotations.Param;

import petProject.vo.Emailcode;

public interface EmailValidService {

	int valid(@Param("emailcode") Emailcode emailcode) throws Exception;

	void validCode(@Param("emailcode") Emailcode emailcode) throws Exception;

	void updateEmail(@Param("emailcode") Emailcode emailcode) throws Exception;
}
