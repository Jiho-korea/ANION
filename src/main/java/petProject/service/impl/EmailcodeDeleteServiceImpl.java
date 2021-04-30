/*
========================================================================
파    일    명 : EmailcodeDeleteServiceImpl.java
========================================================================
작    성    자 : 송찬영
작    성    일 : 2021.04.30
작  성  내  용 : emailcode 테이블 레코드 삭제
========================================================================
*/
package petProject.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import petProject.dao.EmailcodeDAO;
import petProject.exception.EmailcodeDeleteException;
import petProject.service.EmailcodeDeleteService;
import petProject.vo.Emailcode;

@Service("emailcodeDeleteService")
@Transactional
public class EmailcodeDeleteServiceImpl implements EmailcodeDeleteService {

	@Autowired
	private EmailcodeDAO emailcodeDAO;

	//emailCode를 통해 레코드를 삭제
	@Override
	public void deleteRecord(Emailcode emailcode) {
		int cnt = emailcodeDAO.doneEmailcode(emailcode.getEmailCode());
		if (cnt == 0) {
			throw new EmailcodeDeleteException("emailcode delete error");
		}
	}

	//memberId를 통해 레코드를 삭제
	@Override
	public void deleteRecord(String newMemberId) {
		int cnt = emailcodeDAO.doneUpdateId(newMemberId);
		if (cnt == 0) {
			throw new EmailcodeDeleteException("emailcode delete error");
		}
	}

}
