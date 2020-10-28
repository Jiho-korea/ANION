package petProject.service;

import org.apache.ibatis.annotations.Param;

import petProject.vo.LoginRequest;
import petProject.vo.Owner;

public interface LoginService {
	Owner selectByIdPassword(@Param("loginRequest") LoginRequest loginRequest) throws Exception;
}
