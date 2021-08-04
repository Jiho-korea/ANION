/*
========================================================================
파    일    명 : NoseprintAuthChangeServiceImpl.java
========================================================================
작    성    자 : 임원석
작    성    일 : 2021.08.04
작  성  내  용 : 비문 등급 변경 서비스 객체
========================================================================
*/
package petProject.service.impl.admin.event.noseprint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import petProject.dao.NoseprintImageDAO;
import petProject.exception.ImageDeleteException;
import petProject.service.admin.event.noseprint.NoseprintAuthChangeService;

@Service("noseprintAuthChangeService")
@Transactional
public class NoseprintAuthChangeServiceImpl implements NoseprintAuthChangeService {
	@Autowired
	private NoseprintImageDAO noseprintImageDAO;

	@Override
	public void updateNoseprintImageAuthStatus(String[] noseprintImagePath) throws Exception {
		for (int i = 0; i < noseprintImagePath.length; i++) {
			int result = noseprintImageDAO.updateNoseprintImageAuthStatus(noseprintImagePath[i]);
			System.out.print("서비스 임플");
			System.out.print(noseprintImagePath[i]);
			if (result < 0) {
				throw new ImageDeleteException("imageDeleteException");
			}

		}

	}

}