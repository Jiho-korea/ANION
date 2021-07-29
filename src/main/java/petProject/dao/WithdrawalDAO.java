package petProject.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import petProject.vo.request.WithdrawalRequest;

@Mapper
public interface WithdrawalDAO {

	int insertComment(@Param("withdrawalRequest") WithdrawalRequest withdrawalRequest);

}
