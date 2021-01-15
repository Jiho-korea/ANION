package petProject.service;

public interface ChangePasswordService {

	void changePassword(String memberId, String oldPassword, String newPassword) throws Exception;
}
