package petProject.service.impl.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import petProject.dao.WithdrawalDAO;
import petProject.exception.WithdrawalException;
import petProject.service.member.WithdrawalService;
import petProject.vo.request.WithdrawalRequest;

@Service("withdrawalService")
@Transactional
public class WithdrawalServiceImpl implements WithdrawalService {

	@Autowired
	WithdrawalDAO withdrawalDAO;

	@Override
	public void insertComment(WithdrawalRequest withdrawalRequest) {
		int cnt = withdrawalDAO.insertComment(withdrawalRequest);
		if (cnt == 0) {
			throw new WithdrawalException("insert error");
		}
	}

}
