package petProject.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import petProject.dao.ImageDAO;
import petProject.service.ImageListService;
import petProject.vo.Image;

@Service("imageListService")
@Transactional
public class ImageListServiceImpl implements ImageListService {
	@Autowired
	private ImageDAO imageDAO;

	public List<Image> selectImageList(int petRegistrationNumber) throws Exception {
		List<Image> imageList = imageDAO.selectImageList(petRegistrationNumber);
		return imageList;
	}

}
