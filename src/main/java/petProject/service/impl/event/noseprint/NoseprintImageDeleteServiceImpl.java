/*
========================================================================
파    일    명 : NoseprintImageDeleteServiceImpl.java
========================================================================
작    성    자 : 강지호
작    성    일 : 2021.07.04
작  성  내  용 : NoseprintImageDao의 DeleteNoseprintImage메서드를 이용하는 서비스
========================================================================
*/
package petProject.service.impl.event.noseprint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import petProject.dao.NoseprintImageDAO;
import petProject.exception.ImageDeleteException;
import petProject.service.event.noseprint.NoseprintImageDeleteService;

@Service("noseprintImageDeleteService")
@Transactional
public class NoseprintImageDeleteServiceImpl implements NoseprintImageDeleteService {
	@Autowired
	private NoseprintImageDAO noseprintImageDAO;

	public int deleteNoseprintImage(String noseprintImagePath) throws Exception {
		int result = noseprintImageDAO.deleteNoseprintImage(noseprintImagePath);
		if (result < 0) {
			throw new ImageDeleteException("noseprintImageDeleteException");
		}
		return result;
	}

}
