package petProject.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import petProject.vo.Emailcode;

@Mapper
public interface EmailcodeDAO {

	Emailcode selectEmailcode(@Param("emailcode") Emailcode emailcode);

	int insertEmailcode(@Param("emailcode") Emailcode emailcode) throws Exception;

	int updateEmailcode(@Param("emailcode") Emailcode emailcode);

	int requestEmailUpdate(@Param("memberId") String memberId);

	int doneEmailcode(@Param("emailcode") Emailcode emailcode);

}
