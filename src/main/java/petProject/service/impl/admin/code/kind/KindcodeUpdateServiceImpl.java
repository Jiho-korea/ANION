/*
========================================================================
파    일    명 : KindcodeSelectServiceImpl.java
========================================================================
작    성    자 : 강지호
작    성    일 : 2020.11.13
작  성  내  용 : kindcode select메서드 작성
========================================================================
*/
package petProject.service.impl.admin.code.kind;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import petProject.dao.KindcodeDAO;
import petProject.exception.KindcodeNotFoundException;
import petProject.exception.KindcodeUpdateException;
import petProject.service.admin.code.kind.KindcodeUpdateService;
import petProject.vo.dto.Kindcode;

@Service("kindcodeUpdateService")
@Transactional(rollbackFor = SQLException.class)
public class KindcodeUpdateServiceImpl implements KindcodeUpdateService {

	@Autowired
	private KindcodeDAO kindcodeDAO;

	@Override
	public Kindcode selectKindcode(String petKindcode) throws Exception {
		Kindcode kindcode = kindcodeDAO.selectKindcode(petKindcode);
		if (kindcode == null) {
			throw new KindcodeNotFoundException("not found");
		}
		return kindcode;
	}

	@Override
	public int updateKindcode(Kindcode kindcode) throws Exception {
		int cnt = kindcodeDAO.updateKindcode(kindcode);
		if (cnt == 0) {
			throw new KindcodeUpdateException("update failed");
		}
		return cnt;
	}
}
