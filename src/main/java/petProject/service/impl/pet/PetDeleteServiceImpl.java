/*
========================================================================
파    일    명 : PetDeleteServiceImpl.java
========================================================================
작    성    자 : 송찬영
작    성    일 : 2021.05.23
작  성  내  용 : Pet 삭제하는 서비스
========================================================================
*/

package petProject.service.impl.pet;

import java.io.File;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import petProject.dao.ImageDAO;
import petProject.dao.PetDAO;
import petProject.exception.PetDeleteException;
import petProject.service.pet.PetDeleteService;
import petProject.vo.dto.Image;

@Service("petDeleteService")
@Transactional
public class PetDeleteServiceImpl implements PetDeleteService {

	@Autowired
	private PetDAO petDAO;

	@Autowired
	private ImageDAO imageDAO;

	@Transactional(rollbackFor = SQLException.class)
	public int deletePet(int petRegistrationNumber, HttpServletRequest request) throws Exception {
		this.deleteImageList(petRegistrationNumber, request);
		int result = petDAO.deletePet(petRegistrationNumber);
		if (result < 0) {
			throw new PetDeleteException("petDeleteException");
		}
		return result;
	}

	@Override
	public void deleteImageList(int petRegistrationNumber, HttpServletRequest request) throws Exception {
		String rootPath = request.getSession().getServletContext().getRealPath("/upload");
		List<Image> petImageList = imageDAO.selectImageList(petRegistrationNumber);
		if (petImageList != null) {
			for (Image image : petImageList) {
				File deleteFile = new File(rootPath + "/" + image.getImagePath());
				deleteFile.delete();
			}
		}
	}

}
