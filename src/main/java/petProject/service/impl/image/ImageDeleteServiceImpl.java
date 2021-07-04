/*
========================================================================
파    일    명 : ImageDeleteServiceImpl.java
========================================================================
작    성    자 : 임원석
작    성    일 : 2020.03.21
작  성  내  용 : imageDao의 DeleteImage메서드를 이용하는 서비스
========================================================================
*/
package petProject.service.impl.image;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import petProject.dao.ImageDAO;
import petProject.exception.ImageDeleteException;
import petProject.service.image.ImageDeleteService;

@Service("imageDeleteService")
@Transactional
public class ImageDeleteServiceImpl implements ImageDeleteService {
	@Autowired
	private ImageDAO imageDAO;

	@Override
	@Transactional
	public void deleteImage(String[] paths_id, String rootPath) throws Exception {
		for (int i = 0; i < paths_id.length; i++) {
			int result = imageDAO.deleteImage(paths_id[i]);
			if (result < 0) {
				throw new ImageDeleteException("imageDeleteException");
			}

			File deleteFile = new File(rootPath + "/" + paths_id[i]);
			deleteFile.delete();
		}

	}

}
