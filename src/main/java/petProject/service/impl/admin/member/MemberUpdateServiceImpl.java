/*
========================================================================
파    일    명 : MemberUpdateServiceImpl.java
========================================================================
작    성    자 : 정세진
작    성    일 : 2021.08.03
작  성  내  용 : 회원정보 수정 service
========================================================================
*/

package petProject.service.impl.admin.member;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import petProject.dao.EmailcodeDAO;
import petProject.dao.MemberDAO;
import petProject.exception.EmailcodeInsertException;
import petProject.exception.MailException;
import petProject.exception.MemberAuthUpdateException;
import petProject.exception.MemberDuplicateException;
import petProject.exception.MemberNameUpdateException;
import petProject.service.admin.member.MemberSelectService;
import petProject.service.admin.member.MemberUpdateService;
import petProject.service.email.ChangeProfileEmailService;
import petProject.service.member.ChangeProfileService;
import petProject.vo.AuthInfo;
import petProject.vo.dto.Emailcode;
import petProject.vo.dto.Member;
import petProject.vo.request.ChangeIdCommand;
import petProject.vo.request.ChangeNameCommand;

@Service("memberUpdateService")
public class MemberUpdateServiceImpl implements MemberUpdateService {

	@Autowired
	private MemberDAO memberDAO;

	@Resource(name = "memberSelectService")
	MemberSelectService memberSelectService;

	@Transactional
	public void updateName(ChangeNameCommand changeNameCommand) throws Exception {
		Member member = memberSelectService.selectMemberByMemberNumber(changeNameCommand.getMemberNumber());
		member.setMemberName(changeNameCommand.getMemberName());

		int cnt = memberDAO.updateName(member);
		if (cnt == 0) {
			throw new MemberNameUpdateException("name update error");
		}
	}

}
