/*
========================================================================
파    일    명 : NoseprintImageListServiceImpl.java
========================================================================
작    성    자 : 강지호
작    성    일 : 2021.07.04
작  성  내  용 : noseprintImageDAO의 selectNoseprintImagelist메서드를 이용하는 서비스
========================================================================
*/
package petProject.service.impl.event.noseprint;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import petProject.dao.NoseprintImageDAO;
import petProject.service.event.noseprint.NoseprintImageListService;
import petProject.vo.dto.NoseprintImage;

@Service("noseprintImageListService")
@Transactional(rollbackFor = SQLException.class)
public class NoseprintImageListServiceImpl implements NoseprintImageListService {
	@Autowired
	private NoseprintImageDAO noseprintImageDAO;

	public List<NoseprintImage> selectNoseprintImageList(int petRegistrationNumber) throws Exception {
		List<NoseprintImage> noseprintImageList = noseprintImageDAO.selectNoseprintImageList(petRegistrationNumber);
		return noseprintImageList;
	}

}
