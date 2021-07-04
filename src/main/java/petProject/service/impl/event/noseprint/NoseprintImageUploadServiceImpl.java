/*
========================================================================
파    일    명 : NoseprintImageUploadServiceImpl.java
========================================================================
작    성    자 : 강지호
작    성    일 : 2021.07.04
작  성  내  용 : imageDAO의 insertImage메서드를 이용하는 서비스
========================================================================
*/
package petProject.service.impl.event.noseprint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import petProject.dao.NoseprintImageDAO;
import petProject.exception.ImageUploadException;
import petProject.service.event.noseprint.NoseprintImageUploadService;
import petProject.vo.request.NoseprintImageUploadRequest;

@Service("noseprintImageUploadService")
@Transactional
public class NoseprintImageUploadServiceImpl implements NoseprintImageUploadService {
	@Autowired
	private NoseprintImageDAO noseprintImageDAO;

	@Override
	public int insertNoseprintImage(NoseprintImageUploadRequest noseprintImageUploadRequest) throws Exception {
		int result = noseprintImageDAO.insertNoseprintImage(noseprintImageUploadRequest);
		if (result != 1) {
			throw new ImageUploadException("noseprintImageUploadException");
		}
		return result;
	}
}
