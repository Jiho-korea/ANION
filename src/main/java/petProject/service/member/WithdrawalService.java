package petProject.service.member;

import petProject.vo.request.WithdrawalRequest;

public interface WithdrawalService {

	void insertComment(WithdrawalRequest withdrawalRequest);

	void updateAuthStatus(WithdrawalRequest withdrawalRequest);
}
