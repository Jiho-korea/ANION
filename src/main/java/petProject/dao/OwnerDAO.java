package petProject.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import petProject.vo.LoginRequest;
import petProject.vo.Owner;

// owner 테이블에 접근하는 DAO
@Mapper
public interface OwnerDAO {
	Owner selectByIdPassword(@Param("loginRequest") LoginRequest loginRequest) throws Exception;
}
