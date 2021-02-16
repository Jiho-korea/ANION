package petProject.service;

import org.apache.ibatis.annotations.Param;

import petProject.vo.Emailcode;

public interface EmailValidService {

	void validCode(@Param("emailcode") Emailcode emailcode) throws Exception;
	
	void emailChange(@Param("emailcode") Emailcode emailcode) throws Exception;
}
