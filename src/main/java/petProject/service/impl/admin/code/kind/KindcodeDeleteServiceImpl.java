/*
========================================================================
파    일    명 : KindcodeDeleteServiceImpl.java
========================================================================
작    성    자 : 강지호
작    성    일 : 2021.01.05
작  성  내  용 : kindcode delete메서드 작성
========================================================================
*/
package petProject.service.impl.admin.code.kind;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import petProject.dao.KindcodeDAO;
import petProject.exception.KindcodeDeleteException;
import petProject.service.admin.code.kind.KindcodeDeleteService;

@Service("kindcodeDeleteService")
@Transactional
public class KindcodeDeleteServiceImpl implements KindcodeDeleteService {

	@Autowired
	private KindcodeDAO kindcodeDAO;

	@Override
	public int deleteKindcode(String petKindcode) throws Exception {
		int cnt = kindcodeDAO.deleteKindcode(petKindcode);
		if (cnt == 0) {
			throw new KindcodeDeleteException("delete failed");
		}
		return cnt;
	}
}
