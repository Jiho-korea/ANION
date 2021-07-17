/*
========================================================================
파    일    명 : KindcodeInsertServiceImpl.java
========================================================================
작    성    자 : 임원석, 강지호
작    성    일 : 2020.11.28
작  성  내  용 : 견종 코드 insert serviceImpl
========================================================================
*/

package petProject.service.impl.admin.code.kind;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import petProject.dao.KindcodeDAO;
import petProject.exception.KindcodeInsertException;
import petProject.service.admin.code.kind.KindcodeInsertService;
import petProject.vo.dto.Kindcode;

@Service("kindcodeInsertService")
public class KindcodeInsertServiceImpl implements KindcodeInsertService {

	@Autowired
	private KindcodeDAO kindcodeDAO;

	@Override
	public int insertKindcode(Kindcode kindcode) throws Exception {
		int cnt = kindcodeDAO.insertKindcode(kindcode);
		if (cnt == 0) {
			throw new KindcodeInsertException("Insert failed");
		}
		return cnt;
	}

}
