package petProject.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import petProject.dao.ImageDAO;
import petProject.exception.ImageUploadException;
import petProject.service.ImageUploadService;
import petProject.vo.ImageUploadRequest;

@Service("imageUploadService")
@Transactional
public class ImageUploadServiceImpl implements ImageUploadService {
	@Autowired
	private ImageDAO imageDAO;

	@Override
	public int insertImage(ImageUploadRequest imageUploadRequest) throws Exception {
		int result = imageDAO.insertImage(imageUploadRequest);
		if (result != 1) {
			throw new ImageUploadException("imageUploadException");
		}
		return result;
	}

}
