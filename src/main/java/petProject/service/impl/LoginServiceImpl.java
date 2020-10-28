package petProject.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import petProject.dao.OwnerDAO;
import petProject.exception.OwnerNotFoundException;
import petProject.service.LoginService;
import petProject.vo.LoginRequest;
import petProject.vo.Owner;

@Service("loginService")
@Transactional
public class LoginServiceImpl implements LoginService {

	@Autowired
	private OwnerDAO ownerDAO;

	@Override
	public Owner selectByIdPassword(LoginRequest loginRequest) throws Exception {
		Owner owner = ownerDAO.selectByIdPassword(loginRequest);
		if (owner == null) {
			throw new OwnerNotFoundException("not found");
		}
		// TODO Auto-generated method stub
		return owner;
	}
}
